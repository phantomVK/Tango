package com.phantomvk.tango;

import android.content.Context;

import androidx.annotation.NonNull;

import com.phantomvk.tango.store.PrefsStorage;
import com.phantomvk.tango.store.Storage;

public final class Tango {

    private static boolean isInit = false;
    private static Storage sStorage;

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
}
