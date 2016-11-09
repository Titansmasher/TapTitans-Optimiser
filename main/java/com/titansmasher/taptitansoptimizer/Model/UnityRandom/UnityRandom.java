package com.titansmasher.taptitansoptimizer.Model.UnityRandom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danny on 24/10/2016.
 */

public class UnityRandom {
    public int currentSeed;
    public int nextSeed;
    public List<Integer> nextArtifactIndex;

    private UnityRandom(int currentSeed, int nextSeed, List<Integer> artifactIndeicies){
        this.currentSeed = currentSeed;
        this.nextSeed = nextSeed;
        this.nextArtifactIndex = artifactIndeicies;
    }

    public static List<UnityRandom> getUnityRandom(InputStream rawFile){
        List<UnityRandom> outputMap = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(rawFile));

        String line;
        String[] lineSplit;
        try {
            while ((line = reader.readLine()) != null){
                lineSplit = line.split(",");
                int seed1 = Integer.parseInt(lineSplit[0]);
                int seed2 = Integer.parseInt(lineSplit[1]);
                List<Integer> indicies= new ArrayList<>();
                for (String s :
                        lineSplit) {
                    indicies.add(Integer.parseInt(s));
                }
                outputMap.add(new UnityRandom(seed1, seed2, indicies.subList(2, indicies.size())));
            }
        } catch (IOException ex){

        }

        return outputMap;
    }
}
