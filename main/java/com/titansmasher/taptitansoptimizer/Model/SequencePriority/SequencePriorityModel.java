package com.titansmasher.taptitansoptimizer.Model.SequencePriority;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Model.Enums.Artifact;
import com.titansmasher.taptitansoptimizer.Model.RawSave.Abstracts.ArtifactData;
import com.titansmasher.taptitansoptimizer.Model.RawSave.TapTitansSave;

import org.json.JSONObject;

/**
 * Created by Danny on 23/10/2016.
 */

public class SequencePriorityModel extends ArtifactData<SequenceArtifact>{
    public String ARTIFACT1_KEY  = "Artifact1";
    public String ARTIFACT2_KEY  = "Artifact2";
    public String ARTIFACT3_KEY  = "Artifact3";
    public String ARTIFACT4_KEY  = "Artifact4";
    public String ARTIFACT5_KEY  = "Artifact5";
    public String ARTIFACT6_KEY  = "Artifact6";
    public String ARTIFACT7_KEY  = "Artifact7";
    public String ARTIFACT8_KEY  = "Artifact8";
    public String ARTIFACT9_KEY  = "Artifact9";
    public String ARTIFACT10_KEY = "Artifact10";
    public String ARTIFACT11_KEY = "Artifact11";
    public String ARTIFACT12_KEY = "Artifact12";
    public String ARTIFACT13_KEY = "Artifact13";
    public String ARTIFACT14_KEY = "Artifact14";
    public String ARTIFACT15_KEY = "Artifact15";
    public String ARTIFACT16_KEY = "Artifact16";
    public String ARTIFACT17_KEY = "Artifact17";
    public String ARTIFACT18_KEY = "Artifact18";
    public String ARTIFACT19_KEY = "Artifact19";
    public String ARTIFACT20_KEY = "Artifact20";
    public String ARTIFACT21_KEY = "Artifact21";
    public String ARTIFACT22_KEY = "Artifact22";
    public String ARTIFACT23_KEY = "Artifact23";
    public String ARTIFACT24_KEY = "Artifact24";
    public String ARTIFACT25_KEY = "Artifact25";
    public String ARTIFACT26_KEY = "Artifact26";
    public String ARTIFACT27_KEY = "Artifact27";
    public String ARTIFACT28_KEY = "Artifact28";
    public String ARTIFACT29_KEY = "Artifact29";
    public String ARTIFACT30_KEY = "Artifact30";
    public String ARTIFACT31_KEY = "Artifact31";
    public String ARTIFACT32_KEY = "Artifact32";
    public String ARTIFACT33_KEY = "Artifact33";
    public String ARTIFACT34_KEY = "Artifact34";
    public String ARTIFACT35_KEY = "Artifact35";
    public String ARTIFACT36_KEY = "Artifact36";
    public String ARTIFACT37_KEY = "Artifact37";
    public String ARTIFACT38_KEY = "Artifact38";
    public String ARTIFACT39_KEY = "Artifact39";
    public String ARTIFACT40_KEY = "Artifact40";
    public String ARTIFACT41_KEY = "Artifact41";
    public String ARTIFACT42_KEY = "Artifact42";
    public String ARTIFACT43_KEY = "Artifact43";
    public String ARTIFACT44_KEY = "Artifact44";
    public String ARTIFACT45_KEY = "Artifact45";
    public String ARTIFACT46_KEY = "Artifact46";
    public String ARTIFACT47_KEY = "Artifact47";
    public String ARTIFACT48_KEY = "Artifact48";
    public String ARTIFACT49_KEY = "Artifact49";
    public String ARTIFACT50_KEY = "Artifact50";
    public String ARTIFACT51_KEY = "Artifact51";
    public String ARTIFACT52_KEY = "Artifact52";
    public String ARTIFACT53_KEY = "Artifact53";
    public String ARTIFACT54_KEY = "Artifact54";
    public String ARTIFACT55_KEY = "Artifact55";
    public String ARTIFACT56_KEY = "Artifact56";
    public String ARTIFACT57_KEY = "Artifact57";
    public String ARTIFACT58_KEY = "Artifact58";
    public String ARTIFACT59_KEY = "Artifact59";
    public String ARTIFACT60_KEY = "Artifact60";
    public String ARTIFACT61_KEY = "Artifact61";
    public String ARTIFACT62_KEY = "Artifact62";
    public String ARTIFACT63_KEY = "Artifact63";
    public String ARTIFACT64_KEY = "Artifact64";
    public String ARTIFACT65_KEY = "Artifact65";
    public String ARTIFACT66_KEY = "Artifact66";
    public String ARTIFACT67_KEY = "Artifact67";
    public String ARTIFACT68_KEY = "Artifact68";
    public String ARTIFACT69_KEY = "Artifact69";
    public String ARTIFACT70_KEY = "Artifact70";


    public SequencePriorityModel(TapTitansSave save){
        this.Artifact1 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact1, Artifact.getFromId(1));
        this.Artifact2 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact2, Artifact.getFromId(2));
        this.Artifact3 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact3, Artifact.getFromId(3));
        this.Artifact4 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact4, Artifact.getFromId(4));
        this.Artifact5 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact5, Artifact.getFromId(5));
        this.Artifact6 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact6, Artifact.getFromId(6));
        this.Artifact7 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact7, Artifact.getFromId(7));
        this.Artifact8 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact8, Artifact.getFromId(8));
        this.Artifact9 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact9, Artifact.getFromId(9));
        this.Artifact10 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact10, Artifact.getFromId(10));
        this.Artifact11 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact11, Artifact.getFromId(11));
        this.Artifact12 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact12, Artifact.getFromId(12));
        this.Artifact13 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact13, Artifact.getFromId(13));
        this.Artifact14 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact14, Artifact.getFromId(14));
        this.Artifact15 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact15, Artifact.getFromId(15));
        this.Artifact16 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact16, Artifact.getFromId(16));
        this.Artifact17 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact17, Artifact.getFromId(17));
        this.Artifact18 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact18, Artifact.getFromId(18));
        this.Artifact19 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact19, Artifact.getFromId(19));
        this.Artifact20 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact20, Artifact.getFromId(20));
        this.Artifact21 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact21, Artifact.getFromId(21));
        this.Artifact22 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact22, Artifact.getFromId(22));
        this.Artifact23 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact23, Artifact.getFromId(23));
        this.Artifact24 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact24, Artifact.getFromId(24));
        this.Artifact25 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact25, Artifact.getFromId(25));
        this.Artifact26 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact26, Artifact.getFromId(26));
        this.Artifact27 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact27, Artifact.getFromId(27));
        this.Artifact28 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact28, Artifact.getFromId(28));
        this.Artifact29 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact29, Artifact.getFromId(29));
        this.Artifact30 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact30, Artifact.getFromId(30));
        this.Artifact31 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact31, Artifact.getFromId(31));
        this.Artifact32 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact32, Artifact.getFromId(32));
        this.Artifact33 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact33, Artifact.getFromId(33));
        this.Artifact34 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact34, Artifact.getFromId(34));
        this.Artifact35 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact35, Artifact.getFromId(35));
        this.Artifact36 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact36, Artifact.getFromId(36));
        this.Artifact37 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact37, Artifact.getFromId(37));
        this.Artifact38 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact38, Artifact.getFromId(38));
        this.Artifact39 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact39, Artifact.getFromId(39));
        this.Artifact40 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact40, Artifact.getFromId(40));
        this.Artifact41 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact41, Artifact.getFromId(41));
        this.Artifact42 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact42, Artifact.getFromId(42));
        this.Artifact43 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact43, Artifact.getFromId(43));
        this.Artifact44 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact44, Artifact.getFromId(44));
        this.Artifact45 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact45, Artifact.getFromId(45));
        this.Artifact46 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact46, Artifact.getFromId(46));
        this.Artifact47 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact47, Artifact.getFromId(47));
        this.Artifact48 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact48, Artifact.getFromId(48));
        this.Artifact49 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact49, Artifact.getFromId(49));
        this.Artifact50 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact50, Artifact.getFromId(50));
        this.Artifact51 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact51, Artifact.getFromId(51));
        this.Artifact52 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact52, Artifact.getFromId(52));
        this.Artifact53 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact53, Artifact.getFromId(53));
        this.Artifact54 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact54, Artifact.getFromId(54));
        this.Artifact55 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact55, Artifact.getFromId(55));
        this.Artifact56 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact56, Artifact.getFromId(56));
        this.Artifact57 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact57, Artifact.getFromId(57));
        this.Artifact58 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact58, Artifact.getFromId(58));
        this.Artifact59 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact59, Artifact.getFromId(59));
        this.Artifact60 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact60, Artifact.getFromId(60));
        this.Artifact61 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact61, Artifact.getFromId(61));
        this.Artifact62 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact62, Artifact.getFromId(62));
        this.Artifact63 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact63, Artifact.getFromId(63));
        this.Artifact64 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact64, Artifact.getFromId(64));
        this.Artifact65 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact65, Artifact.getFromId(65));
        this.Artifact66 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact66, Artifact.getFromId(66));
        this.Artifact67 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact67, Artifact.getFromId(67));
        this.Artifact68 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact68, Artifact.getFromId(68));
        this.Artifact69 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact69, Artifact.getFromId(69));
        this.Artifact70 = new SequenceArtifact(save.playerInfoSave.artifactLevels.Artifact70, Artifact.getFromId(70));
    }

    public SequencePriorityModel(JSONObject obj){
        if (obj == null){
            populateFromNull();
            return;
        }
        this.Artifact1  = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT1_KEY),  Artifact.getFromId(1 ));
        this.Artifact2  = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT2_KEY),  Artifact.getFromId(2 ));
        this.Artifact3  = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT3_KEY),  Artifact.getFromId(3 ));
        this.Artifact4  = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT4_KEY),  Artifact.getFromId(4 ));
        this.Artifact5  = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT5_KEY),  Artifact.getFromId(5 ));
        this.Artifact6  = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT6_KEY),  Artifact.getFromId(6 ));
        this.Artifact7  = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT7_KEY),  Artifact.getFromId(7 ));
        this.Artifact8  = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT8_KEY),  Artifact.getFromId(8 ));
        this.Artifact9  = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT9_KEY),  Artifact.getFromId(9 ));
        this.Artifact10 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT10_KEY), Artifact.getFromId(10));
        this.Artifact11 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT11_KEY), Artifact.getFromId(11));
        this.Artifact12 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT12_KEY), Artifact.getFromId(12));
        this.Artifact13 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT13_KEY), Artifact.getFromId(13));
        this.Artifact14 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT14_KEY), Artifact.getFromId(14));
        this.Artifact15 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT15_KEY), Artifact.getFromId(15));
        this.Artifact16 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT16_KEY), Artifact.getFromId(16));
        this.Artifact17 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT17_KEY), Artifact.getFromId(17));
        this.Artifact18 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT18_KEY), Artifact.getFromId(18));
        this.Artifact19 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT19_KEY), Artifact.getFromId(19));
        this.Artifact20 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT20_KEY), Artifact.getFromId(20));
        this.Artifact21 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT21_KEY), Artifact.getFromId(21));
        this.Artifact22 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT22_KEY), Artifact.getFromId(22));
        this.Artifact23 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT23_KEY), Artifact.getFromId(23));
        this.Artifact24 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT24_KEY), Artifact.getFromId(24));
        this.Artifact25 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT25_KEY), Artifact.getFromId(25));
        this.Artifact26 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT26_KEY), Artifact.getFromId(26));
        this.Artifact27 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT27_KEY), Artifact.getFromId(27));
        this.Artifact28 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT28_KEY), Artifact.getFromId(28));
        this.Artifact29 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT29_KEY), Artifact.getFromId(29));
        this.Artifact30 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT30_KEY), Artifact.getFromId(30));
        this.Artifact31 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT31_KEY), Artifact.getFromId(31));
        this.Artifact32 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT32_KEY), Artifact.getFromId(32));
        this.Artifact33 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT33_KEY), Artifact.getFromId(33));
        this.Artifact34 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT34_KEY), Artifact.getFromId(34));
        this.Artifact35 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT35_KEY), Artifact.getFromId(35));
        this.Artifact36 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT36_KEY), Artifact.getFromId(36));
        this.Artifact37 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT37_KEY), Artifact.getFromId(37));
        this.Artifact38 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT38_KEY), Artifact.getFromId(38));
        this.Artifact39 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT39_KEY), Artifact.getFromId(39));
        this.Artifact40 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT40_KEY), Artifact.getFromId(40));
        this.Artifact41 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT41_KEY), Artifact.getFromId(41));
        this.Artifact42 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT42_KEY), Artifact.getFromId(42));
        this.Artifact43 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT43_KEY), Artifact.getFromId(43));
        this.Artifact44 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT44_KEY), Artifact.getFromId(44));
        this.Artifact45 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT45_KEY), Artifact.getFromId(45));
        this.Artifact46 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT46_KEY), Artifact.getFromId(46));
        this.Artifact47 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT47_KEY), Artifact.getFromId(47));
        this.Artifact48 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT48_KEY), Artifact.getFromId(48));
        this.Artifact49 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT49_KEY), Artifact.getFromId(49));
        this.Artifact50 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT50_KEY), Artifact.getFromId(50));
        this.Artifact51 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT51_KEY), Artifact.getFromId(51));
        this.Artifact52 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT52_KEY), Artifact.getFromId(52));
        this.Artifact53 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT53_KEY), Artifact.getFromId(53));
        this.Artifact54 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT54_KEY), Artifact.getFromId(54));
        this.Artifact55 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT55_KEY), Artifact.getFromId(55));
        this.Artifact56 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT56_KEY), Artifact.getFromId(56));
        this.Artifact57 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT57_KEY), Artifact.getFromId(57));
        this.Artifact58 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT58_KEY), Artifact.getFromId(58));
        this.Artifact59 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT59_KEY), Artifact.getFromId(59));
        this.Artifact60 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT60_KEY), Artifact.getFromId(60));
        this.Artifact61 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT61_KEY), Artifact.getFromId(61));
        this.Artifact62 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT62_KEY), Artifact.getFromId(62));
        this.Artifact63 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT63_KEY), Artifact.getFromId(63));
        this.Artifact64 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT64_KEY), Artifact.getFromId(64));
        this.Artifact65 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT65_KEY), Artifact.getFromId(65));
        this.Artifact66 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT66_KEY), Artifact.getFromId(66));
        this.Artifact67 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT67_KEY), Artifact.getFromId(67));
        this.Artifact68 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT68_KEY), Artifact.getFromId(68));
        this.Artifact69 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT69_KEY), Artifact.getFromId(69));
        this.Artifact70 = new SequenceArtifact(GenericHelpers.getJSONObjectSafe(obj, ARTIFACT70_KEY), Artifact.getFromId(70));
    }

    private void populateFromNull(){
        this.Artifact1 = new SequenceArtifact(null, Artifact.getFromId(1));
        this.Artifact2 = new SequenceArtifact(null, Artifact.getFromId(2));
        this.Artifact3 = new SequenceArtifact(null, Artifact.getFromId(3));
        this.Artifact4 = new SequenceArtifact(null, Artifact.getFromId(4));
        this.Artifact5 = new SequenceArtifact(null, Artifact.getFromId(5));
        this.Artifact6 = new SequenceArtifact(null, Artifact.getFromId(6));
        this.Artifact7 = new SequenceArtifact(null, Artifact.getFromId(7));
        this.Artifact8 = new SequenceArtifact(null, Artifact.getFromId(8));
        this.Artifact9 = new SequenceArtifact(null, Artifact.getFromId(9));
        this.Artifact10 = new SequenceArtifact(null, Artifact.getFromId(10));
        this.Artifact11 = new SequenceArtifact(null, Artifact.getFromId(11));
        this.Artifact12 = new SequenceArtifact(null, Artifact.getFromId(12));
        this.Artifact13 = new SequenceArtifact(null, Artifact.getFromId(13));
        this.Artifact14 = new SequenceArtifact(null, Artifact.getFromId(14));
        this.Artifact15 = new SequenceArtifact(null, Artifact.getFromId(15));
        this.Artifact16 = new SequenceArtifact(null, Artifact.getFromId(16));
        this.Artifact17 = new SequenceArtifact(null, Artifact.getFromId(17));
        this.Artifact18 = new SequenceArtifact(null, Artifact.getFromId(18));
        this.Artifact19 = new SequenceArtifact(null, Artifact.getFromId(19));
        this.Artifact20 = new SequenceArtifact(null, Artifact.getFromId(20));
        this.Artifact21 = new SequenceArtifact(null, Artifact.getFromId(21));
        this.Artifact22 = new SequenceArtifact(null, Artifact.getFromId(22));
        this.Artifact23 = new SequenceArtifact(null, Artifact.getFromId(23));
        this.Artifact24 = new SequenceArtifact(null, Artifact.getFromId(24));
        this.Artifact25 = new SequenceArtifact(null, Artifact.getFromId(25));
        this.Artifact26 = new SequenceArtifact(null, Artifact.getFromId(26));
        this.Artifact27 = new SequenceArtifact(null, Artifact.getFromId(27));
        this.Artifact28 = new SequenceArtifact(null, Artifact.getFromId(28));
        this.Artifact29 = new SequenceArtifact(null, Artifact.getFromId(29));
        this.Artifact30 = new SequenceArtifact(null, Artifact.getFromId(30));
        this.Artifact31 = new SequenceArtifact(null, Artifact.getFromId(31));
        this.Artifact32 = new SequenceArtifact(null, Artifact.getFromId(32));
        this.Artifact33 = new SequenceArtifact(null, Artifact.getFromId(33));
        this.Artifact34 = new SequenceArtifact(null, Artifact.getFromId(34));
        this.Artifact35 = new SequenceArtifact(null, Artifact.getFromId(35));
        this.Artifact36 = new SequenceArtifact(null, Artifact.getFromId(36));
        this.Artifact37 = new SequenceArtifact(null, Artifact.getFromId(37));
        this.Artifact38 = new SequenceArtifact(null, Artifact.getFromId(38));
        this.Artifact39 = new SequenceArtifact(null, Artifact.getFromId(39));
        this.Artifact40 = new SequenceArtifact(null, Artifact.getFromId(40));
        this.Artifact41 = new SequenceArtifact(null, Artifact.getFromId(41));
        this.Artifact42 = new SequenceArtifact(null, Artifact.getFromId(42));
        this.Artifact43 = new SequenceArtifact(null, Artifact.getFromId(43));
        this.Artifact44 = new SequenceArtifact(null, Artifact.getFromId(44));
        this.Artifact45 = new SequenceArtifact(null, Artifact.getFromId(45));
        this.Artifact46 = new SequenceArtifact(null, Artifact.getFromId(46));
        this.Artifact47 = new SequenceArtifact(null, Artifact.getFromId(47));
        this.Artifact48 = new SequenceArtifact(null, Artifact.getFromId(48));
        this.Artifact49 = new SequenceArtifact(null, Artifact.getFromId(49));
        this.Artifact50 = new SequenceArtifact(null, Artifact.getFromId(50));
        this.Artifact51 = new SequenceArtifact(null, Artifact.getFromId(51));
        this.Artifact52 = new SequenceArtifact(null, Artifact.getFromId(52));
        this.Artifact53 = new SequenceArtifact(null, Artifact.getFromId(53));
        this.Artifact54 = new SequenceArtifact(null, Artifact.getFromId(54));
        this.Artifact55 = new SequenceArtifact(null, Artifact.getFromId(55));
        this.Artifact56 = new SequenceArtifact(null, Artifact.getFromId(56));
        this.Artifact57 = new SequenceArtifact(null, Artifact.getFromId(57));
        this.Artifact58 = new SequenceArtifact(null, Artifact.getFromId(58));
        this.Artifact59 = new SequenceArtifact(null, Artifact.getFromId(59));
        this.Artifact60 = new SequenceArtifact(null, Artifact.getFromId(60));
        this.Artifact61 = new SequenceArtifact(null, Artifact.getFromId(61));
        this.Artifact62 = new SequenceArtifact(null, Artifact.getFromId(62));
        this.Artifact63 = new SequenceArtifact(null, Artifact.getFromId(63));
        this.Artifact64 = new SequenceArtifact(null, Artifact.getFromId(64));
        this.Artifact65 = new SequenceArtifact(null, Artifact.getFromId(65));
        this.Artifact66 = new SequenceArtifact(null, Artifact.getFromId(66));
        this.Artifact67 = new SequenceArtifact(null, Artifact.getFromId(67));
        this.Artifact68 = new SequenceArtifact(null, Artifact.getFromId(68));
        this.Artifact69 = new SequenceArtifact(null, Artifact.getFromId(69));
        this.Artifact70 = new SequenceArtifact(null, Artifact.getFromId(70));
    }

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT1_KEY,  this.Artifact1.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT2_KEY,  this.Artifact2.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT3_KEY,  this.Artifact3.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT4_KEY,  this.Artifact4.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT5_KEY,  this.Artifact5.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT6_KEY,  this.Artifact6.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT7_KEY,  this.Artifact7.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT8_KEY,  this.Artifact8.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT9_KEY,  this.Artifact9.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT10_KEY, this.Artifact10.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT11_KEY, this.Artifact11.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT12_KEY, this.Artifact12.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT13_KEY, this.Artifact13.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT14_KEY, this.Artifact14.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT15_KEY, this.Artifact15.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT16_KEY, this.Artifact16.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT17_KEY, this.Artifact17.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT18_KEY, this.Artifact18.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT19_KEY, this.Artifact19.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT20_KEY, this.Artifact20.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT21_KEY, this.Artifact21.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT22_KEY, this.Artifact22.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT23_KEY, this.Artifact23.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT24_KEY, this.Artifact24.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT25_KEY, this.Artifact25.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT26_KEY, this.Artifact26.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT27_KEY, this.Artifact27.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT28_KEY, this.Artifact28.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT29_KEY, this.Artifact29.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT30_KEY, this.Artifact30.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT31_KEY, this.Artifact31.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT32_KEY, this.Artifact32.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT33_KEY, this.Artifact33.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT34_KEY, this.Artifact34.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT35_KEY, this.Artifact35.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT36_KEY, this.Artifact36.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT37_KEY, this.Artifact37.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT38_KEY, this.Artifact38.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT39_KEY, this.Artifact39.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT40_KEY, this.Artifact40.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT41_KEY, this.Artifact41.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT42_KEY, this.Artifact42.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT43_KEY, this.Artifact43.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT44_KEY, this.Artifact44.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT45_KEY, this.Artifact45.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT46_KEY, this.Artifact46.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT47_KEY, this.Artifact47.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT48_KEY, this.Artifact48.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT49_KEY, this.Artifact49.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT50_KEY, this.Artifact50.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT51_KEY, this.Artifact51.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT52_KEY, this.Artifact52.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT53_KEY, this.Artifact53.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT54_KEY, this.Artifact54.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT55_KEY, this.Artifact55.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT56_KEY, this.Artifact56.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT57_KEY, this.Artifact57.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT58_KEY, this.Artifact58.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT59_KEY, this.Artifact59.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT60_KEY, this.Artifact60.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT61_KEY, this.Artifact61.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT62_KEY, this.Artifact62.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT63_KEY, this.Artifact63.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT64_KEY, this.Artifact64.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT65_KEY, this.Artifact65.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT66_KEY, this.Artifact66.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT67_KEY, this.Artifact67.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT68_KEY, this.Artifact68.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT69_KEY, this.Artifact69.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, ARTIFACT70_KEY, this.Artifact70.generateJson());

        return obj;
    }
}
