package com.zhe.myapplication.done.http.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhe on 2016/12/23.
 */
public final class UserAgentInterceptor implements Interceptor {
    private final String userAgentHeaderValue;

    public UserAgentInterceptor(String userAgentHeaderValue) {
        this.userAgentHeaderValue = userAgentHeaderValue;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request originalRequest = chain.request();

        final Request requestWithUserAgent = originalRequest
                .newBuilder()
                .removeHeader("User-Agent") // 移除先前默认的UA
                .addHeader("User-Agent", userAgentHeaderValue) // 设置UA
                .addHeader("appVersion", "10")
                .build();
        return chain.proceed(requestWithUserAgent);
    }
}
