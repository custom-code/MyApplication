package com.zhe.myapplication;

import com.zhe.myapplication.done.http.BaseRetrofitClient;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


/**
 * Created by zhe on 16/5/22.
 */
public class DataRetrofitClient extends BaseRetrofitClient {

    private DataService mMainService;

    public DataRetrofitClient(String baseUrl) {
        mMainService = initRestAdapter(baseUrl, DataService.class);
    }

    public void postJsonData(String token, String json, Callback<BaseResult<String>> callback) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Call<BaseResult<String>> call = mMainService.postJsonData(token, Locale.getDefault().toString(), body);
        call.enqueue(callback);
    }

    public <M extends Map<String, V>, V> void postBodyData(String token, M map, Callback<BaseResult<List<City>>> callback) {
        RequestBody body = builderBody(map);
//        Call<BaseResult<List<City>>> call = mMainService.postBodyData(token, Locale.getDefault().toString(), body);
        Call<BaseResult<List<City>>> call = mMainService.postBodyData2(token, Locale.getDefault().toString(), (Map<String, String>) map);
        call.enqueue(callback);
    }

    private <K extends String, V> RequestBody builderBody(Map<K, V> map) {
        FormBody.Builder builder = new FormBody.Builder();
        Set<Map.Entry<K, V>> entries = map.entrySet();
        for (Map.Entry<K, V> entry : entries) {
            String key = entry.getKey();
            V value = map.get(key);
            if (value == null)
                break;
            builder.add(key, String.valueOf(value));
        }
        return builder.build();
    }
}
