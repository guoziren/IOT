package com.ustc.iot.fragment.gatewaycenter;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ustc.iot.R;
import com.ustc.iot.adapter.GatewayRecyclerAdapter;
import com.ustc.iot.model.Gateway;
import com.ustc.iot.util.LogUtil;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.ArrayList;
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

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.top = UIUtil.dip2px(view.getContext(),5);
                outRect.bottom = UIUtil.dip2px(view.getContext(),5);;
                outRect.left = UIUtil.dip2px(view.getContext(),5);;
                outRect.right = UIUtil.dip2px(view.getContext(),5);;
            }
        });
        adapter.setData(getGatewayData());
        return view;
    }

    private List<Gateway> getGatewayData() {
        List<Gateway> gateways = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Gateway gateway = new Gateway();
            gateway.setCompany("小米科技" + i);
            gateway.setName("小米网关" + i);
            gateway.setTrade("电子/硬件/互联网" + i);
            gateways.add(gateway);

        }
        LogUtil.d(TAG, "getGatewayData: " + gateways.size());
        return gateways;
    }
}
