package com.titansmasher.taptitansoptimizer.UI;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.R;
import com.titansmasher.taptitansoptimizer.UI.Abstracts.ActivityBase;

/**
 * Created by Danny on 07/11/2016.
 */

public class SettingsActivity extends ActivityBase {
    @Override
    public boolean shouldShowBackButton(){
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        baseContent.addView(View.inflate(this, R.layout.settings_main, null));

        final Activity activity = this;

        findButton(baseContent, R.id.settings_requestdrawoverapps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestDrawOverApps();
            }
        });
        findButton(baseContent, R.id.settings_requestreadexternalstorage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (application.neverAskAgain){
                    new AlertDialog.Builder(activity)
                            .setTitle("Unable to request permissions")
                            .setMessage("You have selected \"Never ask again\" on a previous permission request, preventing this app requesting permissions ever again. Please go into the settings and grant the \"Read external storage\" permission manually.")
                            .setPositiveButton("Ok", null)
                            .show();
                    return;
                }
                application.requestPermissionList(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0, activity, true);
            }
        });
        findButton(baseContent, R.id.settings_optinbeta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.settings_betalink))));
            }
        });
        findButton(baseContent, R.id.settings_sourcelink).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.settings_sourcelink))));
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();

        findCheckBox(baseContent, R.id.settings_drawoverapps).setChecked(canDrawOverApps());
        findCheckBox(baseContent, R.id.settings_readexternalstorage).setChecked(application.hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE, this));
        findButton(baseContent, R.id.settings_requestdrawoverapps).setVisibility(canDrawOverApps() ? View.GONE : View.VISIBLE);
        findButton(baseContent, R.id.settings_requestreadexternalstorage).setVisibility(application.hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE, this) ? View.GONE : View.VISIBLE);
    }

    @Override
    public void saveChanged(){}

    @Override
    public void worldChanged(World world){}
}
