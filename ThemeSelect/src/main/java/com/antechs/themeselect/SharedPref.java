package com.antechs.themeselect;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPref {
    String App="com.antechs.themeselect";
    public  void setLanguage(String val,Context context){
        SharedPreferences preferences = context.getSharedPreferences(App, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Language",val);
        editor.apply();
    }

    public String getLanguage(Context context){
        SharedPreferences preferences = context.getSharedPreferences(App, Context.MODE_PRIVATE);
        String val = preferences.getString("Language", "");
        return val;
    }

    public void setTheme(String val,Context context){
        SharedPreferences preferences = context.getSharedPreferences(App, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Theme",val);
        editor.apply();
    }

    public String getTheme(Context context){
        SharedPreferences preferences = context.getSharedPreferences(App, Context.MODE_PRIVATE);
        String val = preferences.getString("Theme", "");
        return val;
    }
}
