package com.example.myotive.codemash_common.utility;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by michaelyotive_hr on 12/26/16.
 */

public class ConversionUtility {
    public static int dpToPx(int dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int)((dp * displayMetrics.density) + 0.5);
    }

    public int pxToDp(int px, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((px/displayMetrics.density) + 0.5);
    }
}
