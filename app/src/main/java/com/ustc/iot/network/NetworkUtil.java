package com.ustc.iot.network;

import com.google.gson.Gson;
import com.ustc.iot.util.SharedPreferencesUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      NetworkUtil
 * 创建时间：      2020/6/29 3:42 PM
 *
 */
public class NetworkUtil {
//    public static MediaType sMediaType = MediaType.parse("text/plain");
    public static final String BASE_URL_1 = "https://api2.bmob.cn/1/classes/";
    public static final String BASE_URL_2 = "https://api2.bmob.cn/1/";
    public static MediaType sMediaType = MediaType.parse("application/json");
    private static Retrofit sRetrofit3  ;
    private static Retrofit sRetrofit  = new Retrofit.Builder()
            .client(genericClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api2.bmob.cn/1/classes/")
            .build();
    private static Retrofit sRetrofit2  = new Retrofit.Builder()
            .client(genericClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_2)
            .build();
    public static Retrofit getRetrofit(){
        return sRetrofit;
    }
    public static Retrofit getRetrofitBatch(){
        return sRetrofit2;
    }
    private static OkHttpClient genericClient() {
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
    public static Retrofit getUserRetrofit(){
        sRetrofit3 = new Retrofit.Builder()
                .client(genericClient2())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api2.bmob.cn/1/")
                .build();
        return sRetrofit3;
    }
    /**
     * 操作用户表
     * @return
     */
    private static OkHttpClient genericClient2() {
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
                                .addHeader("X-Bmob-Session-Token", (String)SharedPreferencesUtil.getData("sessionToken",""))
                                .build();
                        // 开始请求
                        return chain.proceed(request);
                    }
                })
                .build();
        return httpClient;
    }

    public static RequestBody creteBody(Object src){
        return RequestBody.create(sMediaType,new Gson().toJson(src));
    }
}
