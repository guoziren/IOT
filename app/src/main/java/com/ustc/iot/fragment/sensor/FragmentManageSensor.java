package com.ustc.iot.fragment.sensor;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ustc.iot.R;
import com.ustc.iot.adapter.SensorRecyclerAdapter;
import com.ustc.iot.fragment.gatewaycenter.GatewayBean;
import com.ustc.iot.fragment.solution.NickName;
import com.ustc.iot.model.entity.Sensor;
import com.ustc.iot.util.LogUtil;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*
 * 包名：      com.ustc.iot.fragment.gatewaycenter
 * 文件名：      FragmentAddGateway
 * 创建时间：      2020/5/28 4:42 PM
 *
 */
public class FragmentManageSensor extends Fragment {
    private static final String TAG = "FragmentManageSensor";

    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_manage_sensor,container,false);
        mRecyclerView = view.findViewById(R.id.rv_sensor);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        SensorRecyclerAdapter adapter = new SensorRecyclerAdapter();
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.top = UIUtil.dip2px(view.getContext(),5);
                outRect.bottom = UIUtil.dip2px(view.getContext(),5);;
                outRect.left = UIUtil.dip2px(view.getContext(),15);;
                outRect.right = UIUtil.dip2px(view.getContext(),15);;
            }
        });
        adapter.setData(getSensorData());
        return view;
    }
    private List<SensorBean> getSensorData() {
        List<SensorBean> gateways = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SensorBean gateway = new SensorBean();
            gateway.setName(NickName.generateName2() + "传感器");
            HashMap<String,String> map = new HashMap<>();
            map.put("产品编号","1843-351");
            map.put("功能类型","毫米波传感器");
            map.put("使用环境","工作温度范围：-40~125°");
            map.put("输入电压","DC 9-25V");
            map.put("包装特性","108 mm2: 10.4 x 10.4 (FC/CSP|161) ");
            map.put("产品描述","76GHz 至 81GHz 高性能汽车类 MMIC");
            gateway.setMap(map);
            gateways.add(gateway);
        }
        LogUtil.d(TAG, "getGatewayData: " + gateways.size());
        return gateways;
    }
}
