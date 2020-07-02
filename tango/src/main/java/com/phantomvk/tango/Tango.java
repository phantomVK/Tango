package com.phantomvk.tango;

import android.content.Context;

import androidx.annotation.NonNull;

import com.phantomvk.tango.storage.PrefsStorage;
import com.phantomvk.tango.storage.Storage;

public final class Tango {

    private static boolean isInit = false;
    private static Storage sStorage;
    private static Context appContext; // Application Context only.

    /**
     * Init Tango with context.
     * <p>
     * Store input method's height with Shared Preferences.
     *
     * @param context Application context
     */
    public static void init(@NonNull Context context) {
        init(context, new PrefsStorage(context));
    }

    /**
     * Init Tango with context.
     * <p>
     * Store input method's height with Shared Preferences.
     *
     * @param context Application context
     * @param storage Storage
     */
    public static void init(@NonNull Context context, @NonNull Storage storage) {
        appContext = context.getApplicationContext();
        sStorage = storage;
        isInit = true;
    }

    @NonNull
    public static Storage getStorage() {
        if (!isInit) {
            throw new RuntimeException("Tango::Init->Invoke init() first.");
        } else {
            return sStorage;
        }
    }

    @NonNull
    public static Context getAppContext() {
        if (!isInit) {
            throw new RuntimeException("Tango::Init->Invoke init() first.");
        } else {
            return appContext;
        }
    }
}
