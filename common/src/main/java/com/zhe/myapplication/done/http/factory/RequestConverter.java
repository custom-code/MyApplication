package com.zhe.myapplication.done.http.factory;

import java.io.IOException;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by zhe on 2016/12/23.
 */

public class RequestConverter<T> implements Converter<T, RequestBody> {

    @Override
    public RequestBody convert(T value) throws IOException {
        if (value instanceof String) {
            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), (String) value);
        } else if (value instanceof Map) {
            
        }
        return null;
    }
}
