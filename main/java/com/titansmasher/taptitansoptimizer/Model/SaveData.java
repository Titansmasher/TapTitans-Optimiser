package com.titansmasher.taptitansoptimizer.Model;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Model.RawSave.TapTitansSave;
import com.titansmasher.taptitansoptimizer.Model.SequencePriority.SequencePriorityModel;

import org.json.JSONObject;

/**
 * Created by Danny on 01/11/2016.
 */

public class SaveData {
    public TapTitansSave save;
    public String saveName;
    public SequencePriorityModel priorityModel;

    private String SAVE_KEY = "save";
    private String NAME_KEY = "name";
    private String PRIORITYMODEL_KEY = "prioritymodel";

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putJSONObjectSafe(obj, SAVE_KEY, save.generateJson());
        GenericHelpers.putStringSafe(obj, NAME_KEY, saveName);
        GenericHelpers.putJSONObjectSafe(obj, PRIORITYMODEL_KEY, priorityModel.generateJson());

        return obj;
    }

    public SaveData(){
        saveName = "";
        save = new TapTitansSave((JSONObject) null);
        priorityModel = new SequencePriorityModel(save);
    }

    public SaveData(JSONObject obj){
        this.save = new TapTitansSave(GenericHelpers.getJSONObjectSafe(obj, SAVE_KEY));
        this.saveName = GenericHelpers.getStringSafe(obj, NAME_KEY);
        this.priorityModel = new SequencePriorityModel(GenericHelpers.getJSONObjectSafe(obj, PRIORITYMODEL_KEY));
    }
}
