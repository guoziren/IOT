package com.ustc.iot.network;

import com.ustc.iot.model.entity.Company;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      Company
 * 创建时间：      2020/6/29 6:34 PM
 *
 */
public interface ICompany {
    final String TABLE = "company";
    @POST(TABLE)
    Call<ResponseBody> addCompany(@Body Company b);
}
