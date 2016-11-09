package com.titansmasher.taptitansoptimizer.UI;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Logic.RelicOptimiser;
import com.titansmasher.taptitansoptimizer.Model.Enums.Customisation;
import com.titansmasher.taptitansoptimizer.Model.Enums.Effect;
import com.titansmasher.taptitansoptimizer.Model.Enums.Hero;
import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.Model.Enums.Page;
import com.titansmasher.taptitansoptimizer.Model.Skill;
import com.titansmasher.taptitansoptimizer.Model.WorldSave;
import com.titansmasher.taptitansoptimizer.R;
import com.titansmasher.taptitansoptimizer.UI.Abstracts.PagedActivityBase;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Danny on 29/10/2016.
 */

public class StatsActivity extends PagedActivityBase {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.addPage(Page.STATS_ACCOUNT, View.inflate(this, R.layout.stats_account, null), getString(R.string.tab_stats_account));
        this.addPage(Page.STATS_WORLD, View.inflate(this, R.layout.stats_world, null), getString(R.string.tab_stats_world));
        this.addPage(Page.STATS_ARTIFACT, View.inflate(this, R.layout.stats_artifacts, null), getString(R.string.tab_stats_artifact));
        this.addPage(Page.STATS_HERO, View.inflate(this, R.layout.stats_heros, null), getString(R.string.tab_stats_hero));

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
        View artifactPage = getPage(Page.STATS_ARTIFACT);
        View worldPage = getPage(Page.STATS_WORLD);
        View heroPage = getPage(Page.STATS_HERO);

        switch (application.currentWorld){
            case WORLD_1:
                findTable(artifactPage, R.id.stats_artifacts_world1table).setVisibility(View.VISIBLE);
                findTable(artifactPage, R.id.stats_artifacts_world2table).setVisibility(View.GONE);
                break;
            case WORLD_2:
                findTable(artifactPage, R.id.stats_artifacts_world2table).setVisibility(View.VISIBLE);
                findTable(artifactPage, R.id.stats_artifacts_world1table).setVisibility(View.GONE);
                break;
        }
        int totalRelics = save.playerRelics;
        for (int i:
                save.artifactRelicsSpent.getForWorld(application.currentWorld)){
            totalRelics += i;
        }

        double relicMult = 1 + RelicOptimiser.getEffects(save.artifactLevels.mapArtifacts(application.currentWorld), new ArrayList<Skill>(), new HashMap<Customisation, Boolean>()).get(Effect.RELICS)/100;

        findTextView(worldPage, R.id.stats_world_maxstage).setText(String.valueOf((int) save.trophyProgress.ReachStage.progress));
        findTextView(worldPage, R.id.stats_world_currentstage).setText(String.valueOf(save.currentStage));
        findTextView(worldPage, R.id.stats_world_breakpoint).setText(String.valueOf((int)Math.max(90, (Math.floor(save.currentStage/15) + 1)*15)));
        findTextView(worldPage, R.id.stats_world_relicmult).setText("x" + new DecimalFormat("#.##").format(relicMult));
        findTextView(worldPage, R.id.stats_world_prestigerelics).setText(String.valueOf(RelicOptimiser.relicsAtStage(save.currentStage, save.artifactLevels.mapArtifacts(application.currentWorld), save.heroLevels.mapHeros())));
        findTextView(worldPage, R.id.stats_world_breakpointrelics).setText(String.valueOf(RelicOptimiser.relicsAtStage((int)Math.max(90, (Math.floor(save.currentStage/15) + 1)*15), save.artifactLevels.mapArtifacts(application.currentWorld), save.heroLevels.mapHeros())));
        findTextView(worldPage, R.id.stats_world_relics).setText(String.valueOf(save.playerRelics));
        findTextView(worldPage, R.id.stats_world_totalrelics).setText(String.valueOf(totalRelics));
        findTextView(worldPage, R.id.stats_world_totalgold).setText(GenericHelpers.beautify(save.playerGold));
        findTextView(worldPage, R.id.stats_world_goldlost).setText(GenericHelpers.beautify(save.goldLostToPrestige));
        findTextView(worldPage, R.id.stats_world_dpslost).setText(GenericHelpers.beautify(save.dpsLostToPrestige));
        findTextView(worldPage, R.id.stats_world_artifactseed).setText(String.valueOf(save.nextArtifactSeed));
        findTextView(worldPage, R.id.stats_world_weaponseed).setText(String.valueOf(save.heroWeaponSeed));

        findTextView(getPage(Page.STATS_ACCOUNT), R.id.stats_account_general_playername).setText(save.playerName);

        findTextView(heroPage, R.id.stats_herolevels_1 ).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Takeda)));
        findTextView(heroPage, R.id.stats_herolevels_2 ).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Contessa)));
        findTextView(heroPage, R.id.stats_herolevels_3 ).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Hornetta)));
        findTextView(heroPage, R.id.stats_herolevels_4 ).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Mila)));
        findTextView(heroPage, R.id.stats_herolevels_5 ).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Terra)));
        findTextView(heroPage, R.id.stats_herolevels_6 ).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Inquisireaux)));
        findTextView(heroPage, R.id.stats_herolevels_7 ).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Charlotte)));
        findTextView(heroPage, R.id.stats_herolevels_8 ).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Jordaan)));
        findTextView(heroPage, R.id.stats_herolevels_9 ).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Jukka)));
        findTextView(heroPage, R.id.stats_herolevels_10).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Milo)));
        findTextView(heroPage, R.id.stats_herolevels_11).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Macelord)));
        findTextView(heroPage, R.id.stats_herolevels_12).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Gertrude)));
        findTextView(heroPage, R.id.stats_herolevels_13).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Twitterella)));
        findTextView(heroPage, R.id.stats_herolevels_14).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.MasterHawk)));
        findTextView(heroPage, R.id.stats_herolevels_15).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Elpha)));
        findTextView(heroPage, R.id.stats_herolevels_16).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Poppy)));
        findTextView(heroPage, R.id.stats_herolevels_17).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Skulptor)));
        findTextView(heroPage, R.id.stats_herolevels_18).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Sterling)));
        findTextView(heroPage, R.id.stats_herolevels_19).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Orba)));
        findTextView(heroPage, R.id.stats_herolevels_20).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Remus)));
        findTextView(heroPage, R.id.stats_herolevels_21).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Mikey)));
        findTextView(heroPage, R.id.stats_herolevels_22).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Peter)));
        findTextView(heroPage, R.id.stats_herolevels_23).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Tom)));
        findTextView(heroPage, R.id.stats_herolevels_24).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Deznis)));
        findTextView(heroPage, R.id.stats_herolevels_25).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Hamlette)));
        findTextView(heroPage, R.id.stats_herolevels_26).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Eistor)));
        findTextView(heroPage, R.id.stats_herolevels_27).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Flavius)));
        findTextView(heroPage, R.id.stats_herolevels_28).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Chester)));
        findTextView(heroPage, R.id.stats_herolevels_29).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Mohacas)));
        findTextView(heroPage, R.id.stats_herolevels_30).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Jaqulin)));
        findTextView(heroPage, R.id.stats_herolevels_31).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Pixie)));
        findTextView(heroPage, R.id.stats_herolevels_32).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.Jackalope)));
        findTextView(heroPage, R.id.stats_herolevels_33).setText(String.valueOf(save.heroLevels.mapHeros().get(Hero.DarkLord)));

        findTextView(heroPage, R.id.stats_herolevels_total).setText(String.valueOf(GenericHelpers.sum(save.heroLevels.mapHeros().values())));
    }

    @Override
    public void saveChanged() {
        if (!isSaveValid())
            return;
        worldChanged(application.currentWorld);
        WorldSave save = getWorldSave();

        View artifactPage = getPage(Page.STATS_ARTIFACT);
        View accountPage = getPage(Page.STATS_ACCOUNT);

        findTextView(accountPage, R.id.stats_account_general_playername).setText(save.playerName);
        findTextView(accountPage, R.id.stats_account_general_friendcode).setText(save.friendCode);
        findTextView(accountPage, R.id.stats_account_general_playerlevel).setText(String.valueOf(save.playerLevel));
        findTextView(accountPage, R.id.stats_account_general_lastactive).setText(GenericHelpers.formatDate(save.lastActiveTime, "dd/MM/yyyy HH:mm:ss"));
        findTextView(accountPage, R.id.stats_account_general_playtime).setText(GenericHelpers.secondsToTime(save.activeTime));
        findTextView(accountPage, R.id.stats_account_general_diamonds).setText(String.valueOf(save.playerDiamonds));
        findTextView(accountPage, R.id.stats_account_general_timesincesync).setText(GenericHelpers.secondsToTime((int) save.playTimeSinceLastSync));
        findTextView(accountPage, R.id.stats_account_general_dungeonchain).setText(String.valueOf(save.dungeonsCompleted));
        findTextView(accountPage, R.id.stats_account_general_lastcloudsave).setText(GenericHelpers.formatDate(save.lastCloudSaveTime, "dd/MM/yyyy HH:mm:ss"));
        findTextView(accountPage, R.id.stats_account_general_ischeater).setText(GenericHelpers.boolToYesNoString(save.cheater));
        if (save.cheater) {
            findTextView(accountPage, R.id.stats_account_general_cheatercount).setText(String.valueOf(save.cheatCount));
            findTextView(accountPage, R.id.stats_account_general_cheaterreason).setText(save.cheaterReason);
            findRow(accountPage, R.id.stats_account_general_cheatercountrow).setVisibility(View.VISIBLE);
            findRow(accountPage, R.id.stats_account_general_cheaterreasonrow).setVisibility(View.VISIBLE);
        } else {
            findRow(accountPage, R.id.stats_account_general_cheatercountrow).setVisibility(View.GONE);
            findRow(accountPage, R.id.stats_account_general_cheaterreasonrow).setVisibility(View.GONE);
        }

        findTextView(accountPage, R.id.stats_account_purchases_purchasecount).setText(String.valueOf(save.iapPurchaseCount));
        findTextView(accountPage, R.id.stats_account_purchases_spendamount).setText("$" + save.iapSpendingInUSD);
        findTextView(accountPage, R.id.stats_account_purchases_unapprovedpurchases).setText(String.valueOf(save.iapPurchaseCount - save.iapApprovedByAppleGoogle));
        findTextView(accountPage, R.id.stats_account_purchases_diamonds1).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds1));
        findTextView(accountPage, R.id.stats_account_purchases_diamonds2).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds2));
        findTextView(accountPage, R.id.stats_account_purchases_diamonds3).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds3));
        findTextView(accountPage, R.id.stats_account_purchases_diamonds4).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds4));
        findTextView(accountPage, R.id.stats_account_purchases_diamonds5).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds5));
        findTextView(accountPage, R.id.stats_account_purchases_diamonds6).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds6));

        findTextView(artifactPage, R.id.stats_artifacts_artifact1_level).setText(String.valueOf(save.artifactLevels.Artifact1));
        findTextView(artifactPage, R.id.stats_artifacts_artifact1_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact1));
        findTextView(artifactPage, R.id.stats_artifacts_artifact2_level).setText(String.valueOf(save.artifactLevels.Artifact2));
        findTextView(artifactPage, R.id.stats_artifacts_artifact2_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact2));
        findTextView(artifactPage, R.id.stats_artifacts_artifact3_level).setText(String.valueOf(save.artifactLevels.Artifact3));
        findTextView(artifactPage, R.id.stats_artifacts_artifact3_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact3));
        findTextView(artifactPage, R.id.stats_artifacts_artifact4_level).setText(String.valueOf(save.artifactLevels.Artifact4));
        findTextView(artifactPage, R.id.stats_artifacts_artifact4_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact4));
        findTextView(artifactPage, R.id.stats_artifacts_artifact5_level).setText(String.valueOf(save.artifactLevels.Artifact5));
        findTextView(artifactPage, R.id.stats_artifacts_artifact5_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact5));
        findTextView(artifactPage, R.id.stats_artifacts_artifact6_level).setText(String.valueOf(save.artifactLevels.Artifact6));
        findTextView(artifactPage, R.id.stats_artifacts_artifact6_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact6));
        findTextView(artifactPage, R.id.stats_artifacts_artifact7_level).setText(String.valueOf(save.artifactLevels.Artifact7));
        findTextView(artifactPage, R.id.stats_artifacts_artifact7_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact7));
        findTextView(artifactPage, R.id.stats_artifacts_artifact8_level).setText(String.valueOf(save.artifactLevels.Artifact8));
        findTextView(artifactPage, R.id.stats_artifacts_artifact8_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact8));
        findTextView(artifactPage, R.id.stats_artifacts_artifact9_level).setText(String.valueOf(save.artifactLevels.Artifact9));
        findTextView(artifactPage, R.id.stats_artifacts_artifact9_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact9));
        findTextView(artifactPage, R.id.stats_artifacts_artifact10_level).setText(String.valueOf(save.artifactLevels.Artifact10));
        findTextView(artifactPage, R.id.stats_artifacts_artifact10_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact10));
        findTextView(artifactPage, R.id.stats_artifacts_artifact11_level).setText(String.valueOf(save.artifactLevels.Artifact11));
        findTextView(artifactPage, R.id.stats_artifacts_artifact11_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact11));
        findTextView(artifactPage, R.id.stats_artifacts_artifact12_level).setText(String.valueOf(save.artifactLevels.Artifact12));
        findTextView(artifactPage, R.id.stats_artifacts_artifact12_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact12));
        findTextView(artifactPage, R.id.stats_artifacts_artifact13_level).setText(String.valueOf(save.artifactLevels.Artifact13));
        findTextView(artifactPage, R.id.stats_artifacts_artifact13_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact13));
        findTextView(artifactPage, R.id.stats_artifacts_artifact14_level).setText(String.valueOf(save.artifactLevels.Artifact14));
        findTextView(artifactPage, R.id.stats_artifacts_artifact14_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact14));
        findTextView(artifactPage, R.id.stats_artifacts_artifact15_level).setText(String.valueOf(save.artifactLevels.Artifact15));
        findTextView(artifactPage, R.id.stats_artifacts_artifact15_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact15));
        findTextView(artifactPage, R.id.stats_artifacts_artifact16_level).setText(String.valueOf(save.artifactLevels.Artifact16));
        findTextView(artifactPage, R.id.stats_artifacts_artifact16_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact16));
        findTextView(artifactPage, R.id.stats_artifacts_artifact17_level).setText(String.valueOf(save.artifactLevels.Artifact17));
        findTextView(artifactPage, R.id.stats_artifacts_artifact17_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact17));
        findTextView(artifactPage, R.id.stats_artifacts_artifact18_level).setText(String.valueOf(save.artifactLevels.Artifact18));
        findTextView(artifactPage, R.id.stats_artifacts_artifact18_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact18));
        findTextView(artifactPage, R.id.stats_artifacts_artifact19_level).setText(String.valueOf(save.artifactLevels.Artifact19));
        findTextView(artifactPage, R.id.stats_artifacts_artifact19_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact19));
        findTextView(artifactPage, R.id.stats_artifacts_artifact20_level).setText(String.valueOf(save.artifactLevels.Artifact20));
        findTextView(artifactPage, R.id.stats_artifacts_artifact20_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact20));
        findTextView(artifactPage, R.id.stats_artifacts_artifact21_level).setText(String.valueOf(save.artifactLevels.Artifact21));
        findTextView(artifactPage, R.id.stats_artifacts_artifact21_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact21));
        findTextView(artifactPage, R.id.stats_artifacts_artifact22_level).setText(String.valueOf(save.artifactLevels.Artifact22));
        findTextView(artifactPage, R.id.stats_artifacts_artifact22_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact22));
        findTextView(artifactPage, R.id.stats_artifacts_artifact23_level).setText(String.valueOf(save.artifactLevels.Artifact23));
        findTextView(artifactPage, R.id.stats_artifacts_artifact23_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact23));
        findTextView(artifactPage, R.id.stats_artifacts_artifact24_level).setText(String.valueOf(save.artifactLevels.Artifact24));
        findTextView(artifactPage, R.id.stats_artifacts_artifact24_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact24));
        findTextView(artifactPage, R.id.stats_artifacts_artifact25_level).setText(String.valueOf(save.artifactLevels.Artifact25));
        findTextView(artifactPage, R.id.stats_artifacts_artifact25_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact25));
        findTextView(artifactPage, R.id.stats_artifacts_artifact26_level).setText(String.valueOf(save.artifactLevels.Artifact26));
        findTextView(artifactPage, R.id.stats_artifacts_artifact26_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact26));
        findTextView(artifactPage, R.id.stats_artifacts_artifact27_level).setText(String.valueOf(save.artifactLevels.Artifact27));
        findTextView(artifactPage, R.id.stats_artifacts_artifact27_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact27));
        findTextView(artifactPage, R.id.stats_artifacts_artifact28_level).setText(String.valueOf(save.artifactLevels.Artifact28));
        findTextView(artifactPage, R.id.stats_artifacts_artifact28_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact28));
        findTextView(artifactPage, R.id.stats_artifacts_artifact29_level).setText(String.valueOf(save.artifactLevels.Artifact29));
        findTextView(artifactPage, R.id.stats_artifacts_artifact29_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact29));
        findTextView(artifactPage, R.id.stats_artifacts_artifact30_level).setText(String.valueOf(save.artifactLevels.Artifact30));
        findTextView(artifactPage, R.id.stats_artifacts_artifact30_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact30));
        findTextView(artifactPage, R.id.stats_artifacts_artifact31_level).setText(String.valueOf(save.artifactLevels.Artifact31));
        findTextView(artifactPage, R.id.stats_artifacts_artifact31_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact31));
        findTextView(artifactPage, R.id.stats_artifacts_artifact32_level).setText(String.valueOf(save.artifactLevels.Artifact32));
        findTextView(artifactPage, R.id.stats_artifacts_artifact32_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact32));
        findTextView(artifactPage, R.id.stats_artifacts_artifact33_level).setText(String.valueOf(save.artifactLevels.Artifact33));
        findTextView(artifactPage, R.id.stats_artifacts_artifact33_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact33));
        findTextView(artifactPage, R.id.stats_artifacts_artifact34_level).setText(String.valueOf(save.artifactLevels.Artifact34));
        findTextView(artifactPage, R.id.stats_artifacts_artifact34_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact34));
        findTextView(artifactPage, R.id.stats_artifacts_artifact35_level).setText(String.valueOf(save.artifactLevels.Artifact35));
        findTextView(artifactPage, R.id.stats_artifacts_artifact35_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact35));
        findTextView(artifactPage, R.id.stats_artifacts_artifact36_level).setText(String.valueOf(save.artifactLevels.Artifact36));
        findTextView(artifactPage, R.id.stats_artifacts_artifact36_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact36));
        findTextView(artifactPage, R.id.stats_artifacts_artifact37_level).setText(String.valueOf(save.artifactLevels.Artifact37));
        findTextView(artifactPage, R.id.stats_artifacts_artifact37_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact37));
        findTextView(artifactPage, R.id.stats_artifacts_artifact38_level).setText(String.valueOf(save.artifactLevels.Artifact38));
        findTextView(artifactPage, R.id.stats_artifacts_artifact38_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact38));
        findTextView(artifactPage, R.id.stats_artifacts_artifact39_level).setText(String.valueOf(save.artifactLevels.Artifact39));
        findTextView(artifactPage, R.id.stats_artifacts_artifact39_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact39));
        findTextView(artifactPage, R.id.stats_artifacts_artifact40_level).setText(String.valueOf(save.artifactLevels.Artifact40));
        findTextView(artifactPage, R.id.stats_artifacts_artifact40_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact40));
        findTextView(artifactPage, R.id.stats_artifacts_artifact41_level).setText(String.valueOf(save.artifactLevels.Artifact41));
        findTextView(artifactPage, R.id.stats_artifacts_artifact41_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact41));
        findTextView(artifactPage, R.id.stats_artifacts_artifact42_level).setText(String.valueOf(save.artifactLevels.Artifact42));
        findTextView(artifactPage, R.id.stats_artifacts_artifact42_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact42));
        findTextView(artifactPage, R.id.stats_artifacts_artifact43_level).setText(String.valueOf(save.artifactLevels.Artifact43));
        findTextView(artifactPage, R.id.stats_artifacts_artifact43_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact43));
        findTextView(artifactPage, R.id.stats_artifacts_artifact44_level).setText(String.valueOf(save.artifactLevels.Artifact44));
        findTextView(artifactPage, R.id.stats_artifacts_artifact44_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact44));
        findTextView(artifactPage, R.id.stats_artifacts_artifact45_level).setText(String.valueOf(save.artifactLevels.Artifact45));
        findTextView(artifactPage, R.id.stats_artifacts_artifact45_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact45));
        findTextView(artifactPage, R.id.stats_artifacts_artifact46_level).setText(String.valueOf(save.artifactLevels.Artifact46));
        findTextView(artifactPage, R.id.stats_artifacts_artifact46_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact46));
        findTextView(artifactPage, R.id.stats_artifacts_artifact47_level).setText(String.valueOf(save.artifactLevels.Artifact47));
        findTextView(artifactPage, R.id.stats_artifacts_artifact47_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact47));
        findTextView(artifactPage, R.id.stats_artifacts_artifact48_level).setText(String.valueOf(save.artifactLevels.Artifact48));
        findTextView(artifactPage, R.id.stats_artifacts_artifact48_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact48));
        findTextView(artifactPage, R.id.stats_artifacts_artifact49_level).setText(String.valueOf(save.artifactLevels.Artifact49));
        findTextView(artifactPage, R.id.stats_artifacts_artifact49_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact49));
        findTextView(artifactPage, R.id.stats_artifacts_artifact50_level).setText(String.valueOf(save.artifactLevels.Artifact50));
        findTextView(artifactPage, R.id.stats_artifacts_artifact50_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact50));
        findTextView(artifactPage, R.id.stats_artifacts_artifact51_level).setText(String.valueOf(save.artifactLevels.Artifact51));
        findTextView(artifactPage, R.id.stats_artifacts_artifact51_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact51));
        findTextView(artifactPage, R.id.stats_artifacts_artifact52_level).setText(String.valueOf(save.artifactLevels.Artifact52));
        findTextView(artifactPage, R.id.stats_artifacts_artifact52_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact52));
        findTextView(artifactPage, R.id.stats_artifacts_artifact53_level).setText(String.valueOf(save.artifactLevels.Artifact53));
        findTextView(artifactPage, R.id.stats_artifacts_artifact53_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact53));
        findTextView(artifactPage, R.id.stats_artifacts_artifact54_level).setText(String.valueOf(save.artifactLevels.Artifact54));
        findTextView(artifactPage, R.id.stats_artifacts_artifact54_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact54));
        findTextView(artifactPage, R.id.stats_artifacts_artifact55_level).setText(String.valueOf(save.artifactLevels.Artifact55));
        findTextView(artifactPage, R.id.stats_artifacts_artifact55_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact55));
        findTextView(artifactPage, R.id.stats_artifacts_artifact56_level).setText(String.valueOf(save.artifactLevels.Artifact56));
        findTextView(artifactPage, R.id.stats_artifacts_artifact56_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact56));
        findTextView(artifactPage, R.id.stats_artifacts_artifact57_level).setText(String.valueOf(save.artifactLevels.Artifact57));
        findTextView(artifactPage, R.id.stats_artifacts_artifact57_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact57));
        findTextView(artifactPage, R.id.stats_artifacts_artifact58_level).setText(String.valueOf(save.artifactLevels.Artifact58));
        findTextView(artifactPage, R.id.stats_artifacts_artifact58_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact58));
        findTextView(artifactPage, R.id.stats_artifacts_artifact59_level).setText(String.valueOf(save.artifactLevels.Artifact59));
        findTextView(artifactPage, R.id.stats_artifacts_artifact59_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact59));
        findTextView(artifactPage, R.id.stats_artifacts_artifact60_level).setText(String.valueOf(save.artifactLevels.Artifact60));
        findTextView(artifactPage, R.id.stats_artifacts_artifact60_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact60));
        findTextView(artifactPage, R.id.stats_artifacts_artifact61_level).setText(String.valueOf(save.artifactLevels.Artifact61));
        findTextView(artifactPage, R.id.stats_artifacts_artifact61_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact61));
        findTextView(artifactPage, R.id.stats_artifacts_artifact62_level).setText(String.valueOf(save.artifactLevels.Artifact62));
        findTextView(artifactPage, R.id.stats_artifacts_artifact62_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact62));
        findTextView(artifactPage, R.id.stats_artifacts_artifact63_level).setText(String.valueOf(save.artifactLevels.Artifact63));
        findTextView(artifactPage, R.id.stats_artifacts_artifact63_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact63));
        findTextView(artifactPage, R.id.stats_artifacts_artifact64_level).setText(String.valueOf(save.artifactLevels.Artifact64));
        findTextView(artifactPage, R.id.stats_artifacts_artifact64_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact64));
        findTextView(artifactPage, R.id.stats_artifacts_artifact65_level).setText(String.valueOf(save.artifactLevels.Artifact65));
        findTextView(artifactPage, R.id.stats_artifacts_artifact65_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact65));
        findTextView(artifactPage, R.id.stats_artifacts_artifact66_level).setText(String.valueOf(save.artifactLevels.Artifact66));
        findTextView(artifactPage, R.id.stats_artifacts_artifact66_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact66));
        findTextView(artifactPage, R.id.stats_artifacts_artifact67_level).setText(String.valueOf(save.artifactLevels.Artifact67));
        findTextView(artifactPage, R.id.stats_artifacts_artifact67_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact67));
        findTextView(artifactPage, R.id.stats_artifacts_artifact68_level).setText(String.valueOf(save.artifactLevels.Artifact68));
        findTextView(artifactPage, R.id.stats_artifacts_artifact68_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact68));
        findTextView(artifactPage, R.id.stats_artifacts_artifact69_level).setText(String.valueOf(save.artifactLevels.Artifact69));
        findTextView(artifactPage, R.id.stats_artifacts_artifact69_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact69));
        findTextView(artifactPage, R.id.stats_artifacts_artifact70_level).setText(String.valueOf(save.artifactLevels.Artifact70));
        findTextView(artifactPage, R.id.stats_artifacts_artifact70_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact70));
    }

    protected void registerEvents(){

    }
}
