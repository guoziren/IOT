package com.ustc.iot.fragment.search;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ustc.iot.R;
import com.ustc.iot.model.entity.ConditionQueryResponse;
import com.ustc.iot.util.ReflectUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/*
 * 包名：      com.ustc.iot.fragment.search
 * 文件名：      ResultDialogFragment
 * 创建时间：      2020/7/4 5:19 PM
 *
 */
public class ResultDialogFragment extends DialogFragment {
    private ConditionQueryResponse.DataBean.ListBean mListBean;
    public ResultDialogFragment(ConditionQueryResponse.DataBean.ListBean list) {
        mListBean = list;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_result,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] fieldNames = ReflectUtil.getFieldName(mListBean);
        for (int i = 0; i < fieldNames.length; i++) {
            LinearLayout v = (LinearLayout) LayoutInflater.from(view.getContext()).inflate(R.layout.item_item_ll, (ViewGroup) view,false);

            TextView tv_name = v.findViewById(R.id.tv_name);
            TextView tv_value = v.findViewById(R.id.tv_value);
            tv_name.setText(ReflectUtil.getString(fieldNames[i])+" : ");
            Object value = ReflectUtil.getFieldValueByName(fieldNames[i],mListBean);

            tv_value.setText(String.valueOf(value));
            ((ViewGroup) view).addView(v);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
