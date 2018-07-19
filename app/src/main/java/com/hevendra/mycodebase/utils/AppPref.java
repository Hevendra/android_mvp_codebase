package com.hevendra.mycodebase.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Hevendra.Jadaun on 3/24/2018.
 */

public class AppPref {


    private static final String APP_PREF_NAME="MyCodeBaseAppPref";

    public static final String PREF_LOGIN="pref_login";
    public static final String PREF_LOGGED_IN_USER="pref_logged_in_user";
    public static final String PREF_IS_LOGGED_IN="pref_is_logged_in";

    //-----------Singleton Pattern with Lazy loading to create thread safe environment---
    private AppPref() {

    }

    private static class LazyHolder {
        static final AppPref INSTANCE = new AppPref();
    }

    public static AppPref getInstance() {
        return LazyHolder.INSTANCE;
    }
    //--------------------------END----------------------------------

    public void saveString(Context context,String key,String value)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences(APP_PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void saveBoolean(Context context,String key,boolean value)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences(APP_PREF_NAME, MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public void saveInt(Context context,String key,int value)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences(APP_PREF_NAME, MODE_PRIVATE).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public String getString(Context context,String key)
    {
        SharedPreferences prefs = context.getSharedPreferences(APP_PREF_NAME, MODE_PRIVATE);
        String storedText = prefs.getString(key, "");
        return storedText;
    }

    public boolean getBoolean(Context context,String key)
    {
        SharedPreferences prefs = context.getSharedPreferences(APP_PREF_NAME, MODE_PRIVATE);
        boolean storedVal = prefs.getBoolean(key, false);
        return storedVal;
    }

    public int getInt(Context context,String key)
    {
        SharedPreferences prefs = context.getSharedPreferences(APP_PREF_NAME, MODE_PRIVATE);
        int storedVal = prefs.getInt(key, 0);
        return storedVal;
    }






}
