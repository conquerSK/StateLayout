package com.shenkai.statelayout;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by ShenKai on 2020/3/2 15:53
 * Desc:
 */
public class BaseApplication extends Application {
    private static BaseApplication application;
    private static int mainTid;
    private static Handler handler;

//  在主线程运行的
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mainTid = android.os.Process.myTid();
        handler = new Handler();
    }

    public static Context getApplication() {
        return application;
    }

    public static int getMainTid() {
        return mainTid;
    }

    public static Handler getHandler() {
        return handler;
    }
}
