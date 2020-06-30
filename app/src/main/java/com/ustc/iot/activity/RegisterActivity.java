package com.ustc.iot.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.ustc.iot.R;
import com.ustc.iot.databinding.ActivityRegisterBinding;
import com.ustc.iot.util.SharedPreferencesUtil;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(TextUtils.isEmpty((String)SharedPreferencesUtil.getData("userId",""))){
            ActivityRegisterBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_register);
            new RegisterViewModel(binding);

            binding.loginbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RegisterActivity.this,LoginActivity2.class));
                    finish();
                }
            });
        }else{
            startActivity(new Intent(this,MainActivity.class));
        }

    }
}
