package com.phantomvk.tango.util;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.phantomvk.tango.R;
import com.phantomvk.tango.Tango;
import com.phantomvk.tango.listener.GlobalLayoutListener;
import com.phantomvk.tango.listener.KeyboardStateChangeListener;
import com.phantomvk.tango.listener.PanelListener;

public class KeyboardUtil {

    private static int sHeight;
    private static int minPanelHeight;
    private static int maxPanelHeight;
    private static int minKeyboardHeight;

    static {
        Resources r = Tango.getAppContext().getResources();
        minPanelHeight = r.getDimensionPixelSize(R.dimen.tango_height_panel_min);
        maxPanelHeight = r.getDimensionPixelSize(R.dimen.tango_height_panel_max);
        minKeyboardHeight = r.getDimensionPixelSize(R.dimen.tango_height_keyboard_min);
        sHeight = Tango.getStorage().get(minPanelHeight);
    }

    private static boolean saveHeight(int height) {
        if (sHeight == height || height < 0) return false;
        return Tango.getStorage().save(sHeight = height);
    }

    public static int getHeight() {
        return sHeight;
    }

    public static int getValidPanelHeight() {
        int height = Math.max(minPanelHeight, sHeight);
        return Math.min(maxPanelHeight, height);
    }

    public static OnGlobalLayoutListener attach(@NonNull Activity activity,
                                                @NonNull PanelListener target,
                                                @Nullable KeyboardStateChangeListener listener) {

        OnGlobalLayoutListener l = new GlobalLayoutListener(activity, target, listener);
        activity.findViewById(android.R.id.content)
                .getViewTreeObserver()
                .addOnGlobalLayoutListener(l);
        return l;
    }

    public static void detach(@NonNull Activity activity,
                              @Nullable OnGlobalLayoutListener listener) {

        ViewTreeObserver o = activity.findViewById(android.R.id.content).getViewTreeObserver();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            o.removeOnGlobalLayoutListener(listener);
        } else {
            o.removeGlobalOnLayoutListener(listener);
        }
    }
}
