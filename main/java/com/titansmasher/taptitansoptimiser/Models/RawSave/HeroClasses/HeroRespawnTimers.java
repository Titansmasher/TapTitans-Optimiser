package com.titansmasher.taptitansoptimiser.Models.RawSave.HeroClasses;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimiser.Models.RawSave.Abstracts.HeroData;

import org.json.JSONObject;

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

        this.h1 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "1"));
        this.h2 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "2"));
        this.h3 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "3"));
        this.h4 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "4"));
        this.h5 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "5"));
        this.h6 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "6"));
        this.h7 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "7"));
        this.h8 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "8"));
        this.h9 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "9"));
        this.h10 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "10"));
        this.h11 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "11"));
        this.h12 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "12"));
        this.h13 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "13"));
        this.h14 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "14"));
        this.h15 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "15"));
        this.h16 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "16"));
        this.h17 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "17"));
        this.h18 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "18"));
        this.h19 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "19"));
        this.h20 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "20"));
        this.h21 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "21"));
        this.h22 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "22"));
        this.h23 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "23"));
        this.h24 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "24"));
        this.h25 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "25"));
        this.h26 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "26"));
        this.h27 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "27"));
        this.h28 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "28"));
        this.h29 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "29"));
        this.h30 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "30"));
        this.h31 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "31"));
        this.h32 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "32"));
        this.h33 = GenericHelpers.parseDateSafe(format, GenericHelpers.getStringSafe(obj, "33"));
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
}
