package com.titansmasher.taptitansoptimizer.Model.RawSave.TrophyClasses;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;

import org.json.JSONObject;

/**
 * Created by Danny on 22/10/2016.
 */

public class TrophyProgress {
    public double progress;
    public int goalsCompleted;
    public int collected;

    private String PROGRESS_KEY = "progress";
    private String GOALSCOMPLETED_KEY = "goalsCompleted";
    private String COLLECTED_KEY = "collected";

    public TrophyProgress(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }

        this.progress = GenericHelpers.getDoubleSafe(obj, PROGRESS_KEY);
        this.goalsCompleted = GenericHelpers.getIntSafe(obj, GOALSCOMPLETED_KEY);
        this.collected = GenericHelpers.getIntSafe(obj, COLLECTED_KEY);
    }

    private void populateFromNull() {
        this.progress = 0;
        this.goalsCompleted = 0;
        this.collected = 0;
    }

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putDoubleSafe(obj, PROGRESS_KEY, this.progress);
        GenericHelpers.putIntSafe(obj, GOALSCOMPLETED_KEY, this.goalsCompleted);
        GenericHelpers.putIntSafe(obj, COLLECTED_KEY, this.collected);

        return obj;
    }
}
