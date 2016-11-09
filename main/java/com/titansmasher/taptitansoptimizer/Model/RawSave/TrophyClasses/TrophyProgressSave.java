package com.titansmasher.taptitansoptimizer.Model.RawSave.TrophyClasses;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;

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

    private String MONSTERKILL_KEY = "MonsterKill";
    private String COLLECTGOLD_KEY = "CollectGold";
    private String REACHSTAGE_KEY = "ReachStage";
    private String COLLECTRELICS_KEY = "CollectRelics";
    private String OWNARTIFACTS_KEY = "OwnArtifacts";
    private String HERODPS_KEY = "HeroDPS";
    private String BOSSKILL_KEY = "BossKill";
    private String TAPCOUNT_KEY = "TapCount";
    private String PRESTIGECOUNT_KEY = "PrestigeCount";
    private String HEROLEVELUP_KEY = "HeroLevelUp";
    private String CHESTSOPENED_KEY = "ChestsOpened";
    private String FAIRYCOUNT_KEY = "FairyCount";
    private String JUMPATTACKCOUNT_KEY = "JumpAttackCount";
    private String CRITICALATTACKCOUNT_KEY = "CriticalAttackCount";

    public TrophyProgressSave(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }

        this.MonsterKill = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, MONSTERKILL_KEY));
        this.CollectGold = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, COLLECTGOLD_KEY));
        this.ReachStage = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, REACHSTAGE_KEY));
        this.CollectRelics = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, COLLECTRELICS_KEY));
        this.OwnArtifacts = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, OWNARTIFACTS_KEY));
        this.HeroDPS = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, HERODPS_KEY));
        this.BossKill = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, BOSSKILL_KEY));
        this.TapCount = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, TAPCOUNT_KEY));
        this.PrestigeCount = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, PRESTIGECOUNT_KEY));
        this.HeroLevelUp = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, HEROLEVELUP_KEY));
        this.ChestsOpened = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, CHESTSOPENED_KEY));
        this.FairyCount = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, FAIRYCOUNT_KEY));
        this.JumpAttackCount = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, JUMPATTACKCOUNT_KEY));
        this.CriticalAttackCount = new TrophyProgress(GenericHelpers.getJSONObjectSafe(obj, CRITICALATTACKCOUNT_KEY));
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

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putJSONObjectSafe(obj, MONSTERKILL_KEY, this.MonsterKill.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, COLLECTGOLD_KEY, this.CollectGold.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, REACHSTAGE_KEY, this.ReachStage.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, COLLECTRELICS_KEY, this.CollectRelics.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, OWNARTIFACTS_KEY, this.OwnArtifacts.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, HERODPS_KEY, this.HeroDPS.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, BOSSKILL_KEY, this.BossKill.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, TAPCOUNT_KEY, this.TapCount.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, PRESTIGECOUNT_KEY, this.PrestigeCount.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, HEROLEVELUP_KEY, this.HeroLevelUp.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, CHESTSOPENED_KEY, this.ChestsOpened.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, FAIRYCOUNT_KEY, this.FairyCount.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, JUMPATTACKCOUNT_KEY, this.JumpAttackCount.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, CRITICALATTACKCOUNT_KEY, this.CriticalAttackCount.generateJson());

        return obj;
    }
}
