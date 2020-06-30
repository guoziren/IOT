package com.ustc.iot.activity;

import android.app.Activity;
import android.view.View;

import com.ustc.iot.databinding.ActivityLogin2Binding;

/*
 * 包名：      com.ustc.iot.activity
 * 文件名：      LoginViewModel
 * 创建时间：      2020/6/30 4:36 AM
 *
 */
public class LoginViewModel {
    ActivityLogin2Binding mBinding;
    Activity activity;
    public LoginViewModel(ActivityLogin2Binding binding, Activity activity) {
        mBinding = binding;
        this.activity = activity;
    }

    public void onRegClick(View v){

    }
    public void onLoginClick(View v){

    }
}
