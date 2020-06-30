package com.ustc.iot.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      IGateway
 * 创建时间：      2020/6/29 9:58 PM
 *
 */
public interface IGateway {
    String TABLE = "component";
    @PUT(TABLE)
    Call<ResponseBody> addGateway(@Body RequestBody body);
}
