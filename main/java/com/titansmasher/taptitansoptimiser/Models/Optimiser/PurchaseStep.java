package com.titansmasher.taptitansoptimiser.Models.Optimiser;

import com.titansmasher.taptitansoptimiser.Models.Enums.Artifact;

/**
 * Created by Danny on 26/10/2016.
 */

public class PurchaseStep {
    public Artifact artifact;
    public int levelTo;
    public int cost;

    public PurchaseStep(Artifact artifact, int levelTo, int cost){
        this.artifact = artifact;
        this.levelTo = levelTo;
        this.cost = cost;
    }
}
