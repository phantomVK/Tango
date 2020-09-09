package com.phantomvk.tango.storage;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import static android.content.Context.MODE_PRIVATE;

/**
 * Shared Preferences as the default implementation.
 */
public class PrefsStorage extends Storage {

    private static final String PREFS_NAME = "com.phantomvk.tango.storage";
    private static final String PREFS_KEY = "height";

    private final SharedPreferences prefs;

    public PrefsStorage(@NonNull Context context) {
        Context appContext = context.getApplicationContext();
        prefs = appContext.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
    }

    @Override
    public boolean save(int height) {
        if (height < 0 || height == sHeight) return false;

        sHeight = height;
        prefs.edit().putInt(PREFS_KEY, height).apply();
        return true;
    }

    @Override
    public int get(int defValue) {
        if (sHeight == Integer.MIN_VALUE) {
            sHeight = prefs.getInt(PREFS_KEY, defValue);
        }

        return sHeight;
    }

    @Override
    public boolean remove() {
        sHeight = Integer.MIN_VALUE;
        prefs.edit().remove(PREFS_KEY).apply();
        return true;
    }
}
