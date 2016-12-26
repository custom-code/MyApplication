package com.zhe.myapplication.done.async.threadpool;

/**
 * 任务单元
 * Created by zhe on 2016/12/9.
 */
public abstract class ThreadPoolTask implements Runnable {

    protected String url;

    public ThreadPoolTask(String url) {
        this.url = url;
    }

    public abstract void run();

    public String getURL() {
        return this.url;
    }
}
