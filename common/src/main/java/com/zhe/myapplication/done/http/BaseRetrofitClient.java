package com.zhe.myapplication.done.http;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhe on 16/3/7.
 */
public class BaseRetrofitClient {

    public <T> T initRestAdapter(String ENDPOINT, Class<T> restInterface) {
        return initRestAdapters(ENDPOINT, restInterface);
    }

    private <T> T initRestAdapters(String ENDPOINT, Class<T> restInterface) {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .serializeNulls()
                .create();

        // Set the custom client when building adapter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkHttpFactory.INSTANCE.getOkHttpClient())
                .build();

        return retrofit.create(restInterface);
    }
}
