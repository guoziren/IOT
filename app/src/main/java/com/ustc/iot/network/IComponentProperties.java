package com.ustc.iot.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      IComponentProperties
 * 创建时间：      2020/6/29 11:00 PM
 *
 */
public interface IComponentProperties {
    @POST("batch")
    Call<ResponseBody> add(@Body RequestBody b);
}
