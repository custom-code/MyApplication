package com.zhe.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhe.myapplication.done.http.BaseCallBack;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {

    DataRetrofitClient client;
    @Bind(R.id.post_json_data)
    Button mPostJsonData;
    @Bind(R.id.post_map_data)
    Button mPostMapData;
    @Bind(R.id.activity_data)
    LinearLayout mActivityData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ButterKnife.bind(this);
        client = Api.getInstance().getMainRetrofitClient();
        mPostJsonData.setOnClickListener(this);
        mPostMapData.setOnClickListener(this);
    }

    private void postJsonData() {
        String json = "{\"shareId\":\"5e20d5268dfb400fb1cc59aa13e6a9bc\",\"praiseflag\":\"0\"}";
        String token = "BC86A11608B00F1F3271C968E4C07EF9";
        client.postJsonData(token, json, new BaseCallBack<BaseResult<String>>() {

            @Override
            protected void onSuccess(BaseResult<String> body) {
                Log.d("DataRetrofitClient", body.getData());
            }

            @Override
            protected void onFail(String error) {
                Log.d("DataRetrofitClient", "onFailure" + error);
            }
        });
    }

    private void postMapBodyData() {
        Map<String, String> map = new HashMap<>();
        String token = "BC86A11608B00F1F3271C968E4C07EF9";
        client.postBodyData(token, map, new BaseCallBack<BaseResult<List<City>>>() {
            @Override
            protected void onSuccess(BaseResult<List<City>> body) {
                List<City> cities = body.getData();
                Log.d("DataRetrofitClient", body.getMessage());
            }

            @Override
            protected void onFail(String error) {
                Log.d("DataRetrofitClient", "onFailure" + error);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.post_json_data:
                postJsonData();
                break;
            case R.id.post_map_data:
                postMapBodyData();
                break;
        }
    }
}
