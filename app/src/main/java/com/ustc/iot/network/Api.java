package com.ustc.iot.network;

import com.ustc.iot.model.entity.Gateway1;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      Api
 * 创建时间：      2020/6/29 2:07 PM
 *
 */
public interface Api {
    /**
     * 添加网关
     * @return
     */
    @POST("Gateway")
    Call<ResponseBody> addGateway(@Body Gateway1 s);
}
