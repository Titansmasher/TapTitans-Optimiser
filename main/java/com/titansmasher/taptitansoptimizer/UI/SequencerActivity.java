package com.titansmasher.taptitansoptimizer.UI;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.titansmasher.taptitansoptimizer.Logic.ArtifactSequencer;
import com.titansmasher.taptitansoptimizer.Model.Enums.Artifact;
import com.titansmasher.taptitansoptimizer.Model.Enums.Page;
import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.Model.WorldSave;
import com.titansmasher.taptitansoptimizer.R;
import com.titansmasher.taptitansoptimizer.UI.Abstracts.PagedActivityBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Danny on 03/11/2016.
 */

public class SequencerActivity extends PagedActivityBase {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPage(Page.SEQUENCER_ARTIFACT, View.inflate(this, R.layout.sequencer_artifact, null), getString(R.string.tab_sequencer_artifact));
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

        findTextView(baseContent, R.id.sequencer_artifact_seed).setText(String.valueOf(save.nextArtifactSeed));

        pageChanged();
    }

    @Override
    public void saveChanged() {
        if (!isSaveValid())
            return;
        worldChanged(application.currentWorld);
        WorldSave save = getWorldSave();
    }

    private void updateArtifactSequence(){
        WorldSave save = getWorldSave();

        List<Boolean> salvages = getCurrentSalvageSteps();
        Map<Artifact, Boolean> artifacts = new HashMap<>();
        Map<Artifact, Integer> artifactLevels = save.artifactLevels.mapArtifacts(application.currentWorld);
        for (Artifact artifact
                : artifactLevels.keySet()){
            artifacts.put(artifact, artifactLevels.get(artifact) > 0);
        }

        List<Artifact> result = ArtifactSequencer.getSequence(application.currentWorld, save.nextArtifactSeed, artifacts, salvages, application.artifactUnityRandom.get(application.currentWorld));

        TableLayout outputTable = findTable(baseContent, R.id.sequencer_artifact_outputtable);
        outputTable.removeAllViews();

        TableRow headerRow = new TableRow(outputTable.getContext());
        TextView artifactHeader = new TextView(outputTable.getContext());
        TextView salvageHeader = new TextView(outputTable.getContext());

        artifactHeader.setText(R.string.sequencer_artifact_sequencetable_nameheader);
        salvageHeader.setText(R.string.sequencer_artifact_sequencetable_salvageheader);

        headerRow.setBackgroundColor(ContextCompat.getColor(application.getApplicationContext(), R.color.row_alternate));
        headerRow.addView(artifactHeader);
        headerRow.addView(salvageHeader);

        outputTable.addView(headerRow);

        boolean altRowColour = false;
        for (int i = 0; i < result.size(); i++) {
            addSequencerRow(outputTable, result.get(i), salvages.size() > i ? salvages.get(i) : false, altRowColour, i + 1 == result.size());
            altRowColour = !altRowColour;
        }
    }

    private List<Boolean> getCurrentSalvageSteps(){
        TableLayout table = findTable(baseContent, R.id.sequencer_artifact_outputtable);
        List<Boolean> salvages = new ArrayList<>();
        for (int i = 1; i < table.getChildCount(); i++){
            TableRow row = (TableRow)table.getChildAt(i);
            CheckBox checkBox = (CheckBox)row.getChildAt(1);
            salvages.add(checkBox.isChecked());
        }
        return salvages;
    }

    private void addSequencerRow(TableLayout table, Artifact artifact, boolean salvage, boolean altRowColour, boolean locked){
        TableRow row = new TableRow(table.getContext());

        TextView artifactName = new TextView(table.getContext());
        CheckBox salvageBox = new CheckBox(table.getContext());

        artifactName.setText(getArtifactName(artifact));
        salvageBox.setChecked(salvage);
        salvageBox.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateArtifactSequence();
            }
        });
        if (altRowColour)
            row.setBackgroundColor(ContextCompat.getColor(table.getContext(), R.color.row_alternate));

        row.addView(artifactName);
        row.addView(salvageBox);

        salvageBox.setClickable(!locked);
        if (locked)
            salvageBox.setText(Html.fromHtml("&#128274;"));

        table.addView(row);

    }

    @Override
    protected void pageChanged(){
        switch (getCurrentPage()){
            case SEQUENCER_ARTIFACT:
                updateArtifactSequence();
        }
    }
}
