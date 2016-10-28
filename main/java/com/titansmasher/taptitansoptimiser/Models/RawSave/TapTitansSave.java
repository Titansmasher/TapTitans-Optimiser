package com.titansmasher.taptitansoptimiser.Models.RawSave;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Danny on 19/10/2016.
 */

public class TapTitansSave {
    public String lastUsedTexture = null;
    public PlayerInfoSave playerInfoSave;
    private boolean editable = true;

    public TapTitansSave() {
        populate(null);
    }

    public TapTitansSave(File saveFile, boolean editable) {
        this.loadSaveFromFile(saveFile);
        this.editable = editable;
    }

    public boolean isEditable() {
        return editable;
    }

    public void loadSaveFromString(String saveJson) {
        populate(saveJson);
    }

    public void loadSaveFromFile(File saveFile) {
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(saveFile));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        } catch (IOException ex) {

        }
        String json = text.toString();
        json = json.substring(json.indexOf("{\"playerInfoSaveString"));
        json = json.substring(0, json.lastIndexOf("}") + 1);

        populate(json);
    }

    private void populate(String saveJson) {
        if (saveJson == null) {
            populateFromNull();
            return;
        }

        JSONObject obj = GenericHelpers.constructJSONObjectSafe(saveJson);
        JSONObject saveData = GenericHelpers.constructJSONObjectSafe(GenericHelpers.getStringSafe(obj, "playerInfoSaveString"));
        this.lastUsedTexture = GenericHelpers.getStringSafe(obj, "lastUsedTexture");
        this.playerInfoSave = new PlayerInfoSave(saveData);
    }

    private void populateFromNull() {
        this.lastUsedTexture = null;
        this.playerInfoSave = new PlayerInfoSave(null);
    }

    public String generateJson() {
        return "";
    }
}
