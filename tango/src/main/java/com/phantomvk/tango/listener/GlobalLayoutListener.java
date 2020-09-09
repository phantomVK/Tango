package com.phantomvk.tango.listener;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public class GlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

    private final ViewGroup contentView;

    public GlobalLayoutListener(Activity activity) {
        contentView = activity.findViewById(android.R.id.content);
    }

    @Override
    public void onGlobalLayout() {
    }
}
