package com.titansmasher.taptitansoptimiser.Optimisers;

import android.util.Log;

import com.titansmasher.taptitansoptimiser.Helpers.ArrayListConstructor;
import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimiser.Models.Enums.Ability;
import com.titansmasher.taptitansoptimiser.Models.Enums.Artifact;
import com.titansmasher.taptitansoptimiser.Models.Enums.CalculationType;
import com.titansmasher.taptitansoptimiser.Models.Enums.Customisation;
import com.titansmasher.taptitansoptimiser.Models.Enums.Effect;
import com.titansmasher.taptitansoptimiser.Models.Enums.Hero;
import com.titansmasher.taptitansoptimiser.Models.Enums.World;
import com.titansmasher.taptitansoptimiser.Models.Optimiser.PurchaseStep;
import com.titansmasher.taptitansoptimiser.Models.RawSave.AbilityClasses.AbilityLevels;
import com.titansmasher.taptitansoptimiser.Models.RawSave.ArtifactClasses.ArtifactLevels;
import com.titansmasher.taptitansoptimiser.Models.RawSave.HeroClasses.HeroLevels;
import com.titansmasher.taptitansoptimiser.Models.RawSave.HeroClasses.HeroWeapons;
import com.titansmasher.taptitansoptimiser.Models.RawSave.PlayerCustomizations;
import com.titansmasher.taptitansoptimiser.Models.Skill;
import com.titansmasher.taptitansoptimiser.Models.WorldSave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Danny on 25/10/2016.
 */

public class RelicOptimiser {
    public Map<Artifact, Integer> artifactLevels;
    public Map<Hero, Integer> heroLevels;
    public Map<Customisation, Boolean> playerCustomizations;
    public Map<Ability, Integer> abilityLevels;
    public Map<Hero, Integer> heroWeapons;
    public WorldSave save;
    public World world;

    private final double BASE_CRIT_CHANCE = 0.02;
    private final double BASE_CHEST_CHANCE = 0.02;
    private final double MAIN_HERO_DAMAGE = 600 * Math.pow(1.05, 600);
    private final double BASE_SKILL_CRIT_COOLDOWN = 1800;
    private final double BASE_SKILL_TDMG_COOLDOWN = 3600;
    private final double BASE_SKILL_CRIT_DURATION = 30;
    private final double BASE_SKILL_TDMG_DURATION = 30;
    private final double BOSS_GOLD_CONSTANT = (2 + 4 + 6 + 7 + 10) / 5.0;

    public RelicOptimiser(World world, WorldSave save){
        this.save = save;
        this.heroLevels = save.heroLevels.mapHeros();
        this.heroWeapons = save.heroWeaponUpgrades.mapHeros();
        this.artifactLevels = save.artifactLevels.mapArtifacts();
        this.playerCustomizations = save.unlockedPlayerCustomizations.mapCustomizations();
        this.abilityLevels = save.levels.mapAbility();
        this.world = world;
    }

    public List<PurchaseStep> getBest(CalculationType type, int relicLimit, int stepLimit, boolean useAllRelics){
        ArrayListConstructor<PurchaseStep> steps = new ArrayListConstructor<>();
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

        while (relicLimit > 0 && steps.size() < stepLimit){
            double baseMeasure = getEfficencyMeasure(type, getEffects(ownedArtifacts, allSkills, playerCustomizations));
            Artifact best = null;
            double bestEfficency = 0;
            int bestLevel = 0;
            int bestCost = 0;
            for (Artifact artifact:
                    ownedArtifacts.keySet()){
                if (artifact.costAtLevel(ownedArtifacts.get(artifact)) <= relicLimit || !useAllRelics) {
                    Map<Effect, Double> effects = getEffects(ownedArtifacts, allSkills, playerCustomizations);
                    int levelsNeeded = 1;

                    if (type == CalculationType.GOLD || type == CalculationType.DMGE)
                        levelsNeeded = levelsNeeded(artifact, ownedArtifacts.get(artifact), effects);

                    int artifactLevel = ownedArtifacts.get(artifact);
                    for (int level = levelsNeeded; level > 0; level--){
                        effects = getEffects(ownedArtifacts, allSkills, playerCustomizations);

                        int cost = 0;
                        for (int i = 0; i < level; i++)
                            cost += artifact.costAtLevel(artifactLevel + i);

                        for (Effect effect :
                                artifact.effects.keySet()) {
                            double curVal = effects.get(effect);
                            effects.put(effect, curVal + (artifact.effects.get(effect) * level));
                        }

                        double newMeasure = getEfficencyMeasure(type, effects);

                        double artifactEfficency = (newMeasure - baseMeasure) / cost;

                        if (artifactEfficency > bestEfficency) {
                            best = artifact;
                            bestEfficency = artifactEfficency;
                            bestLevel = level + artifactLevel;
                            bestCost = cost;
                        }
                    }
                }
            }
            if (best == null || bestCost > relicLimit)
                break;
            steps.add(new PurchaseStep(best, bestLevel, bestCost));
            relicLimit -= bestCost;
            ownedArtifacts.put(best, bestLevel);
            Log.d("Artifact", best.artifactId + "");
        }

        return steps.getList();
    }

    public int getNextBreakpoint(){
        return (int)Math.max(90, (Math.floor(save.currentStage / 15) + 1) * 15);
    }

    public int relicsAtStage(int stage){
        int heroRelics = GenericHelpers.sum(this.heroLevels.values()) / 1000;
        int stageRelics = (int)Math.pow(Math.floor(stage / 15) - 5, 1.7);

        return (int)Math.round((heroRelics + stageRelics) * getEffect(Effect.RELICS, getEffects(this.artifactLevels, null, null)));
    }

    private double getEfficencyMeasure(CalculationType type, Map<Effect, Double> effects){
        switch (type){
            case DMG:
                return getDMG(effects);
            case GOLD:
                return getGoldMult(effects);
            case TDMG:
                return getTDMG(effects);
            case DMGE:
                return getDMGE(effects);
            default:
                return 0;
        }
    }

    private Map<Effect, Double> getEffects(Map<Artifact, Integer> artifacts, List<Skill> skills, Map<Customisation, Boolean> customisations){
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

    private double getDMG(Map<Effect, Double> effects){
        return getEffect(Effect.ALL_DAMAGE_ARTIFACTS, effects) * (1 + getEffect(Effect.ARTIFACT_DAMAGE_BOOST, effects));
    }

    private double getGoldMult(Map<Effect, Double> effects){
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

    private double getTDMG(Map<Effect, Double> effects){
        double totalDps = getHeroDps(effects) * getEffect(Effect.TAP_DAMAGE_DPS, effects) + MAIN_HERO_DAMAGE;
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

    private double getDMGE(Map<Effect, Double> effects){
        double goldMult = getGoldMult(effects);
        double tdmg = getTDMG(effects);

        return tdmg * Math.pow(1.044685, Math.log(goldMult) / Math.log(1.075));
    }

    private double getEffect(Effect effect, Map<Effect, Double> effects){
        return effects.get(effect) / 100;
    }

    private double getHeroDps(Map<Effect, Double> effects){
        double dps = 0;

        for (Hero hero :
                heroLevels.keySet()) {
            int level = 2000;//heroLevels.get(hero);
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

    private int levelsNeeded(Artifact artifact, int count, Map<Effect, Double> effects){
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
