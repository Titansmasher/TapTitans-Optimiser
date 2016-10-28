package com.titansmasher.taptitansoptimiser.Models.RawSave;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;

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

    public RewardedIAPs(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }
        this.diamonds1 = GenericHelpers.getIntSafe(obj, "diamonds1");
        this.diamonds2 = GenericHelpers.getIntSafe(obj, "diamonds2");
        this.diamonds3 = GenericHelpers.getIntSafe(obj, "diamonds3");
        this.diamonds4 = GenericHelpers.getIntSafe(obj, "diamonds4");
        this.diamonds5 = GenericHelpers.getIntSafe(obj, "diamonds5");
        this.diamonds6 = GenericHelpers.getIntSafe(obj, "diamonds6");
        this.special1 = GenericHelpers.getIntSafe(obj, "special1");
        this.special2 = GenericHelpers.getIntSafe(obj, "special2");
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
}
