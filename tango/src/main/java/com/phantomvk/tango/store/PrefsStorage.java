package com.phantomvk.tango.store;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import static android.content.Context.MODE_PRIVATE;

/**
 * Shared Preferences as the default implementation.
 */
public class PrefsStorage extends Storage {

    private final SharedPreferences prefs;

    public PrefsStorage(@NonNull Context context) {
        final Context appContext = context.getApplicationContext();
        prefs = appContext.getSharedPreferences("com.phantomvk.tango.store", MODE_PRIVATE);
    }

    @Override
    public boolean save(int height) {
        if (height < 0 || height == sHeight) return false;

        sHeight = height;
        prefs.edit().putInt("height", height).apply();
        return true;
    }

    @Override
    public int get(int defValue) {
        return sHeight == Integer.MIN_VALUE ? (sHeight = prefs.getInt("height", defValue)) : sHeight;
    }

    @Override
    public boolean remove() {
        sHeight = Integer.MIN_VALUE;
        prefs.edit().remove("height").apply();
        return true;
    }
}
