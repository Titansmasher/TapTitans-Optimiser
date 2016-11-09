package com.titansmasher.taptitansoptimizer;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.Model.RawSave.TapTitansSave;
import com.titansmasher.taptitansoptimizer.Model.SaveData;
import com.titansmasher.taptitansoptimizer.Model.UnityRandom.UnityRandom;
import com.titansmasher.taptitansoptimizer.SaveManagement.SaveManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Danny on 28/10/2016.
 */

public class OptimiserApp extends Application {
    public SaveManager saveManager = new SaveManager();
    public World currentWorld = World.WORLD_1;
    public int activeSaveId = 0;
    public SharedPreferences preferences;
    public Map<World, List<UnityRandom>> artifactUnityRandom = new HashMap<>();
    public boolean neverAskAgain = false;
    public int currentVersion;

    private String SAVES_KEY = "Saves";
    private String INSTALLMESSAGESHOWN_KEY = "installMessageShown";

    public void loadGameSaves(Activity activity){
        saveManager = new SaveManager();
        Set<String> savedFiles = preferences.getStringSet(SAVES_KEY, new HashSet<String>());
        for (String save :
                savedFiles) {
            int saveId = Integer.parseInt(save.split("\\|", 2)[0]);
            String saveData = save.split("\\|", 2)[1];
            saveManager.addSave(saveId, new SaveData(GenericHelpers.constructJSONObjectSafe(saveData)));
        }
        if (isTapTitansInstalled() && hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE, activity)){
            String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + getString(R.string.tapTitans_name);
            File saveLocation = null;
            File f = new File(path);
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().matches("^files(?!Save).*\\.adat$")) {
                        saveLocation = file;
                        break;
                    }
                }
            }
            if (saveLocation != null){
                SaveData data = new SaveData();
                data.saveName = "Tap Titans Save";
                data.save = new TapTitansSave(saveLocation, false);
                saveManager.addSave(0, data);
            }
        }
        Set<Integer> saveIds = saveManager.getSaveIds();

        if (!saveIds.contains(activeSaveId) && saveIds.size() > 0){
            activeSaveId = saveIds.iterator().next();
        }
    }

    public void saveGameSaves() {
        Set<String> saveStrings = new HashSet<>();
        for (int saveId:
                saveManager.getSaveIds()) {
            SaveData saveData = saveManager.getSaveData(saveId);
            if (saveData.save.isEditable()){
                saveStrings.add(String.valueOf(saveId) + "|" + saveData.generateJson().toString());
            }
        }
        preferences.edit().putStringSet(SAVES_KEY, saveStrings).commit();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        preferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);

        try {
            this.currentVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (Exception ex){
            this.currentVersion = 0;
        }

        try {
            artifactUnityRandom.put(World.WORLD_1, UnityRandom.getUnityRandom(getAssets().open("artifact_order_W1.csv")));
            artifactUnityRandom.put(World.WORLD_2, UnityRandom.getUnityRandom(getAssets().open("artifact_order_W2.csv")));
        }
        catch (IOException ex){

        }
    }

    public boolean isTapTitansInstalled() {
        try {
            this.getPackageManager().getApplicationInfo(getString(R.string.tapTitans_name), 0);
            return true;
        } catch (PackageManager.NameNotFoundException ex) {
            return false;
        }
    }

    public boolean shouldShowInstallMessage(){
        return !this.preferences.getBoolean(INSTALLMESSAGESHOWN_KEY, false) && !isTapTitansInstalled();
    }

    public boolean requestPermissionList(String[] permissions, int requestId, Activity activity, boolean force) {
        if (neverAskAgain) {
            return false;
        }

        List<String> permissionsToRequest = new ArrayList<>();
        boolean missingPermission = false;

        for (String permission :
                permissions) {
            if (!hasPermission(permission, activity)) {
                missingPermission = true;
                if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, permission) || force) {
                    permissionsToRequest.add(permission);
                }
            }
        }

        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(activity, permissionsToRequest.toArray(new String[permissionsToRequest.size()]), requestId);
        }

        return !missingPermission;
    }

    public boolean requestPermissionList(String[] permissions, int requestId, Activity activity){
        return requestPermissionList(permissions, requestId, activity, false);
    }

    public boolean hasPermission(String permission, Activity activity) {
        return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }
}
