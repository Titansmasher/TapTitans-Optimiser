package com.titansmasher.taptitansoptimizer.Helpers;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.titansmasher.taptitansoptimizer.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Danny on 19/10/2016.
 */

public class GenericHelpers {

    public static JSONObject getJSONObjectSafe(JSONObject obj, String name) {
        try {
            return obj.getJSONObject(name);
        } catch (JSONException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public static String getStringSafe(JSONObject obj, String name) {
        try {
            return obj.getString(name);
        } catch (JSONException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public static int getIntSafe(JSONObject obj, String name) {
        try {
            return obj.getInt(name);
        } catch (JSONException ex) {
            return 0;
        } catch (NullPointerException ex) {
            return 0;
        }
    }

    public static double getDoubleSafe(JSONObject obj, String name) {
        try {
            return obj.getDouble(name);
        } catch (JSONException ex) {
            return 0;
        } catch (NullPointerException ex) {
            return 0;
        }
    }

    public static boolean getBooleanSafe(JSONObject obj, String name, boolean defaultVal) {
        try {
            return obj.getBoolean(name);
        } catch (JSONException ex) {
            return defaultVal;
        } catch (NullPointerException ex) {
            return defaultVal;
        }
    }

    public static void putJSONObjectSafe(JSONObject obj, String name, JSONObject value) {
        try{
            obj.put(name, value);
        } catch (JSONException ex){}
        catch (NullPointerException ex){}
    }

    public static void putStringSafe(JSONObject obj, String name, String value) {
        try{
            obj.put(name, value);
        } catch (JSONException ex){}
        catch (NullPointerException ex){}
    }

    public static void putIntSafe(JSONObject obj, String name, int value) {
        try{
            obj.put(name, value);
        } catch (JSONException ex){}
        catch (NullPointerException ex){}
    }

    public static void putDoubleSafe(JSONObject obj, String name, double value) {
        try{
            obj.put(name, value);
        } catch (JSONException ex){}
        catch (NullPointerException ex){}
    }

    public static void putBooleanSafe(JSONObject obj, String name, boolean value) {
        try{
            obj.put(name, value);
        } catch (JSONException ex){}
        catch (NullPointerException ex){}
    }

    public static Date parseDateSafe(String format, String value) {
        try {
            return new SimpleDateFormat(format).parse(value);
        } catch (ParseException ex) {
            return new Date();
        } catch (NullPointerException ex){
            return new Date();
        }
    }

    public static JSONObject constructJSONObjectSafe(String jsonText) {
        try {
            return new JSONObject(jsonText);
        } catch (JSONException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public static boolean areAllTheSame(int[] array) {
        for (int item :
                array) {
            if (item != array[0]) {
                return false;
            }
        }
        return true;
    }

    public static Drawable drawableFromAttr(int attrId, Resources.Theme theme, Resources resources) {
        TypedArray a = theme.obtainStyledAttributes(R.style.AppTheme, new int[]{attrId});
        int attributeResourceId = a.getResourceId(0, 0);
        return resources.getDrawable(attributeResourceId);
    }

    public static String secondsToTime(int seconds) {
        int hours = (int) Math.floor(seconds / 3600);
        int minutes = (int) Math.floor((seconds % 3600) / 60);
        int absseconds = seconds % 60;
        return hours + ":" + padString(Integer.toString(minutes), '0', 2) + ":" + padString(Integer.toString(absseconds), '0', 2);
    }

    public static String padString(String text, char padder, int length) {
        for (int i = text.length(); i < length; i++) {
            text = padder + text;
        }

        return text;
    }

    public static String boolToYesNoString(boolean bool) {
        return bool ? "Yes" : "No";
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String beautify(double value) {
        int magnitude = (int) Math.floor(Math.log10(value));
        String[] suffixes = new String[]{"", "K", "M", "B", "T", "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz"};
        String returnString;
        DecimalFormat format = new DecimalFormat("#.###");
        int index = (int) Math.floor(magnitude / 3);
        if (suffixes.length > index && index >= 1) {
            returnString = format.format(value / Math.pow(10, index * 3));
            returnString = returnString + suffixes[index];
        } else if (index >= 1) {
            returnString = Double.toString(value);
            returnString = format.format(Double.parseDouble(returnString.substring(0, returnString.indexOf('E')))) + returnString.substring(returnString.indexOf('E'));
        } else {
            return "0";
        }

        return returnString;
    }

    public static int min(Collection<Integer> col){
        int min = (int)col.toArray()[0];
        for (int i:
                col){
            if (i < min)
                min = i;
        }
        return min;
    }

    public static int sum(Collection<Integer> vals){
        int returnval = 0;
        for (Integer val
                : vals){
            returnval += val;
        }

        return returnval;
    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth() + 6, view.getHeight() + 6,Bitmap.Config.ARGB_8888);
        returnedBitmap.eraseColor(Color.BLACK);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.translate(3, 3);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable!=null)
            bgDrawable.draw(canvas);
        view.draw(canvas);

        return returnedBitmap;
    }

    public static Bitmap getBitmapFromView(View view, float scaleFactor) {
        Bitmap bitmap = getBitmapFromView(view);
        return Bitmap.createScaledBitmap(bitmap, (int)(bitmap.getWidth() * scaleFactor), (int)(bitmap.getHeight() * scaleFactor), true);
    }

    public static Bitmap getBitmapFromView(View view, int width, int height) {
        Bitmap bitmap = getBitmapFromView(view);
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    public static int parseIntDefault(String text, int defaultVal){
        try{
            return Integer.parseInt(text);
        } catch (Exception ex){
            return defaultVal;
        }
    }
}
