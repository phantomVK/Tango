package com.phantomvk.tango;

import android.content.Context;

import com.phantomvk.tango.storage.PrefsStorage;
import com.phantomvk.tango.storage.Storage;

public final class Tango {

    private volatile static boolean isInit = false;
    private static Storage sStorage;
    private static Context appContext; // Application Context only.

    /**
     * Init Tango with context.
     * <p>
     * Store input method's height with Shared Preferences.
     *
     * @param context Application context
     */
    public static void init(Context context) {
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
    public static void init(Context context, Storage storage) {
        if (isInit) return;
        if (context == null) throw new NullPointerException("Context should not be null.");
        if (storage == null) throw new NullPointerException("Storage should not be null.");

        synchronized (Tango.class) {
            if (isInit) return;

            appContext = context.getApplicationContext();
            sStorage = storage;
            isInit = true;
        }
    }

    public static Storage getStorage() {
        if (!isInit) {
            throw new RuntimeException("Tango::Init->Invoke init() first.");
        } else {
            return sStorage;
        }
    }

    public static Context getAppContext() {
        if (!isInit) {
            throw new RuntimeException("Tango::Init->Invoke init() first.");
        } else {
            return appContext;
        }
    }
}
