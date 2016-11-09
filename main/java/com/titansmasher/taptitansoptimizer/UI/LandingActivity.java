package com.titansmasher.taptitansoptimizer.UI;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;

import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.R;
import com.titansmasher.taptitansoptimizer.UI.Abstracts.ActivityBase;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.Manifest;

/**
 * Created by Danny on 28/10/2016.
 */

public class LandingActivity extends ActivityBase {

    Map<Integer, ImageView> activityButtons = new HashMap<>();
    String LAST_VERSION_KEY = "LastOpenedVersion";

    @Override
    public boolean shouldShowBackButton(){
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseContent.addView(View.inflate(this, R.layout.landing_content, null));

        activityButtons.put(R.id.landing_button_stats, (ImageView) findViewById(R.id.landing_button_stats));
        activityButtons.put(R.id.landing_button_optimiser, (ImageView) findViewById(R.id.landing_button_optimiser));
        activityButtons.put(R.id.landing_button_sequencer, (ImageView) findViewById(R.id.landing_button_sequencer));
        activityButtons.put(R.id.landing_button_savemanager, (ImageView) findViewById(R.id.landing_button_savemanager));
        activityButtons.put(R.id.landing_button_faqabout, (ImageView) findViewById(R.id.landing_button_faqabout));

        activityButtons.get(R.id.landing_button_savemanager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SaveManagerActivity.class));
            }
        });
        activityButtons.get(R.id.landing_button_faqabout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FaqAboutActivity.class));
            }
        });

        Bitmap current = BitmapFactory.decodeResource(getResources(), R.drawable.landing_background);

        baseContent.setBackgroundDrawable(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(current, 1080, 1920, true)));

        int lastOpenedVersion = application.preferences.getInt(LAST_VERSION_KEY, 0);
        if (lastOpenedVersion == 0){
            application.preferences.edit().putInt(LAST_VERSION_KEY, application.currentVersion).commit();
            new AlertDialog.Builder(this)
                    .setTitle("Welcome!")
                    .setMessage(Html.fromHtml(getString(R.string.welcome_message)))
                    .setPositiveButton("Ok", null)
                    .show();
        } else if (lastOpenedVersion < application.currentVersion){
            application.preferences.edit().putInt(LAST_VERSION_KEY, application.currentVersion).commit();
            new AlertDialog.Builder(this)
                    .setTitle("Whats new?")
                    .setMessage(Html.fromHtml(getString(R.string.whats_new_message)))
                    .setPositiveButton("Ok", null)
                    .show();
        }
    }

    @Override
    public void saveChanged(){
        if (application.saveManager.getSave(application.activeSaveId) == null){
            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(baseContent, "No save selected!", 3000).show();
                }
            };
            activityButtons.get(R.id.landing_button_stats).setOnClickListener(listener);
            activityButtons.get(R.id.landing_button_optimiser).setOnClickListener(listener);
            activityButtons.get(R.id.landing_button_sequencer).setOnClickListener(listener);
        } else {
            activityButtons.get(R.id.landing_button_stats).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), StatsActivity.class));
                }
            });
            activityButtons.get(R.id.landing_button_optimiser).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), OptimiserActivity.class));
                }
            });
            activityButtons.get(R.id.landing_button_sequencer).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), SequencerActivity.class));
                }
            });
        }
    }

    @Override
    public void worldChanged(World world){
        //Snackbar.make(baseContent, "worldChanged", 1000).show();
    }
}
