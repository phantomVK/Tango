package com.phantomvk.tango.listener;

import android.app.Activity;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.phantomvk.tango.util.SysUtil;

public class GlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

    private final ViewGroup contentView;
    private final boolean isFullScreen;
    private final boolean isTranslucentStatus;
    private final boolean isFitSystemWindows;
    private final int screenHeight;

    private final PanelListener target;
    private final KeyboardStateChangeListener listener;

    public GlobalLayoutListener(@NonNull Activity activity,
                                @NonNull PanelListener target,
                                @Nullable KeyboardStateChangeListener listener) {

        this.target = target;
        this.listener = listener;

        contentView = activity.findViewById(android.R.id.content);
        isFullScreen = SysUtil.isFullScreen(activity);
        isTranslucentStatus = SysUtil.isTranslucentStatus(activity);
        isFitSystemWindows = SysUtil.isFitsSystemWindows(activity);

        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        screenHeight = point.y;
    }

    @Override
    public void onGlobalLayout() {
    }
}
