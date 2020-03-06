/*
 * Copyright (C) 2019 Wenkang Tan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.phantomvk.tango.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.KITKAT;
import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;
import static android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;

public final class SysUtil {

    public static boolean isFullScreen(@NonNull Activity activity) {
        int flags = activity.getWindow().getAttributes().flags;
        return (flags & FLAG_FULLSCREEN) != 0;
    }

    public static boolean isFitsSystemWindows(@NonNull Activity activity) {
        ViewGroup group = activity.findViewById(android.R.id.content);
        return group.getChildAt(0).getFitsSystemWindows();
    }

    public static boolean isTranslucentStatus(@NonNull Activity activity) {
        if (SDK_INT >= KITKAT) {
            int flags = activity.getWindow().getAttributes().flags;
            return (flags & FLAG_TRANSLUCENT_STATUS) != 0;
        } else {
            return false;
        }
    }

    public static int dp(Context context, int value) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) applyDimension(COMPLEX_UNIT_DIP, value, metrics);
    }
}
