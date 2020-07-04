package com.ustc.iot;

import android.app.Application;
import android.content.Context;

import com.ustc.iot.util.ReflectUtil;
import com.ustc.iot.util.SharedPreferencesUtil;

/*
 * 包名：      com.ustc.iot
 * 文件名：      MyApplication
 * 创建时间：      2020/6/29 6:22 PM
 *
 */
public class MyApplication extends Application {
    private static Context INSTANCE;
    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        SharedPreferencesUtil.getInstance(this,"config");
        ReflectUtil.initMap();
    }
    public static Context getAppContext(){
        return INSTANCE;
    }
}
