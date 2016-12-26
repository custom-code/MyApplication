package com.zhe.myapplication.done.async;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

public abstract class DataProcessHandle {
    private Context mContext;
    private static String THREAD_NAME = "dataprocess_thread";
    protected static final int COMPLETE = 2;
    protected static final int INVALIDEUSER = 3;

    protected Thread processThread;

    public DataProcessHandle(Context context, String threadName) {
        this.mContext = context;
        THREAD_NAME = threadName;
    }

    private Handler messageHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case COMPLETE:
                    updateUI();
                    break;
            }
        }
    };

    public void startup() {
        processThread = new Thread(THREAD_NAME) {
            public void run() {
                try {
                    handleData();
                } catch (Exception e) {
                    handleException(e);
                    e.printStackTrace();
                } finally {
                    Message.obtain(messageHandler, COMPLETE).sendToTarget();
                }
            }

        };
        processThread.start();
    }

    public void handleException(Exception e) {
    }

    // 处理数据
    public abstract void handleData();

    // 数据操作结果要更新的UI
    public abstract void updateUI();
}
