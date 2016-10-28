package com.titansmasher.taptitansoptimiser.Models.RawSave.Abstracts;

import com.titansmasher.taptitansoptimiser.Helpers.ArrayListConstructor;
import com.titansmasher.taptitansoptimiser.Helpers.HashMapConstructor;
import com.titansmasher.taptitansoptimiser.Models.Enums.Artifact;
import com.titansmasher.taptitansoptimiser.Models.Enums.World;

import java.util.List;
import java.util.Map;

/**
 * Created by Danny on 22/10/2016.
 */

public abstract class ArtifactData<T> {
    public T Artifact1;
    public T Artifact2;
    public T Artifact3;
    public T Artifact4;
    public T Artifact5;
    public T Artifact6;
    public T Artifact7;
    public T Artifact8;
    public T Artifact9;
    public T Artifact10;
    public T Artifact11;
    public T Artifact12;
    public T Artifact13;
    public T Artifact14;
    public T Artifact15;
    public T Artifact16;
    public T Artifact17;
    public T Artifact18;
    public T Artifact19;
    public T Artifact20;
    public T Artifact21;
    public T Artifact22;
    public T Artifact23;
    public T Artifact24;
    public T Artifact25;
    public T Artifact26;
    public T Artifact27;
    public T Artifact28;
    public T Artifact29;
    public T Artifact30;
    public T Artifact31;
    public T Artifact32;
    public T Artifact33;
    public T Artifact34;
    public T Artifact35;
    public T Artifact36;
    public T Artifact37;
    public T Artifact38;
    public T Artifact39;
    public T Artifact40;
    public T Artifact41;
    public T Artifact42;
    public T Artifact43;
    public T Artifact44;
    public T Artifact45;
    public T Artifact46;
    public T Artifact47;
    public T Artifact48;
    public T Artifact49;
    public T Artifact50;
    public T Artifact51;
    public T Artifact52;
    public T Artifact53;
    public T Artifact54;
    public T Artifact55;
    public T Artifact56;
    public T Artifact57;
    public T Artifact58;
    public T Artifact59;
    public T Artifact60;
    public T Artifact61;
    public T Artifact62;
    public T Artifact63;
    public T Artifact64;
    public T Artifact65;
    public T Artifact66;
    public T Artifact67;
    public T Artifact68;
    public T Artifact69;
    public T Artifact70;

    public List<T> getForWorld(World world){
        switch (world){
            case WORLD_1:
                return new ArrayListConstructor<T>()
                        .add(Artifact1)
                        .add(Artifact2)
                        .add(Artifact3)
                        .add(Artifact4)
                        .add(Artifact5)
                        .add(Artifact6)
                        .add(Artifact7)
                        .add(Artifact8)
                        .add(Artifact9)
                        .add(Artifact10)
                        .add(Artifact11)
                        .add(Artifact12)
                        .add(Artifact13)
                        .add(Artifact14)
                        .add(Artifact15)
                        .add(Artifact16)
                        .add(Artifact17)
                        .add(Artifact18)
                        .add(Artifact19)
                        .add(Artifact20)
                        .add(Artifact21)
                        .add(Artifact22)
                        .add(Artifact23)
                        .add(Artifact24)
                        .add(Artifact25)
                        .add(Artifact26)
                        .add(Artifact27)
                        .add(Artifact28)
                        .add(Artifact29)
                        .add(Artifact30)
                        .getList();
            case WORLD_2:
                return new ArrayListConstructor<T>()
                        .add(Artifact31)
                        .add(Artifact32)
                        .add(Artifact33)
                        .add(Artifact34)
                        .add(Artifact35)
                        .add(Artifact36)
                        .add(Artifact37)
                        .add(Artifact38)
                        .add(Artifact39)
                        .add(Artifact40)
                        .add(Artifact41)
                        .add(Artifact42)
                        .add(Artifact43)
                        .add(Artifact44)
                        .add(Artifact45)
                        .add(Artifact46)
                        .add(Artifact47)
                        .add(Artifact48)
                        .add(Artifact49)
                        .add(Artifact50)
                        .add(Artifact51)
                        .add(Artifact52)
                        .add(Artifact53)
                        .add(Artifact54)
                        .add(Artifact55)
                        .add(Artifact56)
                        .add(Artifact57)
                        .add(Artifact58)
                        .add(Artifact59)
                        .add(Artifact60)
                        .add(Artifact61)
                        .add(Artifact62)
                        .add(Artifact63)
                        .add(Artifact64)
                        .add(Artifact65)
                        .add(Artifact66)
                        .add(Artifact67)
                        .add(Artifact68)
                        .add(Artifact69)
                        .add(Artifact70)
                        .getList();
            default:
                return null;

        }
    }

    public Map<Artifact, T> mapArtifacts() {
        return new HashMapConstructor<Artifact, T>()
                .add(Artifact.getFromId(1), Artifact1)
                .add(Artifact.getFromId(2), Artifact2)
                .add(Artifact.getFromId(3), Artifact3)
                .add(Artifact.getFromId(4), Artifact4)
                .add(Artifact.getFromId(5), Artifact5)
                .add(Artifact.getFromId(6), Artifact6)
                .add(Artifact.getFromId(7), Artifact7)
                .add(Artifact.getFromId(8), Artifact8)
                .add(Artifact.getFromId(9), Artifact9)
                .add(Artifact.getFromId(10), Artifact10)
                .add(Artifact.getFromId(11), Artifact11)
                .add(Artifact.getFromId(12), Artifact12)
                .add(Artifact.getFromId(13), Artifact13)
                .add(Artifact.getFromId(14), Artifact14)
                .add(Artifact.getFromId(15), Artifact15)
                .add(Artifact.getFromId(16), Artifact16)
                .add(Artifact.getFromId(17), Artifact17)
                .add(Artifact.getFromId(18), Artifact18)
                .add(Artifact.getFromId(19), Artifact19)
                .add(Artifact.getFromId(20), Artifact20)
                .add(Artifact.getFromId(21), Artifact21)
                .add(Artifact.getFromId(22), Artifact22)
                .add(Artifact.getFromId(23), Artifact23)
                .add(Artifact.getFromId(24), Artifact24)
                .add(Artifact.getFromId(25), Artifact25)
                .add(Artifact.getFromId(26), Artifact26)
                .add(Artifact.getFromId(27), Artifact27)
                .add(Artifact.getFromId(28), Artifact28)
                .add(Artifact.getFromId(29), Artifact29)
                .add(Artifact.getFromId(30), Artifact30)
                .add(Artifact.getFromId(31), Artifact31)
                .add(Artifact.getFromId(32), Artifact32)
                .add(Artifact.getFromId(33), Artifact33)
                .add(Artifact.getFromId(34), Artifact34)
                .add(Artifact.getFromId(35), Artifact35)
                .add(Artifact.getFromId(36), Artifact36)
                .add(Artifact.getFromId(37), Artifact37)
                .add(Artifact.getFromId(38), Artifact38)
                .add(Artifact.getFromId(39), Artifact39)
                .add(Artifact.getFromId(40), Artifact40)
                .add(Artifact.getFromId(41), Artifact41)
                .add(Artifact.getFromId(42), Artifact42)
                .add(Artifact.getFromId(43), Artifact43)
                .add(Artifact.getFromId(44), Artifact44)
                .add(Artifact.getFromId(45), Artifact45)
                .add(Artifact.getFromId(46), Artifact46)
                .add(Artifact.getFromId(47), Artifact47)
                .add(Artifact.getFromId(48), Artifact48)
                .add(Artifact.getFromId(49), Artifact49)
                .add(Artifact.getFromId(50), Artifact50)
                .add(Artifact.getFromId(51), Artifact51)
                .add(Artifact.getFromId(52), Artifact52)
                .add(Artifact.getFromId(53), Artifact53)
                .add(Artifact.getFromId(54), Artifact54)
                .add(Artifact.getFromId(55), Artifact55)
                .add(Artifact.getFromId(56), Artifact56)
                .add(Artifact.getFromId(57), Artifact57)
                .add(Artifact.getFromId(58), Artifact58)
                .add(Artifact.getFromId(59), Artifact59)
                .add(Artifact.getFromId(60), Artifact60)
                .add(Artifact.getFromId(61), Artifact61)
                .add(Artifact.getFromId(62), Artifact62)
                .add(Artifact.getFromId(63), Artifact63)
                .add(Artifact.getFromId(64), Artifact64)
                .add(Artifact.getFromId(65), Artifact65)
                .add(Artifact.getFromId(66), Artifact66)
                .add(Artifact.getFromId(67), Artifact67)
                .add(Artifact.getFromId(68), Artifact68)
                .add(Artifact.getFromId(69), Artifact69)
                .add(Artifact.getFromId(70), Artifact70)
                .getMap();

    }
}
