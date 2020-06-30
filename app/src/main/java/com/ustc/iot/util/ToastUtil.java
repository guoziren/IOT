package com.ustc.iot.util;

import android.content.Context;
import android.widget.Toast;

import com.ustc.iot.MyApplication;

/*
 * 包名：      com.bytedance.xly.util
 * 文件名：      ToastUtil
 * 创建时间：      2020/6/6 4:34 PM
 *
 */
public class ToastUtil {
    private static Toast toast;
    public static void showToast(Context context, int code, String content) {

        if (toast==null) {
            if (code ==0)
                toast=Toast.makeText(context,content,Toast.LENGTH_SHORT);
            if (code==1)
                toast=Toast.makeText(context,content,Toast.LENGTH_LONG);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
    public static void showToast( String content) {

        if (toast==null) {

                toast=Toast.makeText(MyApplication.getAppContext(),content,Toast.LENGTH_SHORT);

        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
