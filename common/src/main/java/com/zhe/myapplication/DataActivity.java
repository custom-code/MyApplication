package com.zhe.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zhe.myapplication.done.http.BaseCallBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.post_json_data)
    Button mPostJsonData;
    @Bind(R.id.post_map_data)
    Button mPostMapData;
    @Bind(R.id.activity_data)
    LinearLayout mActivityData;
    @Bind(R.id.post_file_data)
    Button mPostFileData;
    @Bind(R.id.post_file_list_data)
    Button mPostFileListData;

    private DataRetrofitClient mClient;
    private FileRetrofitClient mFileClient;
    private ArrayList<String> paths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ButterKnife.bind(this);
        initView();
        mClient = Api.getInstance().getMainRetrofitClient();
        mFileClient = Api.getInstance().getFileRetrofitClient();
        paths = getIntent().getStringArrayListExtra("path");
    }

    private void initView() {
        mPostJsonData.setOnClickListener(this);
        mPostMapData.setOnClickListener(this);
        mPostFileData.setOnClickListener(this);
        mPostFileListData.setOnClickListener(this);
    }

    private void postJsonData() {
        String json = "{\"shareId\":\"5e20d5268dfb400fb1cc59aa13e6a9bc\",\"praiseflag\":\"0\"}";
        String token = BaseApplication.getInstance().getToken();
        mClient.postJsonData(token, json, new BaseCallBack<BaseResult<String>>() {

            @Override
            protected void onSuccess(BaseResult<String> body) {
                Log.d("DataActivity", body.getData());
            }

            @Override
            protected void onFail(String error) {
                Log.d("DataActivity", "onFailure" + error);
            }
        });
    }

    private void postMapBodyData() {
        Map<String, String> map = new HashMap<>();
        String token = BaseApplication.getInstance().getToken();
        map.put("token", token);
        mClient.postBodyData(token, map, new BaseCallBack<BaseResult<List<City>>>() {
            @Override
            protected void onSuccess(BaseResult<List<City>> body) {
                List<City> cities = body.getData();
                Log.d("DataActivity", body.getMessage());
            }

            @Override
            protected void onFail(String error) {
                Log.d("DataActivity", "onFailure" + error);
            }
        });
    }

    private void postFileData() {
        String token = BaseApplication.getInstance().getToken();
        mFileClient.postFile(token, paths.get(0), new BaseCallBack<BaseResult<String>>() {
            @Override
            protected void onSuccess(BaseResult<String> body) {
                Log.d("DataActivity", body.getData());
            }

            @Override
            protected void onFail(String error) {
                Log.d("DataActivity", "onFail error = " + error);
            }
        });
    }

    private void postFileListData() {
        String token = BaseApplication.getInstance().getToken();
        mFileClient.postFiles(token, paths, new BaseCallBack<BaseResult<String>>() {
            @Override
            protected void onSuccess(BaseResult<String> body) {
                Log.d("DataActivity", body.getData());
            }

            @Override
            protected void onFail(String error) {
                Log.d("DataActivity", "onFail error = " + error);
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
            case R.id.post_file_data:
                postFileData();
                break;
            case R.id.post_file_list_data:
                postFileListData();
                break;
        }
    }
}
