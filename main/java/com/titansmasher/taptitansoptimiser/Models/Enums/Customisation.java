package com.titansmasher.taptitansoptimiser.Models.Enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danny on 25/10/2016.
 */

public enum Customisation {
    C0_0   (Effect.GOLD_CUSTOMIZATIONS,  0, CostType.CTYPE_N,    0),
    C0_1   (Effect.GOLD_CUSTOMIZATIONS,  5, CostType.CTYPE_S, 1000),
    C0_10  (Effect.GOLD_CUSTOMIZATIONS,  6, CostType.CTYPE_D,  310),
    C0_11  (Effect.GOLD_CUSTOMIZATIONS,  5, CostType.CTYPE_D,  250),
    C0_13  (Effect.GOLD_CUSTOMIZATIONS,  7, CostType.CTYPE_D,  770),
    C0_14  (Effect.GOLD_CUSTOMIZATIONS,  5, CostType.CTYPE_S,   50),
    C0_2   (Effect.GOLD_CUSTOMIZATIONS,  5, CostType.CTYPE_S,  300),
    C0_3   (Effect.GOLD_CUSTOMIZATIONS,  5, CostType.CTYPE_S,  400),
    C0_4   (Effect.GOLD_CUSTOMIZATIONS,  5, CostType.CTYPE_S, 1500),
    C0_5   (Effect.GOLD_CUSTOMIZATIONS,  5, CostType.CTYPE_S, 1600),
    C0_6   (Effect.GOLD_CUSTOMIZATIONS,  5, CostType.CTYPE_S,  700),
    C0_7   (Effect.GOLD_CUSTOMIZATIONS, 10, CostType.CTYPE_D,  550),
    C0_8   (Effect.GOLD_CUSTOMIZATIONS, 10, CostType.CTYPE_D,  500),
    C0_9   (Effect.GOLD_CUSTOMIZATIONS, 13, CostType.CTYPE_D,  650),
    C1_0   (Effect.CRIT_DAMAGE_CUSTOMIZATIONS,  0, CostType.CTYPE_N,    0),
    C1_1   (Effect.CRIT_DAMAGE_CUSTOMIZATIONS,  5, CostType.CTYPE_P,    5),
    C1_10  (Effect.CRIT_DAMAGE_CUSTOMIZATIONS,  6, CostType.CTYPE_D,  110),
    C1_11  (Effect.CRIT_DAMAGE_CUSTOMIZATIONS, 10, CostType.CTYPE_P,   50),
    C1_2   (Effect.CRIT_DAMAGE_CUSTOMIZATIONS, 10, CostType.CTYPE_P,   20),
    C1_3   (Effect.CRIT_DAMAGE_CUSTOMIZATIONS,  7, CostType.CTYPE_P,   10),
    C1_4   (Effect.CRIT_DAMAGE_CUSTOMIZATIONS,  4, CostType.CTYPE_D,   85),
    C1_5   (Effect.CRIT_DAMAGE_CUSTOMIZATIONS,  4, CostType.CTYPE_D,   75),
    C1_6   (Effect.CRIT_DAMAGE_CUSTOMIZATIONS, 19, CostType.CTYPE_D,  380),
    C1_7   (Effect.CRIT_DAMAGE_CUSTOMIZATIONS, 22, CostType.CTYPE_D,  435),
    C1_8   (Effect.CRIT_DAMAGE_CUSTOMIZATIONS,  1, CostType.CTYPE_D,   30),
    C1_9   (Effect.CRIT_DAMAGE_CUSTOMIZATIONS,  3, CostType.CTYPE_P,    2),
    C2_0   (Effect.CRIT_CHANCE,  0, CostType.CTYPE_N,    0),
    C2_1   (Effect.CRIT_CHANCE,0.5, CostType.CTYPE_T,  150),
    C2_10  (Effect.CRIT_CHANCE,0.5, CostType.CTYPE_T, 1300),
    C2_11  (Effect.CRIT_CHANCE,  3, CostType.CTYPE_D, 1000),
    C2_12  (Effect.CRIT_CHANCE,0.5, CostType.CTYPE_D,  250),
    C2_13  (Effect.CRIT_CHANCE,  1, CostType.CTYPE_D,  400),
    C2_14  (Effect.CRIT_CHANCE,0.5, CostType.CTYPE_T, 1000),
    C2_15  (Effect.CRIT_CHANCE,  1, CostType.CTYPE_D,  350),
    C2_16  (Effect.CRIT_CHANCE,  1, CostType.CTYPE_D,  310),
    C2_17  (Effect.CRIT_CHANCE,  1, CostType.CTYPE_D,  430),
    C2_2   (Effect.CRIT_CHANCE,0.5, CostType.CTYPE_T,  200),
    C2_3   (Effect.CRIT_CHANCE,0.5, CostType.CTYPE_T,   10),
    C2_4   (Effect.CRIT_CHANCE,0.5, CostType.CTYPE_T,  500),
    C2_5   (Effect.CRIT_CHANCE,  2, CostType.CTYPE_D,  800),
    C2_6   (Effect.CRIT_CHANCE,0.5, CostType.CTYPE_T,  700),
    C2_8   (Effect.CRIT_CHANCE,0.5, CostType.CTYPE_D,   50),
    C2_9   (Effect.CRIT_CHANCE,  1, CostType.CTYPE_D,  450),
    C3_0   (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  0, CostType.CTYPE_N,    0),
    C3_1   (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  1, CostType.CTYPE_D,  110),
    C3_10  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  2, CostType.CTYPE_D,  100),
    C3_11  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  6, CostType.CTYPE_D,  666),
    C3_12  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  7, CostType.CTYPE_P,  500),
    C3_13  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  9, CostType.CTYPE_D,  880),
    C3_14  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  5, CostType.CTYPE_D,  500),
    C3_15  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  1, CostType.CTYPE_D,   80),
    C3_17  (Effect.ALL_DAMAGE_CUSTOMIZATIONS, 12, CostType.CTYPE_D, 1500),
    C3_18  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  9, CostType.CTYPE_D, 1000),
    C3_19  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  5, CostType.CTYPE_P,   50),
    C3_20  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  2, CostType.CTYPE_D,  200),
    C3_21  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  3, CostType.CTYPE_D,  350),
    C3_22  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  7, CostType.CTYPE_P,  400),
    C3_25  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  2, CostType.CTYPE_D,  150),
    C3_26  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  3, CostType.CTYPE_D,  270),
    C3_28  (Effect.ALL_DAMAGE_CUSTOMIZATIONS, 12, CostType.CTYPE_D, 1500),
    C3_29  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  7, CostType.CTYPE_P,  200),
    C3_3   (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  6, CostType.CTYPE_P,   70),
    C3_30  (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  6, CostType.CTYPE_D,  620),
    C3_4   (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  6, CostType.CTYPE_P,  100),
    C3_5   (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  5, CostType.CTYPE_D,  500),
    C3_7   (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  8, CostType.CTYPE_D,  860),
    C3_901 (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  2, CostType.CTYPE_P,    1),
    C3_902 (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  2, CostType.CTYPE_P,    3),
    C3_903 (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  3, CostType.CTYPE_P,    7),
    C3_904 (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  3, CostType.CTYPE_P,   15),
    C3_905 (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  4, CostType.CTYPE_P,   25),
    C3_906 (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  4, CostType.CTYPE_P,   30),
    C3_907 (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  5, CostType.CTYPE_P,   40),
    C3_909 (Effect.ALL_DAMAGE_CUSTOMIZATIONS,  7, CostType.CTYPE_P,  300),
    C4_0   (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  0, CostType.CTYPE_N,    0),
    C4_1   (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  4, CostType.CTYPE_T,   50),
    C4_10  (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  6, CostType.CTYPE_D,  490),
    C4_2   (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  4, CostType.CTYPE_T,  100),
    C4_3   (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  4, CostType.CTYPE_T,  300),
    C4_4   (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  4, CostType.CTYPE_T,  400),
    C4_5   (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  4, CostType.CTYPE_D,  410),
    C4_6   (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  6, CostType.CTYPE_D,  700),
    C4_7   (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  2, CostType.CTYPE_D,  140),
    C4_8   (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  8, CostType.CTYPE_D,  620),
    C4_9   (Effect.TAP_DAMAGE_CUSTOMIZATIONS,  2, CostType.CTYPE_D,  290),
    C5_0   (Effect.CHEST_CUSTOMIZATIONS,  0, CostType.CTYPE_N,    0),
    C5_1   (Effect.CHEST_CUSTOMIZATIONS,  5, CostType.CTYPE_S,  100),
    C5_10  (Effect.CHEST_CUSTOMIZATIONS, 20, CostType.CTYPE_D,  380),
    C5_2   (Effect.CHEST_CUSTOMIZATIONS,  7, CostType.CTYPE_S,  200),
    C5_3   (Effect.CHEST_CUSTOMIZATIONS, 10, CostType.CTYPE_S,  500),
    C5_4   (Effect.CHEST_CUSTOMIZATIONS, 10, CostType.CTYPE_S, 1300),
    C5_5   (Effect.CHEST_CUSTOMIZATIONS, 10, CostType.CTYPE_S,  600),
    C5_6   (Effect.CHEST_CUSTOMIZATIONS, 50, CostType.CTYPE_D,  990),
    C5_7   (Effect.CHEST_CUSTOMIZATIONS, 15, CostType.CTYPE_D,  340),
    C5_8   (Effect.CHEST_CUSTOMIZATIONS, 10, CostType.CTYPE_S, 2000),
    C5_9   (Effect.CHEST_CUSTOMIZATIONS, 40, CostType.CTYPE_D,  620);

    public Effect effect;
    public double amount;
    public CostType costType;
    public double cost;

    Customisation(Effect effect, double amount, CostType costType, double cost){
        this.effect = effect;
        this.amount = amount;
        this.costType = costType;
        this.cost = cost;
    }

    public List<Customisation> getCustomisations (List<String> customisations){
        List<Customisation> outList = new ArrayList<>();
        for (String cust :
                customisations) {
            outList.add(getCustomisation(cust));
        }
        return outList;
    }

    public Customisation getCustomisation(String customisation){
        switch (customisation){
            case "C0_0":
                return C0_0;
            case "C0_1":
                return C0_1;
            case "C0_10":
                return C0_10;
            case "C0_11":
                return C0_11;
            case "C0_13":
                return C0_13;
            case "C0_14":
                return C0_14;
            case "C0_2":
                return C0_2;
            case "C0_3":
                return C0_3;
            case "C0_4":
                return C0_4;
            case "C0_5":
                return C0_5;
            case "C0_6":
                return C0_6;
            case "C0_7":
                return C0_7;
            case "C0_8":
                return C0_8;
            case "C0_9":
                return C0_9;
            case "C1_0":
                return C1_0;
            case "C1_1":
                return C1_1;
            case "C1_10":
                return C1_10;
            case "C1_11":
                return C1_11;
            case "C1_2":
                return C1_2;
            case "C1_3":
                return C1_3;
            case "C1_4":
                return C1_4;
            case "C1_5":
                return C1_5;
            case "C1_6":
                return C1_6;
            case "C1_7":
                return C1_7;
            case "C1_8":
                return C1_8;
            case "C1_9":
                return C1_9;
            case "C2_0":
                return C2_0;
            case "C2_1":
                return C2_1;
            case "C2_10":
                return C2_10;
            case "C2_11":
                return C2_11;
            case "C2_12":
                return C2_12;
            case "C2_13":
                return C2_13;
            case "C2_14":
                return C2_14;
            case "C2_15":
                return C2_15;
            case "C2_16":
                return C2_16;
            case "C2_17":
                return C2_17;
            case "C2_2":
                return C2_2;
            case "C2_3":
                return C2_3;
            case "C2_4":
                return C2_4;
            case "C2_5":
                return C2_5;
            case "C2_6":
                return C2_6;
            case "C2_8":
                return C2_8;
            case "C2_9":
                return C2_9;
            case "C3_0":
                return C3_0;
            case "C3_1":
                return C3_1;
            case "C3_10":
                return C3_10;
            case "C3_11":
                return C3_11;
            case "C3_12":
                return C3_12;
            case "C3_13":
                return C3_13;
            case "C3_14":
                return C3_14;
            case "C3_15":
                return C3_15;
            case "C3_17":
                return C3_17;
            case "C3_18":
                return C3_18;
            case "C3_19":
                return C3_19;
            case "C3_20":
                return C3_20;
            case "C3_21":
                return C3_21;
            case "C3_22":
                return C3_22;
            case "C3_25":
                return C3_25;
            case "C3_26":
                return C3_26;
            case "C3_28":
                return C3_28;
            case "C3_29":
                return C3_29;
            case "C3_3":
                return C3_3;
            case "C3_30":
                return C3_30;
            case "C3_4":
                return C3_4;
            case "C3_5":
                return C3_5;
            case "C3_7":
                return C3_7;
            case "C3_901":
                return C3_901;
            case "C3_902":
                return C3_902;
            case "C3_903":
                return C3_903;
            case "C3_904":
                return C3_904;
            case "C3_905":
                return C3_905;
            case "C3_906":
                return C3_906;
            case "C3_907":
                return C3_907;
            case "C3_909":
                return C3_909;
            case "C4_0":
                return C4_0;
            case "C4_1":
                return C4_1;
            case "C4_10":
                return C4_10;
            case "C4_2":
                return C4_2;
            case "C4_3":
                return C4_3;
            case "C4_4":
                return C4_4;
            case "C4_5":
                return C4_5;
            case "C4_6":
                return C4_6;
            case "C4_7":
                return C4_7;
            case "C4_8":
                return C4_8;
            case "C4_9":
                return C4_9;
            case "C5_0":
                return C5_0;
            case "C5_1":
                return C5_1;
            case "C5_10":
                return C5_10;
            case "C5_2":
                return C5_2;
            case "C5_3":
                return C5_3;
            case "C5_4":
                return C5_4;
            case "C5_5":
                return C5_5;
            case "C5_6":
                return C5_6;
            case "C5_7":
                return C5_7;
            case "C5_8":
                return C5_8;
            case "C5_9":
                return C5_9;
        }
        return null;
    }
}
