package com.titansmasher.taptitansoptimizer.Model.RawSave.AbilityClasses;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;

import org.json.JSONObject;

/**
 * Created by Danny on 19/10/2016.
 */

public class AbilitySave {
    public AbilityLevels levels;
    public AbilityLevels levelsGirl;
    public AbilityCooldowns cooldown;
    public AbilityCooldowns cooldownGirl;

    public String LEVELS_KEY = "levels";
    public String LEVELSGIRL_KEY = "levelsGirl";
    public String COOLDOWN_KEY = "cooldown";
    public String COOLDOWNGIRL_KEY = "cooldownGirl";

    public AbilitySave(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }

        this.levels = new AbilityLevels(GenericHelpers.getJSONObjectSafe(obj, LEVELS_KEY));
        this.levelsGirl = new AbilityLevels(GenericHelpers.getJSONObjectSafe(obj, LEVELSGIRL_KEY));
        this.cooldown = new AbilityCooldowns(GenericHelpers.getJSONObjectSafe(obj, COOLDOWN_KEY));
        this.cooldownGirl = new AbilityCooldowns(GenericHelpers.getJSONObjectSafe(obj, COOLDOWNGIRL_KEY));
    }

    private void populateFromNull() {
        this.levels = new AbilityLevels(null);
        this.levelsGirl = new AbilityLevels(null);
        this.cooldown = new AbilityCooldowns(null);
        this.cooldownGirl = new AbilityCooldowns(null);
    }

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putJSONObjectSafe(obj, LEVELS_KEY, levels.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, LEVELSGIRL_KEY, levelsGirl.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, COOLDOWN_KEY, cooldown.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, COOLDOWNGIRL_KEY, cooldownGirl.generateJson());

        return obj;
    }
}

