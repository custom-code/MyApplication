package com.zhe.myapplication;

import com.zhe.myapplication.done.http.BaseRetrofitClient;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Callback;


/**
 * Created by zhe on 2016/12/26.
 */
public class FileRetrofitClient extends BaseRetrofitClient {

    private DataService mDataService;

    public FileRetrofitClient(String baseUrl) {
        mDataService = initRestAdapter(baseUrl, DataService.class);
    }

    public void postFile(String token, String path, Callback<BaseResult<String>> callback) {
        File file = new File(path);
        RequestBody body = RequestBody.create(getMediaType(MEDIA_TYPE_FORM), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), body);
        mDataService.postFile(token, part).enqueue(callback);
    }

    public void postFile2(String token, String path, Callback<BaseResult<String>> callback) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("file", path, RequestBody.create(getMediaType(MEDIA_TYPE_FORM), new File(path)));
        RequestBody body = builder.build();
        mDataService.postFile2(token, body).enqueue(callback);
    }

    public void postFiles(String token, List<String> list, Callback<BaseResult<String>> callback) {
        Map<String, RequestBody> params = new HashMap<>();
        for (String path : list) {
            File file = new File(path);
            RequestBody body = RequestBody.create(getMediaType(MEDIA_TYPE_FORM), file);
            String key = file.getName();
            params.put(key, body);
        }
        mDataService.postFiles(token, params).enqueue(callback);
    }

    private RequestBody postFileToService(String path, Map<String, String> map) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.addFormDataPart(entry.getKey(), entry.getValue());
        }
        builder.addFormDataPart("file", path, RequestBody.create(getMediaType(MEDIA_TYPE_IMAGE), new File(path)));

        return builder.build();
    }
}
