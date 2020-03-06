package com.phantomvk.tango.store;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import static android.content.Context.MODE_PRIVATE;

/**
 * Shared Preferences as the default implementation.
 */
public class PrefsStorage extends Storage {

    private static final String HEIGHT = "HEIGHT";

    private final SharedPreferences prefs;

    /**
     * Constructor.
     *
     * @param context Context
     */
    public PrefsStorage(@NonNull Context context) {
        Context appContext = context.getApplicationContext();
        prefs = appContext.getSharedPreferences("com.phantomvk.tango.store", MODE_PRIVATE);
    }

    @Override
    public boolean save(int height) {
        if (height < 0 || height == sHeight) return false;

        sHeight = height;
        prefs.edit().putInt(HEIGHT, height).apply();
        return true;
    }

    @Override
    public int get(int defValue) {
        if (sHeight == -1) {
            sHeight = prefs.getInt(HEIGHT, defValue);
        }
        return sHeight;
    }

    @Override
    public boolean remove() {
        sHeight = -1;
        prefs.edit().remove(HEIGHT).apply();
        return true;
    }
}
