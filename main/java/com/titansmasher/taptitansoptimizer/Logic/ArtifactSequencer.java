package com.titansmasher.taptitansoptimizer.Logic;

import com.titansmasher.taptitansoptimizer.Helpers.Pair;
import com.titansmasher.taptitansoptimizer.Model.Enums.Artifact;
import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.Model.LiveUpdate;
import com.titansmasher.taptitansoptimizer.Model.SequencePriority.SequenceArtifact;
import com.titansmasher.taptitansoptimizer.Model.SequencePriority.SequencePriorityModel;
import com.titansmasher.taptitansoptimizer.Model.UnityRandom.UnityRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Danny on 23/10/2016.
 */

public class ArtifactSequencer {
    public int seed;
    public SequencePriorityModel model;

    public ArtifactSequencer(int seed, SequencePriorityModel model){
        this.model = model;
        this.seed = seed;
    }

    public static List<Artifact> getSequence(World world, int seed, Map<Artifact, Boolean> artifacts, List<Boolean> salvageSteps, List<UnityRandom> artifactMap){
        List<Artifact> unOwnedArtifacts = new ArrayList<>();
        int ownedCount = 0;
        for (Artifact artifact : artifacts.keySet()){
            if (artifacts.get(artifact)){
                ownedCount++;
            } else {
                unOwnedArtifacts.add(artifact);
            }
        }

        List<Artifact> output = new ArrayList<>();
        int stepNo = 0;

        while (unOwnedArtifacts.size() > 0){
            Pair<Artifact,Integer> data = getNext(seed, ownedCount, unOwnedArtifacts, artifactMap);
            if (salvageSteps.size() <= stepNo || !salvageSteps.get(stepNo)){
                unOwnedArtifacts.remove(data.getFirst());
                ownedCount++;
            }
            output.add(data.getFirst());
            seed = data.getSecond();
            stepNo++;
        }

        return output;

    }

    //public LiveUpdate optimiseSalvages(final World world, final List<UnityRandom> artifactMap, final int iterations){
    //    final LiveUpdate tracker = new LiveUpdate();
    //    tracker.output = new ArrayList<Boolean>();
    //    new Thread(new Runnable() {
    //        @Override
    //        public void run() {
    //            List<Boolean> salvageOrder = new ArrayList<Boolean>();

    //            double best = -1;

    //            for (int i = 0; i < iterations; i++){
    //                List<Artifact> artifacts = getSequence(world, salvageOrder, artifactMap);
    //                double value = getsequenceValue(world, artifacts);
    //                if (value > best){
    //                    best = value;
    //                    tracker.output = new ArrayList<>(salvageOrder);
    //                }
    //                salvageOrder = incriment(salvageOrder);
    //            }
    //            tracker.done = true;
    //        }
    //    }).start();
    //    return tracker;
    //}

    private double temp = 0;

    private double getsequenceValue(World world, List<Artifact> artifacts){
        double score = 0;
        for (SequenceArtifact sArtifact :
                this.model.getForWorld(world)) {
            if (!sArtifact.isOwned()) {
                double position = artifacts.indexOf(sArtifact.artifact);
                double priority = sArtifact.priority;
                score += (1 + priority) / (position + 1);
            }
        }

        return score;
    }

    private static Pair<Artifact, Integer> getNext (int seed, int ownedCount, List<Artifact> remaining, List<UnityRandom> unityRandomMap){
        int nextSeed = unityRandomMap.get(seed).nextSeed;
        Artifact artifact = remaining.get(unityRandomMap.get(seed).nextArtifactIndex.get(ownedCount));
        return new Pair<>(artifact, nextSeed);
    }

    private List<Boolean> incriment(List<Boolean> bools){
        List<Boolean> outlist = new ArrayList<>();
        boolean swap = true;
        for (boolean var :
                bools) {
            if (var && swap){
                outlist.add(false);
            }
            else if (swap){
                outlist.add(true);
                swap = false;
            }
            else {
                outlist.add(var);
            }
        }
        if (swap){
            outlist.add(true);
        }
        return outlist;
    }
}
