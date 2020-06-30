package com.ustc.iot.fragment.gatewaycenter;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ustc.iot.R;
import com.ustc.iot.adapter.GatewayRecyclerAdapter;
import com.ustc.iot.fragment.solution.NickName;
import com.ustc.iot.model.entity.Gateway;
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
public class FragmentManageGateway extends Fragment {
    private static final String TAG = "FragmentManageGateway";


    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       LogUtil.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_manage_gateway,container,false);
        mRecyclerView = view.findViewById(R.id.rv_gateway);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        GatewayRecyclerAdapter adapter = new GatewayRecyclerAdapter();
        mRecyclerView.setAdapter(adapter);
        if (mRecyclerView.getItemDecorationCount() == 0) {
            mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                    outRect.top = UIUtil.dip2px(view.getContext(),5);
                    outRect.bottom = UIUtil.dip2px(view.getContext(),5);;
                    outRect.left = UIUtil.dip2px(view.getContext(),15);;
                    outRect.right = UIUtil.dip2px(view.getContext(),15);;
                }
            });
        }

        adapter.setData(getGatewayData());
        return view;
    }

    private List<GatewayBean> getGatewayData() {
        List<GatewayBean> gateways = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GatewayBean gateway = new GatewayBean();
            gateway.setName(NickName.generateName2() + "网关");
            HashMap<String,String> map = new HashMap<>();
            map.put("网间协议","RS-351");
            map.put("上传协议","UDP");
            map.put("可否充电","是");
            map.put("输入电压","DC 9-25V");
            map.put("传感器介绍","支持2g 3g ");
            map.put("所属公司","上海华三");
            gateway.setMap(map);
            gateways.add(gateway);
        }
        LogUtil.d(TAG, "getGatewayData: " + gateways.size());
        return gateways;
    }
}
