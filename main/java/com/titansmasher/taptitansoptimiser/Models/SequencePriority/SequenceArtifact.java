package com.titansmasher.taptitansoptimiser.Models.SequencePriority;

import com.titansmasher.taptitansoptimiser.Models.Enums.Artifact;

/**
 * Created by Danny on 23/10/2016.
 */

public class SequenceArtifact {
    private boolean locked = false;
    private boolean owned = false;
    public int priority = 0;
    public Artifact artifact;

    public SequenceArtifact(int artifactCount, Artifact artifact){
        this.locked = artifactCount > 0;
        this.owned = artifactCount > 0;
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
}
