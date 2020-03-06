package com.phantomvk.tango.util;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class SoftInputUtil {
    /**
     * Show soft input method.
     *
     * @param view current focus view
     */
    public static void show(@NonNull View view) {
        view.requestFocus();
        Object o = view.getContext().getSystemService(INPUT_METHOD_SERVICE);
        if (o != null) ((InputMethodManager) o).showSoftInput(view, 0);
    }

    /**
     * Hide soft input method.
     *
     * @param view current focus view
     */
    public static void hide(@NonNull View view) {
        Object o = view.getContext().getSystemService(INPUT_METHOD_SERVICE);
        if (o != null) ((InputMethodManager) o).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
