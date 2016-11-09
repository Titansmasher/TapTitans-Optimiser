package com.titansmasher.taptitansoptimizer.UI;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Model.Enums.Artifact;
import com.titansmasher.taptitansoptimizer.Model.Enums.Page;
import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.Model.RawSave.ArtifactClasses.ArtifactLevels;
import com.titansmasher.taptitansoptimizer.Model.RawSave.PlayerCustomizations;
import com.titansmasher.taptitansoptimizer.Model.RawSave.TapTitansSave;
import com.titansmasher.taptitansoptimizer.Model.SaveData;
import com.titansmasher.taptitansoptimizer.Model.WorldSave;
import com.titansmasher.taptitansoptimizer.R;
import com.titansmasher.taptitansoptimizer.UI.Abstracts.PagedActivityBase;

/**
 * Created by Danny on 03/11/2016.
 */

public class SaveManagerActivity extends PagedActivityBase {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPage(Page.SAVE_MANAGE, View.inflate(this, R.layout.save_manage, null), getString(R.string.tab_save_manage));
        addPage(Page.SAVE_EDITARTIFACT, View.inflate(this, R.layout.save_edit_artifacts, null), getString(R.string.tab_save_editartifacts));
        addPage(Page.SAVE_EDITCUSTOMISATION, View.inflate(this, R.layout.save_edit_customisations, null), getString(R.string.tab_save_editcustomisation));

        registerEvents();
    }

    @Override
    public void worldChanged(World world) {

    }

    @Override
    public void saveChanged() {
        pageChanged();
    }

    @Override
    protected void pageChanged(){

        SaveData data = application.saveManager.getSaveData(application.activeSaveId);
        WorldSave save = getWorldSave();
        boolean editable = data != null && data.save.isEditable();

        switch (getCurrentPage()){
            case SAVE_MANAGE:
                findTextView(getPage(Page.SAVE_MANAGE), R.id.save_manage_savename).setText(data != null ? data.saveName : "No save. Create a new one");
                findTextView(getPage(Page.SAVE_MANAGE), R.id.save_manage_editable).setText(GenericHelpers.boolToYesNoString(editable));
                findButton(getPage(Page.SAVE_MANAGE), R.id.save_manage_delete).setEnabled(editable);
                findButton(getPage(Page.SAVE_MANAGE), R.id.save_manage_copyfrom).setEnabled(editable);
                findButton(getPage(Page.SAVE_MANAGE), R.id.save_manage_changename).setEnabled(editable);
                break;
            case SAVE_EDITCUSTOMISATION:
                View customisationPage = getPage(Page.SAVE_EDITCUSTOMISATION);
                findButton(customisationPage, R.id.save_customisation_savechanges).setEnabled(editable);
                customisationPage.findViewById(R.id.save_customisation_tables).setVisibility(editable ? View.VISIBLE : View.GONE);
                findTextView(customisationPage, R.id.save_customisation_noedit).setVisibility(editable ? View.GONE : View.VISIBLE);
                if (editable){
                    findCheckBox(customisationPage, R.id.save_customisation3_0  ).setChecked(save.unlockedPlayerCustomizations.C3_0  );
                    findCheckBox(customisationPage, R.id.save_customisation3_901).setChecked(save.unlockedPlayerCustomizations.C3_901);
                    findCheckBox(customisationPage, R.id.save_customisation3_902).setChecked(save.unlockedPlayerCustomizations.C3_902);
                    findCheckBox(customisationPage, R.id.save_customisation3_903).setChecked(save.unlockedPlayerCustomizations.C3_903);
                    findCheckBox(customisationPage, R.id.save_customisation3_904).setChecked(save.unlockedPlayerCustomizations.C3_904);
                    findCheckBox(customisationPage, R.id.save_customisation3_905).setChecked(save.unlockedPlayerCustomizations.C3_905);
                    findCheckBox(customisationPage, R.id.save_customisation3_906).setChecked(save.unlockedPlayerCustomizations.C3_906);
                    findCheckBox(customisationPage, R.id.save_customisation3_907).setChecked(save.unlockedPlayerCustomizations.C3_907);
                    findCheckBox(customisationPage, R.id.save_customisation3_19 ).setChecked(save.unlockedPlayerCustomizations.C3_19 );
                    findCheckBox(customisationPage, R.id.save_customisation3_3  ).setChecked(save.unlockedPlayerCustomizations.C3_3  );
                    findCheckBox(customisationPage, R.id.save_customisation3_4  ).setChecked(save.unlockedPlayerCustomizations.C3_4  );
                    findCheckBox(customisationPage, R.id.save_customisation3_29 ).setChecked(save.unlockedPlayerCustomizations.C3_29 );
                    findCheckBox(customisationPage, R.id.save_customisation3_909).setChecked(save.unlockedPlayerCustomizations.C3_909);
                    findCheckBox(customisationPage, R.id.save_customisation3_22 ).setChecked(save.unlockedPlayerCustomizations.C3_22 );
                    findCheckBox(customisationPage, R.id.save_customisation3_12 ).setChecked(save.unlockedPlayerCustomizations.C3_12 );
                    findCheckBox(customisationPage, R.id.save_customisation3_30 ).setChecked(save.unlockedPlayerCustomizations.C3_30 );
                    findCheckBox(customisationPage, R.id.save_customisation3_26 ).setChecked(save.unlockedPlayerCustomizations.C3_26 );
                    findCheckBox(customisationPage, R.id.save_customisation3_1  ).setChecked(save.unlockedPlayerCustomizations.C3_1  );
                    findCheckBox(customisationPage, R.id.save_customisation3_13 ).setChecked(save.unlockedPlayerCustomizations.C3_13 );
                    findCheckBox(customisationPage, R.id.save_customisation3_5  ).setChecked(save.unlockedPlayerCustomizations.C3_5  );
                    findCheckBox(customisationPage, R.id.save_customisation3_15 ).setChecked(save.unlockedPlayerCustomizations.C3_15 );
                    findCheckBox(customisationPage, R.id.save_customisation3_10 ).setChecked(save.unlockedPlayerCustomizations.C3_10 );
                    findCheckBox(customisationPage, R.id.save_customisation3_25 ).setChecked(save.unlockedPlayerCustomizations.C3_25 );
                    findCheckBox(customisationPage, R.id.save_customisation3_20 ).setChecked(save.unlockedPlayerCustomizations.C3_20 );
                    findCheckBox(customisationPage, R.id.save_customisation3_21 ).setChecked(save.unlockedPlayerCustomizations.C3_21 );
                    findCheckBox(customisationPage, R.id.save_customisation3_14 ).setChecked(save.unlockedPlayerCustomizations.C3_14 );
                    findCheckBox(customisationPage, R.id.save_customisation3_11 ).setChecked(save.unlockedPlayerCustomizations.C3_11 );
                    findCheckBox(customisationPage, R.id.save_customisation3_7  ).setChecked(save.unlockedPlayerCustomizations.C3_7  );
                    findCheckBox(customisationPage, R.id.save_customisation3_18 ).setChecked(save.unlockedPlayerCustomizations.C3_18 );
                    findCheckBox(customisationPage, R.id.save_customisation3_17 ).setChecked(save.unlockedPlayerCustomizations.C3_17 );
                    findCheckBox(customisationPage, R.id.save_customisation3_28 ).setChecked(save.unlockedPlayerCustomizations.C3_28 );
                    findCheckBox(customisationPage, R.id.save_customisation1_0  ).setChecked(save.unlockedPlayerCustomizations.C1_0  );
                    findCheckBox(customisationPage, R.id.save_customisation1_9  ).setChecked(save.unlockedPlayerCustomizations.C1_9  );
                    findCheckBox(customisationPage, R.id.save_customisation1_1  ).setChecked(save.unlockedPlayerCustomizations.C1_1  );
                    findCheckBox(customisationPage, R.id.save_customisation1_3  ).setChecked(save.unlockedPlayerCustomizations.C1_3  );
                    findCheckBox(customisationPage, R.id.save_customisation1_2  ).setChecked(save.unlockedPlayerCustomizations.C1_2  );
                    findCheckBox(customisationPage, R.id.save_customisation1_11 ).setChecked(save.unlockedPlayerCustomizations.C1_11 );
                    findCheckBox(customisationPage, R.id.save_customisation1_8  ).setChecked(save.unlockedPlayerCustomizations.C1_8  );
                    findCheckBox(customisationPage, R.id.save_customisation1_4  ).setChecked(save.unlockedPlayerCustomizations.C1_4  );
                    findCheckBox(customisationPage, R.id.save_customisation1_5  ).setChecked(save.unlockedPlayerCustomizations.C1_5  );
                    findCheckBox(customisationPage, R.id.save_customisation1_6  ).setChecked(save.unlockedPlayerCustomizations.C1_6  );
                    findCheckBox(customisationPage, R.id.save_customisation1_7  ).setChecked(save.unlockedPlayerCustomizations.C1_7  );
                    findCheckBox(customisationPage, R.id.save_customisation1_10 ).setChecked(save.unlockedPlayerCustomizations.C1_10 );
                    findCheckBox(customisationPage, R.id.save_customisation0_0  ).setChecked(save.unlockedPlayerCustomizations.C0_0  );
                    findCheckBox(customisationPage, R.id.save_customisation0_14 ).setChecked(save.unlockedPlayerCustomizations.C0_14 );
                    findCheckBox(customisationPage, R.id.save_customisation0_2  ).setChecked(save.unlockedPlayerCustomizations.C0_2  );
                    findCheckBox(customisationPage, R.id.save_customisation0_3  ).setChecked(save.unlockedPlayerCustomizations.C0_3  );
                    findCheckBox(customisationPage, R.id.save_customisation0_6  ).setChecked(save.unlockedPlayerCustomizations.C0_6  );
                    findCheckBox(customisationPage, R.id.save_customisation0_1  ).setChecked(save.unlockedPlayerCustomizations.C0_1  );
                    findCheckBox(customisationPage, R.id.save_customisation0_4  ).setChecked(save.unlockedPlayerCustomizations.C0_4  );
                    findCheckBox(customisationPage, R.id.save_customisation0_5  ).setChecked(save.unlockedPlayerCustomizations.C0_5  );
                    findCheckBox(customisationPage, R.id.save_customisation0_8  ).setChecked(save.unlockedPlayerCustomizations.C0_8  );
                    findCheckBox(customisationPage, R.id.save_customisation0_7  ).setChecked(save.unlockedPlayerCustomizations.C0_7  );
                    findCheckBox(customisationPage, R.id.save_customisation0_9  ).setChecked(save.unlockedPlayerCustomizations.C0_9  );
                    findCheckBox(customisationPage, R.id.save_customisation0_10 ).setChecked(save.unlockedPlayerCustomizations.C0_10 );
                    findCheckBox(customisationPage, R.id.save_customisation0_13 ).setChecked(save.unlockedPlayerCustomizations.C0_13 );
                    findCheckBox(customisationPage, R.id.save_customisation0_11 ).setChecked(save.unlockedPlayerCustomizations.C0_11 );
                    findCheckBox(customisationPage, R.id.save_customisation5_0  ).setChecked(save.unlockedPlayerCustomizations.C5_0  );
                    findCheckBox(customisationPage, R.id.save_customisation5_1  ).setChecked(save.unlockedPlayerCustomizations.C5_1  );
                    findCheckBox(customisationPage, R.id.save_customisation5_2  ).setChecked(save.unlockedPlayerCustomizations.C5_2  );
                    findCheckBox(customisationPage, R.id.save_customisation5_3  ).setChecked(save.unlockedPlayerCustomizations.C5_3  );
                    findCheckBox(customisationPage, R.id.save_customisation5_5  ).setChecked(save.unlockedPlayerCustomizations.C5_5  );
                    findCheckBox(customisationPage, R.id.save_customisation5_4  ).setChecked(save.unlockedPlayerCustomizations.C5_4  );
                    findCheckBox(customisationPage, R.id.save_customisation5_8  ).setChecked(save.unlockedPlayerCustomizations.C5_8  );
                    findCheckBox(customisationPage, R.id.save_customisation5_6  ).setChecked(save.unlockedPlayerCustomizations.C5_6  );
                    findCheckBox(customisationPage, R.id.save_customisation5_7  ).setChecked(save.unlockedPlayerCustomizations.C5_7  );
                    findCheckBox(customisationPage, R.id.save_customisation5_9  ).setChecked(save.unlockedPlayerCustomizations.C5_9  );
                    findCheckBox(customisationPage, R.id.save_customisation5_10 ).setChecked(save.unlockedPlayerCustomizations.C5_10 );
                    findCheckBox(customisationPage, R.id.save_customisation2_0  ).setChecked(save.unlockedPlayerCustomizations.C2_0  );
                    findCheckBox(customisationPage, R.id.save_customisation2_3  ).setChecked(save.unlockedPlayerCustomizations.C2_3  );
                    findCheckBox(customisationPage, R.id.save_customisation2_1  ).setChecked(save.unlockedPlayerCustomizations.C2_1  );
                    findCheckBox(customisationPage, R.id.save_customisation2_2  ).setChecked(save.unlockedPlayerCustomizations.C2_2  );
                    findCheckBox(customisationPage, R.id.save_customisation2_4  ).setChecked(save.unlockedPlayerCustomizations.C2_4  );
                    findCheckBox(customisationPage, R.id.save_customisation2_6  ).setChecked(save.unlockedPlayerCustomizations.C2_6  );
                    findCheckBox(customisationPage, R.id.save_customisation2_14 ).setChecked(save.unlockedPlayerCustomizations.C2_14 );
                    findCheckBox(customisationPage, R.id.save_customisation2_10 ).setChecked(save.unlockedPlayerCustomizations.C2_10 );
                    findCheckBox(customisationPage, R.id.save_customisation2_13 ).setChecked(save.unlockedPlayerCustomizations.C2_13 );
                    findCheckBox(customisationPage, R.id.save_customisation2_8  ).setChecked(save.unlockedPlayerCustomizations.C2_8  );
                    findCheckBox(customisationPage, R.id.save_customisation2_9  ).setChecked(save.unlockedPlayerCustomizations.C2_9  );
                    findCheckBox(customisationPage, R.id.save_customisation2_11 ).setChecked(save.unlockedPlayerCustomizations.C2_11 );
                    findCheckBox(customisationPage, R.id.save_customisation2_12 ).setChecked(save.unlockedPlayerCustomizations.C2_12 );
                    findCheckBox(customisationPage, R.id.save_customisation2_17 ).setChecked(save.unlockedPlayerCustomizations.C2_17 );
                    findCheckBox(customisationPage, R.id.save_customisation2_16 ).setChecked(save.unlockedPlayerCustomizations.C2_16 );
                    findCheckBox(customisationPage, R.id.save_customisation2_5  ).setChecked(save.unlockedPlayerCustomizations.C2_5  );
                    findCheckBox(customisationPage, R.id.save_customisation2_15 ).setChecked(save.unlockedPlayerCustomizations.C2_15 );
                    findCheckBox(customisationPage, R.id.save_customisation4_0  ).setChecked(save.unlockedPlayerCustomizations.C4_0  );
                    findCheckBox(customisationPage, R.id.save_customisation4_1  ).setChecked(save.unlockedPlayerCustomizations.C4_1  );
                    findCheckBox(customisationPage, R.id.save_customisation4_2  ).setChecked(save.unlockedPlayerCustomizations.C4_2  );
                    findCheckBox(customisationPage, R.id.save_customisation4_3  ).setChecked(save.unlockedPlayerCustomizations.C4_3  );
                    findCheckBox(customisationPage, R.id.save_customisation4_4  ).setChecked(save.unlockedPlayerCustomizations.C4_4  );
                    findCheckBox(customisationPage, R.id.save_customisation4_5  ).setChecked(save.unlockedPlayerCustomizations.C4_5  );
                    findCheckBox(customisationPage, R.id.save_customisation4_6  ).setChecked(save.unlockedPlayerCustomizations.C4_6  );
                    findCheckBox(customisationPage, R.id.save_customisation4_7  ).setChecked(save.unlockedPlayerCustomizations.C4_7  );
                    findCheckBox(customisationPage, R.id.save_customisation4_8  ).setChecked(save.unlockedPlayerCustomizations.C4_8  );
                    findCheckBox(customisationPage, R.id.save_customisation4_9  ).setChecked(save.unlockedPlayerCustomizations.C4_9  );
                    findCheckBox(customisationPage, R.id.save_customisation4_10 ).setChecked(save.unlockedPlayerCustomizations.C4_10 );
                }
                break;
            case SAVE_EDITARTIFACT:
                View artifactPage = getPage(Page.SAVE_EDITARTIFACT);
                findButton(artifactPage, R.id.save_artifact_savechanges).setEnabled(editable);
                findTable(artifactPage, R.id.save_artifacts_artifacttable).setVisibility(editable ? View.VISIBLE : View.GONE);
                findTextView(artifactPage, R.id.save_artifact_noedits).setVisibility(editable ? View.GONE : View.VISIBLE);

                if (editable) {
                    findEditText(artifactPage, R.id.save_artifacts_artifact1_level).setText(String.valueOf(save.artifactLevels.Artifact1));
                    findEditText(artifactPage, R.id.save_artifacts_artifact2_level).setText(String.valueOf(save.artifactLevels.Artifact2));
                    findEditText(artifactPage, R.id.save_artifacts_artifact3_level).setText(String.valueOf(save.artifactLevels.Artifact3));
                    findEditText(artifactPage, R.id.save_artifacts_artifact4_level).setText(String.valueOf(save.artifactLevels.Artifact4));
                    findEditText(artifactPage, R.id.save_artifacts_artifact5_level).setText(String.valueOf(save.artifactLevels.Artifact5));
                    findEditText(artifactPage, R.id.save_artifacts_artifact6_level).setText(String.valueOf(save.artifactLevels.Artifact6));
                    findEditText(artifactPage, R.id.save_artifacts_artifact7_level).setText(String.valueOf(save.artifactLevels.Artifact7));
                    findEditText(artifactPage, R.id.save_artifacts_artifact8_level).setText(String.valueOf(save.artifactLevels.Artifact8));
                    findEditText(artifactPage, R.id.save_artifacts_artifact9_level).setText(String.valueOf(save.artifactLevels.Artifact9));
                    findEditText(artifactPage, R.id.save_artifacts_artifact10_level).setText(String.valueOf(save.artifactLevels.Artifact10));
                    findEditText(artifactPage, R.id.save_artifacts_artifact11_level).setText(String.valueOf(save.artifactLevels.Artifact11));
                    findEditText(artifactPage, R.id.save_artifacts_artifact12_level).setText(String.valueOf(save.artifactLevels.Artifact12));
                    findEditText(artifactPage, R.id.save_artifacts_artifact13_level).setText(String.valueOf(save.artifactLevels.Artifact13));
                    findEditText(artifactPage, R.id.save_artifacts_artifact14_level).setText(String.valueOf(save.artifactLevels.Artifact14));
                    findEditText(artifactPage, R.id.save_artifacts_artifact15_level).setText(String.valueOf(save.artifactLevels.Artifact15));
                    findEditText(artifactPage, R.id.save_artifacts_artifact16_level).setText(String.valueOf(save.artifactLevels.Artifact16));
                    findEditText(artifactPage, R.id.save_artifacts_artifact17_level).setText(String.valueOf(save.artifactLevels.Artifact17));
                    findEditText(artifactPage, R.id.save_artifacts_artifact18_level).setText(String.valueOf(save.artifactLevels.Artifact18));
                    findEditText(artifactPage, R.id.save_artifacts_artifact19_level).setText(String.valueOf(save.artifactLevels.Artifact19));
                    findEditText(artifactPage, R.id.save_artifacts_artifact20_level).setText(String.valueOf(save.artifactLevels.Artifact20));
                    findEditText(artifactPage, R.id.save_artifacts_artifact21_level).setText(String.valueOf(save.artifactLevels.Artifact21));
                    findEditText(artifactPage, R.id.save_artifacts_artifact22_level).setText(String.valueOf(save.artifactLevels.Artifact22));
                    findEditText(artifactPage, R.id.save_artifacts_artifact23_level).setText(String.valueOf(save.artifactLevels.Artifact23));
                    findEditText(artifactPage, R.id.save_artifacts_artifact24_level).setText(String.valueOf(save.artifactLevels.Artifact24));
                    findEditText(artifactPage, R.id.save_artifacts_artifact25_level).setText(String.valueOf(save.artifactLevels.Artifact25));
                    findEditText(artifactPage, R.id.save_artifacts_artifact26_level).setText(String.valueOf(save.artifactLevels.Artifact26));
                    findEditText(artifactPage, R.id.save_artifacts_artifact27_level).setText(String.valueOf(save.artifactLevels.Artifact27));
                    findEditText(artifactPage, R.id.save_artifacts_artifact28_level).setText(String.valueOf(save.artifactLevels.Artifact28));
                    findEditText(artifactPage, R.id.save_artifacts_artifact29_level).setText(String.valueOf(save.artifactLevels.Artifact29));
                    findEditText(artifactPage, R.id.save_artifacts_artifact30_level).setText(String.valueOf(save.artifactLevels.Artifact30));
                    findEditText(artifactPage, R.id.save_artifacts_artifact31_level).setText(String.valueOf(save.artifactLevels.Artifact31));
                    findEditText(artifactPage, R.id.save_artifacts_artifact32_level).setText(String.valueOf(save.artifactLevels.Artifact32));
                    findEditText(artifactPage, R.id.save_artifacts_artifact33_level).setText(String.valueOf(save.artifactLevels.Artifact33));
                    findEditText(artifactPage, R.id.save_artifacts_artifact34_level).setText(String.valueOf(save.artifactLevels.Artifact34));
                    findEditText(artifactPage, R.id.save_artifacts_artifact35_level).setText(String.valueOf(save.artifactLevels.Artifact35));
                    findEditText(artifactPage, R.id.save_artifacts_artifact36_level).setText(String.valueOf(save.artifactLevels.Artifact36));
                    findEditText(artifactPage, R.id.save_artifacts_artifact37_level).setText(String.valueOf(save.artifactLevels.Artifact37));
                    findEditText(artifactPage, R.id.save_artifacts_artifact38_level).setText(String.valueOf(save.artifactLevels.Artifact38));
                    findEditText(artifactPage, R.id.save_artifacts_artifact39_level).setText(String.valueOf(save.artifactLevels.Artifact39));
                    findEditText(artifactPage, R.id.save_artifacts_artifact40_level).setText(String.valueOf(save.artifactLevels.Artifact40));
                    findEditText(artifactPage, R.id.save_artifacts_artifact41_level).setText(String.valueOf(save.artifactLevels.Artifact41));
                    findEditText(artifactPage, R.id.save_artifacts_artifact42_level).setText(String.valueOf(save.artifactLevels.Artifact42));
                    findEditText(artifactPage, R.id.save_artifacts_artifact43_level).setText(String.valueOf(save.artifactLevels.Artifact43));
                    findEditText(artifactPage, R.id.save_artifacts_artifact44_level).setText(String.valueOf(save.artifactLevels.Artifact44));
                    findEditText(artifactPage, R.id.save_artifacts_artifact45_level).setText(String.valueOf(save.artifactLevels.Artifact45));
                    findEditText(artifactPage, R.id.save_artifacts_artifact46_level).setText(String.valueOf(save.artifactLevels.Artifact46));
                    findEditText(artifactPage, R.id.save_artifacts_artifact47_level).setText(String.valueOf(save.artifactLevels.Artifact47));
                    findEditText(artifactPage, R.id.save_artifacts_artifact48_level).setText(String.valueOf(save.artifactLevels.Artifact48));
                    findEditText(artifactPage, R.id.save_artifacts_artifact49_level).setText(String.valueOf(save.artifactLevels.Artifact49));
                    findEditText(artifactPage, R.id.save_artifacts_artifact50_level).setText(String.valueOf(save.artifactLevels.Artifact50));
                    findEditText(artifactPage, R.id.save_artifacts_artifact51_level).setText(String.valueOf(save.artifactLevels.Artifact51));
                    findEditText(artifactPage, R.id.save_artifacts_artifact52_level).setText(String.valueOf(save.artifactLevels.Artifact52));
                    findEditText(artifactPage, R.id.save_artifacts_artifact53_level).setText(String.valueOf(save.artifactLevels.Artifact53));
                    findEditText(artifactPage, R.id.save_artifacts_artifact54_level).setText(String.valueOf(save.artifactLevels.Artifact54));
                    findEditText(artifactPage, R.id.save_artifacts_artifact55_level).setText(String.valueOf(save.artifactLevels.Artifact55));
                    findEditText(artifactPage, R.id.save_artifacts_artifact56_level).setText(String.valueOf(save.artifactLevels.Artifact56));
                    findEditText(artifactPage, R.id.save_artifacts_artifact57_level).setText(String.valueOf(save.artifactLevels.Artifact57));
                    findEditText(artifactPage, R.id.save_artifacts_artifact58_level).setText(String.valueOf(save.artifactLevels.Artifact58));
                    findEditText(artifactPage, R.id.save_artifacts_artifact59_level).setText(String.valueOf(save.artifactLevels.Artifact59));
                    findEditText(artifactPage, R.id.save_artifacts_artifact60_level).setText(String.valueOf(save.artifactLevels.Artifact60));
                    findEditText(artifactPage, R.id.save_artifacts_artifact61_level).setText(String.valueOf(save.artifactLevels.Artifact61));
                    findEditText(artifactPage, R.id.save_artifacts_artifact62_level).setText(String.valueOf(save.artifactLevels.Artifact62));
                    findEditText(artifactPage, R.id.save_artifacts_artifact63_level).setText(String.valueOf(save.artifactLevels.Artifact63));
                    findEditText(artifactPage, R.id.save_artifacts_artifact64_level).setText(String.valueOf(save.artifactLevels.Artifact64));
                    findEditText(artifactPage, R.id.save_artifacts_artifact65_level).setText(String.valueOf(save.artifactLevels.Artifact65));
                    findEditText(artifactPage, R.id.save_artifacts_artifact66_level).setText(String.valueOf(save.artifactLevels.Artifact66));
                    findEditText(artifactPage, R.id.save_artifacts_artifact67_level).setText(String.valueOf(save.artifactLevels.Artifact67));
                    findEditText(artifactPage, R.id.save_artifacts_artifact68_level).setText(String.valueOf(save.artifactLevels.Artifact68));
                    findEditText(artifactPage, R.id.save_artifacts_artifact69_level).setText(String.valueOf(save.artifactLevels.Artifact69));
                    findEditText(artifactPage, R.id.save_artifacts_artifact70_level).setText(String.valueOf(save.artifactLevels.Artifact70));
                }
                break;

        }
    }

    private void registerEvents() {
        final Activity activity = this;
        findButton(getPage(Page.SAVE_MANAGE), R.id.save_manage_createsave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNewSaveDialog();
            }
        });
        findButton(getPage(Page.SAVE_MANAGE), R.id.save_manage_pastesave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPasteSaveDialog();
            }
        });
        findButton(getPage(Page.SAVE_MANAGE), R.id.save_manage_copyfrom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCloneSaveDialog();
            }
        });
        findButton(getPage(Page.SAVE_MANAGE), R.id.save_manage_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                application.saveManager.removeSave(application.activeSaveId);
                application.saveGameSaves();
                application.loadGameSaves(activity);
                updateSaveList();
            }
        });
        findButton(getPage(Page.SAVE_MANAGE), R.id.save_manage_changename).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeNameDialog();
            }
        });
        findButton(getPage(Page.SAVE_EDITARTIFACT), R.id.save_artifact_savechanges).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveArtifactLevels();
            }
        });
        findButton(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_savechanges).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_Customisations();
            }
        });
        findTextView(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_swordheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = findLayout(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_swords);
                if (layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);
                } else {
                    layout.setVisibility(View.VISIBLE);
                }
            }
        });
        findTextView(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_scarfheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = findLayout(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_scarves);
                if (layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);
                } else {
                    layout.setVisibility(View.VISIBLE);
                }
            }
        });
        findTextView(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_auraheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = findLayout(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_auras);
                if (layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);
                } else {
                    layout.setVisibility(View.VISIBLE);
                }
            }
        });
        findTextView(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_hatheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = findLayout(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_hats);
                if (layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);
                } else {
                    layout.setVisibility(View.VISIBLE);
                }
            }
        });
        findTextView(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_clothesheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = findLayout(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_clothes);
                if (layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);
                } else {
                    layout.setVisibility(View.VISIBLE);
                }
            }
        });
        findTextView(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_trailheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = findLayout(getPage(Page.SAVE_EDITCUSTOMISATION), R.id.save_customisation_trails);
                if (layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);
                } else {
                    layout.setVisibility(View.VISIBLE);
                }
            }
        });

        View artifactPage = getPage(Page.SAVE_EDITARTIFACT);
        findEditText(artifactPage, R.id.save_artifacts_artifact1_level). addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(1) .levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact2_level). addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(2) .levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact3_level). addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(3) .levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact4_level). addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(4) .levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact5_level). addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(5) .levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact6_level). addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(6) .levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact7_level). addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(7) .levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact8_level). addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(8) .levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact9_level). addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(9) .levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact10_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(10).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact11_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(11).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact12_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(12).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact13_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(13).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact14_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(14).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact15_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(15).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact16_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(16).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact17_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(17).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact18_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(18).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact19_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(19).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact20_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(20).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact21_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(21).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact22_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(22).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact23_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(23).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact24_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(24).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact25_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(25).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact26_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(26).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact27_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(27).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact28_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(28).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact29_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(29).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact30_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(30).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact31_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(31).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact32_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(32).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact33_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(33).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact34_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(34).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact35_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(35).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact36_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(36).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact37_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(37).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact38_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(38).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact39_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(39).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact40_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(40).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact41_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(41).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact42_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(42).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact43_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(43).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact44_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(44).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact45_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(45).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact46_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(46).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact47_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(47).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact48_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(48).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact49_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(49).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact50_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(50).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact51_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(51).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact52_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(52).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact53_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(53).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact54_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(54).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact55_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(55).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact56_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(56).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact57_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(57).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact58_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(58).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact59_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(59).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact60_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(60).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact61_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(61).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact62_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(62).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact63_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(63).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact64_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(64).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact65_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(65).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact66_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(66).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact67_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(67).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact68_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(68).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact69_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(69).levelCap));
        findEditText(artifactPage, R.id.save_artifacts_artifact70_level).addTextChangedListener(generatePositiveIntValidator(Artifact.getFromId(70).levelCap));
    }

    private void showCloneSaveDialog() {
        final RadioGroup group = new RadioGroup(this);
        group.setPadding(32, 0, 32, 0);

        for (int saveId
                : application.saveManager.getSaveIds()) {
            if (saveId == application.activeSaveId)
                continue;
            RadioButton button = new RadioButton(this);
            button.setText(application.saveManager.getSaveName(saveId));
            button.setId(saveId);
            group.addView(button);
        }

        new AlertDialog.Builder(this)
                .setTitle("Select a save")
                .setView(group)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SaveData current = application.saveManager.getSaveData(application.activeSaveId);
                        SaveData cloning = application.saveManager.getSaveData(group.getCheckedRadioButtonId());
                        current.save = new TapTitansSave(cloning.save.generateJson());
                        application.saveGameSaves();
                        saveChanged();
                        Snackbar.make(baseContent, "Cloned data from " + cloning.saveName + " to " + current.saveName, 5000).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .create()
                .show();
    }

    private void showChangeNameDialog(){
        final EditText input = new EditText(this);
        final View view = this.baseContent;

        new AlertDialog.Builder(this)
                .setTitle("Enter new name")
                .setView(input)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String text = input.getText().toString();
                        if (text.length() >= 3) {
                            application.saveManager.getSaveData(application.activeSaveId).saveName = text;
                            application.saveGameSaves();
                            updateSaveList();
                        } else {
                            Snackbar.make(view, "Save name too short. Min 3 characters", Snackbar.LENGTH_LONG).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .create()
                .show();
    }

    private void showPasteSaveDialog(){
        final EditText input = new EditText(this);
        final View view = this.baseContent;

        new AlertDialog.Builder(this)
                .setTitle("Paste in a save file")
                .setView(input)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String text = input.getText().toString();
                        SaveData saveData = new SaveData();
                        saveData.save = new TapTitansSave(GenericHelpers.constructJSONObjectSafe(text));
                        saveData.saveName = saveData.save.playerInfoSave.playerName + " - Pasted";
                        application.saveManager.addSave(saveData);
                        application.saveGameSaves();
                        updateSaveList();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .create()
                .show();
    }

    private void saveArtifactLevels(){
        ArtifactLevels levels = application.saveManager.getSave(application.activeSaveId).playerInfoSave.artifactLevels;
        View page = getPage(Page.SAVE_EDITARTIFACT);

        levels.Artifact1  = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact1_level) .getText().toString(), 0);
        levels.Artifact2  = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact2_level) .getText().toString(), 0);
        levels.Artifact3  = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact3_level) .getText().toString(), 0);
        levels.Artifact4  = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact4_level) .getText().toString(), 0);
        levels.Artifact5  = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact5_level) .getText().toString(), 0);
        levels.Artifact6  = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact6_level) .getText().toString(), 0);
        levels.Artifact7  = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact7_level) .getText().toString(), 0);
        levels.Artifact8  = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact8_level) .getText().toString(), 0);
        levels.Artifact9  = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact9_level) .getText().toString(), 0);
        levels.Artifact10 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact10_level).getText().toString(), 0);
        levels.Artifact11 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact11_level).getText().toString(), 0);
        levels.Artifact12 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact12_level).getText().toString(), 0);
        levels.Artifact13 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact13_level).getText().toString(), 0);
        levels.Artifact14 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact14_level).getText().toString(), 0);
        levels.Artifact15 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact15_level).getText().toString(), 0);
        levels.Artifact16 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact16_level).getText().toString(), 0);
        levels.Artifact17 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact17_level).getText().toString(), 0);
        levels.Artifact18 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact18_level).getText().toString(), 0);
        levels.Artifact19 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact19_level).getText().toString(), 0);
        levels.Artifact20 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact20_level).getText().toString(), 0);
        levels.Artifact21 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact21_level).getText().toString(), 0);
        levels.Artifact22 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact22_level).getText().toString(), 0);
        levels.Artifact23 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact23_level).getText().toString(), 0);
        levels.Artifact24 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact24_level).getText().toString(), 0);
        levels.Artifact25 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact25_level).getText().toString(), 0);
        levels.Artifact26 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact26_level).getText().toString(), 0);
        levels.Artifact27 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact27_level).getText().toString(), 0);
        levels.Artifact28 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact28_level).getText().toString(), 0);
        levels.Artifact29 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact29_level).getText().toString(), 0);
        levels.Artifact30 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact30_level).getText().toString(), 0);
        levels.Artifact31 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact31_level).getText().toString(), 0);
        levels.Artifact32 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact32_level).getText().toString(), 0);
        levels.Artifact33 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact33_level).getText().toString(), 0);
        levels.Artifact34 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact34_level).getText().toString(), 0);
        levels.Artifact35 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact35_level).getText().toString(), 0);
        levels.Artifact36 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact36_level).getText().toString(), 0);
        levels.Artifact37 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact37_level).getText().toString(), 0);
        levels.Artifact38 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact38_level).getText().toString(), 0);
        levels.Artifact39 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact39_level).getText().toString(), 0);
        levels.Artifact40 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact40_level).getText().toString(), 0);
        levels.Artifact41 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact41_level).getText().toString(), 0);
        levels.Artifact42 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact42_level).getText().toString(), 0);
        levels.Artifact43 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact43_level).getText().toString(), 0);
        levels.Artifact44 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact44_level).getText().toString(), 0);
        levels.Artifact45 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact45_level).getText().toString(), 0);
        levels.Artifact46 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact46_level).getText().toString(), 0);
        levels.Artifact47 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact47_level).getText().toString(), 0);
        levels.Artifact48 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact48_level).getText().toString(), 0);
        levels.Artifact49 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact49_level).getText().toString(), 0);
        levels.Artifact50 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact50_level).getText().toString(), 0);
        levels.Artifact51 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact51_level).getText().toString(), 0);
        levels.Artifact52 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact52_level).getText().toString(), 0);
        levels.Artifact53 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact53_level).getText().toString(), 0);
        levels.Artifact54 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact54_level).getText().toString(), 0);
        levels.Artifact55 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact55_level).getText().toString(), 0);
        levels.Artifact56 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact56_level).getText().toString(), 0);
        levels.Artifact57 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact57_level).getText().toString(), 0);
        levels.Artifact58 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact58_level).getText().toString(), 0);
        levels.Artifact59 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact59_level).getText().toString(), 0);
        levels.Artifact60 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact60_level).getText().toString(), 0);
        levels.Artifact61 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact61_level).getText().toString(), 0);
        levels.Artifact62 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact62_level).getText().toString(), 0);
        levels.Artifact63 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact63_level).getText().toString(), 0);
        levels.Artifact64 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact64_level).getText().toString(), 0);
        levels.Artifact65 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact65_level).getText().toString(), 0);
        levels.Artifact66 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact66_level).getText().toString(), 0);
        levels.Artifact67 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact67_level).getText().toString(), 0);
        levels.Artifact68 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact68_level).getText().toString(), 0);
        levels.Artifact69 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact69_level).getText().toString(), 0);
        levels.Artifact70 = GenericHelpers.parseIntDefault(findEditText(page, R.id.save_artifacts_artifact70_level).getText().toString(), 0);

        application.saveGameSaves();
    }

    private void save_Customisations(){
        PlayerCustomizations customisations = application.saveManager.getSave(application.activeSaveId).playerInfoSave.unlockedPlayerCustomizations;
        View page = getPage(Page.SAVE_EDITCUSTOMISATION);

        customisations.C3_0   = findCheckBox(page, R.id.save_customisation3_0  ).isChecked();
        customisations.C3_901 = findCheckBox(page, R.id.save_customisation3_901).isChecked();
        customisations.C3_902 = findCheckBox(page, R.id.save_customisation3_902).isChecked();
        customisations.C3_903 = findCheckBox(page, R.id.save_customisation3_903).isChecked();
        customisations.C3_904 = findCheckBox(page, R.id.save_customisation3_904).isChecked();
        customisations.C3_905 = findCheckBox(page, R.id.save_customisation3_905).isChecked();
        customisations.C3_906 = findCheckBox(page, R.id.save_customisation3_906).isChecked();
        customisations.C3_907 = findCheckBox(page, R.id.save_customisation3_907).isChecked();
        customisations.C3_19  = findCheckBox(page, R.id.save_customisation3_19 ).isChecked();
        customisations.C3_3   = findCheckBox(page, R.id.save_customisation3_3  ).isChecked();
        customisations.C3_4   = findCheckBox(page, R.id.save_customisation3_4  ).isChecked();
        customisations.C3_29  = findCheckBox(page, R.id.save_customisation3_29 ).isChecked();
        customisations.C3_909 = findCheckBox(page, R.id.save_customisation3_909).isChecked();
        customisations.C3_22  = findCheckBox(page, R.id.save_customisation3_22 ).isChecked();
        customisations.C3_12  = findCheckBox(page, R.id.save_customisation3_12 ).isChecked();
        customisations.C3_30  = findCheckBox(page, R.id.save_customisation3_30 ).isChecked();
        customisations.C3_26  = findCheckBox(page, R.id.save_customisation3_26 ).isChecked();
        customisations.C3_1   = findCheckBox(page, R.id.save_customisation3_1  ).isChecked();
        customisations.C3_13  = findCheckBox(page, R.id.save_customisation3_13 ).isChecked();
        customisations.C3_5   = findCheckBox(page, R.id.save_customisation3_5  ).isChecked();
        customisations.C3_15  = findCheckBox(page, R.id.save_customisation3_15 ).isChecked();
        customisations.C3_10  = findCheckBox(page, R.id.save_customisation3_10 ).isChecked();
        customisations.C3_25  = findCheckBox(page, R.id.save_customisation3_25 ).isChecked();
        customisations.C3_20  = findCheckBox(page, R.id.save_customisation3_20 ).isChecked();
        customisations.C3_21  = findCheckBox(page, R.id.save_customisation3_21 ).isChecked();
        customisations.C3_14  = findCheckBox(page, R.id.save_customisation3_14 ).isChecked();
        customisations.C3_11  = findCheckBox(page, R.id.save_customisation3_11 ).isChecked();
        customisations.C3_7   = findCheckBox(page, R.id.save_customisation3_7  ).isChecked();
        customisations.C3_18  = findCheckBox(page, R.id.save_customisation3_18 ).isChecked();
        customisations.C3_17  = findCheckBox(page, R.id.save_customisation3_17 ).isChecked();
        customisations.C3_28  = findCheckBox(page, R.id.save_customisation3_28 ).isChecked();
        customisations.C1_0   = findCheckBox(page, R.id.save_customisation1_0  ).isChecked();
        customisations.C1_9   = findCheckBox(page, R.id.save_customisation1_9  ).isChecked();
        customisations.C1_1   = findCheckBox(page, R.id.save_customisation1_1  ).isChecked();
        customisations.C1_3   = findCheckBox(page, R.id.save_customisation1_3  ).isChecked();
        customisations.C1_2   = findCheckBox(page, R.id.save_customisation1_2  ).isChecked();
        customisations.C1_11  = findCheckBox(page, R.id.save_customisation1_11 ).isChecked();
        customisations.C1_8   = findCheckBox(page, R.id.save_customisation1_8  ).isChecked();
        customisations.C1_4   = findCheckBox(page, R.id.save_customisation1_4  ).isChecked();
        customisations.C1_5   = findCheckBox(page, R.id.save_customisation1_5  ).isChecked();
        customisations.C1_6   = findCheckBox(page, R.id.save_customisation1_6  ).isChecked();
        customisations.C1_7   = findCheckBox(page, R.id.save_customisation1_7  ).isChecked();
        customisations.C1_10  = findCheckBox(page, R.id.save_customisation1_10 ).isChecked();
        customisations.C0_0   = findCheckBox(page, R.id.save_customisation0_0  ).isChecked();
        customisations.C0_14  = findCheckBox(page, R.id.save_customisation0_14 ).isChecked();
        customisations.C0_2   = findCheckBox(page, R.id.save_customisation0_2  ).isChecked();
        customisations.C0_3   = findCheckBox(page, R.id.save_customisation0_3  ).isChecked();
        customisations.C0_6   = findCheckBox(page, R.id.save_customisation0_6  ).isChecked();
        customisations.C0_1   = findCheckBox(page, R.id.save_customisation0_1  ).isChecked();
        customisations.C0_4   = findCheckBox(page, R.id.save_customisation0_4  ).isChecked();
        customisations.C0_5   = findCheckBox(page, R.id.save_customisation0_5  ).isChecked();
        customisations.C0_8   = findCheckBox(page, R.id.save_customisation0_8  ).isChecked();
        customisations.C0_7   = findCheckBox(page, R.id.save_customisation0_7  ).isChecked();
        customisations.C0_9   = findCheckBox(page, R.id.save_customisation0_9  ).isChecked();
        customisations.C0_10  = findCheckBox(page, R.id.save_customisation0_10 ).isChecked();
        customisations.C0_13  = findCheckBox(page, R.id.save_customisation0_13 ).isChecked();
        customisations.C0_11  = findCheckBox(page, R.id.save_customisation0_11 ).isChecked();
        customisations.C5_0   = findCheckBox(page, R.id.save_customisation5_0  ).isChecked();
        customisations.C5_1   = findCheckBox(page, R.id.save_customisation5_1  ).isChecked();
        customisations.C5_2   = findCheckBox(page, R.id.save_customisation5_2  ).isChecked();
        customisations.C5_3   = findCheckBox(page, R.id.save_customisation5_3  ).isChecked();
        customisations.C5_5   = findCheckBox(page, R.id.save_customisation5_5  ).isChecked();
        customisations.C5_4   = findCheckBox(page, R.id.save_customisation5_4  ).isChecked();
        customisations.C5_8   = findCheckBox(page, R.id.save_customisation5_8  ).isChecked();
        customisations.C5_6   = findCheckBox(page, R.id.save_customisation5_6  ).isChecked();
        customisations.C5_7   = findCheckBox(page, R.id.save_customisation5_7  ).isChecked();
        customisations.C5_9   = findCheckBox(page, R.id.save_customisation5_9  ).isChecked();
        customisations.C5_10  = findCheckBox(page, R.id.save_customisation5_10 ).isChecked();
        customisations.C2_0   = findCheckBox(page, R.id.save_customisation2_0  ).isChecked();
        customisations.C2_3   = findCheckBox(page, R.id.save_customisation2_3  ).isChecked();
        customisations.C2_1   = findCheckBox(page, R.id.save_customisation2_1  ).isChecked();
        customisations.C2_2   = findCheckBox(page, R.id.save_customisation2_2  ).isChecked();
        customisations.C2_4   = findCheckBox(page, R.id.save_customisation2_4  ).isChecked();
        customisations.C2_6   = findCheckBox(page, R.id.save_customisation2_6  ).isChecked();
        customisations.C2_14  = findCheckBox(page, R.id.save_customisation2_14 ).isChecked();
        customisations.C2_10  = findCheckBox(page, R.id.save_customisation2_10 ).isChecked();
        customisations.C2_13  = findCheckBox(page, R.id.save_customisation2_13 ).isChecked();
        customisations.C2_8   = findCheckBox(page, R.id.save_customisation2_8  ).isChecked();
        customisations.C2_9   = findCheckBox(page, R.id.save_customisation2_9  ).isChecked();
        customisations.C2_11  = findCheckBox(page, R.id.save_customisation2_11 ).isChecked();
        customisations.C2_12  = findCheckBox(page, R.id.save_customisation2_12 ).isChecked();
        customisations.C2_17  = findCheckBox(page, R.id.save_customisation2_17 ).isChecked();
        customisations.C2_16  = findCheckBox(page, R.id.save_customisation2_16 ).isChecked();
        customisations.C2_5   = findCheckBox(page, R.id.save_customisation2_5  ).isChecked();
        customisations.C2_15  = findCheckBox(page, R.id.save_customisation2_15 ).isChecked();
        customisations.C4_0   = findCheckBox(page, R.id.save_customisation4_0  ).isChecked();
        customisations.C4_1   = findCheckBox(page, R.id.save_customisation4_1  ).isChecked();
        customisations.C4_2   = findCheckBox(page, R.id.save_customisation4_2  ).isChecked();
        customisations.C4_3   = findCheckBox(page, R.id.save_customisation4_3  ).isChecked();
        customisations.C4_4   = findCheckBox(page, R.id.save_customisation4_4  ).isChecked();
        customisations.C4_5   = findCheckBox(page, R.id.save_customisation4_5  ).isChecked();
        customisations.C4_6   = findCheckBox(page, R.id.save_customisation4_6  ).isChecked();
        customisations.C4_7   = findCheckBox(page, R.id.save_customisation4_7  ).isChecked();
        customisations.C4_8   = findCheckBox(page, R.id.save_customisation4_8  ).isChecked();
        customisations.C4_9   = findCheckBox(page, R.id.save_customisation4_9  ).isChecked();
        customisations.C4_10  = findCheckBox(page, R.id.save_customisation4_10 ).isChecked();

        application.saveGameSaves();
    }
}
