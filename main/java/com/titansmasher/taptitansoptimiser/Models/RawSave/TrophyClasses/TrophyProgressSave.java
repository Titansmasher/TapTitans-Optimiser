package com.titansmasher.taptitansoptimiser.Models.RawSave.TrophyClasses;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;

import org.json.JSONObject;

/**
 * Created by Danny on 20/10/2016.
 */

public class TrophyProgressSave {
    public TrophyProgress MonsterKill;
    public TrophyProgress CollectGold;
    public TrophyProgress ReachStage;
    public TrophyProgress CollectRelics;
    public TrophyProgress OwnArtifacts;
    public TrophyProgress HeroDPS;
    public TrophyProgress BossKill;
    public TrophyProgress TapCount;
    public TrophyProgress PrestigeCount;
    public TrophyProgress HeroLevelUp;
    public TrophyProgress ChestsOpened;
    public TrophyProgress FairyCount;
    public TrophyProgress JumpAttackCount;
    public TrophyProgress CriticalAttackCount;

    public TrophyProgressSave(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }

        this.MonsterKill = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "MonsterKill"));
        this.CollectGold = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "CollectGold"));
        this.ReachStage = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "ReachStage"));
        this.CollectRelics = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "CollectRelics"));
        this.OwnArtifacts = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "OwnArtifacts"));
        this.HeroDPS = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "HeroDPS"));
        this.BossKill = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "BossKill"));
        this.TapCount = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "TapCount"));
        this.PrestigeCount = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "PrestigeCount"));
        this.HeroLevelUp = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "HeroLevelUp"));
        this.ChestsOpened = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "ChestsOpened"));
        this.FairyCount = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "FairyCount"));
        this.JumpAttackCount = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "JumpAttackCount"));
        this.CriticalAttackCount = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, "CriticalAttackCount"));
    }

    private void populateFromNull() {
        this.MonsterKill = new TrophyProgress(null);
        this.CollectGold = new TrophyProgress(null);
        this.ReachStage = new TrophyProgress(null);
        this.CollectRelics = new TrophyProgress(null);
        this.OwnArtifacts = new TrophyProgress(null);
        this.HeroDPS = new TrophyProgress(null);
        this.BossKill = new TrophyProgress(null);
        this.TapCount = new TrophyProgress(null);
        this.PrestigeCount = new TrophyProgress(null);
        this.PrestigeCount = new TrophyProgress(null);
        this.HeroLevelUp = new TrophyProgress(null);
        this.ChestsOpened = new TrophyProgress(null);
        this.FairyCount = new TrophyProgress(null);
        this.JumpAttackCount = new TrophyProgress(null);
        this.CriticalAttackCount = new TrophyProgress(null);
    }
}
