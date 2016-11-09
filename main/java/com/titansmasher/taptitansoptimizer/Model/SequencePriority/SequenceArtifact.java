package com.titansmasher.taptitansoptimizer.Model.SequencePriority;

import android.support.annotation.NonNull;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Model.Enums.Artifact;

import org.json.JSONObject;

/**
 * Created by Danny on 23/10/2016.
 */

public class SequenceArtifact {
    private boolean locked = false;
    private boolean owned = false;
    public int priority = 0;
    public Artifact artifact;

    private String LOCKED_KEY = "locked";
    private String OWNED_KEY = "owned";
    private String PRIORITY_KEY = "priority";
    private String ARTIFACT_KEY = "artifact";

    public SequenceArtifact(int artifactCount, Artifact artifact){
        this.locked = artifactCount > 0;
        this.owned = artifactCount > 0;
        this.artifact = artifact;
    }

    public SequenceArtifact(JSONObject obj, @NonNull Artifact artifact){
        if (obj == null){
            populateFromNull(artifact);
            return;
        }
        this.locked = GenericHelpers.getBooleanSafe(obj, LOCKED_KEY, false);
        this.owned = GenericHelpers.getBooleanSafe(obj, OWNED_KEY, false);
        this.priority = GenericHelpers.getIntSafe(obj, PRIORITY_KEY);
        this.artifact = artifact;
    }

    private void populateFromNull(Artifact artifact){
        this.locked = false;
        this.owned = false;
        this.priority = 0;
        this.artifact = artifact;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        if (!locked)
            this.owned = owned;
    }

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putBooleanSafe(obj, LOCKED_KEY, this.locked);
        GenericHelpers.putBooleanSafe(obj, OWNED_KEY, this.owned);
        GenericHelpers.putIntSafe(obj, PRIORITY_KEY, this.priority);
        GenericHelpers.putIntSafe(obj, ARTIFACT_KEY, this.artifact.artifactId);

        return obj;
    }
}
