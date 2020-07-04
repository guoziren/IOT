package com.ustc.iot.activity;

import android.text.TextUtils;
import android.view.View;

import com.ustc.iot.MyApplication;
import com.ustc.iot.databinding.ActivityRegisterBinding;
import com.ustc.iot.network.ApiCompany;
import com.ustc.iot.network.ApiUser;
import com.ustc.iot.util.ToastUtil;

/*
 * 包名：      com.ustc.iot.activity
 * 文件名：      RegisterViewModel
 * 创建时间：      2020/6/29 6:05 PM
 *
 */
public class RegisterViewModel {
    private static final String TAG = "RegisterViewModel";
    private ActivityRegisterBinding mRegisterBinding;
    public RegisterViewModel(ActivityRegisterBinding binding) {
        mRegisterBinding = binding;
        binding.setRegisteViewModel(this);
    }
    public void onClick(View view){
         String email = mRegisterBinding.textInputEditText1.getText().toString();
       String password =mRegisterBinding.textInputEditText2.getText().toString();
//       String name =mRegisterBinding.textInputEditText3.getText().toString();
//       String companyName =mRegisterBinding.textInputEditText4.getText().toString();
       String phone =mRegisterBinding.textInputEditText6.getText().toString();
       String username =mRegisterBinding.textInputEditText7.getText().toString();

       if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)
//               || TextUtils.isEmpty(name) || TextUtils.isEmpty(companyName)
               || TextUtils.isEmpty(phone)){
           ToastUtil.showToast(MyApplication.getAppContext(),0,"有输入为空");
           return;
       }
//        ApiUser.registe(name,username,password,companyName,phone,email);
    }


}
