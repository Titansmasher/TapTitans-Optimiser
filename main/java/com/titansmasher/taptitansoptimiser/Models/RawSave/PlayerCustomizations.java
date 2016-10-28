package com.titansmasher.taptitansoptimiser.Models.RawSave;

import com.titansmasher.taptitansoptimiser.Helpers.HashMapConstructor;
import com.titansmasher.taptitansoptimiser.Models.Enums.Customisation;

import java.util.Map;

/**
 * Created by Danny on 25/10/2016.
 */

public class PlayerCustomizations {
    public boolean C0_0;
    public boolean C0_1;
    public boolean C0_10;
    public boolean C0_11;
    public boolean C0_13;
    public boolean C0_14;
    public boolean C0_2;
    public boolean C0_3;
    public boolean C0_4;
    public boolean C0_5;
    public boolean C0_6;
    public boolean C0_7;
    public boolean C0_8;
    public boolean C0_9;
    public boolean C1_0;
    public boolean C1_1;
    public boolean C1_10;
    public boolean C1_11;
    public boolean C1_2;
    public boolean C1_3;
    public boolean C1_4;
    public boolean C1_5;
    public boolean C1_6;
    public boolean C1_7;
    public boolean C1_8;
    public boolean C1_9;
    public boolean C2_0;
    public boolean C2_1;
    public boolean C2_10;
    public boolean C2_11;
    public boolean C2_12;
    public boolean C2_13;
    public boolean C2_14;
    public boolean C2_15;
    public boolean C2_16;
    public boolean C2_17;
    public boolean C2_2;
    public boolean C2_3;
    public boolean C2_4;
    public boolean C2_5;
    public boolean C2_6;
    public boolean C2_8;
    public boolean C2_9;
    public boolean C3_0;
    public boolean C3_1;
    public boolean C3_10;
    public boolean C3_11;
    public boolean C3_12;
    public boolean C3_13;
    public boolean C3_14;
    public boolean C3_15;
    public boolean C3_17;
    public boolean C3_18;
    public boolean C3_19;
    public boolean C3_20;
    public boolean C3_21;
    public boolean C3_22;
    public boolean C3_25;
    public boolean C3_26;
    public boolean C3_28;
    public boolean C3_29;
    public boolean C3_3;
    public boolean C3_30;
    public boolean C3_4;
    public boolean C3_5;
    public boolean C3_7;
    public boolean C3_901;
    public boolean C3_902;
    public boolean C3_903;
    public boolean C3_904;
    public boolean C3_905;
    public boolean C3_906;
    public boolean C3_907;
    public boolean C3_909;
    public boolean C4_0;
    public boolean C4_1;
    public boolean C4_10;
    public boolean C4_2;
    public boolean C4_3;
    public boolean C4_4;
    public boolean C4_5;
    public boolean C4_6;
    public boolean C4_7;
    public boolean C4_8;
    public boolean C4_9;
    public boolean C5_0;
    public boolean C5_1;
    public boolean C5_10;
    public boolean C5_2;
    public boolean C5_3;
    public boolean C5_4;
    public boolean C5_5;
    public boolean C5_6;
    public boolean C5_7;
    public boolean C5_8;
    public boolean C5_9;

    public PlayerCustomizations(String customization){
        if (customization == null){
            populateFromNull();
            return;
        }
        this.C0_0 = customization.contains("0_0");
        this.C0_1 = customization.contains("0_1");
        this.C0_10 = customization.contains("0_10");
        this.C0_11 = customization.contains("0_11");
        this.C0_13 = customization.contains("0_13");
        this.C0_14 = customization.contains("0_14");
        this.C0_2 = customization.contains("0_2");
        this.C0_3 = customization.contains("0_3");
        this.C0_4 = customization.contains("0_4");
        this.C0_5 = customization.contains("0_5");
        this.C0_6 = customization.contains("0_6");
        this.C0_7 = customization.contains("0_7");
        this.C0_8 = customization.contains("0_8");
        this.C0_9 = customization.contains("0_9");
        this.C1_0 = customization.contains("1_0");
        this.C1_1 = customization.contains("1_1");
        this.C1_10 = customization.contains("1_10");
        this.C1_11 = customization.contains("1_11");
        this.C1_2 = customization.contains("1_2");
        this.C1_3 = customization.contains("1_3");
        this.C1_4 = customization.contains("1_4");
        this.C1_5 = customization.contains("1_5");
        this.C1_6 = customization.contains("1_6");
        this.C1_7 = customization.contains("1_7");
        this.C1_8 = customization.contains("1_8");
        this.C1_9 = customization.contains("1_9");
        this.C2_0 = customization.contains("2_0");
        this.C2_1 = customization.contains("2_1");
        this.C2_10 = customization.contains("2_10");
        this.C2_11 = customization.contains("2_11");
        this.C2_12 = customization.contains("2_12");
        this.C2_13 = customization.contains("2_13");
        this.C2_14 = customization.contains("2_14");
        this.C2_15 = customization.contains("2_15");
        this.C2_16 = customization.contains("2_16");
        this.C2_17 = customization.contains("2_17");
        this.C2_2 = customization.contains("2_2");
        this.C2_3 = customization.contains("2_3");
        this.C2_4 = customization.contains("2_4");
        this.C2_5 = customization.contains("2_5");
        this.C2_6 = customization.contains("2_6");
        this.C2_8 = customization.contains("2_8");
        this.C2_9 = customization.contains("2_9");
        this.C3_0 = customization.contains("3_0");
        this.C3_1 = customization.contains("3_1");
        this.C3_10 = customization.contains("3_10");
        this.C3_11 = customization.contains("3_11");
        this.C3_12 = customization.contains("3_12");
        this.C3_13 = customization.contains("3_13");
        this.C3_14 = customization.contains("3_14");
        this.C3_15 = customization.contains("3_15");
        this.C3_17 = customization.contains("3_17");
        this.C3_18 = customization.contains("3_18");
        this.C3_19 = customization.contains("3_19");
        this.C3_20 = customization.contains("3_20");
        this.C3_21 = customization.contains("3_21");
        this.C3_22 = customization.contains("3_22");
        this.C3_25 = customization.contains("3_25");
        this.C3_26 = customization.contains("3_26");
        this.C3_28 = customization.contains("3_28");
        this.C3_29 = customization.contains("3_29");
        this.C3_3 = customization.contains("3_3");
        this.C3_30 = customization.contains("3_30");
        this.C3_4 = customization.contains("3_4");
        this.C3_5 = customization.contains("3_5");
        this.C3_7 = customization.contains("3_7");
        this.C3_901 = customization.contains("3_901");
        this.C3_902 = customization.contains("3_902");
        this.C3_903 = customization.contains("3_903");
        this.C3_904 = customization.contains("3_904");
        this.C3_905 = customization.contains("3_905");
        this.C3_906 = customization.contains("3_906");
        this.C3_907 = customization.contains("3_907");
        this.C3_909 = customization.contains("3_909");
        this.C4_0 = customization.contains("4_0");
        this.C4_1 = customization.contains("4_1");
        this.C4_10 = customization.contains("4_10");
        this.C4_2 = customization.contains("4_2");
        this.C4_3 = customization.contains("4_3");
        this.C4_4 = customization.contains("4_4");
        this.C4_5 = customization.contains("4_5");
        this.C4_6 = customization.contains("4_6");
        this.C4_7 = customization.contains("4_7");
        this.C4_8 = customization.contains("4_8");
        this.C4_9 = customization.contains("4_9");
        this.C5_0 = customization.contains("5_0");
        this.C5_1 = customization.contains("5_1");
        this.C5_10 = customization.contains("5_10");
        this.C5_2 = customization.contains("5_2");
        this.C5_3 = customization.contains("5_3");
        this.C5_4 = customization.contains("5_4");
        this.C5_5 = customization.contains("5_5");
        this.C5_6 = customization.contains("5_6");
        this.C5_7 = customization.contains("5_7");
        this.C5_8 = customization.contains("5_8");
        this.C5_9 = customization.contains("5_9");
    }

    private void populateFromNull(){

    }

    public Map<Customisation, Boolean> mapCustomizations() {
        return new HashMapConstructor<Customisation, Boolean>()
                .add(Customisation.C0_0, C0_0)
                .add(Customisation.C0_1, C0_1)
                .add(Customisation.C0_10, C0_10)
                .add(Customisation.C0_11, C0_11)
                .add(Customisation.C0_13, C0_13)
                .add(Customisation.C0_14, C0_14)
                .add(Customisation.C0_2, C0_2)
                .add(Customisation.C0_3, C0_3)
                .add(Customisation.C0_4, C0_4)
                .add(Customisation.C0_5, C0_5)
                .add(Customisation.C0_6, C0_6)
                .add(Customisation.C0_7, C0_7)
                .add(Customisation.C0_8, C0_8)
                .add(Customisation.C0_9, C0_9)
                .add(Customisation.C1_0, C1_0)
                .add(Customisation.C1_1, C1_1)
                .add(Customisation.C1_10, C1_10)
                .add(Customisation.C1_11, C1_11)
                .add(Customisation.C1_2, C1_2)
                .add(Customisation.C1_3, C1_3)
                .add(Customisation.C1_4, C1_4)
                .add(Customisation.C1_5, C1_5)
                .add(Customisation.C1_6, C1_6)
                .add(Customisation.C1_7, C1_7)
                .add(Customisation.C1_8, C1_8)
                .add(Customisation.C1_9, C1_9)
                .add(Customisation.C2_0, C2_0)
                .add(Customisation.C2_1, C2_1)
                .add(Customisation.C2_10, C2_10)
                .add(Customisation.C2_11, C2_11)
                .add(Customisation.C2_12, C2_12)
                .add(Customisation.C2_13, C2_13)
                .add(Customisation.C2_14, C2_14)
                .add(Customisation.C2_15, C2_15)
                .add(Customisation.C2_16, C2_16)
                .add(Customisation.C2_17, C2_17)
                .add(Customisation.C2_2, C2_2)
                .add(Customisation.C2_3, C2_3)
                .add(Customisation.C2_4, C2_4)
                .add(Customisation.C2_5, C2_5)
                .add(Customisation.C2_6, C2_6)
                .add(Customisation.C2_8, C2_8)
                .add(Customisation.C2_9, C2_9)
                .add(Customisation.C3_0, C3_0)
                .add(Customisation.C3_1, C3_1)
                .add(Customisation.C3_10, C3_10)
                .add(Customisation.C3_11, C3_11)
                .add(Customisation.C3_12, C3_12)
                .add(Customisation.C3_13, C3_13)
                .add(Customisation.C3_14, C3_14)
                .add(Customisation.C3_15, C3_15)
                .add(Customisation.C3_17, C3_17)
                .add(Customisation.C3_18, C3_18)
                .add(Customisation.C3_19, C3_19)
                .add(Customisation.C3_20, C3_20)
                .add(Customisation.C3_21, C3_21)
                .add(Customisation.C3_22, C3_22)
                .add(Customisation.C3_25, C3_25)
                .add(Customisation.C3_26, C3_26)
                .add(Customisation.C3_28, C3_28)
                .add(Customisation.C3_29, C3_29)
                .add(Customisation.C3_3, C3_3)
                .add(Customisation.C3_30, C3_30)
                .add(Customisation.C3_4, C3_4)
                .add(Customisation.C3_5, C3_5)
                .add(Customisation.C3_7, C3_7)
                .add(Customisation.C3_901, C3_901)
                .add(Customisation.C3_902, C3_902)
                .add(Customisation.C3_903, C3_903)
                .add(Customisation.C3_904, C3_904)
                .add(Customisation.C3_905, C3_905)
                .add(Customisation.C3_906, C3_906)
                .add(Customisation.C3_907, C3_907)
                .add(Customisation.C3_909, C3_909)
                .add(Customisation.C4_0, C4_0)
                .add(Customisation.C4_1, C4_1)
                .add(Customisation.C4_10, C4_10)
                .add(Customisation.C4_2, C4_2)
                .add(Customisation.C4_3, C4_3)
                .add(Customisation.C4_4, C4_4)
                .add(Customisation.C4_5, C4_5)
                .add(Customisation.C4_6, C4_6)
                .add(Customisation.C4_7, C4_7)
                .add(Customisation.C4_8, C4_8)
                .add(Customisation.C4_9, C4_9)
                .add(Customisation.C5_0, C5_0)
                .add(Customisation.C5_1, C5_1)
                .add(Customisation.C5_10, C5_10)
                .add(Customisation.C5_2, C5_2)
                .add(Customisation.C5_3, C5_3)
                .add(Customisation.C5_4, C5_4)
                .add(Customisation.C5_5, C5_5)
                .add(Customisation.C5_6, C5_6)
                .add(Customisation.C5_7, C5_7)
                .add(Customisation.C5_8, C5_8)
                .add(Customisation.C5_9, C5_9)
                .getMap();
    }
}
