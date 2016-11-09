package com.titansmasher.taptitansoptimizer.Model.RawSave;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;

import org.json.JSONObject;

/**
 * Created by Danny on 22/10/2016.
 */

public class RewardedIAPs {
    public int diamonds1;
    public int diamonds2;
    public int diamonds3;
    public int diamonds4;
    public int diamonds5;
    public int diamonds6;
    public int special1;
    public int special2;

    public String DIAMONDS1_KEY = "diamonds1";
    public String DIAMONDS2_KEY = "diamonds2";
    public String DIAMONDS3_KEY = "diamonds3";
    public String DIAMONDS4_KEY = "diamonds4";
    public String DIAMONDS5_KEY = "diamonds5";
    public String DIAMONDS6_KEY = "diamonds6";
    public String SPECIAL1_KEY  = "special1";
    public String SPECIAL2_KEY  = "special2";

    public RewardedIAPs(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }
        this.diamonds1 = GenericHelpers.getIntSafe(obj, DIAMONDS1_KEY);
        this.diamonds2 = GenericHelpers.getIntSafe(obj, DIAMONDS2_KEY);
        this.diamonds3 = GenericHelpers.getIntSafe(obj, DIAMONDS3_KEY);
        this.diamonds4 = GenericHelpers.getIntSafe(obj, DIAMONDS4_KEY);
        this.diamonds5 = GenericHelpers.getIntSafe(obj, DIAMONDS5_KEY);
        this.diamonds6 = GenericHelpers.getIntSafe(obj, DIAMONDS6_KEY);
        this.special1 = GenericHelpers.getIntSafe(obj,  SPECIAL1_KEY);
        this.special2 = GenericHelpers.getIntSafe(obj,  SPECIAL2_KEY);
    }

    private void populateFromNull() {
        this.diamonds1 = 0;
        this.diamonds2 = 0;
        this.diamonds3 = 0;
        this.diamonds4 = 0;
        this.diamonds5 = 0;
        this.diamonds6 = 0;
        this.special1 = 0;
        this.special2 = 0;
    }

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putIntSafe(obj, DIAMONDS1_KEY, diamonds1);
        GenericHelpers.putIntSafe(obj, DIAMONDS2_KEY, diamonds2);
        GenericHelpers.putIntSafe(obj, DIAMONDS3_KEY, diamonds3);
        GenericHelpers.putIntSafe(obj, DIAMONDS4_KEY, diamonds4);
        GenericHelpers.putIntSafe(obj, DIAMONDS5_KEY, diamonds5);
        GenericHelpers.putIntSafe(obj, DIAMONDS6_KEY, diamonds6);
        GenericHelpers.putIntSafe(obj, SPECIAL1_KEY, special1);
        GenericHelpers.putIntSafe(obj, SPECIAL2_KEY, special2);

        return obj;
    }
}
