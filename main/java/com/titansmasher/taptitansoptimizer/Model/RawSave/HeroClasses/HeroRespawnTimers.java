package com.titansmasher.taptitansoptimizer.Model.RawSave.HeroClasses;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Model.RawSave.Abstracts.HeroData;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Danny on 22/10/2016.
 */

public class HeroRespawnTimers extends HeroData<Date> {
    public HeroRespawnTimers(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }
        String format = "MM/dd/yyyy HH:mm:ss";

        this.h1 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H1_KEY));
        this.h2 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H2_KEY));
        this.h3 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H3_KEY));
        this.h4 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H4_KEY));
        this.h5 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H5_KEY));
        this.h6 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H6_KEY));
        this.h7 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H7_KEY));
        this.h8 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H8_KEY));
        this.h9 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H9_KEY));
        this.h10 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H10_KEY));
        this.h11 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H11_KEY));
        this.h12 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H12_KEY));
        this.h13 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H13_KEY));
        this.h14 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H14_KEY));
        this.h15 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H15_KEY));
        this.h16 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H16_KEY));
        this.h17 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H17_KEY));
        this.h18 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H18_KEY));
        this.h19 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H19_KEY));
        this.h20 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H20_KEY));
        this.h21 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H21_KEY));
        this.h22 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H22_KEY));
        this.h23 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H23_KEY));
        this.h24 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H24_KEY));
        this.h25 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H25_KEY));
        this.h26 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H26_KEY));
        this.h27 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H27_KEY));
        this.h28 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H28_KEY));
        this.h29 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H29_KEY));
        this.h30 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H30_KEY));
        this.h31 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H31_KEY));
        this.h32 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H32_KEY));
        this.h33 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, H33_KEY));
    }

    private void populateFromNull() {
        this.h1 = new Date();
        this.h2 = new Date();
        this.h3 = new Date();
        this.h4 = new Date();
        this.h5 = new Date();
        this.h6 = new Date();
        this.h7 = new Date();
        this.h8 = new Date();
        this.h9 = new Date();
        this.h10 = new Date();
        this.h11 = new Date();
        this.h12 = new Date();
        this.h13 = new Date();
        this.h14 = new Date();
        this.h15 = new Date();
        this.h16 = new Date();
        this.h17 = new Date();
        this.h18 = new Date();
        this.h19 = new Date();
        this.h20 = new Date();
        this.h21 = new Date();
        this.h22 = new Date();
        this.h23 = new Date();
        this.h24 = new Date();
        this.h25 = new Date();
        this.h26 = new Date();
        this.h27 = new Date();
        this.h28 = new Date();
        this.h29 = new Date();
        this.h30 = new Date();
        this.h31 = new Date();
        this.h32 = new Date();
        this.h33 = new Date();
    }

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        GenericHelpers.putStringSafe(obj, H1_KEY,  formatter.format(h1));
        GenericHelpers.putStringSafe(obj, H2_KEY,  formatter.format(h2));
        GenericHelpers.putStringSafe(obj, H3_KEY,  formatter.format(h3));
        GenericHelpers.putStringSafe(obj, H4_KEY,  formatter.format(h4));
        GenericHelpers.putStringSafe(obj, H5_KEY,  formatter.format(h5));
        GenericHelpers.putStringSafe(obj, H6_KEY,  formatter.format(h6));
        GenericHelpers.putStringSafe(obj, H7_KEY,  formatter.format(h7));
        GenericHelpers.putStringSafe(obj, H8_KEY,  formatter.format(h8));
        GenericHelpers.putStringSafe(obj, H9_KEY,  formatter.format(h9));
        GenericHelpers.putStringSafe(obj, H10_KEY, formatter.format(h10));
        GenericHelpers.putStringSafe(obj, H11_KEY, formatter.format(h11));
        GenericHelpers.putStringSafe(obj, H12_KEY, formatter.format(h12));
        GenericHelpers.putStringSafe(obj, H13_KEY, formatter.format(h13));
        GenericHelpers.putStringSafe(obj, H14_KEY, formatter.format(h14));
        GenericHelpers.putStringSafe(obj, H15_KEY, formatter.format(h15));
        GenericHelpers.putStringSafe(obj, H16_KEY, formatter.format(h16));
        GenericHelpers.putStringSafe(obj, H17_KEY, formatter.format(h17));
        GenericHelpers.putStringSafe(obj, H18_KEY, formatter.format(h18));
        GenericHelpers.putStringSafe(obj, H19_KEY, formatter.format(h19));
        GenericHelpers.putStringSafe(obj, H20_KEY, formatter.format(h20));
        GenericHelpers.putStringSafe(obj, H21_KEY, formatter.format(h21));
        GenericHelpers.putStringSafe(obj, H22_KEY, formatter.format(h22));
        GenericHelpers.putStringSafe(obj, H23_KEY, formatter.format(h23));
        GenericHelpers.putStringSafe(obj, H24_KEY, formatter.format(h24));
        GenericHelpers.putStringSafe(obj, H25_KEY, formatter.format(h25));
        GenericHelpers.putStringSafe(obj, H26_KEY, formatter.format(h26));
        GenericHelpers.putStringSafe(obj, H27_KEY, formatter.format(h27));
        GenericHelpers.putStringSafe(obj, H28_KEY, formatter.format(h28));
        GenericHelpers.putStringSafe(obj, H29_KEY, formatter.format(h29));
        GenericHelpers.putStringSafe(obj, H30_KEY, formatter.format(h30));
        GenericHelpers.putStringSafe(obj, H31_KEY, formatter.format(h31));
        GenericHelpers.putStringSafe(obj, H32_KEY, formatter.format(h32));


        return obj;
    }
}
