package com.ustc.iot.model;

import com.google.gson.Gson;
import com.ustc.iot.model.entity.Gateway1;
import com.ustc.iot.network.Api;
import com.ustc.iot.util.LogUtil;

import java.io.IOException;
import java.lang.reflect.Field;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * 包名：      com.ustc.iot.model
 * 文件名：      API
 * 创建时间：      2020/6/29 2:14 PM
 *
 */
public class API {
    private static final String TAG = "API";
    private static Retrofit sRetrofit  = new Retrofit.Builder()
            .client(genericClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api2.bmob.cn/1/classes/")
            .build();
    public static void addGateway(){

        Api api = sRetrofit.create(Api.class);
        Gateway1 g = new Gateway1();
        g.setName("c网关");
        g.setDescription("AADSFASDF网关");
        Call<ResponseBody> call = api.addGateway(g);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                LogUtil.d(TAG, "onResponse: " + response.code());
                LogUtil.d(TAG, "onResponse: " + response);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                LogUtil.d(TAG, "onFailure: ");
            }
        });
    }
    public static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                // 设置拦截器，添加统一的请求头
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        // 以拦截到的请求为基础创建一个新的请求对象，然后插入Header
                        Request request = chain.request().newBuilder()
                                .addHeader("X-Bmob-Application-Id", "f4800f81c2b86d7673f60d22f68ee543")
                                .addHeader("X-Bmob-REST-API-Key", "2261337d6fbc4859e70979bbc583a931")
                                .addHeader("Content-Type", "application/json")
                                .build();
                        // 开始请求
                        return chain.proceed(request);
                    }
                })
                .build();
            return httpClient;
    }
}
