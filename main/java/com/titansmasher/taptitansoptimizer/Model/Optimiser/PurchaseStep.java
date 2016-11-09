package com.titansmasher.taptitansoptimizer.Model.Optimiser;

import com.titansmasher.taptitansoptimizer.Model.Enums.Artifact;

/**
 * Created by Danny on 26/10/2016.
 */

public class PurchaseStep {
    public Artifact artifact;
    public int levelTo;
    public double cost;

    public PurchaseStep(Artifact artifact, int levelTo, double cost){
        this.artifact = artifact;
        this.levelTo = levelTo;
        this.cost = cost;
    }
}
