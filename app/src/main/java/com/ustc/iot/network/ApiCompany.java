package com.ustc.iot.network;

import com.ustc.iot.model.entity.Company;
import com.ustc.iot.util.LogUtil;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      ApiCompany
 * 创建时间：      2020/6/29 6:37 PM
 *
 */
public class ApiCompany {
    private static final String TAG = "ApiCompany";
    public static void addCompany(String name){
        Retrofit retrofit = NetworkUtil.getRetrofit();
        ICompany ICompany = retrofit.create(ICompany.class);

        Company company = new Company();
        company.setName(name);
        Call<ResponseBody> call = ICompany.addCompany(company);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                int statusCode = response.code();
                if (statusCode == 401){

                }else if(statusCode == 200 || statusCode == 201){//成功

                }else{

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                LogUtil.d(TAG, "onFailure: ");
            }
        });
    }
}
