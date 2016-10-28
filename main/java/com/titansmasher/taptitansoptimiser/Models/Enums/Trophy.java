package com.titansmasher.taptitansoptimiser.Models.Enums;

/**
 * Created by Danny on 22/10/2016.
 */

public enum Trophy {
    MonsterKill("MonsterKill"),
    CollectGold("CollectGold"),
    ReachStage("ReachStage"),
    CollectRelics("CollectRelics"),
    OwnArtifacts("OwnArtifacts"),
    HeroDPS("HeroDPS"),
    BossKill("BossKill"),
    TapCount("TapCount"),
    PrestigeCount("PrestigeCount"),
    HeroLevelUp("HeroLevelUp"),
    ChestsOpened("ChestsOpened"),
    FairyCount("FairyCount"),
    JumpAttackCount("JumpAttackCount"),
    CriticalAttackCount("CriticalAttackCount");

    public String trophyName;

    Trophy(String name) {
        trophyName = name;
    }
}
