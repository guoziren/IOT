package com.ustc.iot.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.ustc.iot.R;
import com.ustc.iot.databinding.ActivityLogin2Binding;
import com.ustc.iot.network.ApiUser;
import com.ustc.iot.util.ToastUtil;


public class LoginActivity2 extends AppCompatActivity {

    private ActivityLogin2Binding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_login2);
        mBinding.setLoginViewModel(new LoginViewModel(mBinding,this));
        mBinding.registe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity2.this,RegisterActivity.class));
                finish();
            }
        });
        mBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mBinding.textInputEditText1.getText().toString();
                String password = mBinding.textInputEditText2.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    ToastUtil.showToast("输入有空值");
                    return;
                }
//                ApiUser.login(username, password, new ApiUser.onLoginListener() {
//                    @Override
//                    public void onSuccess() {
//                        startActivity(new Intent(LoginActivity2.this,HomeActivity.class));
//                        finish();
//                    }
//                });

                        startActivity(new Intent(LoginActivity2.this,HomeActivity.class));
                        finish();


            }
        });

    }
}
