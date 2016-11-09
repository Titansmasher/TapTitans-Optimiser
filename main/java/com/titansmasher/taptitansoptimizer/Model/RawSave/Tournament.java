package com.titansmasher.taptitansoptimizer.Model.RawSave;

import org.json.JSONObject;

/**
 * Created by Danny on 20/10/2016.
 */

public class Tournament {
    public Tournament(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }
    }

    private void populateFromNull() {

    }

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        return obj;
    }
}
