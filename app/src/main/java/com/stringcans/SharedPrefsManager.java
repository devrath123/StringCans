package com.stringcans;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefsManager {


    static SharedPreferences getSP(Context context) {
        return context.getSharedPreferences(Constants.SHARED_PREFS_NAME, MODE_PRIVATE);
    }

    public static String getToken(Context context) {
        SharedPreferences sp = getSP(context);
        return sp.getString(Constants.TOKEN, "");
    }

    public static void saveString(Context context, String key, String value) {
        SharedPreferences sp = getSP(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key) {
        SharedPreferences sp = getSP(context);
        return sp.getString(key, "");
    }
}
