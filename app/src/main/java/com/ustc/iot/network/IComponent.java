package com.ustc.iot.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      Gateway
 * 创建时间：      2020/6/29 3:27 PM
 *
 */
public interface IComponent {
    static String TABLE = "Component";
    @GET(TABLE)
    Call<ResponseBody> queryByNameAndType(@Query("where") String  param);
    @POST(TABLE)
    Call<ResponseBody> addGateway(@Body RequestBody body);
}
