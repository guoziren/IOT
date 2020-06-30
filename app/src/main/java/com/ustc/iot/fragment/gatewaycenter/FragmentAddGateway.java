package com.ustc.iot.fragment.gatewaycenter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ustc.iot.R;
import com.ustc.iot.databinding.FragmentAddGatewayBinding;
import com.ustc.iot.model.API;
import com.ustc.iot.network.ApiComponent;
import com.ustc.iot.util.LogUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/*
 * 包名：      com.ustc.iot.fragment.gatewaycenter
 * 文件名：      FragmentAddGateway
 * 创建时间：      2020/5/28 4:42 PM
 *
 */
public class FragmentAddGateway extends Fragment {

    private static final String TAG = "FragmentAddGateway";
    private FragmentAddGatewayBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_gateway,container,false);
        View view = mBinding.getRoot();
        mBinding.setAddGatewayModel(new AddGateWayViewModel(mBinding));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}
