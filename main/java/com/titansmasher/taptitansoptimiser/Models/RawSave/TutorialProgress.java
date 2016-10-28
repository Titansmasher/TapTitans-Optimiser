package com.titansmasher.taptitansoptimiser.Models.RawSave;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;

import org.json.JSONObject;

/**
 * Created by Danny on 22/10/2016.
 */

public class TutorialProgress {
    public boolean Tutorial1;
    public boolean Tutorial2;
    public boolean Tutorial3;
    public boolean TutorialBossFail;
    public boolean TutorialFC;
    public boolean TutorialGotRelic;
    public boolean TutorialGirlAvailable;
    public boolean TutorialGirl;

    public TutorialProgress(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }

        this.Tutorial1 = GenericHelpers.getBooleanSafe(obj, "Tutorial1", false);
        this.Tutorial2 = GenericHelpers.getBooleanSafe(obj, "Tutorial2", false);
        ;
        this.Tutorial3 = GenericHelpers.getBooleanSafe(obj, "Tutorial3", false);
        ;
        this.TutorialBossFail = GenericHelpers.getBooleanSafe(obj, "TutorialBossFail", false);
        ;
        this.TutorialFC = GenericHelpers.getBooleanSafe(obj, "TutorialFC", false);
        ;
        this.TutorialGotRelic = GenericHelpers.getBooleanSafe(obj, "TutorialGotRelic", false);
        ;
        this.TutorialGirlAvailable = GenericHelpers.getBooleanSafe(obj, "TutorialGirlAvailable", false);
        ;
        this.TutorialGirl = GenericHelpers.getBooleanSafe(obj, "TutorialGirl", false);
        ;
    }

    private void populateFromNull() {
        this.Tutorial1 = false;
        this.Tutorial2 = false;
        this.Tutorial3 = false;
        this.TutorialBossFail = false;
        this.TutorialFC = false;
        this.TutorialGotRelic = false;
        this.TutorialGirlAvailable = false;
        this.TutorialGirl = false;
    }
}
