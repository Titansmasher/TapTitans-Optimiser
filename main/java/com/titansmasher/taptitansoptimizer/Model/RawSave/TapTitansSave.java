package com.titansmasher.taptitansoptimizer.Model.RawSave;

import android.support.annotation.NonNull;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.Model.WorldSave;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Danny on 19/10/2016.
 */

public class TapTitansSave {
    public String lastUsedTexture = null;
    public PlayerInfoSave playerInfoSave;
    private boolean editable = true;
    private Map<World, WorldSave> worldSaves = new HashMap<>();

    private String LAST_USED_TEXTURE_KEY = "lastUsedTexture";
    private String PLAYER_INFO_SAVE_STRING = "playerInfoSaveString";

    public TapTitansSave(JSONObject obj) {
        populate(obj);
    }

    public TapTitansSave(@NonNull File saveFile) {
        this.loadSaveFromFile(saveFile);
    }

    public TapTitansSave(JSONObject obj, boolean editable) {
        populate(obj);
        this.editable = editable;
    }

    public TapTitansSave(@NonNull File saveFile, boolean editable) {
        this.loadSaveFromFile(saveFile);
        this.editable = editable;
    }

    public boolean isEditable() {
        return editable;
    }

    public void loadSaveFromString(String saveJson) {
        populate(GenericHelpers.constructJSONObjectSafe(saveJson));
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
        json = json.substring(json.indexOf("{\"" + PLAYER_INFO_SAVE_STRING));
        json = json.substring(0, json.lastIndexOf("}") + 1);

        JSONObject obj = GenericHelpers.constructJSONObjectSafe(json);

        populate(obj);
    }

    private void populate(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }

        JSONObject saveData = GenericHelpers.constructJSONObjectSafe(GenericHelpers.getStringSafe(obj, PLAYER_INFO_SAVE_STRING));
        this.lastUsedTexture = GenericHelpers.getStringSafe(obj, LAST_USED_TEXTURE_KEY);
        this.playerInfoSave = new PlayerInfoSave(saveData);

        populateWorldSaves();
    }

    private void populateFromNull() {
        this.lastUsedTexture = null;
        this.playerInfoSave = new PlayerInfoSave(null);

        populateWorldSaves();
    }

    private void populateWorldSaves(){
        for (World world :
                World.values()) {
            this.worldSaves.put(world, new WorldSave(this, world));
        }
    }

    public WorldSave getWorldSave(World world){
        return this.worldSaves.get(world);
    }

    public JSONObject generateJson() {
        JSONObject obj = new JSONObject();

        GenericHelpers.putStringSafe(obj, PLAYER_INFO_SAVE_STRING, this.playerInfoSave.generateJson().toString());
        GenericHelpers.putStringSafe(obj, LAST_USED_TEXTURE_KEY, this.lastUsedTexture);

        return obj;
    }
}
