package com.titansmasher.taptitansoptimiser.Models.SequencePriority;

import com.titansmasher.taptitansoptimiser.Models.Enums.Artifact;
import com.titansmasher.taptitansoptimiser.Models.RawSave.Abstracts.ArtifactData;
import com.titansmasher.taptitansoptimiser.Models.RawSave.TapTitansSave;

/**
 * Created by Danny on 23/10/2016.
 */

public class SequencePriorityModel extends ArtifactData<SequenceArtifact>{

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
}
