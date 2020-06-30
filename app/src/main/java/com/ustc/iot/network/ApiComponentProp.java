package com.ustc.iot.network;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ustc.iot.MyApplication;
import com.ustc.iot.util.LogUtil;
import com.ustc.iot.util.ToastUtil;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      ApiComponentProp
 * 创建时间：      2020/6/29 11:02 PM
 *
 */
public class ApiComponentProp {
    private static final String TAG = "ApiComponentProp";
    public static void addManyProperties(JsonObject jsonObject,String componentId){
        Retrofit retrofit = NetworkUtil.getRetrofitBatch();
        IComponentProperties properties = retrofit.create(IComponentProperties.class);

        JsonArray array = new JsonArray();
        for (String s : jsonObject.keySet()) {
            String value = jsonObject.get(s).getAsString();
            JsonObject req2 = new JsonObject();
            req2.addProperty("method","POST");
            req2.addProperty("path","/1/classes/ComponentProperties");
            JsonObject body = new JsonObject();
            body.addProperty("cid",componentId);
            body.addProperty("name",s);
            body.addProperty("value",value);
            req2.add("body",body);
            array.add(req2);
        }

        JsonObject req = new JsonObject();
        req.add("requests",array);
        Call<ResponseBody> call = properties.add(NetworkUtil.creteBody(req));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                int code = response.code();
                LogUtil.d(TAG, "onResponse: " + code);
                if (code == 200 || code == 201){
                    ToastUtil.showToast("创建成功");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}
