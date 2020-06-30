package com.ustc.iot.fragment.sensor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ustc.iot.R;
import com.ustc.iot.databinding.FragmentAddGatewayBinding;
import com.ustc.iot.databinding.FragmentAddSensorBinding;
import com.ustc.iot.fragment.gatewaycenter.AddGateWayViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/*
 * 包名：      com.ustc.iot.fragment.gatewaycenter
 * 文件名：      FragmentAddGateway
 * 创建时间：      2020/5/28 4:42 PM
 *
 */
public class FragmentAddSensor extends Fragment {


    private FragmentAddSensorBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_sensor,container,false);
        View view = mBinding.getRoot();
        mBinding.setAddSensorModel(new AddSensorViewModel(mBinding));
        return view;
    }
}
