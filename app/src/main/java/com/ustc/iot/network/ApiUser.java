package com.ustc.iot.network;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ustc.iot.MyApplication;
import com.ustc.iot.model.entity.Gateway1;
import com.ustc.iot.util.LogUtil;
import com.ustc.iot.util.SharedPreferencesUtil;
import com.ustc.iot.util.ToastUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/*
 * 包名：      com.ustc.iot.network
 * 文件名：      ApiUser
 * 创建时间：      2020/6/29 6:28 PM
 *
 */
public class ApiUser {
    private static final String TAG = "ApiUser";
    /**
     * 注册
     */
    public static void registe(String name,String username,String passowrd,String company,String phone,String email){
        IUser user = NetworkUtil.getRetrofitBatch().create(IUser.class);
        JsonObject req = getRequestContent(name, username, passowrd, company, phone, email);

        Call<ResponseBody> call = user.registe(RequestBody.create(NetworkUtil.sMediaType,new Gson().toJson(req)));
        //插入公司表
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                int statusCode = response.code();
                if (statusCode == 200){
                    try {
                       String result = response.body().string();
                        JsonArray array = new JsonParser().parse(result).getAsJsonArray();
                        List<Response> responseList = new ArrayList<>();
                        for (JsonElement jsonElement : array) {
                            Response res = new Gson().fromJson(((JsonObject)jsonElement).get("success"),Response.class);
                            responseList.add(res);
                        }
                        String token = responseList.get(0).getSessionToken();
                        String userId = responseList.get(0).getObjectId();
                        String companyId = responseList.get(1).getObjectId();
                        SharedPreferencesUtil.putData("userId",userId);
                        SharedPreferencesUtil.putData("sessionToken",token);
                        SharedPreferencesUtil.putData("companyId",companyId);

                        bindCompany(userId);
                        LogUtil.d(TAG, "onResponse:registe "  + result);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    ToastUtil.showToast(MyApplication.getAppContext(),0,"注册失败，请重试");
                }
                LogUtil.d(TAG, "onResponse: registe" + response.code());
                LogUtil.d(TAG, "onResponse:registe " + response);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                LogUtil.d(TAG, "onFailure: ");
            }
        });
    }

    public static void login(String username,String password,onLoginListener listener){
        Retrofit retrofit = NetworkUtil.getRetrofitBatch();
        IUser user = retrofit.create(IUser.class);
        Call<ResponseBody> call = user.login(username,password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                int code = response.code();
                if (code == 200 || code == 201){
                    try {
                        Response resp = new Gson().fromJson(response.body().string(),Response.class);
                        SharedPreferencesUtil.putData("userId",resp.getObjectId());
                        SharedPreferencesUtil.putData("sessionToken",resp.getSessionToken());
                        listener.onSuccess();
                        ToastUtil.showToast("登录成功");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else{
                    ToastUtil.showToast("登录失败");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                ToastUtil.showToast("网络错误");
            }
        });
    }
    public interface onLoginListener{
        void onSuccess();
    }
    public static void bindCompany(String objectid){
        IUser user = NetworkUtil.getUserRetrofit().create(IUser.class);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("__type","Pointer");
        jsonObject.addProperty("className","company");
        jsonObject.addProperty("objectId",(String)SharedPreferencesUtil.getData("companyId",""));
        JsonObject req = new JsonObject();
        req.add("company",jsonObject);

        RequestBody body = RequestBody.create(NetworkUtil.sMediaType,new Gson().toJson(req));
         Call<ResponseBody> call = user.bindCompany(objectid,body);
         call.enqueue(new Callback<ResponseBody>() {
             @Override
             public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                 int code = response.code();
                 if (code == 200){
                     LogUtil.d(TAG, "onResponse: 注册成功");

                 }
             }

             @Override
             public void onFailure(Call<ResponseBody> call, Throwable t) {

             }
         });
    }

    private static JsonObject getRequestContent(String name, String username, String passowrd, String company, String phone, String email) {
        //插入用户表
        JsonObject body1 = new JsonObject();
        body1.addProperty("username",username);
        body1.addProperty("password",passowrd);
        body1.addProperty("mobilePhoneNumber",phone);
        body1.addProperty("email",email);
        body1.addProperty("name",name);
        body1.addProperty("type",0);
        JsonObject req1 = new JsonObject();
        req1.addProperty("method","POST");
        req1.addProperty("path","/1/users");
        req1.add("body",body1);


        //插入公司表
        JsonObject body2 = new JsonObject();
        body2.addProperty("name",company);


        JsonObject req2 = new JsonObject();
        req2.addProperty("method","POST");
        req2.addProperty("path","/1/classes/company");
        req2.add("body",body2);

        JsonArray array = new JsonArray();
        array.add(req1);
        array.add(req2);

        JsonObject req = new JsonObject();
        req.add("requests",array);
        return req;
    }
}
