package com.zhe.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhe.myapplication.done.util.DisplayUtils;

public class DragActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private RelativeLayout activityDrag;
    private LinearLayout actionLayout;
    private Button addItem;
    private DragLayout dragLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        mContext = DragActivity.this;
        initView();
    }

    private void initView() {
        activityDrag = (RelativeLayout) findViewById(R.id.activity_drag);
        actionLayout = (LinearLayout) findViewById(R.id.action_layout);
        addItem = (Button) findViewById(R.id.add_item);
        dragLayout = (DragLayout) findViewById(R.id.drag_layout);
        addItem.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_item:
                TextView textView = new TextView(mContext);
                textView.setText("Just Test Add");
                textView.setGravity(Gravity.CENTER);
                textView.setBackgroundResource(R.drawable.shape_drag_view_bg);
                int width = DisplayUtils.dip2px(mContext, 100);
                int height = DisplayUtils.dip2px(mContext, 50);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
                textView.setLayoutParams(params);
                dragLayout.addView(textView);
                break;
        }
    }
}
