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

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

/**
 * Get Status Bar's height.
 * <p>
 * For more details, see: https://stackoverflow.com/a/3410200/8750399
 */
public class StatusBarUtil {

    private static boolean sInit = false;
    private static int sHeight = 50; // StatusBarHeight

    /**
     * Called on UiThread to get the height of the status bar.
     *
     * @param context context to get resource
     * @return the height of the status bar
     */
    @UiThread
    public static int getHeight(@NonNull Context context) {
        if (!sInit) {
            Resources r = context.getResources();
            int id = r.getIdentifier("status_bar_height", "dimen", "android");
            if (id > 0) {
                sHeight = r.getDimensionPixelSize(id);
                sInit = true;
            }
        }

        return sHeight;
    }
}
