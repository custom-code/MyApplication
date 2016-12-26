package com.zhe.myapplication;

import android.app.Application;

/**
 * Created by zhe on 2016/12/23.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
