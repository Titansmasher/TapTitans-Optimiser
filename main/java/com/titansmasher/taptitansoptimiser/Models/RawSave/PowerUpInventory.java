package com.titansmasher.taptitansoptimiser.Models.RawSave;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;

import org.json.JSONObject;

/**
 * Created by Danny on 22/10/2016.
 */

public class PowerUpInventory {
    public int powerOfHolding;
    public int guardianShield;
    public int halfMonsterHP;
    public int bonusCash;

    public PowerUpInventory(JSONObject obj) {
        this.powerOfHolding = GenericHelpers.getIntSafe(obj, "PowerOfHolding");
        this.guardianShield = GenericHelpers.getIntSafe(obj, "GuardianShield");
        ;
        this.halfMonsterHP = GenericHelpers.getIntSafe(obj, "HalfMonsterHP");
        ;
        this.bonusCash = GenericHelpers.getIntSafe(obj, "BonusCash");
        ;
    }

    private void populateFromNull() {
        this.powerOfHolding = 0;
        this.guardianShield = 0;
        this.halfMonsterHP = 0;
        this.bonusCash = 0;
    }
}
