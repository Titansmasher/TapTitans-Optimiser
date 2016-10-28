package com.titansmasher.taptitansoptimiser.Models.Enums;

import com.titansmasher.taptitansoptimiser.Helpers.HashMapConstructor;

import java.util.Map;

/**
 * Created by Danny on 20/10/2016.
 */

public enum Artifact {
    AmuletValrunes(2, World.WORLD_1, 0.7, 2.0, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(25)).add(Effect.GOLD_MOBS, new Double(10)).getMap()),
    AxeResolution(16, World.WORLD_1, 0.5, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_DRN_TDMG, new Double(10)).getMap()),
    BarbarianMettle(10, World.WORLD_1, 0.4, 1.5, 10, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_CDR_TDMG, new Double(-5)).getMap()),
    BrewAbsorption(30, World.WORLD_1, 0.6, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(30)).add(Effect.TAP_DAMAGE_ARTIFACTS, new Double(2)).getMap()),
    ChestContentment(19, World.WORLD_1, 1.0, 1.5, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(20)).add(Effect.CHEST_ARTIFACTS, new Double(20)).getMap()),
    CrafterElixir(27, World.WORLD_1, 0.5, 1.8, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(20)).add(Effect.GOLD_OVERALL, new Double(15)).getMap()), // gold while playing
    CrownEgg(18, World.WORLD_1, 1.0, 1.5, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(20)).add(Effect.CHEST_CHANCE, new Double(20)).getMap()),
    DarkCloakLife(3, World.WORLD_1, 0.5, 2.0, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.BOSS_HEALTH, new Double(-2)).getMap()),
    DeathSeeker(4, World.WORLD_1, 0.8, 2.5, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.CRIT_CHANCE, new Double(2)).getMap()),
    DivineChalice(21, World.WORLD_1, 0.7, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.GOLD_10X_CHANCE, new Double(0.5)).getMap()),
    DrunkenHammer(29, World.WORLD_1, 0.6, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(30)).add(Effect.TAP_DAMAGE_ARTIFACTS, new Double(2)).getMap()),
    FutureFortune(20, World.WORLD_1, 0.7, 2.0, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.GOLD_ARTIFACTS, new Double(5)).getMap()),
    HeroThrust(17, World.WORLD_1, 0.7, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(20)).getMap()),
    HunterOintment(8, World.WORLD_1, 0.4, 1.5, 10, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(60)).add(Effect.SKILL_CDR_HERO, new Double(-5)).getMap()),
    KnightShield(1, World.WORLD_1, 0.7, 1.5, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(30)).add(Effect.GOLD_BOSS, new Double(100)).getMap()),
    LaborerPendant(9, World.WORLD_1, 0.7, 1.5, 10, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_CDR_GOLD, new Double(-5)).getMap()),
    OgreGauntlet(12, World.WORLD_1, 0.5, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_DRN_AUTO, new Double(10)).getMap()),
    OtherworldlyArmor(28, World.WORLD_1, 1.0, 2.2, 10, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.HERO_DEATH_CHANCE, new Double(-5)).getMap()),
    OverseerLotion(6, World.WORLD_1, 0.4, 1.5, 10, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_CDR_AUTO, new Double(-5)).getMap()),
    ParchmentImportance(13, World.WORLD_1, 0.5, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_DRN_CRIT, new Double(10)).getMap()),
    RingOpulence(15, World.WORLD_1, 0.7, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_DRN_GOLD, new Double(10)).getMap()),
    RingWondrousCharm(24, World.WORLD_1, 0.5, 1.7, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.UPGRADE_COST, new Double(-2)).getMap()),
    SacredScroll(7, World.WORLD_1, 0.4, 1.5, 10, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_CDR_CRIT, new Double(-5)).getMap()),
    SaintlyShield(11, World.WORLD_1, 0.3, 1.5, 10, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_CDR_OHKO, new Double(-5)).getMap()),
    SaviorShield(5, World.WORLD_1, 0.5, 1.7, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.BOSS_TIME, new Double(10)).getMap()),
    TinctureMaker(26, World.WORLD_1, 0.6, 2.5, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(5)).add(Effect.ARTIFACT_DAMAGE_BOOST, new Double(5)).getMap()),
    UndeadAura(22, World.WORLD_1, 0.7, 2.0, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.RELICS, new Double(5)).getMap()),
    UniversalFissure(14, World.WORLD_1, 0.5, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(60)).add(Effect.SKILL_DRN_HERO, new Double(10)).getMap()),
    WarriorRevival(23, World.WORLD_1, 1.0, 2.2, 10, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.HERO_REVIVE_TIME, new Double(-5)).getMap()),
    WorldlyIlluminator(25, World.WORLD_1, 0.6, 3.0, 5, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(150)).add(Effect.NUM_MOBS, new Double(-100)).getMap()),

    AmuletStorm(55, World.WORLD_2, 2.0, 6.0, 5, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(300)).add(Effect.NUM_MOBS, new Double(-100)).getMap()),
    AnnihilationOrb(49, World.WORLD_2, 1.0, 1.5, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(20)).add(Effect.CHEST_ARTIFACTS, new Double(10)).add(Effect.GOLD_ARTIFACTS, new Double(2)).getMap()),
    AnointmentOintment(54, World.WORLD_2, 0.5, 2.8, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(150)).add(Effect.UPGRADE_COST, new Double(-1)).add(Effect.GOLD_OVERALL, new Double(5)).getMap()),
    AphroditeBaton(53, World.WORLD_2, 1.0, 4.0, 10, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.HERO_REVIVE_TIME, new Double(-2)).add(Effect.GOLD_OVERALL, new Double(5)).getMap()),
    AtomicWand(52, World.WORLD_2, 0.7, 2.0, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.RELICS, new Double(2)).add(Effect.GOLD_OVERALL, new Double(5)).getMap()),
    AzureDragonStatuette(57, World.WORLD_2, 0.5, 1.8, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(20)).add(Effect.GOLD_OVERALL, new Double(5)).add(Effect.SKILL_DRN_TDMG, new Double(5)).getMap()),
    BootsWilting(41, World.WORLD_2, 0.3, 2.8, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(200)).add(Effect.SKILL_CDR_OHKO, new Double(-2)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(5)).getMap()),
    BraidBinding(48, World.WORLD_2, 1.1, 2.1, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(30)).add(Effect.CHEST_CHANCE, new Double(5)).add(Effect.GOLD_ARTIFACTS, new Double(2)).getMap()),
    ChillingChalice(40, World.WORLD_2, 0.4, 2.8, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(200)).add(Effect.SKILL_CDR_TDMG, new Double(-2)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(5)).getMap()),
    CirceMirror(67, World.WORLD_2, 0.7, 2.0, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.RELICS, new Double(2)).add(Effect.GOLD_BOSS, new Double(30)).getMap()),
    ConjurorCrystal(58, World.WORLD_2, 1.1, 4.0, 12, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(115)).add(Effect.HERO_DEATH_CHANCE, new Double(-2)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(10)).getMap()),
    CosmicCandle(66, World.WORLD_2, 0.6, 2.5, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(5)).add(Effect.ARTIFACT_DAMAGE_BOOST, new Double(2)).add(Effect.GOLD_BOSS, new Double(30)).getMap()),
    CrownCleopatra(32, World.WORLD_2, 0.9, 2.1, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(25)).add(Effect.GOLD_MOBS, new Double(5)).add(Effect.SKILL_DRN_CRIT, new Double(5)).getMap()),
    DemonHorn(38, World.WORLD_2, 0.4, 2.8, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(200)).add(Effect.SKILL_CDR_HERO, new Double(-2)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(5)).getMap()),
    ElixirVerve(44, World.WORLD_2, 0.5, 2.1, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_DRN_HERO, new Double(5)).add(Effect.GOLD_ARTIFACTS, new Double(2)).getMap()),
    HarpMedea(69, World.WORLD_2, 0.5, 3.1, 50, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(140)).add(Effect.BOSS_HEALTH, new Double(-0.5)).add(Effect.GOLD_MOBS, new Double(5)).getMap()),
    HorseshoeFortune(61, World.WORLD_2, 0.6, 2.1, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(30)).add(Effect.TAP_DAMAGE_ARTIFACTS, new Double(1)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(10)).getMap()),
    InebriatedStaff(70, World.WORLD_2, 0.7, 2.0, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.GOLD_10X_CHANCE, new Double(0.2)).add(Effect.RELICS, new Double(2)).getMap()),
    MageMantle(31, World.WORLD_2, 0.7, 2.1, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(30)).add(Effect.GOLD_BOSS, new Double(40)).add(Effect.SKILL_DRN_AUTO, new Double(5)).getMap()),
    MagicMist(43, World.WORLD_2, 0.5, 2.1, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_DRN_CRIT, new Double(5)).add(Effect.GOLD_ARTIFACTS, new Double(2)).getMap()),
    MarkDominance(56, World.WORLD_2, 0.6, 2.5, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(5)).add(Effect.ARTIFACT_DAMAGE_BOOST, new Double(2)).add(Effect.SKILL_DRN_GOLD, new Double(5)).getMap()),
    MercuryEarring(47, World.WORLD_2, 0.7, 2.3, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(5)).add(Effect.SKILL_DRN_HERO, new Double(5)).getMap()),
    MerlinGlobe(36, World.WORLD_2, 0.4, 2.8, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(200)).add(Effect.SKILL_CDR_AUTO, new Double(-2)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(5)).getMap()),
    MirrorRefraction(60, World.WORLD_2, 0.6, 2.1, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(30)).add(Effect.TAP_DAMAGE_ARTIFACTS, new Double(1)).add(Effect.GOLD_10X_CHANCE, new Double(1)).getMap()),
    MorganaGoblet(68, World.WORLD_2, 0.6, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(30)).add(Effect.GOLD_ARTIFACTS, new Double(2)).add(Effect.GOLD_BOSS, new Double(30)).getMap()),
    NecklaceNether(39, World.WORLD_2, 0.7, 2.8, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(200)).add(Effect.SKILL_CDR_GOLD, new Double(-2)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(5)).getMap()),
    PandoraMusicBox(37, World.WORLD_2, 0.4, 2.8, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(200)).add(Effect.SKILL_CDR_CRIT, new Double(-2)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(5)).getMap()),
    PetalsProtection(59, World.WORLD_2, 0.6, 4.0, 12, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(130)).add(Effect.TAP_DAMAGE_ARTIFACTS, new Double(1)).add(Effect.HERO_DEATH_CHANCE, new Double(-2)).getMap()),
    PhoenixRenewed(42, World.WORLD_2, 0.5, 2.1, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_DRN_AUTO, new Double(5)).add(Effect.GOLD_ARTIFACTS, new Double(2)).getMap()),
    RaRing(51, World.WORLD_2, 0.7, 1.7, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.GOLD_10X_CHANCE, new Double(0.25)).add(Effect.GOLD_OVERALL, new Double(5)).getMap()),
    RingFire(50, World.WORLD_2, 0.7, 2.3, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.GOLD_ARTIFACTS, new Double(2)).add(Effect.CRIT_DAMAGE_ARTIFACTS, new Double(2)).getMap()),
    RodGreatGales(62, World.WORLD_2, 0.9, 4.0, 12, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(130)).add(Effect.HERO_DEATH_CHANCE, new Double(-2)).add(Effect.HERO_REVIVE_TIME, new Double(-10)).getMap()),
    RopeLashes(63, World.WORLD_2, 0.5, 3.3, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(125)).add(Effect.GOLD_MOBS, new Double(5)).add(Effect.BOSS_TIME, new Double(5)).getMap()),
    ScarabInsanity(64, World.WORLD_2, 0.7, 2.0, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.RELICS, new Double(2)).add(Effect.GOLD_MOBS, new Double(5)).getMap()),
    ScrollLightning(34, World.WORLD_2, 0.8, 3.4, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.CRIT_CHANCE, new Double(1)).add(Effect.GOLD_MOBS, new Double(5)).getMap()),
    ShockGauntlet(33, World.WORLD_2, 0.5, 2.6, 50, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(85)).add(Effect.BOSS_HEALTH, new Double(-0.5)).add(Effect.GOLD_ARTIFACTS, new Double(2)).getMap()),
    SlipperSleep(65, World.WORLD_2, 0.6, 2.5, 10, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(5)).add(Effect.ARTIFACT_DAMAGE_BOOST, new Double(2)).add(Effect.HERO_REVIVE_TIME, new Double(-2)).getMap()),
    SwiftSwill(46, World.WORLD_2, 0.5, 2.5, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(5)).add(Effect.GOLD_BOSS, new Double(30)).add(Effect.CHEST_ARTIFACTS, new Double(10)).getMap()),
    VialFrost(45, World.WORLD_2, 0.7, 2.1, null, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(35)).add(Effect.SKILL_DRN_GOLD, new Double(5)).add(Effect.GOLD_ARTIFACTS, new Double(2)).getMap()),
    WandWonder(35, World.WORLD_2, 0.5, 3.4, 25, new HashMapConstructor<Effect, Double>().add(Effect.ALL_DAMAGE_ARTIFACTS, new Double(15)).add(Effect.BOSS_TIME, new Double(5)).add(Effect.CRIT_CHANCE, new Double(1)).getMap());
    
    public int artifactId;
    public World world;
    public double x;
    public double y;
    public Integer levelCap;
    public Map<Effect, Double> effects;

    Artifact(int id, World world, double x, double y, Integer levelCap, Map<Effect, Double> effects) {
        this.artifactId = id;
        this.world = world;
        this.x = x;
        this.y = y;
        this.levelCap = levelCap;
        this.effects = effects;
    }

    public int costAtLevel(int level){
        if (level == 0 || (levelCap != null && level == levelCap))
            return Integer.MAX_VALUE;
        return (int)Math.ceil(this.x * Math.pow(level + 1, this.y));
    }

    public static Artifact getFromId(int id) {
        for (Artifact a :
                Artifact.values()) {
            if (a.artifactId == id) {
                return a;
            }
        }
        return null;
    }
}
