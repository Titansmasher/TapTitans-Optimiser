package com.titansmasher.taptitansoptimiser.Save;

import com.titansmasher.taptitansoptimiser.Models.Enums.World;
import com.titansmasher.taptitansoptimiser.Models.RawSave.TapTitansSave;
import com.titansmasher.taptitansoptimiser.Models.SequencePriority.SequencePriorityModel;
import com.titansmasher.taptitansoptimiser.Models.WorldSave;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Danny on 22/10/2016.
 */

public class SaveManager {

    private static int curId = 0;
    private Map<Integer, TapTitansSave> saves = new HashMap<>();
    private Map<Integer, String> saveNames = new HashMap<>();
    private Map<Integer, SequencePriorityModel> sequencerPriorities = new HashMap<>();
    private int activeSave = -1;

    public int addSave(String name, TapTitansSave save) {
        int saveId = curId++;
        this.saves.put(saveId, save);
        this.saveNames.put(saveId, name);
        this.sequencerPriorities.put(saveId, new SequencePriorityModel(save));
        if (activeSave == -1) {
            activeSave = saveId;
        }

        return saveId;
    }

    public WorldSave getSave(int id, World world) {
        return new WorldSave(this.saves.get(id), world);
    }

    public SequencePriorityModel getSequencerPriorities(int id){
        return this.sequencerPriorities.get(id);
    }

    public String getSaveName(int id) {
        return this.saveNames.get(id);
    }

    public Set<Integer> getSaveIds() {
        return this.saves.keySet();
    }

    public boolean hasSaveId(int id) {
        return this.getSaveIds().contains(id);
    }

    public void removeSave(int id) {
        this.saves.remove(id);
        this.saveNames.remove(id);
        this.sequencerPriorities.remove(id);
        if (activeSave == id) {
            if (saves.size() > 0) {
                setActiveSave(getSaveIds().iterator().next());
            } else {
                this.activeSave = -1;
            }
        }
    }

    public boolean setActiveSave(int id) {
        if (this.hasSaveId(id)) {
            this.activeSave = id;
            return true;
        }
        return false;
    }

    public WorldSave getActiveSave(World world) {
        if (hasSaveId(activeSave)) {
            return getSave(activeSave, world);
        } else if (this.saves.size() > 0){
            return getSave(getSaveIds().iterator().next(), world);
        }
        return null;
    }

    public int getActiveSave() {
        return this.activeSave;
    }
}
