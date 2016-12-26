package com.zhe.myapplication.done.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

public abstract class DialogProcessHandler {
    private Context context;
    private ProgressDialog dialog;
    private final int DISMISS = 2;

    public DialogProcessHandler(Context context) {
        this.context = context;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case DISMISS:
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    updateUI();
                    break;
            }
        }
    };

    public void show() {
        dialog = new ProgressDialog(context);
        dialog.setMessage(initialContent() == null ? "数据加载中..."
                : initialContent());
        dialog.show();
        new Thread() {
            @Override
            public void run() {
                super.run();
                handleData();
                Message.obtain(handler, DISMISS).sendToTarget();
            }
        }.start();
    }

    // 处理数据
    public abstract void handleData();

    // 初始化progressdialog的显示内容
    public abstract String initialContent();

    // 数据操作结果要更新的ui
    public abstract void updateUI();
}
