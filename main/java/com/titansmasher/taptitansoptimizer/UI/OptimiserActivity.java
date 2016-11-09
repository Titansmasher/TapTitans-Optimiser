package com.titansmasher.taptitansoptimizer.UI;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Logic.RelicOptimiser;
import com.titansmasher.taptitansoptimizer.Model.Enums.Artifact;
import com.titansmasher.taptitansoptimizer.Model.Enums.CalculationType;
import com.titansmasher.taptitansoptimizer.Model.Enums.Hero;
import com.titansmasher.taptitansoptimizer.Model.Enums.Page;
import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.Model.LiveUpdate;
import com.titansmasher.taptitansoptimizer.Model.Optimiser.PurchaseStep;
import com.titansmasher.taptitansoptimizer.Model.RawSave.HeroClasses.HeroLevels;
import com.titansmasher.taptitansoptimizer.Model.WorldSave;
import com.titansmasher.taptitansoptimizer.R;
import com.titansmasher.taptitansoptimizer.UI.Abstracts.PagedActivityBase;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by Danny on 03/11/2016.
 */

public class OptimiserActivity extends PagedActivityBase {
    private Map<Page, LiveUpdate<List<PurchaseStep>>> optimiserProcesses = new HashMap<>();
    private Map<Page, Boolean> processing = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPage(Page.OPTIMISER_SETTINGS, View.inflate(this, R.layout.optimiser_settings, null), getString(R.string.tab_optimiser_settings));
        addPage(Page.OPTIMISER_CUSTOMHEROLEVELS, View.inflate(this, R.layout.optimiser_herolevels, null), getString(R.string.tab_optimiser_herolevels));
        addPage(Page.OPTIMISER_DMGE, View.inflate(this, R.layout.optimiser_output, null), getString(R.string.tab_optimiser_dmge));
        addPage(Page.OPTIMISER_TDMG, View.inflate(this, R.layout.optimiser_output, null), getString(R.string.tab_optimiser_tdmg));
        addPage(Page.OPTIMISER_GOLD, View.inflate(this, R.layout.optimiser_output, null), getString(R.string.tab_optimiser_gold));
        addPage(Page.OPTIMISER_DMG, View.inflate(this, R.layout.optimiser_output, null), getString(R.string.tab_optimiser_dmg));

        processing.put(Page.OPTIMISER_DMGE, false);
        processing.put(Page.OPTIMISER_TDMG, false);
        processing.put(Page.OPTIMISER_GOLD, false);
        processing.put(Page.OPTIMISER_DMG,  false);

        findEditText(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_steps).setText("100");

        registerEvents();
    }

    private boolean isSaveValid(){
        if (application.saveManager.getSave(application.activeSaveId) == null) {
            finish();
            return false;
        }
        return true;
    }

    @Override
    public void worldChanged(World world) {
        if (!isSaveValid())
            return;
        WorldSave save = getWorldSave();

        findEditText(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_relics).setText(String.valueOf(save.playerRelics));

        populateHeroLevels(save.heroLevels.mapHeros());
    }

    @Override
    public void saveChanged() {
        if (!isSaveValid())
            return;
        worldChanged(application.currentWorld);
    }

    private void registerEvents(){
        findButton(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_heros_fromsave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateHeroLevels(getWorldSave().heroLevels.mapHeros());
            }
        });
        findButton(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_heros_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<Hero, Integer> levels = new HeroLevels(null).mapHeros();
                for (Hero hero
                        : levels.keySet()){
                    levels.put(hero, 2000);
                }
                populateHeroLevels(levels);
            }
        });

        findButton(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_resetrelics).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findEditText(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_relics).setText(String.valueOf(getWorldSave().playerRelics));
            }
        });

        findEditText(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_relics).addTextChangedListener(generatePositiveIntValidator());
        findEditText(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_steps).addTextChangedListener(generatePositiveIntValidator(300));


        getPage(Page.OPTIMISER_DMG).findViewById(R.id.optimiser_artifact_floatview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView view = new ImageView(getApplicationContext());
                Bitmap viewImage = GenericHelpers.getBitmapFromView(findTable(getPage(Page.OPTIMISER_DMG), R.id.optimiser_artifact_totaltable), 0.7f);
                view.setImageBitmap(viewImage);

                stopFloatingWidget();
                startFloatingWidget(view);
            }
        });
        getPage(Page.OPTIMISER_GOLD).findViewById(R.id.optimiser_artifact_floatview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView view = new ImageView(getApplicationContext());
                Bitmap viewImage = GenericHelpers.getBitmapFromView(findTable(getPage(Page.OPTIMISER_GOLD), R.id.optimiser_artifact_totaltable), 0.7f);
                view.setImageBitmap(viewImage);

                stopFloatingWidget();
                startFloatingWidget(view);
            }
        });
        getPage(Page.OPTIMISER_TDMG).findViewById(R.id.optimiser_artifact_floatview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView view = new ImageView(getApplicationContext());
                Bitmap viewImage = GenericHelpers.getBitmapFromView(findTable(getPage(Page.OPTIMISER_TDMG), R.id.optimiser_artifact_totaltable), 0.7f);
                view.setImageBitmap(viewImage);

                stopFloatingWidget();
                startFloatingWidget(view);
            }
        });
        getPage(Page.OPTIMISER_DMGE).findViewById(R.id.optimiser_artifact_floatview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView view = new ImageView(getApplicationContext());
                Bitmap viewImage = GenericHelpers.getBitmapFromView(findTable(getPage(Page.OPTIMISER_DMGE), R.id.optimiser_artifact_totaltable), 0.7f);
                view.setImageBitmap(viewImage);

                stopFloatingWidget();
                startFloatingWidget(view);
            }
        });

        findButton(getPage(Page.OPTIMISER_DMG), R.id.optimiser_output_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArtifactSteps(CalculationType.DMG, Page.OPTIMISER_DMG);
            }
        });
        findButton(getPage(Page.OPTIMISER_GOLD), R.id.optimiser_output_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArtifactSteps(CalculationType.GOLD, Page.OPTIMISER_GOLD);
            }
        });
        findButton(getPage(Page.OPTIMISER_TDMG), R.id.optimiser_output_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArtifactSteps(CalculationType.TDMG, Page.OPTIMISER_TDMG);
            }
        });
        findButton(getPage(Page.OPTIMISER_DMGE), R.id.optimiser_output_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArtifactSteps(CalculationType.DMGE, Page.OPTIMISER_DMGE);
            }
        });

        View herosPage = getPage(Page.OPTIMISER_CUSTOMHEROLEVELS);

        findEditText(herosPage, R.id.optimiser_herolevels_1 ).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(1 ))));
        findEditText(herosPage, R.id.optimiser_herolevels_2 ).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(2 ))));
        findEditText(herosPage, R.id.optimiser_herolevels_3 ).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(3 ))));
        findEditText(herosPage, R.id.optimiser_herolevels_4 ).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(4 ))));
        findEditText(herosPage, R.id.optimiser_herolevels_5 ).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(5 ))));
        findEditText(herosPage, R.id.optimiser_herolevels_6 ).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(6 ))));
        findEditText(herosPage, R.id.optimiser_herolevels_7 ).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(7 ))));
        findEditText(herosPage, R.id.optimiser_herolevels_8 ).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(8 ))));
        findEditText(herosPage, R.id.optimiser_herolevels_9 ).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(9 ))));
        findEditText(herosPage, R.id.optimiser_herolevels_10).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(10))));
        findEditText(herosPage, R.id.optimiser_herolevels_11).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(11))));
        findEditText(herosPage, R.id.optimiser_herolevels_12).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(12))));
        findEditText(herosPage, R.id.optimiser_herolevels_13).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(13))));
        findEditText(herosPage, R.id.optimiser_herolevels_14).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(14))));
        findEditText(herosPage, R.id.optimiser_herolevels_15).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(15))));
        findEditText(herosPage, R.id.optimiser_herolevels_16).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(16))));
        findEditText(herosPage, R.id.optimiser_herolevels_17).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(17))));
        findEditText(herosPage, R.id.optimiser_herolevels_18).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(18))));
        findEditText(herosPage, R.id.optimiser_herolevels_19).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(19))));
        findEditText(herosPage, R.id.optimiser_herolevels_20).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(20))));
        findEditText(herosPage, R.id.optimiser_herolevels_21).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(21))));
        findEditText(herosPage, R.id.optimiser_herolevels_22).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(22))));
        findEditText(herosPage, R.id.optimiser_herolevels_23).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(23))));
        findEditText(herosPage, R.id.optimiser_herolevels_24).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(24))));
        findEditText(herosPage, R.id.optimiser_herolevels_25).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(25))));
        findEditText(herosPage, R.id.optimiser_herolevels_26).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(26))));
        findEditText(herosPage, R.id.optimiser_herolevels_27).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(27))));
        findEditText(herosPage, R.id.optimiser_herolevels_28).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(28))));
        findEditText(herosPage, R.id.optimiser_herolevels_29).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(29))));
        findEditText(herosPage, R.id.optimiser_herolevels_30).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(30))));
        findEditText(herosPage, R.id.optimiser_herolevels_31).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(31))));
        findEditText(herosPage, R.id.optimiser_herolevels_32).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(32))));
        findEditText(herosPage, R.id.optimiser_herolevels_33).addTextChangedListener(generatePositiveIntValidator(createHeroLevelValidator(Hero.getHero(33))));
    }

    private void refreshOptimiserButton(Page page){
        if (processing.get(page) == true){
            findButton(getPage(page), R.id.optimiser_output_calculate).setText("Stop Optimisation");
        } else {
            findButton(getPage(page), R.id.optimiser_output_calculate).setText(getString(R.string.optimiser_output_calc));
        }
    }


    private void getArtifactSteps(CalculationType method, final Page page) {
        if (processing.get(page).equals(true)){
            optimiserProcesses.get(page).done = true;
            Snackbar.make(baseContent, "Stopping optimisation...", 500).show();
            return;
        }
        processing.put(page, true);
        refreshOptimiserButton(page);

        String relicText = findEditText(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_relics).getText().toString();
        if (relicText.equals("") || relicText == null){
            relicText = "0";
            findEditText(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_relics).setText("0");
        }
        int relicLimit = Integer.parseInt(relicText);

        String stepText = findEditText(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_steps).getText().toString();
        if (stepText.equals("") || stepText == null){
            stepText = "0";
            findEditText(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_artifact_steps).setText("0");
        }
        int stepLimit = Integer.parseInt(stepText);

        Map<Hero, Integer> heroLevels = getHeroLevels();

        boolean useAllRelics = findCheckBox(getPage(Page.OPTIMISER_SETTINGS), R.id.optimiser_settings_useallrelics).isChecked();

        WorldSave save = getWorldSave();
        View pageView = getPage(page);

        final LiveUpdate<List<PurchaseStep>> asyncLink = RelicOptimiser.getBestAsync(method,
                application.currentWorld,
                save.artifactLevels.mapArtifacts(),
                heroLevels,
                save.heroWeaponUpgrades.mapHeros(),
                save.unlockedPlayerCustomizations.mapCustomizations(),
                relicLimit,
                stepLimit,
                useAllRelics);

        this.optimiserProcesses.put(page, asyncLink);

        final TableLayout sequenceTable = findTable(pageView, R.id.optimiser_artifact_sequencetable);
        final TableLayout totalTable = findTable(pageView, R.id.optimiser_artifact_totaltable);
        final ProgressBar spinnersequence = (ProgressBar) (pageView.findViewById(R.id.optimiser_loading_sequence));
        final ProgressBar spinnertotal = (ProgressBar) (pageView.findViewById(R.id.optimiser_loading_total));

        spinnersequence.setVisibility(View.VISIBLE);
        spinnertotal.setVisibility(View.VISIBLE);

        addArtifactRow(sequenceTable, "#", "Artifact", "Level to", "Cost", false);
        addArtifactRow(totalTable, "Artifact", "Level to", "Cost", false);

        sequenceTable.removeAllViews();
        totalTable.removeAllViews();

        Snackbar.make(baseContent, "Calculating optimal relics...", 700).show();

        final Handler handler = new Handler();

        handler.post(new Runnable() {
            private int lastIndex = 0;
            private boolean altColour = true;
            private int stepNo = 1;
            private double total = 0;
            final private Map<Artifact, PurchaseStep> purchaseTotals = new HashMap<>();

            @Override
            public void run() {
                int listSize = asyncLink.output.size();
                for (int i = lastIndex; i < listSize; i++) {
                    final String artifactName = getArtifactName(asyncLink.output.get(i).artifact);
                    final String levelTo = String.valueOf(asyncLink.output.get(i).levelTo);
                    final String cost = new DecimalFormat("#").format(asyncLink.output.get(i).cost);
                    final String step = String.valueOf(stepNo);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addArtifactRow(sequenceTable, step, artifactName, levelTo, cost, altColour);
                        }
                    });
                    stepNo++;
                    altColour = !altColour;
                    total += asyncLink.output.get(i).cost;
                    PurchaseStep current;
                    if (purchaseTotals.containsKey(asyncLink.output.get(i).artifact)){
                        current = purchaseTotals.get(asyncLink.output.get(i).artifact);
                    } else {
                        current = new PurchaseStep(asyncLink.output.get(i).artifact, 0, 0);
                    }
                    purchaseTotals.put(current.artifact, new PurchaseStep(current.artifact, asyncLink.output.get(i).levelTo, current.cost + asyncLink.output.get(i).cost));
                }

                lastIndex = listSize;

                if (!asyncLink.done)
                    handler.postDelayed(this, 500);
                else if (asyncLink.output.size() != lastIndex){
                    handler.post(this);
                }
                else{
                    final String totalCost = new DecimalFormat("#").format(total);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            boolean altColour = true;
                            for (PurchaseStep step
                                    : purchaseTotals.values()){
                                addArtifactRow(totalTable, getArtifactName(step.artifact), String.valueOf(step.levelTo), new DecimalFormat("#").format(step.cost), altColour);
                                altColour = !altColour;
                            }
                            addArtifactRow(totalTable, "", "Total", totalCost, altColour);
                            spinnersequence.setVisibility(View.GONE);
                            spinnertotal.setVisibility(View.GONE);
                            processing.put(page, false);
                            refreshOptimiserButton(page);
                        }
                    });
                }
            }
        });
    }

    private void addArtifactRow(TableLayout table, String artifact, String levelTo, String cost, boolean altColour) {
        TextView artifactName = new TextView(table.getContext());
        TextView artifactLevel = new TextView(table.getContext());
        TextView relicCost = new TextView(table.getContext());
        TableRow row = new TableRow(table.getContext());

        artifactName.setText(artifact);
        artifactLevel.setText(levelTo);
        relicCost.setText(cost);

        row.addView(artifactName);
        row.addView(artifactLevel);
        row.addView(relicCost);

        if (altColour) {
            row.setBackgroundColor(ContextCompat.getColor(table.getContext(), R.color.row_alternate));
        }

        table.addView(row);
    }

    private void addArtifactRow(TableLayout table, String stepNo, String artifact, String levelTo, String cost, boolean altColour) {
        TextView stepNoView = new TextView(table.getContext());
        TextView artifactName = new TextView(table.getContext());
        TextView artifactLevel = new TextView(table.getContext());
        TextView relicCost = new TextView(table.getContext());
        TableRow row = new TableRow(table.getContext());

        stepNoView.setText(stepNo + " ");
        artifactName.setText(artifact);
        artifactLevel.setText(levelTo);
        relicCost.setText(cost);

        row.addView(stepNoView);
        row.addView(artifactName);
        row.addView(artifactLevel);
        row.addView(relicCost);

        if (altColour) {
            row.setBackgroundColor(ContextCompat.getColor(table.getContext(), R.color.row_alternate));
        }

        table.addView(row);
    }

    private void populateHeroLevels(Map<Hero, Integer> heroLevels){
        View page = getPage(Page.OPTIMISER_CUSTOMHEROLEVELS);

        findEditText(page, R.id.optimiser_herolevels_1 ).setText(String.valueOf(heroLevels.get(Hero.Takeda)));
        findEditText(page, R.id.optimiser_herolevels_2 ).setText(String.valueOf(heroLevels.get(Hero.Contessa)));
        findEditText(page, R.id.optimiser_herolevels_3 ).setText(String.valueOf(heroLevels.get(Hero.Hornetta)));
        findEditText(page, R.id.optimiser_herolevels_4 ).setText(String.valueOf(heroLevels.get(Hero.Mila)));
        findEditText(page, R.id.optimiser_herolevels_5 ).setText(String.valueOf(heroLevels.get(Hero.Terra)));
        findEditText(page, R.id.optimiser_herolevels_6 ).setText(String.valueOf(heroLevels.get(Hero.Inquisireaux)));
        findEditText(page, R.id.optimiser_herolevels_7 ).setText(String.valueOf(heroLevels.get(Hero.Charlotte)));
        findEditText(page, R.id.optimiser_herolevels_8 ).setText(String.valueOf(heroLevels.get(Hero.Jordaan)));
        findEditText(page, R.id.optimiser_herolevels_9 ).setText(String.valueOf(heroLevels.get(Hero.Jukka)));
        findEditText(page, R.id.optimiser_herolevels_10).setText(String.valueOf(heroLevels.get(Hero.Milo)));
        findEditText(page, R.id.optimiser_herolevels_11).setText(String.valueOf(heroLevels.get(Hero.Macelord)));
        findEditText(page, R.id.optimiser_herolevels_12).setText(String.valueOf(heroLevels.get(Hero.Gertrude)));
        findEditText(page, R.id.optimiser_herolevels_13).setText(String.valueOf(heroLevels.get(Hero.Twitterella)));
        findEditText(page, R.id.optimiser_herolevels_14).setText(String.valueOf(heroLevels.get(Hero.MasterHawk)));
        findEditText(page, R.id.optimiser_herolevels_15).setText(String.valueOf(heroLevels.get(Hero.Elpha)));
        findEditText(page, R.id.optimiser_herolevels_16).setText(String.valueOf(heroLevels.get(Hero.Poppy)));
        findEditText(page, R.id.optimiser_herolevels_17).setText(String.valueOf(heroLevels.get(Hero.Skulptor)));
        findEditText(page, R.id.optimiser_herolevels_18).setText(String.valueOf(heroLevels.get(Hero.Sterling)));
        findEditText(page, R.id.optimiser_herolevels_19).setText(String.valueOf(heroLevels.get(Hero.Orba)));
        findEditText(page, R.id.optimiser_herolevels_20).setText(String.valueOf(heroLevels.get(Hero.Remus)));
        findEditText(page, R.id.optimiser_herolevels_21).setText(String.valueOf(heroLevels.get(Hero.Mikey)));
        findEditText(page, R.id.optimiser_herolevels_22).setText(String.valueOf(heroLevels.get(Hero.Peter)));
        findEditText(page, R.id.optimiser_herolevels_23).setText(String.valueOf(heroLevels.get(Hero.Tom)));
        findEditText(page, R.id.optimiser_herolevels_24).setText(String.valueOf(heroLevels.get(Hero.Deznis)));
        findEditText(page, R.id.optimiser_herolevels_25).setText(String.valueOf(heroLevels.get(Hero.Hamlette)));
        findEditText(page, R.id.optimiser_herolevels_26).setText(String.valueOf(heroLevels.get(Hero.Eistor)));
        findEditText(page, R.id.optimiser_herolevels_27).setText(String.valueOf(heroLevels.get(Hero.Flavius)));
        findEditText(page, R.id.optimiser_herolevels_28).setText(String.valueOf(heroLevels.get(Hero.Chester)));
        findEditText(page, R.id.optimiser_herolevels_29).setText(String.valueOf(heroLevels.get(Hero.Mohacas)));
        findEditText(page, R.id.optimiser_herolevels_30).setText(String.valueOf(heroLevels.get(Hero.Jaqulin)));
        findEditText(page, R.id.optimiser_herolevels_31).setText(String.valueOf(heroLevels.get(Hero.Pixie)));
        findEditText(page, R.id.optimiser_herolevels_32).setText(String.valueOf(heroLevels.get(Hero.Jackalope)));
        findEditText(page, R.id.optimiser_herolevels_33).setText(String.valueOf(heroLevels.get(Hero.DarkLord)));
    }

    private Map<Hero, Integer> getHeroLevels(){
        Map<Hero, Integer> levels = new HeroLevels(null).mapHeros();
        View page = getPage(Page.OPTIMISER_CUSTOMHEROLEVELS);

        levels.put(Hero.Takeda, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_1 ).getText().toString()));
        levels.put(Hero.Contessa, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_2 ).getText().toString()));
        levels.put(Hero.Hornetta, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_3 ).getText().toString()));
        levels.put(Hero.Mila, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_4 ).getText().toString()));
        levels.put(Hero.Terra, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_5 ).getText().toString()));
        levels.put(Hero.Inquisireaux, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_6 ).getText().toString()));
        levels.put(Hero.Charlotte, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_7 ).getText().toString()));
        levels.put(Hero.Jordaan, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_8 ).getText().toString()));
        levels.put(Hero.Jukka, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_9 ).getText().toString()));
        levels.put(Hero.Milo, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_10).getText().toString()));
        levels.put(Hero.Macelord, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_11).getText().toString()));
        levels.put(Hero.Gertrude, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_12).getText().toString()));
        levels.put(Hero.Twitterella, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_13).getText().toString()));
        levels.put(Hero.MasterHawk, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_14).getText().toString()));
        levels.put(Hero.Elpha, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_15).getText().toString()));
        levels.put(Hero.Poppy, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_16).getText().toString()));
        levels.put(Hero.Skulptor, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_17).getText().toString()));
        levels.put(Hero.Sterling, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_18).getText().toString()));
        levels.put(Hero.Orba, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_19).getText().toString()));
        levels.put(Hero.Remus, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_20).getText().toString()));
        levels.put(Hero.Mikey, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_21).getText().toString()));
        levels.put(Hero.Peter, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_22).getText().toString()));
        levels.put(Hero.Tom, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_23).getText().toString()));
        levels.put(Hero.Deznis, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_24).getText().toString()));
        levels.put(Hero.Hamlette, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_25).getText().toString()));
        levels.put(Hero.Eistor, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_26).getText().toString()));
        levels.put(Hero.Flavius, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_27).getText().toString()));
        levels.put(Hero.Chester, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_28).getText().toString()));
        levels.put(Hero.Mohacas, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_29).getText().toString()));
        levels.put(Hero.Jaqulin, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_30).getText().toString()));
        levels.put(Hero.Pixie, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_31).getText().toString()));
        levels.put(Hero.Jackalope, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_32).getText().toString()));
        levels.put(Hero.DarkLord, Integer.parseInt(findEditText(page, R.id.optimiser_herolevels_33).getText().toString()));

        return levels;
    }

    private Callable<Integer> createHeroLevelValidator(final Hero hero){
        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return hero.getLevelCap(application.currentWorld);
            }
        };
    }
}
