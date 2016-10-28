package com.titansmasher.taptitansoptimiser.Models.RawSave.TrophyClasses;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;

import org.json.JSONObject;

/**
 * Created by Danny on 22/10/2016.
 */

public class TrophyProgress {
    public double progress;
    public int goalsCompleted;
    public int collected;

    public TrophyProgress(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }

        this.progress = GenericHelpers.getDoubleSafe(obj, "progress");
        this.goalsCompleted = GenericHelpers.getIntSafe(obj, "goalsCompleted");
        this.collected = GenericHelpers.getIntSafe(obj, "collected");
    }

    private void populateFromNull() {
        this.progress = 0;
        this.goalsCompleted = 0;
        this.collected = 0;
    }
}
