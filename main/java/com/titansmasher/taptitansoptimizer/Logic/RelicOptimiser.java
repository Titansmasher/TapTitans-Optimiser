package com.titansmasher.taptitansoptimizer.Logic;

import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.util.Log;

import com.titansmasher.taptitansoptimizer.Helpers.ArrayListConstructor;
import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Model.Enums.Ability;
import com.titansmasher.taptitansoptimizer.Model.Enums.Artifact;
import com.titansmasher.taptitansoptimizer.Model.Enums.CalculationType;
import com.titansmasher.taptitansoptimizer.Model.Enums.Customisation;
import com.titansmasher.taptitansoptimizer.Model.Enums.Effect;
import com.titansmasher.taptitansoptimizer.Model.Enums.Hero;
import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.Model.LiveUpdate;
import com.titansmasher.taptitansoptimizer.Model.Optimiser.PurchaseStep;
import com.titansmasher.taptitansoptimizer.Model.Skill;
import com.titansmasher.taptitansoptimizer.Model.WorldSave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Danny on 25/10/2016.
 */

public class RelicOptimiser {

    private static double BASE_CRIT_CHANCE = 0.02;
    private static double BASE_CHEST_CHANCE = 0.02;
    private static double MAIN_HERO_DAMAGE = 600 * Math.pow(1.05, 600);
    private static double BASE_SKILL_CRIT_COOLDOWN = 1800;
    private static double BASE_SKILL_TDMG_COOLDOWN = 3600;
    private static double BASE_SKILL_CRIT_DURATION = 30;
    private static double BASE_SKILL_TDMG_DURATION = 30;
    private static double BOSS_GOLD_CONSTANT = (2 + 4 + 6 + 7 + 10) / 5.0;

    public static LiveUpdate<List<PurchaseStep>> getBestAsync(final CalculationType type, final World world, final Map<Artifact, Integer> artifactLevels, final Map<Hero, Integer> heroLevels, final Map<Hero, Integer> heroWeapons, final Map<Customisation, Boolean> playerCustomizations, final int relicLimit, final int stepLimit, final boolean useAllRelics){
        final LiveUpdate<List<PurchaseStep>> returnObj = new LiveUpdate<>();
        returnObj.output = new ArrayList<>();

        final Map<Customisation, Boolean> customisations = world == World.WORLD_1 ? playerCustomizations : null;

        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<Artifact, Integer> ownedArtifacts = new HashMap<>();
                for (Artifact a :
                        artifactLevels.keySet()) {
                    if (artifactLevels.get(a) > 0 && a.world == world)
                        ownedArtifacts.put(a, artifactLevels.get(a));
                }

                List<Skill> allSkills = new ArrayList<>();
                for (Hero hero :
                        heroLevels.keySet()) {
                    allSkills.addAll(hero.getSkills(world, heroLevels.get(hero)));
                }
                double remainingRelics = relicLimit;
                while (remainingRelics > 0 && returnObj.output.size() < stepLimit && !returnObj.done){
                    double baseMeasure = getEfficencyMeasure(type, world,  getEffects(ownedArtifacts, allSkills, customisations), heroLevels, heroWeapons);
                    Artifact best = null;
                    double bestEfficency = 0;
                    int bestLevel = 0;
                    double bestCost = 0;
                    for (Artifact artifact:
                            ownedArtifacts.keySet()){
                        double cost = artifact.costAtLevel(ownedArtifacts.get(artifact));
                        if (cost != Integer.MAX_VALUE && (cost <= remainingRelics || !useAllRelics)) {
                            Map<Effect, Double> effects = getEffects(ownedArtifacts, allSkills, customisations);
                            int levelsNeeded = 1;

                            if (type == CalculationType.GOLD || type == CalculationType.DMGE)
                                levelsNeeded = levelsNeeded(artifact, ownedArtifacts.get(artifact), effects);

                            int artifactLevel = ownedArtifacts.get(artifact);
                            for (int level = levelsNeeded; level > 0; level--){
                                effects = getEffects(ownedArtifacts, allSkills, customisations);

                                double totalCost = 0;
                                for (int i = 0; i < level; i++) {
                                    totalCost += artifact.costAtLevel(artifactLevel + i);
                                }

                                for (Effect effect :
                                        artifact.effects.keySet()) {
                                    double curVal = effects.get(effect);
                                    effects.put(effect, curVal + (artifact.effects.get(effect) * level));
                                }

                                double newMeasure = getEfficencyMeasure(type, world, effects, heroLevels, heroWeapons);

                                double artifactEfficency = (newMeasure - baseMeasure) / totalCost;

                                if (artifactEfficency > bestEfficency) {
                                    best = artifact;
                                    bestEfficency = artifactEfficency;
                                    bestLevel = level + artifactLevel;
                                    bestCost = totalCost;
                                }
                            }
                        }
                    }
                    if (best == null || bestCost > remainingRelics)
                        break;
                    returnObj.output.add(new PurchaseStep(best, bestLevel, bestCost));
                    remainingRelics -= bestCost;
                    ownedArtifacts.put(best, bestLevel);
                }

                returnObj.done = true;
            }
        }).start();

        return returnObj;
    }

    public static int getNextBreakpoint(int currentStage){
        return (int)Math.max(90, (Math.floor(currentStage / 15) + 1) * 15);
    }

    public static double relicsAtStage(int stage, Map<Artifact, Integer> artifactLevels, Map<Hero, Integer> heroLevels){
        double relicMult = (1 + getEffect(Effect.RELICS, getEffects(artifactLevels, null, null)));
        double heroRelics = Math.ceil(GenericHelpers.sum(heroLevels.values()) * relicMult / 1000);
        double stageRelics = Math.ceil(relicMult * Math.pow(Math.max(0, Math.floor(stage / 15) - 5), 1.7));

        return heroRelics + stageRelics;
    }

    private static double getEfficencyMeasure(CalculationType type, World world, Map<Effect, Double> effects, Map<Hero, Integer> heroLevels, Map<Hero, Integer> heroWeapons){
        switch (type){
            case DMG:
                return getDMG(effects);
            case GOLD:
                return getGoldMult(effects);
            case TDMG:
                return getTDMG(world, effects, heroLevels, heroWeapons);
            case DMGE:
                return getDMGE(world, effects, heroLevels, heroWeapons);
            default:
                return 0;
        }
    }

    public static Map<Effect, Double> getEffects(Map<Artifact, Integer> artifacts, List<Skill> skills, Map<Customisation, Boolean> customisations){
        Map<Effect, Double> effectMap = new HashMap<>();
        for (Effect effect :
                Effect.values()) {
            effectMap.put(effect, 0e1);
        }

        double current = 0;
        double newVal;

        if (artifacts != null) {
            for (Artifact artifact :
                    artifacts.keySet()) {
                for (Effect effect :
                        artifact.effects.keySet()) {
                    current = effectMap.get(effect);
                    if (effect == Effect.ALL_DAMAGE_ARTIFACTS)
                        newVal = current + (artifact.effects.get(effect) * (1 + artifacts.get(artifact)));
                    else
                        newVal = current + (artifact.effects.get(effect) * artifacts.get(artifact));
                    effectMap.put(effect, newVal);
                }
            }
        }

        if (customisations != null) {
            for (Customisation customisation :
                    customisations.keySet()) {
                if (customisations.get(customisation)) {
                    current = effectMap.get(customisation.effect);
                    newVal = current + customisation.amount;
                    effectMap.put(customisation.effect, newVal);
                }
            }
        }

        if (skills != null) {
            for (Skill skill :
                    skills) {
                current = effectMap.get(skill.effect);
                newVal = current + skill.value;
                effectMap.put(skill.effect, newVal);
            }
        }

        return effectMap;
    }

    private static double getDMG(Map<Effect, Double> effects){
        return getEffect(Effect.ALL_DAMAGE_ARTIFACTS, effects) * (1 + getEffect(Effect.ARTIFACT_DAMAGE_BOOST, effects));
    }

    private static double getGoldMult(Map<Effect, Double> effects){
        double numOfMobs = 10 + getEffect(Effect.NUM_MOBS, effects);
        double chestChance = Math.min(1, BASE_CHEST_CHANCE * (1 + getEffect(Effect.CHEST_CHANCE, effects)));
        double chestGold = 10 * (1 + getEffect(Effect.CHEST_ARTIFACTS, effects))
                              * (1 + getEffect(Effect.CHEST_HEROSKILLS, effects))
                              * (1 + getEffect(Effect.CHEST_CUSTOMIZATIONS, effects));

        double mobChance = 1 - chestChance;
        double mobGold = (1 + getEffect(Effect.GOLD_MOBS, effects));

        double chance10x = Math.min(1, getEffect(Effect.GOLD_10X_CHANCE, effects));
        double multiplier10x = 1 + 9 * chance10x;
        double mobMultiplier = mobGold * multiplier10x;

        double goldFromMobs = numOfMobs * (chestChance * chestGold + mobChance * mobMultiplier);
        double goldFromBoss = BOSS_GOLD_CONSTANT * (1 + getEffect(Effect.GOLD_BOSS, effects));

        double averageMobBossGold = (goldFromBoss + goldFromMobs) / (1 + numOfMobs);

        double addativeMultipliers = Math.ceil(1 + getEffect(Effect.GOLD_ARTIFACTS, effects)
                                                 + getEffect(Effect.GOLD_HEROSKILLS, effects)
                                                 + getEffect(Effect.GOLD_CUSTOMIZATIONS, effects));

        double overallMultiplier = 1 + getEffect(Effect.GOLD_OVERALL, effects);
        double upgradeMultiplier = 1 / (1 + getEffect(Effect.UPGRADE_COST, effects));

        return averageMobBossGold * addativeMultipliers * overallMultiplier * upgradeMultiplier;
    }

    private static double getTDMG(World world, Map<Effect, Double> effects, Map<Hero, Integer> heroLevels, Map<Hero, Integer> heroWeapons){
        double totalDps = getHeroDps(world, effects, heroLevels, heroWeapons) * getEffect(Effect.TAP_DAMAGE_DPS, effects) + MAIN_HERO_DAMAGE;
        double totalTDMG = (1 + getEffect(Effect.TAP_DAMAGE_HEROSKILLS, effects) + getEffect(Effect.TAP_DAMAGE_CUSTOMIZATIONS, effects))
                         * (1 + getEffect(Effect.TAP_DAMAGE_ARTIFACTS, effects))
                         * (1 + getEffect(Effect.ALL_DAMAGE_CUSTOMIZATIONS, effects))
                         * (1 + getDMG(effects))
                         * totalDps;

        double critMultipier = (10 + getEffect(Effect.CRIT_DAMAGE_HEROSKILLS, effects))
                * (1 + getEffect(Effect.CRIT_DAMAGE_ARTIFACTS, effects))
                * (1 + getEffect(Effect.CRIT_DAMAGE_CUSTOMIZATIONS, effects));

        double critChance = Math.min(1, BASE_CRIT_CHANCE + getEffect(Effect.CRIT_CHANCE, effects));
        double overallCritMult = ((1 - critChance) + (critChance * 0.65 * critMultipier));

        return totalTDMG * overallCritMult;
    }

    private static double getDMGE(World world, Map<Effect, Double> effects, Map<Hero, Integer> heroLevels, Map<Hero, Integer> heroWeapons){
        double goldMult = getGoldMult(effects);
        double tdmg = getTDMG(world, effects, heroLevels, heroWeapons);

        return tdmg * Math.pow(1.044685, Math.log(goldMult) / Math.log(1.075));
    }

    public static double getEffect(Effect effect, Map<Effect, Double> effects){
        return effects.get(effect) / 100;
    }

    private static double getHeroDps(World world, Map<Effect, Double> effects, Map<Hero, Integer> heroLevels, Map<Hero, Integer> heroWeapons){
        double dps = 0;

        for (Hero hero :
                heroLevels.keySet()) {
            int level = heroLevels.get(hero);
            if (level > 0){
                double heroDps = hero.getBaseDPS(world, level);
                double heroDpsMult = 1 + hero.getHeroDamageBonus(world, level)
                        + getEffect(Effect.ALL_DAMAGE_HEROSKILLS, effects)
                        + getEffect(Effect.ALL_DAMAGE_MEMORY, effects);

                double allDamage = 1 + getDMG(effects);
                double customisationMult = 1 + getEffect(Effect.ALL_DAMAGE_CUSTOMIZATIONS, effects);
                double weaponMult = 1 + (heroWeapons.get(hero) * 0.5);
                double setMult = Math.max(1, GenericHelpers.min(heroWeapons.values()) * 10);

                dps += heroDps * heroDpsMult * allDamage * customisationMult * weaponMult * setMult;
            }
        }

        return dps;
    }

    private static int levelsNeeded(Artifact artifact, int count, Map<Effect, Double> effects){
        if (artifact.effects.keySet().contains(Effect.GOLD_ARTIFACTS)){
            double current = Math.ceil(1 + (count * artifact.effects.get(Effect.GOLD_ARTIFACTS) / 100)
                    + getEffect(Effect.GOLD_HEROSKILLS, effects)
                    + getEffect(Effect.GOLD_CUSTOMIZATIONS, effects));
            double newVal = current;
            int levels = 0;
            while (newVal == current){
                levels ++;
                newVal = Math.ceil(1 + ((count + levels) * artifact.effects.get(Effect.GOLD_ARTIFACTS) / 100)
                        + getEffect(Effect.GOLD_HEROSKILLS, effects)
                        + getEffect(Effect.GOLD_CUSTOMIZATIONS, effects));
            }
            return levels;
        }
        return 1;
    }
}
