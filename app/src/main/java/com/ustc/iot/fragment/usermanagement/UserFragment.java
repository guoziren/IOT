package com.ustc.iot.fragment.usermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustc.iot.R;
import com.ustc.iot.activity.HomeActivity;
import com.ustc.iot.activity.LoginActivity2;
import com.ustc.iot.databinding.FragmentUserBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/*
 * 包名：      com.ustc.iot.fragment.usermanagement
 * 文件名：      UserFragment
 * 创建时间：      2020/7/2 4:59 PM
 *
 */
public class UserFragment extends Fragment {

    private FragmentUserBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_user,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        HomeActivity activity = (HomeActivity)getActivity();
        activity.getHomeBinding().toolbar.setVisibility(View.VISIBLE);
        activity.getHomeBinding().toolbar.setTitle("用户中心");
        mBinding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity2.class));
                getActivity().finish();
            }
        });

    }
}
