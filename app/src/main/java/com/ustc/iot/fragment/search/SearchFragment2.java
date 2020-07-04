package com.ustc.iot.fragment.search;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustc.iot.R;
import com.ustc.iot.activity.ComponentResultActivity;
import com.ustc.iot.activity.HomeActivity;
import com.ustc.iot.databinding.FragmentSearch2Binding;
import com.ustc.iot.databinding.FragmentSearchBinding;
import com.ustc.iot.network.ApiQuery;
import com.ustc.iot.util.ToastUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/*
 * 包名：      com.ustc.iot.fragment.search
 * 文件名：      SearchFragment2
 * 创建时间：      2020/7/2 11:23 PM
 *
 */
public class SearchFragment2 extends Fragment {

    private FragmentSearch2Binding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search2,container,false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

    }

    @Override
    public void onStart() {
        super.onStart();
        HomeActivity activity = (HomeActivity)getActivity();
        activity.getHomeBinding().toolbar.setTitle("查询中心");
        activity.getHomeBinding().toolbar.setVisibility(View.VISIBLE);
    }

    private void init() {


        mBinding.cbModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.cbOther.setChecked(false);
                mBinding.cbModel.setChecked(true);
                mBinding.llOther.setVisibility(View.GONE);
                mBinding.llModel.setVisibility(View.VISIBLE);
            }
        });
        mBinding.cbOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.cbOther.setChecked(true);
                mBinding.cbModel.setChecked(false);
                mBinding.llOther.setVisibility(View.VISIBLE);
                mBinding.llModel.setVisibility(View.GONE);
            }
        });
        mBinding.cbGateway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.cbGateway.setChecked(true);
                mBinding.cbSensor.setChecked(false);

            }
        });
        mBinding.cbSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.cbGateway.setChecked(false);
                mBinding.cbSensor.setChecked(true);

            }
        });
        mBinding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type = mBinding.cbSensor.isChecked() ? 0 : 1;

                if (mBinding.cbModel.isChecked()){//根据型号
                    if (TextUtils.isEmpty(mBinding.etModel.getText().toString())){
                        ToastUtil.showToast("请输入型号");
                        return;
                    }
                    ComponentResultActivity.list = ApiQuery.queryComponentByModel(0).getData().getList();
                }else{//根据其他条件
                    ComponentResultActivity.list = ApiQuery.queryComponentByOther(0).getData().getList();
                }
                startActivity(new Intent(getActivity(), ComponentResultActivity.class));
            }
        });
    }
}
