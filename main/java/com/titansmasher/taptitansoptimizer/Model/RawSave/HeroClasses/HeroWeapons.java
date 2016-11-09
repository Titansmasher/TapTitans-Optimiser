package com.titansmasher.taptitansoptimizer.Model.RawSave.HeroClasses;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Model.RawSave.Abstracts.HeroData;

import org.json.JSONObject;

/**
 * Created by Danny on 22/10/2016.
 */

public class HeroWeapons extends HeroData<Integer> {
    public HeroWeapons(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }
        this.h1 = GenericHelpers.getIntSafe(obj, H1_KEY);
        this.h2 = GenericHelpers.getIntSafe(obj, H2_KEY);
        this.h3 = GenericHelpers.getIntSafe(obj, H3_KEY);
        this.h4 = GenericHelpers.getIntSafe(obj, H4_KEY);
        this.h5 = GenericHelpers.getIntSafe(obj, H5_KEY);
        this.h6 = GenericHelpers.getIntSafe(obj, H6_KEY);
        this.h7 = GenericHelpers.getIntSafe(obj, H7_KEY);
        this.h8 = GenericHelpers.getIntSafe(obj, H8_KEY);
        this.h9 = GenericHelpers.getIntSafe(obj, H9_KEY);
        this.h10 = GenericHelpers.getIntSafe(obj, H10_KEY);
        this.h11 = GenericHelpers.getIntSafe(obj, H11_KEY);
        this.h12 = GenericHelpers.getIntSafe(obj, H12_KEY);
        this.h13 = GenericHelpers.getIntSafe(obj, H13_KEY);
        this.h14 = GenericHelpers.getIntSafe(obj, H14_KEY);
        this.h15 = GenericHelpers.getIntSafe(obj, H15_KEY);
        this.h16 = GenericHelpers.getIntSafe(obj, H16_KEY);
        this.h17 = GenericHelpers.getIntSafe(obj, H17_KEY);
        this.h18 = GenericHelpers.getIntSafe(obj, H18_KEY);
        this.h19 = GenericHelpers.getIntSafe(obj, H19_KEY);
        this.h20 = GenericHelpers.getIntSafe(obj, H20_KEY);
        this.h21 = GenericHelpers.getIntSafe(obj, H21_KEY);
        this.h22 = GenericHelpers.getIntSafe(obj, H22_KEY);
        this.h23 = GenericHelpers.getIntSafe(obj, H23_KEY);
        this.h24 = GenericHelpers.getIntSafe(obj, H24_KEY);
        this.h25 = GenericHelpers.getIntSafe(obj, H25_KEY);
        this.h26 = GenericHelpers.getIntSafe(obj, H26_KEY);
        this.h27 = GenericHelpers.getIntSafe(obj, H27_KEY);
        this.h28 = GenericHelpers.getIntSafe(obj, H28_KEY);
        this.h29 = GenericHelpers.getIntSafe(obj, H29_KEY);
        this.h30 = GenericHelpers.getIntSafe(obj, H30_KEY);
        this.h31 = GenericHelpers.getIntSafe(obj, H31_KEY);
        this.h32 = GenericHelpers.getIntSafe(obj, H32_KEY);
        this.h33 = GenericHelpers.getIntSafe(obj, H33_KEY);
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

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putIntSafe(obj, H1_KEY, h1);
        GenericHelpers.putIntSafe(obj, H2_KEY, h2);
        GenericHelpers.putIntSafe(obj, H3_KEY, h3);
        GenericHelpers.putIntSafe(obj, H4_KEY, h4);
        GenericHelpers.putIntSafe(obj, H5_KEY, h5);
        GenericHelpers.putIntSafe(obj, H6_KEY, h6);
        GenericHelpers.putIntSafe(obj, H7_KEY, h7);
        GenericHelpers.putIntSafe(obj, H8_KEY, h8);
        GenericHelpers.putIntSafe(obj, H9_KEY, h9);
        GenericHelpers.putIntSafe(obj, H10_KEY, h10);
        GenericHelpers.putIntSafe(obj, H11_KEY, h11);
        GenericHelpers.putIntSafe(obj, H12_KEY, h12);
        GenericHelpers.putIntSafe(obj, H13_KEY, h13);
        GenericHelpers.putIntSafe(obj, H14_KEY, h14);
        GenericHelpers.putIntSafe(obj, H15_KEY, h15);
        GenericHelpers.putIntSafe(obj, H16_KEY, h16);
        GenericHelpers.putIntSafe(obj, H17_KEY, h17);
        GenericHelpers.putIntSafe(obj, H18_KEY, h18);
        GenericHelpers.putIntSafe(obj, H19_KEY, h19);
        GenericHelpers.putIntSafe(obj, H20_KEY, h20);
        GenericHelpers.putIntSafe(obj, H21_KEY, h21);
        GenericHelpers.putIntSafe(obj, H22_KEY, h22);
        GenericHelpers.putIntSafe(obj, H23_KEY, h23);
        GenericHelpers.putIntSafe(obj, H24_KEY, h24);
        GenericHelpers.putIntSafe(obj, H25_KEY, h25);
        GenericHelpers.putIntSafe(obj, H26_KEY, h26);
        GenericHelpers.putIntSafe(obj, H27_KEY, h27);
        GenericHelpers.putIntSafe(obj, H28_KEY, h28);
        GenericHelpers.putIntSafe(obj, H29_KEY, h29);
        GenericHelpers.putIntSafe(obj, H30_KEY, h30);
        GenericHelpers.putIntSafe(obj, H31_KEY, h31);
        GenericHelpers.putIntSafe(obj, H32_KEY, h32);


        return obj;
    }
}
