package com.zhe.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RepeatActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.go_to_repeat_b)
    Button mGoToRepeatB;
    @Bind(R.id.activity_repeat_a)
    RelativeLayout mActivityRepeatA;
    @Bind(R.id.repeat_label)
    TextView mRepeatLabel;

    private Context mContext;
    private boolean isFirst = false;

    public static final int REQUEST_JUMP_NEW = 0x10001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat);
        mContext = RepeatActivity.this;
        ButterKnife.bind(this);
        mGoToRepeatB.setOnClickListener(this);
        isFirst = getIntent().getBooleanExtra("isFirst", false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_to_repeat_b:
                if (isFirst) {
                    Intent intent = new Intent();
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                } else {
                    Intent intent = new Intent();
                    intent.setClass(mContext, RepeatActivity.class);
                    intent.putExtra("isFirst", true);
                    startActivityForResult(intent, REQUEST_JUMP_NEW);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

        }
    }
}
