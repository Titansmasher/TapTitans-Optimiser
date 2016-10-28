package com.titansmasher.taptitansoptimiser.Models.RawSave.HeroClasses;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimiser.Models.RawSave.Abstracts.HeroData;

import org.json.JSONObject;

/**
 * Created by Danny on 22/10/2016.
 */

public class HeroLevels extends HeroData<Integer> {

    public HeroLevels(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }
        this.h1 = GenericHelpers.getIntSafe(obj, "1");
        this.h2 = GenericHelpers.getIntSafe(obj, "2");
        this.h3 = GenericHelpers.getIntSafe(obj, "3");
        this.h4 = GenericHelpers.getIntSafe(obj, "4");
        this.h5 = GenericHelpers.getIntSafe(obj, "5");
        this.h6 = GenericHelpers.getIntSafe(obj, "6");
        this.h7 = GenericHelpers.getIntSafe(obj, "7");
        this.h8 = GenericHelpers.getIntSafe(obj, "8");
        this.h9 = GenericHelpers.getIntSafe(obj, "9");
        this.h10 = GenericHelpers.getIntSafe(obj, "10");
        this.h11 = GenericHelpers.getIntSafe(obj, "11");
        this.h12 = GenericHelpers.getIntSafe(obj, "12");
        this.h13 = GenericHelpers.getIntSafe(obj, "13");
        this.h14 = GenericHelpers.getIntSafe(obj, "14");
        this.h15 = GenericHelpers.getIntSafe(obj, "15");
        this.h16 = GenericHelpers.getIntSafe(obj, "16");
        this.h17 = GenericHelpers.getIntSafe(obj, "17");
        this.h18 = GenericHelpers.getIntSafe(obj, "18");
        this.h19 = GenericHelpers.getIntSafe(obj, "19");
        this.h20 = GenericHelpers.getIntSafe(obj, "20");
        this.h21 = GenericHelpers.getIntSafe(obj, "21");
        this.h22 = GenericHelpers.getIntSafe(obj, "22");
        this.h23 = GenericHelpers.getIntSafe(obj, "23");
        this.h24 = GenericHelpers.getIntSafe(obj, "24");
        this.h25 = GenericHelpers.getIntSafe(obj, "25");
        this.h26 = GenericHelpers.getIntSafe(obj, "26");
        this.h27 = GenericHelpers.getIntSafe(obj, "27");
        this.h28 = GenericHelpers.getIntSafe(obj, "28");
        this.h29 = GenericHelpers.getIntSafe(obj, "29");
        this.h30 = GenericHelpers.getIntSafe(obj, "30");
        this.h31 = GenericHelpers.getIntSafe(obj, "31");
        this.h32 = GenericHelpers.getIntSafe(obj, "32");
        this.h33 = GenericHelpers.getIntSafe(obj, "33");
    }

    private void populateFromNull() {
        this.h1 = 0;
        this.h2 = 0;
        this.h3 = 0;
        this.h4 = 0;
        this.h5 = 0;
        this.h6 = 0;
        this.h7 = 0;
        this.h8 = 0;
        this.h9 = 0;
        this.h10 = 0;
        this.h11 = 0;
        this.h12 = 0;
        this.h13 = 0;
        this.h14 = 0;
        this.h15 = 0;
        this.h16 = 0;
        this.h17 = 0;
        this.h18 = 0;
        this.h19 = 0;
        this.h20 = 0;
        this.h21 = 0;
        this.h22 = 0;
        this.h23 = 0;
        this.h24 = 0;
        this.h25 = 0;
        this.h26 = 0;
        this.h27 = 0;
        this.h28 = 0;
        this.h29 = 0;
        this.h30 = 0;
        this.h31 = 0;
        this.h32 = 0;
        this.h33 = 0;
    }
}
