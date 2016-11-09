package com.titansmasher.taptitansoptimizer.SaveManagement;

import com.titansmasher.taptitansoptimizer.Model.RawSave.TapTitansSave;
import com.titansmasher.taptitansoptimizer.Model.SaveData;
import com.titansmasher.taptitansoptimizer.Model.SequencePriority.SequencePriorityModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Danny on 22/10/2016.
 */

public class SaveManager {

    private static int curId = 0;
    private Map<Integer, SaveData> saves = new HashMap<>();

    public int addSave(SaveData data) {
        int saveId = curId++;
        this.saves.put(saveId, data);

        return saveId;
    }

    public boolean addSave(int saveId, SaveData data){
        curId = Math.max(curId, saveId + 1);

        this.saves.put(saveId, data);

        return true;
    }

    public SaveData getSaveData(int id){
        if (this.saves.keySet().contains(id))
            return this.saves.get(id);
        return null;
    }

    public TapTitansSave getSave(int id) {
        if (hasSaveId(id))
            return this.saves.get(id).save;
        return null;
    }

    public SequencePriorityModel getSequencerPriorities(int id){
        return this.saves.get(id).priorityModel;
    }

    public String getSaveName(int id) {
        return this.saves.get(id).saveName;
    }

    public Set<Integer> getSaveIds() {
        return this.saves.keySet();
    }

    public boolean hasSaveId(int id) {
        return this.getSaveIds().contains(id);
    }

    public void removeSave(int id) {
        this.saves.remove(id);
    }
}
