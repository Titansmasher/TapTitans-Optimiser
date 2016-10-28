package com.titansmasher.taptitansoptimiser.Models.RawSave.ArtifactClasses;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimiser.Models.RawSave.Abstracts.ArtifactData;

import org.json.JSONObject;

/**
 * Created by Danny on 22/10/2016.
 */

public class ArtifactLevels extends ArtifactData<Integer> {

    public ArtifactLevels(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }
        this.Artifact1 = GenericHelpers.getIntSafe(obj, "Artifact1");
        this.Artifact2 = GenericHelpers.getIntSafe(obj, "Artifact2");
        this.Artifact3 = GenericHelpers.getIntSafe(obj, "Artifact3");
        this.Artifact4 = GenericHelpers.getIntSafe(obj, "Artifact4");
        this.Artifact5 = GenericHelpers.getIntSafe(obj, "Artifact5");
        this.Artifact6 = GenericHelpers.getIntSafe(obj, "Artifact6");
        this.Artifact7 = GenericHelpers.getIntSafe(obj, "Artifact7");
        this.Artifact8 = GenericHelpers.getIntSafe(obj, "Artifact8");
        this.Artifact9 = GenericHelpers.getIntSafe(obj, "Artifact9");
        this.Artifact10 = GenericHelpers.getIntSafe(obj, "Artifact10");
        this.Artifact11 = GenericHelpers.getIntSafe(obj, "Artifact11");
        this.Artifact12 = GenericHelpers.getIntSafe(obj, "Artifact12");
        this.Artifact13 = GenericHelpers.getIntSafe(obj, "Artifact13");
        this.Artifact14 = GenericHelpers.getIntSafe(obj, "Artifact14");
        this.Artifact15 = GenericHelpers.getIntSafe(obj, "Artifact15");
        this.Artifact16 = GenericHelpers.getIntSafe(obj, "Artifact16");
        this.Artifact17 = GenericHelpers.getIntSafe(obj, "Artifact17");
        this.Artifact18 = GenericHelpers.getIntSafe(obj, "Artifact18");
        this.Artifact19 = GenericHelpers.getIntSafe(obj, "Artifact19");
        this.Artifact20 = GenericHelpers.getIntSafe(obj, "Artifact20");
        this.Artifact21 = GenericHelpers.getIntSafe(obj, "Artifact21");
        this.Artifact22 = GenericHelpers.getIntSafe(obj, "Artifact22");
        this.Artifact23 = GenericHelpers.getIntSafe(obj, "Artifact23");
        this.Artifact24 = GenericHelpers.getIntSafe(obj, "Artifact24");
        this.Artifact25 = GenericHelpers.getIntSafe(obj, "Artifact25");
        this.Artifact26 = GenericHelpers.getIntSafe(obj, "Artifact26");
        this.Artifact27 = GenericHelpers.getIntSafe(obj, "Artifact27");
        this.Artifact28 = GenericHelpers.getIntSafe(obj, "Artifact28");
        this.Artifact29 = GenericHelpers.getIntSafe(obj, "Artifact29");
        this.Artifact30 = GenericHelpers.getIntSafe(obj, "Artifact30");
        this.Artifact31 = GenericHelpers.getIntSafe(obj, "Artifact31");
        this.Artifact32 = GenericHelpers.getIntSafe(obj, "Artifact32");
        this.Artifact33 = GenericHelpers.getIntSafe(obj, "Artifact33");
        this.Artifact34 = GenericHelpers.getIntSafe(obj, "Artifact34");
        this.Artifact35 = GenericHelpers.getIntSafe(obj, "Artifact35");
        this.Artifact36 = GenericHelpers.getIntSafe(obj, "Artifact36");
        this.Artifact37 = GenericHelpers.getIntSafe(obj, "Artifact37");
        this.Artifact38 = GenericHelpers.getIntSafe(obj, "Artifact38");
        this.Artifact39 = GenericHelpers.getIntSafe(obj, "Artifact39");
        this.Artifact40 = GenericHelpers.getIntSafe(obj, "Artifact40");
        this.Artifact41 = GenericHelpers.getIntSafe(obj, "Artifact41");
        this.Artifact42 = GenericHelpers.getIntSafe(obj, "Artifact42");
        this.Artifact43 = GenericHelpers.getIntSafe(obj, "Artifact43");
        this.Artifact44 = GenericHelpers.getIntSafe(obj, "Artifact44");
        this.Artifact45 = GenericHelpers.getIntSafe(obj, "Artifact45");
        this.Artifact46 = GenericHelpers.getIntSafe(obj, "Artifact46");
        this.Artifact47 = GenericHelpers.getIntSafe(obj, "Artifact47");
        this.Artifact48 = GenericHelpers.getIntSafe(obj, "Artifact48");
        this.Artifact49 = GenericHelpers.getIntSafe(obj, "Artifact49");
        this.Artifact50 = GenericHelpers.getIntSafe(obj, "Artifact50");
        this.Artifact51 = GenericHelpers.getIntSafe(obj, "Artifact51");
        this.Artifact52 = GenericHelpers.getIntSafe(obj, "Artifact52");
        this.Artifact53 = GenericHelpers.getIntSafe(obj, "Artifact53");
        this.Artifact54 = GenericHelpers.getIntSafe(obj, "Artifact54");
        this.Artifact55 = GenericHelpers.getIntSafe(obj, "Artifact55");
        this.Artifact56 = GenericHelpers.getIntSafe(obj, "Artifact56");
        this.Artifact57 = GenericHelpers.getIntSafe(obj, "Artifact57");
        this.Artifact58 = GenericHelpers.getIntSafe(obj, "Artifact58");
        this.Artifact59 = GenericHelpers.getIntSafe(obj, "Artifact59");
        this.Artifact60 = GenericHelpers.getIntSafe(obj, "Artifact60");
        this.Artifact61 = GenericHelpers.getIntSafe(obj, "Artifact61");
        this.Artifact62 = GenericHelpers.getIntSafe(obj, "Artifact62");
        this.Artifact63 = GenericHelpers.getIntSafe(obj, "Artifact63");
        this.Artifact64 = GenericHelpers.getIntSafe(obj, "Artifact64");
        this.Artifact65 = GenericHelpers.getIntSafe(obj, "Artifact65");
        this.Artifact66 = GenericHelpers.getIntSafe(obj, "Artifact66");
        this.Artifact67 = GenericHelpers.getIntSafe(obj, "Artifact67");
        this.Artifact68 = GenericHelpers.getIntSafe(obj, "Artifact68");
        this.Artifact69 = GenericHelpers.getIntSafe(obj, "Artifact69");
        this.Artifact70 = GenericHelpers.getIntSafe(obj, "Artifact70");
    }

    private void populateFromNull() {
        this.Artifact1 = 0;
        this.Artifact2 = 0;
        this.Artifact3 = 0;
        this.Artifact4 = 0;
        this.Artifact5 = 0;
        this.Artifact6 = 0;
        this.Artifact7 = 0;
        this.Artifact8 = 0;
        this.Artifact9 = 0;
        this.Artifact10 = 0;
        this.Artifact11 = 0;
        this.Artifact12 = 0;
        this.Artifact13 = 0;
        this.Artifact14 = 0;
        this.Artifact15 = 0;
        this.Artifact16 = 0;
        this.Artifact17 = 0;
        this.Artifact18 = 0;
        this.Artifact19 = 0;
        this.Artifact20 = 0;
        this.Artifact21 = 0;
        this.Artifact22 = 0;
        this.Artifact23 = 0;
        this.Artifact24 = 0;
        this.Artifact25 = 0;
        this.Artifact26 = 0;
        this.Artifact27 = 0;
        this.Artifact28 = 0;
        this.Artifact29 = 0;
        this.Artifact30 = 0;
        this.Artifact31 = 0;
        this.Artifact32 = 0;
        this.Artifact33 = 0;
        this.Artifact34 = 0;
        this.Artifact35 = 0;
        this.Artifact36 = 0;
        this.Artifact37 = 0;
        this.Artifact38 = 0;
        this.Artifact39 = 0;
        this.Artifact40 = 0;
        this.Artifact41 = 0;
        this.Artifact42 = 0;
        this.Artifact43 = 0;
        this.Artifact44 = 0;
        this.Artifact45 = 0;
        this.Artifact46 = 0;
        this.Artifact47 = 0;
        this.Artifact48 = 0;
        this.Artifact49 = 0;
        this.Artifact50 = 0;
        this.Artifact51 = 0;
        this.Artifact52 = 0;
        this.Artifact53 = 0;
        this.Artifact54 = 0;
        this.Artifact55 = 0;
        this.Artifact56 = 0;
        this.Artifact57 = 0;
        this.Artifact58 = 0;
        this.Artifact59 = 0;
        this.Artifact60 = 0;
        this.Artifact61 = 0;
        this.Artifact62 = 0;
        this.Artifact63 = 0;
        this.Artifact64 = 0;
        this.Artifact65 = 0;
        this.Artifact66 = 0;
        this.Artifact67 = 0;
        this.Artifact68 = 0;
        this.Artifact69 = 0;
        this.Artifact70 = 0;
    }

}
