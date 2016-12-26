package com.zhe.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

public abstract class AlertCustomDialog {

    private CustomDialog.Builder builder = null;
    private CustomDialog alertDialog = null;

    /**
     * 确定弹框
     *
     * @param context
     * @param title
     * @param posText
     * @param negText
     * @param msgText
     */
    public AlertCustomDialog(Context context, String title, String posText,
                             String negText, String msgText) {
        builder = new CustomDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msgText);
        builder.setPositiveButton(posText, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                _positiveButton(dialog, which);
            }
        });
        builder.setNegativeButton(negText, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                _negativeButton(dialog, which);
            }
        });
    }

    /**
     * 自定义组件弹框
     *
     * @param context
     * @param title
     * @param posText
     * @param negText
     */
    public AlertCustomDialog(Context context, String title, String posText,
                             String negText, View view) {
        builder = new CustomDialog.Builder(context);
        builder.setTitle(title);
        builder.setView(view);
        builder.setPositiveButton(posText, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                _positiveButton(dialog, which);
            }
        });
        builder.setNegativeButton(negText, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                _negativeButton(dialog, which);
            }
        });
    }

    /**
     * 显示dialog
     */
    public void show() {
        if (builder != null) {
            alertDialog = builder.create();
            if (!alertDialog.isShowing()) {
                alertDialog.show();
            }
        }
    }

    /**
     * 隐藏dialog
     */
    public void dismiss() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    private void _positiveButton(DialogInterface dialog, int which) {
        positiveButton(dialog, which);
        dismiss();
    }

    private void _negativeButton(DialogInterface dialog, int which) {
        negativeButton(dialog, which);
        dismiss();
    }

    /**
     * 确定按钮
     *
     * @param dialog
     * @param which
     */
    protected abstract void positiveButton(DialogInterface dialog, int which);

    /**
     * 取消按钮
     *
     * @param dialog
     * @param which
     */
    protected void negativeButton(DialogInterface dialog, int which) {
    }


}
