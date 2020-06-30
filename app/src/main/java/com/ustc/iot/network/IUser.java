package com.ustc.iot.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      ApiUser
 * 创建时间：      2020/6/29 6:25 PM
 *
 */
public interface IUser {
     static final String TABLE = "users";

    @POST("batch")
    Call<ResponseBody> registe(@Body RequestBody b);


    @GET("login")
    Call<ResponseBody> login(@Query("username") String username, @Query("password") String password);

    @PUT(TABLE+"/{objectid}")
    Call<ResponseBody> bindCompany(@Path("objectid")String objectid,@Body RequestBody b);
}
