package com.zsj.customview;

import android.content.Context;


/**
 * @created by PingYuan at 8/2/18
 * @email: husteryp@gmail.com
 * @description: Use this class to help get the information about the screen !
 */
public class ScreenUtils {

    private static Context sContext = MyApplication.instance;

    public static int getScreenWidth() {
         return sContext.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return sContext.getResources().getDisplayMetrics().heightPixels;
    }

    public static int dpTopx(int dp) {
        final float scale = sContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int pxTodp(int px) {
        final float scale = sContext.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

}
