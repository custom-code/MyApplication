package com.zhe.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by zhe on 2016/12/9.
 */
public class CustomDialog extends Dialog {

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private Context mContext;
        private String mTittle;
        private String mMessage;
        private String positiveButtonText;
        private String negativeButtonText;
        private View contentView;
        private OnClickListener positiveButtonClickListener;
        private OnClickListener negativeButtonClickListener;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setMessage(String message) {
            this.mMessage = message;
            return this;
        }

        /**
         * Set the Dialog message from resource
         *
         * @param message
         * @return
         */
        public Builder setMessage(int message) {
            this.mMessage = (String) mContext.getText(message);
            return this;
        }

        /**
         * Set the Dialog mTittle from resource
         *
         * @param tittle
         * @return
         */
        public Builder setmTittle(int tittle) {
            this.mTittle = (String) mContext.getText(tittle);
            return this;
        }

        /**
         * Set the Dialog mTittle from String
         *
         * @param title
         * @return
         */

        public Builder setTitle(String title) {
            this.mTittle = title;
            return this;
        }

        /**
         * 设置自定义的布局
         *
         * @param v
         * @return
         */
        public Builder setView(View v) {
            this.contentView = v;
            return this;
        }

        public Builder setPositiveButton(int positiveButtonText, OnClickListener listener) {
            this.positiveButtonText = (String) mContext
                    .getText(positiveButtonText);
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText, OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButtonText,
                                         OnClickListener listener) {
            this.negativeButtonText = (String) mContext
                    .getText(negativeButtonText);
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText,
                                         OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        public CustomDialog create() {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            final CustomDialog dialog = new CustomDialog(mContext, R.style.AppStyle_Dialog);
            View layout = inflater.inflate(R.layout.dialog_normal_layout, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            Button negativeButton = (Button) layout.findViewById(R.id.negativeButton); // 取消按钮
            Button positiveButton = (Button) layout.findViewById(R.id.positiveButton); // 确定按钮
            LinearLayout content = (LinearLayout) layout.findViewById(R.id.content); // 自定义布局内容
            TextView message = (TextView) layout.findViewById(R.id.message); // 消息内容
            TextView title = (TextView) layout.findViewById(R.id.tittle); // 标题

            title.setText(mTittle);

            if (mMessage != null) {
                message.setText(mMessage);
            } else if (contentView != null) {
                content.removeAllViews();
                content.addView(contentView, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
            }

            if (positiveButtonText != null) {
                positiveButton.setText(positiveButtonText);
                if (positiveButtonClickListener != null) {
                    positiveButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            positiveButtonClickListener.onClick(dialog,
                                    DialogInterface.BUTTON_POSITIVE);
                        }
                    });
                }
            } else {
                positiveButton.setVisibility(View.GONE);
            }

            if (negativeButtonText != null) {
                negativeButton.setText(negativeButtonText);
                if (negativeButtonClickListener != null) {
                    negativeButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            negativeButtonClickListener.onClick(dialog,
                                    DialogInterface.BUTTON_NEGATIVE);
                        }
                    });
                }
            } else {
                negativeButton.setVisibility(
                        View.GONE);
            }
            dialog.setContentView(layout);
            return dialog;
        }
    }
}
