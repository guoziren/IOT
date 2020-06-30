package com.ustc.iot.fragment.sensor;

import android.text.TextUtils;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ustc.iot.MyApplication;
import com.ustc.iot.databinding.FragmentAddGatewayBinding;
import com.ustc.iot.databinding.FragmentAddSensorBinding;
import com.ustc.iot.network.ApiComponent;
import com.ustc.iot.network.NetworkUtil;
import com.ustc.iot.util.LogUtil;
import com.ustc.iot.util.ToastUtil;

import okhttp3.RequestBody;

/*
 * 包名：      com.ustc.iot.fragment.gatewaycenter
 * 文件名：      AddGateWayViewModel
 * 创建时间：      2020/6/29 10:33 PM
 *
 */
public class AddSensorViewModel {
    private static final String TAG = "AddSensorViewModel";
    private FragmentAddSensorBinding mBinding;
    public AddSensorViewModel(FragmentAddSensorBinding binding) {
        mBinding = binding;
    }
    public void onClick(View v){
        LogUtil.d(TAG, "onClick: ");
         String xieyi = mBinding.textView1.getText().toString();
         String dianya = mBinding.textView2.getText().toString();
         String dianchi = mBinding.textView3.getText().toString();
         String tvEnr = mBinding.tvEnr.getText().toString();
         String tvIntro = mBinding.tvIntro.getText().toString();
         String tvName = mBinding.tvName.getText().toString();

         String xieyi_value = mBinding.editText1.getText().toString();
         String dianya_value = mBinding.editText2.getText().toString();
         String dianchi_value = mBinding.editText3.getText().toString();
         String etEnr = mBinding.etEnr.getText().toString();
         String etIntro = mBinding.etIntro.getText().toString();
         String etName = mBinding.etName.getText().toString();
        if (TextUtils.isEmpty(etName)){
            ToastUtil.showToast(MyApplication.getAppContext(),0,"名称不能为空");
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name",etName);
        jsonObject.addProperty("type",0);
//        jsonObject.addProperty("company", (String)SharedPreferencesUtil.getData("company",""));
        RequestBody body  = RequestBody.create(NetworkUtil.sMediaType,new Gson().toJson(jsonObject));

        JsonObject jsonObject2 = new JsonObject();
        if (!TextUtils.isEmpty(xieyi_value)){
            jsonObject2.addProperty(xieyi,xieyi_value);
        }
        if (!TextUtils.isEmpty(dianya_value)){
            jsonObject2.addProperty(dianya,dianya_value);
        }
        if (!TextUtils.isEmpty(dianchi_value)){
            jsonObject2.addProperty(dianchi,dianchi_value);
        }
        if (!TextUtils.isEmpty(etEnr)){
            jsonObject2.addProperty(tvEnr,etEnr);
        }
        if (!TextUtils.isEmpty(etIntro)){
            jsonObject2.addProperty(tvIntro,etIntro);
        }
        if (!TextUtils.isEmpty(etName)){
            jsonObject2.addProperty(tvName,etName);
        }


        ApiComponent.addComponent(body,jsonObject2);
    }
}
