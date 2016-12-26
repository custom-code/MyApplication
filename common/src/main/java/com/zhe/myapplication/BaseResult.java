package com.zhe.myapplication;

/**
 * Created by zhe on 2016/12/23.
 */

public class BaseResult<T> {

    /**
     * code : 0
     * data : 21
     * message : 操作成功
     * status : OK
     */

    private int code;
    private T data;
    private String message;
    private String status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
