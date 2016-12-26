package com.zhe.myapplication.done.http;


import com.zhe.myapplication.BaseApplication;
import com.zhe.myapplication.done.http.interceptor.OnOffLineCachedInterceptor;
import com.zhe.myapplication.done.http.interceptor.UserAgentInterceptor;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by zhe on 2016/12/23.
 */
enum OkHttpFactory {

    INSTANCE;

    private final OkHttpClient okHttpClient;
    private final long TIMEOUT_READ = 25;
    private final long TIMEOUT_CONNECTION = 25;
    private final long TIMEOUT_WRITE = 25;

    OkHttpFactory() {

        // 打印请求Log
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        //缓存目录
        Cache cache = new Cache(BaseApplication.getInstance().getCacheDir(), 10 * 1024 * 1024);

        ClearableCookieJar cookieJar = new PersistentCookieJar(
                new SetCookieCache(),
                new SharedPrefsCookiePersistor(BaseApplication.getInstance().getBaseContext()));

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logInterceptor)
                .addInterceptor(new UserAgentInterceptor(HttpHelper.getUserAgent())) // 添加UA
                .addInterceptor(new OnOffLineCachedInterceptor()) // 走缓存，两个都要设置
                .addNetworkInterceptor(new OnOffLineCachedInterceptor())
                .addNetworkInterceptor(new StethoInterceptor()) //stetho,可以在chrome中查看请求
                .cache(cache) // 必须是设置Cache目录
                .retryOnConnectionFailure(true) // 失败重连
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
                .cookieJar(cookieJar)
                .build();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
