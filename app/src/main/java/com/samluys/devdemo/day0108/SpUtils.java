package com.samluys.devdemo.day0108;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;

public enum  SpUtils {

    INSTANCE;

    /**
     * 保存Preference的name
     */
    private static final String PREFERENCE_NAME = "saveInfo";
    private static SharedPreferences sp;
    private static volatile SpUtils mSharedPreferencesUtil;
    private static SharedPreferences.Editor editor;

    private SpUtils() {
    }


    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key,int defValue) {
        return sp.getInt(key, defValue);
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLong(String key,long defValue) {
        return sp.getLong(key, defValue);
    }


    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key,boolean defValue) {
        return sp.getBoolean(key, defValue);
    }


    public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public float getFloat(String key, float defValue) {
        return sp.getFloat(key, defValue);
    }


    public void putStringSet(String key, HashSet<String> strings) {
        editor.putStringSet(key, strings);
        editor.commit();
    }

    public HashSet<String> getStringSet(String key, HashSet<String> defValues) {
        return (HashSet<String>) sp.getStringSet(key, defValues);
    }
}
