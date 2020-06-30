package com.ustc.iot.util;

import com.ustc.iot.fragment.gatewaycenter.FragmentAddGateway;
import com.ustc.iot.fragment.gatewaycenter.FragmentManageGateway;
import com.ustc.iot.fragment.sensor.FragmentAddSensor;
import com.ustc.iot.fragment.sensor.FragmentManageSensor;
import com.ustc.iot.fragment.solution.FragmentAddSolution;
import com.ustc.iot.fragment.solution.FragmentManageSolution;

import java.util.HashMap;
import java.util.Map;

import androidx.fragment.app.Fragment;

/*
 * 包名：      com.ustc.iot.util
 * 文件名：      FragmentCreator
 * 创建时间：      2020/5/28 4:52 PM
 *
 */
public class FragmentCreator {
    //网关
    public static final int INDEX_ADD_GATEWAY = 0 ;
    public static final int INDEX_MANAGE_GATEWAY = 1 ;
    public static final int GATEWAY_PAGE_COUNT = 2;
    //传感器
    public static final int INDEX_ADD_SENSOR = 0 ;
    public static final int INDEX_MANAGE_SENSOR = 1 ;
    public static final int SENSOR_PAGE_COUNT = 2;
    //解决方案
    public static final int INDEX_ADD_SOLUTION = 0 ;
    public static final int INDEX_MANAGE_SOLUTION = 1 ;
    public static final int SOLUTION_PAGE_COUNT = 2;


    private static Map<Integer, Fragment> sGatewayMap = new HashMap<>();
    private static Map<Integer, Fragment> sSensorMap = new HashMap<>();
    private static Map<Integer, Fragment> sSolutionMap = new HashMap<>();

    public static Fragment getGatewayFragment(int index){
        Fragment fragment = sGatewayMap.get(index);
        if (fragment != null){
            return fragment;
        }
        switch (index){
            case INDEX_ADD_GATEWAY:
                fragment = new FragmentAddGateway();
                break;
            case INDEX_MANAGE_GATEWAY:
                fragment = new FragmentManageGateway();
                break;
        }
        sGatewayMap.put(index,fragment);
        return fragment;
    }
    public static Fragment getSensorFragment(int index){
        Fragment fragment = sSensorMap.get(index);
        if (fragment != null){
            return fragment;
        }
        switch (index){
            case INDEX_ADD_SENSOR:
                fragment = new FragmentAddSensor();
                break;
            case INDEX_MANAGE_SENSOR:
                fragment = new FragmentManageSensor();
                break;
        }
        sSensorMap.put(index,fragment);
        return fragment;
    }
    public static Fragment getSolutionFragment(int index){
        Fragment fragment = sSolutionMap.get(index);
        if (fragment != null){
            return fragment;
        }
        switch (index){
            case INDEX_ADD_SOLUTION:
                fragment = new FragmentAddSolution();
                break;
            case INDEX_MANAGE_SOLUTION:
                fragment = new FragmentManageSolution();
                break;
        }
        sSolutionMap.put(index,fragment);
        return fragment;
    }
}
