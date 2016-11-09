package com.titansmasher.taptitansoptimizer.Model.RawSave;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;

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

    public String TUTORIAL1_KEY = "Tutorial1";
    public String TUTORIAL2_KEY = "Tutorial2";
    public String TUTORIAL3_KEY = "Tutorial3";
    public String TUTORIALBOSSFAIL_KEY = "TutorialBossFail";
    public String TUTORIALFC_KEY = "TutorialFC";
    public String TUTORIALGOTRELIC_KEY = "TutorialGotRelic";
    public String TUTORIALGIRLAVAILABLE_KEY = "TutorialGirlAvailable";
    public String TUTORIALGIRL_KEY = "TutorialGirl";

    public TutorialProgress(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }

        this.Tutorial1 = GenericHelpers.getBooleanSafe(obj, TUTORIAL1_KEY, false);
        this.Tutorial2 = GenericHelpers.getBooleanSafe(obj, TUTORIAL2_KEY, false);
        this.Tutorial3 = GenericHelpers.getBooleanSafe(obj, TUTORIAL3_KEY, false);
        this.TutorialBossFail = GenericHelpers.getBooleanSafe(obj, TUTORIALBOSSFAIL_KEY, false);
        this.TutorialFC = GenericHelpers.getBooleanSafe(obj, TUTORIALFC_KEY, false);
        this.TutorialGotRelic = GenericHelpers.getBooleanSafe(obj, TUTORIALGOTRELIC_KEY, false);
        this.TutorialGirlAvailable = GenericHelpers.getBooleanSafe(obj, TUTORIALGIRLAVAILABLE_KEY, false);
        this.TutorialGirl = GenericHelpers.getBooleanSafe(obj, TUTORIALGIRL_KEY, false);
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

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putBooleanSafe(obj, TUTORIAL1_KEY, Tutorial1);
        GenericHelpers.putBooleanSafe(obj, TUTORIAL2_KEY, Tutorial2);
        GenericHelpers.putBooleanSafe(obj, TUTORIAL3_KEY, Tutorial3);
        GenericHelpers.putBooleanSafe(obj, TUTORIALBOSSFAIL_KEY, TutorialBossFail);
        GenericHelpers.putBooleanSafe(obj, TUTORIALFC_KEY, TutorialFC);
        GenericHelpers.putBooleanSafe(obj, TUTORIALGOTRELIC_KEY, TutorialGotRelic);
        GenericHelpers.putBooleanSafe(obj, TUTORIALGIRLAVAILABLE_KEY, TutorialGirlAvailable);
        GenericHelpers.putBooleanSafe(obj, TUTORIALGIRL_KEY, TutorialGirl);

        return obj;
    }
}
