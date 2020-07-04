package com.ustc.iot.fragment.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustc.iot.R;
import com.ustc.iot.activity.HomeActivity;
import com.ustc.iot.adapter.GatewayPagerAdapter;
import com.ustc.iot.adapter.SolutionPagerAdapter;
import com.ustc.iot.adapter.indicator.GatewayIndicatorAdapter;
import com.ustc.iot.adapter.indicator.ProjectIndicatorAdapter;
import com.ustc.iot.databinding.FragmentProjectBinding;
import com.ustc.iot.fragment.sensor.AddSensorViewModel;

import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/*
 * 包名：      com.ustc.iot.fragment.project
 * 文件名：      ProjectFragment
 * 创建时间：      2020/7/2 4:45 PM
 *
 */
public class ProjectFragment extends Fragment {

    private FragmentProjectBinding mMBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_project,container,false);

        return mMBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        init();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMBinding.mainProjectIndicator.setBackgroundColor(this.getResources().getColor(R.color.mainColor));
        //创建网关Indicator的适配器
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdjustMode(true);//平分宽度
        ProjectIndicatorAdapter adapter = new ProjectIndicatorAdapter(getActivity());
        adapter.setOnIndicatorTabClickListener(new ProjectIndicatorAdapter.OnIndicatorTabClickListener() {
            @Override
            public void onTabClick(int index) {
                mMBinding.pagerProject.setCurrentItem(index);
            }
        });
        commonNavigator.setAdapter(adapter);

        mMBinding.mainProjectIndicator.setNavigator(commonNavigator);


        ViewPagerHelper.bind(mMBinding.mainProjectIndicator,mMBinding.pagerProject);




        FragmentManager fragmentManager = getChildFragmentManager();
        SolutionPagerAdapter solutionPagerAdapter = new SolutionPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        mMBinding.pagerProject.setAdapter(solutionPagerAdapter);
    }

    private void init() {
        HomeActivity activity = (HomeActivity)getActivity();
        activity.getHomeBinding().toolbar.setVisibility(View.GONE);
//        activity.getHomeBinding().toolbar.setTitle("查询中心");
    }
}
