package com.ustc.iot.network;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ustc.iot.model.entity.Company;
import com.ustc.iot.util.LogUtil;

import java.io.IOException;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      ApiComponent
 * 创建时间：      2020/6/29 3:41 PM
 *
 */
public class ApiComponent {
    private static final String TAG = "API";

    /**
     * 根据组件名称和组件类型查询组件是否存在
     */
    public static void queryByNameAndType(){
        Retrofit retrofit = NetworkUtil.getRetrofit();
        IComponent IComponent = retrofit.create(IComponent.class);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name","A");
        jsonObject.addProperty("type",0);
        
        Gson gson  = new Gson();
        String content = gson.toJson(jsonObject);

        Call<ResponseBody> call = IComponent.queryByNameAndType(content);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                LogUtil.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                LogUtil.d(TAG, "onFailure: ");
            }
        });
    }

    public static void addComponent(RequestBody componentBody,JsonObject obj){
            LogUtil.d(TAG, "addComponent: ");
            Retrofit retrofit = NetworkUtil.getRetrofit();
            IComponent component = retrofit.create(IComponent.class);


            Call<ResponseBody> call = component.addGateway(componentBody);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    int statusCode = response.code();
                    if (statusCode == 401){

                    }else if(statusCode == 200 || statusCode == 201){//成功
                        com.ustc.iot.network.Response resp = null;
                        try {
                            resp = new Gson().fromJson(response.body().string(), com.ustc.iot.network.Response.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ApiComponentProp.addManyProperties(obj,resp.getObjectId());
                        LogUtil.d(TAG, "onResponse: addComponent success");
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

