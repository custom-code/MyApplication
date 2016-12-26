package com.zhe.myapplication.done.widget.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.widget.BaseAdapter;

public abstract class AlertMessageDialog {

    private Builder builder = null;
    private AlertDialog alertDialog = null;

    /**
     * 确定弹框
     *
     * @param context
     * @param title
     * @param posText
     * @param negText
     * @param msgText
     */
    public AlertMessageDialog(Context context, String title, String posText,
                              String negText, String msgText) {
        builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msgText);
        builder.setPositiveButton(posText, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                positiveButton(dialog, which);
            }
        });
        builder.setNegativeButton(negText, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                negativeButton(dialog, which);
            }
        });
    }

    /**
     * 可以多选的弹框
     *
     * @param context
     * @param title
     * @param posText
     * @param negText
     * @param items
     * @param checkedItems
     */
    public AlertMessageDialog(Context context, String title, String posText,
                              String negText, String[] items, boolean[] checkedItems) {
        builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setPositiveButton(posText, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                positiveButton(dialog, which);
            }
        });
        builder.setMultiChoiceItems(items, checkedItems,
                new OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        multiChoiceItems(dialog, which, isChecked);
                    }
                });
        builder.setNegativeButton(negText, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                negativeButton(dialog, which);
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
    public AlertMessageDialog(Context context, String title, String posText,
                              String negText, View view) {
        builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setView(view);
        builder.setPositiveButton(posText, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                positiveButton(dialog, which);
            }
        });
        builder.setNegativeButton(negText, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                negativeButton(dialog, which);
            }
        });
    }

    public AlertMessageDialog(Context context, String title, BaseAdapter adapter) {
        builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setAdapter(adapter, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                positiveButton(dialog, which);
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

    /**
     * 多选事件
     *
     * @param dialog
     * @param which
     * @param isChecked
     */
    protected void multiChoiceItems(DialogInterface dialog, int which,
                                    boolean isChecked) {
    }

}
