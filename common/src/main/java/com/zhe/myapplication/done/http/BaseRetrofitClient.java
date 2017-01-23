package com.zhe.myapplication.done.http;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.MediaType;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhe on 16/3/7.
 */
public class BaseRetrofitClient {

    protected final int MEDIA_TYPE_JSON = 0x00a10;
    protected final int MEDIA_TYPE_IMAGE = 0x00a11;
    protected final int MEDIA_TYPE_FORM = 0x00a12;

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

    protected MediaType getMediaType(int type) {
        switch (type) {
            case MEDIA_TYPE_IMAGE:
                return MediaType.parse("image/png"); //图片类型
            case MEDIA_TYPE_FORM:
                return MediaType.parse("multipart/form-data");
            case MEDIA_TYPE_JSON:
            default:
                return MediaType.parse("application/json; charset=utf-8"); //json 类型
        }
    }
}
