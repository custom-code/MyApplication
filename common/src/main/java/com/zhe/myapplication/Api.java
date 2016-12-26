package com.zhe.myapplication;

/**
 * Created by zhe on 16/5/22.
 */
public class Api {
    private static final Object monitor = new Object();
    private static Api mApi;
    private DataRetrofitClient mMainRetrofitClient;
    private final String baseUrl = "https://appuat.yaok.com/appapi/";

    public static Api getInstance() {
        synchronized (monitor) {
            if (mApi == null) {
                mApi = new Api();
            }
            return mApi;
        }
    }

    public DataRetrofitClient getMainRetrofitClient() {
        if (mMainRetrofitClient == null) {
            mMainRetrofitClient = new DataRetrofitClient(baseUrl);
        }
        return mMainRetrofitClient;
    }
}
