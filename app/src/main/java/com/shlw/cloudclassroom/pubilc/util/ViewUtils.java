package com.shlw.cloudclassroom.pubilc.util;

import android.view.View;

/**
 * Created by john on 2017/4/26.
 */

public class ViewUtils {
    /**
     * 隐藏view
     *
     * @param view
     */
    public static void hideView(View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 显示view
     *
     * @param view
     */
    public static void showView(View view) {
        if (view.getVisibility() == View.INVISIBLE || view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 判断view是否为显示状态
     *
     * @param view
     * @return true为显示状态   false为隐藏状态
     */
    public static boolean isShowView(View view) {
        return view.getVisibility() == View.VISIBLE ? true : false;
    }

    /**
     * 消失view
     *
     * @param views
     */
    public static void goneView(View... views) {
        for(View view : views){
            if (view.getVisibility() == View.VISIBLE) {
                view.setVisibility(View.GONE);
            }
        }
    }

}
