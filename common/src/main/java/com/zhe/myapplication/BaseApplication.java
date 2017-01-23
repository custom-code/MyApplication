package com.zhe.myapplication;

import android.app.Application;

/**
 * Created by zhe on 2016/12/23.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;
    private int count = 0;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public int getCount() {
        return count++;
    }

    public String getToken() {
        return "1F5109DE343FD1F9149600D82B54EB04";
    }
}
