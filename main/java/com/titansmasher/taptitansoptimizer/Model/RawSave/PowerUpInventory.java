package com.titansmasher.taptitansoptimizer.Model.RawSave;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;

import org.json.JSONObject;

/**
 * Created by Danny on 22/10/2016.
 */

public class PowerUpInventory {
    public int powerOfHolding;
    public int guardianShield;
    public int halfMonsterHP;
    public int bonusCash;

    public String POWEROFHOLDING_KEY = "PowerOfHolding";
    public String GUARDIANSHIELD_KEY = "GuardianShield";
    public String HALFMONSTERHP_KEY = "HalfMonsterHP";
    public String BONUSCASH_KEY = "BonusCash";

    public PowerUpInventory(JSONObject obj) {
        this.powerOfHolding = GenericHelpers.getIntSafe(obj, POWEROFHOLDING_KEY);
        this.guardianShield = GenericHelpers.getIntSafe(obj, GUARDIANSHIELD_KEY);
        ;
        this.halfMonsterHP = GenericHelpers.getIntSafe(obj, HALFMONSTERHP_KEY);
        ;
        this.bonusCash = GenericHelpers.getIntSafe(obj, BONUSCASH_KEY);
        ;
    }

    private void populateFromNull() {
        this.powerOfHolding = 0;
        this.guardianShield = 0;
        this.halfMonsterHP = 0;
        this.bonusCash = 0;
    }

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putIntSafe(obj, POWEROFHOLDING_KEY, powerOfHolding);
        GenericHelpers.putIntSafe(obj, GUARDIANSHIELD_KEY, guardianShield);
        GenericHelpers.putIntSafe(obj, HALFMONSTERHP_KEY, halfMonsterHP);
        GenericHelpers.putIntSafe(obj, BONUSCASH_KEY, bonusCash);

        return obj;
    }
}
