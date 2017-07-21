package com.shlw.cloudclassroom;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.gyf.barlibrary.ImmersionBar;
import com.orm.SugarApp;
import com.shlw.cloudclassroom.launcher.NoStatusBar;
import com.zxy.recovery.core.Recovery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by john on 2017/4/21.
 */

public class Application extends SugarApp implements android.app.Application.ActivityLifecycleCallbacks {
    public static List<?> images=new ArrayList<>();
    public static int H;

    @Override
    public void onCreate() {
        super.onCreate();
        H=getScreenH(this);
        Fresco.initialize(this);
        Recovery.getInstance()
                .debug(true)
                .recoverInBackground(false)
                .recoverStack(true)
                .mainPage(MainMainActivity.class)
                .init(this);
        String[] urls = getResources().getStringArray(R.array.url4);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public int getScreenH(Context aty) {
        DisplayMetrics dm = aty.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        if(!(activity instanceof NoStatusBar)){
            ImmersionBar.with(activity).barColor(android.R.color.holo_blue_light).init();
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        ImmersionBar.with(activity).destroy();
    }
}
