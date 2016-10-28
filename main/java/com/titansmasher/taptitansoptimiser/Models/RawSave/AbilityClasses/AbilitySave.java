package com.titansmasher.taptitansoptimiser.Models.RawSave.AbilityClasses;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;

import org.json.JSONObject;

/**
 * Created by Danny on 19/10/2016.
 */

public class AbilitySave {
    public AbilityLevels levels;
    public AbilityLevels levelsGirl;
    public AbilityCooldowns cooldown;
    public AbilityCooldowns cooldownGirl;

    public AbilitySave(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }

        this.levels = new AbilityLevels(GenericHelpers.getJSONObjectSafe(obj, "levels"));
        this.levelsGirl = new AbilityLevels(GenericHelpers.getJSONObjectSafe(obj, "levelsGirl"));
        this.cooldown = new AbilityCooldowns(GenericHelpers.getJSONObjectSafe(obj, "cooldown"));
        this.cooldownGirl = new AbilityCooldowns(GenericHelpers.getJSONObjectSafe(obj, "cooldownGirl"));
    }

    private void populateFromNull() {
        this.levels = new AbilityLevels(null);
        this.levelsGirl = new AbilityLevels(null);
        this.cooldown = new AbilityCooldowns(null);
        this.cooldownGirl = new AbilityCooldowns(null);
    }
}

