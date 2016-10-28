package com.titansmasher.taptitansoptimiser;

import android.app.Application;

import com.titansmasher.taptitansoptimiser.Models.Enums.Page;
import com.titansmasher.taptitansoptimiser.Models.Enums.World;
import com.titansmasher.taptitansoptimiser.Save.SaveManager;
import com.titansmasher.taptitansoptimiser.Models.UnityRandom.UnityRandom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Danny on 21/10/2016.
 */

public class OptimiserApp extends Application {

    public final SaveManager saveManager = new SaveManager();
    public int defaultSave = -1;
    public World currentWorld = World.WORLD_1;
    public Page currentPage = Page.Stats;
    public Map<World, List<UnityRandom>> artifactUnityRandom = new HashMap<>();
}