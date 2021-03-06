package com.ustc.iot.adapter;

import com.ustc.iot.util.FragmentCreator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/*
 * 包名：      com.ustc.iot.adapter
 * 文件名：      GatewayPageAdapter
 * 创建时间：      2020/5/28 4:51 PM
 *
 */
public class SensorPagerAdapter extends FragmentPagerAdapter {
    public SensorPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FragmentCreator.getSensorFragment(position);
    }

    @Override
    public int getCount() {
        return FragmentCreator.SENSOR_PAGE_COUNT;
    }
}
