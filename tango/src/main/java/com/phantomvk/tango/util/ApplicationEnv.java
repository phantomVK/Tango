package com.phantomvk.tango.util;

import android.app.Application;

import androidx.annotation.Nullable;

import java.lang.reflect.Method;

public class ApplicationEnv {

    /**
     * Get application instance using reflect.
     *
     * @return application instance
     */
    @Nullable
    public static Application getApplication() {
        try {
            Class<?> clazz = Class.forName("android.app.ActivityThread");
            Method method = clazz.getMethod("currentApplication");
            return (Application) method.invoke(null, (Object[]) null);
        } catch (Exception ignored) {
        }
        return null;
    }
}
