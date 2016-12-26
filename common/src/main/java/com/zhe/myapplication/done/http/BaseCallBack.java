package com.zhe.myapplication.done.http;

import com.zhe.myapplication.BaseResult;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhe on 2016/12/23.
 */

public abstract class BaseCallBack<T extends BaseResult> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.raw().code() == 200) {
            if (response.body().getCode() == 0) {
                onSuccess(response.body());
            } else if (response.body().getCode() == 1) {

            } else {
                onFail(response.body().getMessage());
            }
        } else {
            onFailure(call, new RuntimeException("response error, detail = " + response.raw().toString()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof SocketTimeoutException) {

        } else if (t instanceof ConnectException) {

        } else if (t instanceof RuntimeException) {

        }
        onFail(t.getMessage());
    }

    protected abstract void onSuccess(T body);

    protected abstract void onFail(String error);

}
