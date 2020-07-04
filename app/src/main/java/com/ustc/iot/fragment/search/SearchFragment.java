package com.ustc.iot.fragment.search;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.ustc.iot.R;
import com.ustc.iot.adapter.GatewayRecyclerAdapter;
import com.ustc.iot.databinding.FragmentSearchBinding;
import com.ustc.iot.fragment.gatewaycenter.GatewayBean;
import com.ustc.iot.fragment.solution.NickName;
import com.ustc.iot.util.LogUtil;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

/*
 * 包名：      com.ustc.iot.fragment.search
 * 文件名：      SearchFragment
 * 创建时间：      2020/7/2 8:14 PM
 *
 */
public class SearchFragment extends Fragment {
    private static final String TAG = "SearchFragment";
    private FragmentSearchBinding mMBinding;
    private GatewayRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_search,container,false);

        return mMBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new GatewayRecyclerAdapter();
        mMBinding.recyclerview.setAdapter(mAdapter);
        if (mMBinding.recyclerview.getItemDecorationCount() == 0) {
            mMBinding.recyclerview.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                    outRect.top = UIUtil.dip2px(view.getContext(),5);
                    outRect.bottom = UIUtil.dip2px(view.getContext(),5);;
                    outRect.left = UIUtil.dip2px(view.getContext(),15);;
                    outRect.right = UIUtil.dip2px(view.getContext(),15);;
                }
            });
        }
        mMBinding.llPopMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(mMBinding.llPopMenu);
            }
        });

        mMBinding.searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.setData(getGatewayData());
            }
        });




    }

    public void showMenu(View anchor) {
        PopupMenu popup = new PopupMenu(getActivity(), anchor);
        popup.getMenuInflater().inflate(R.menu.test_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.gateway:
                        mMBinding.searchCat.setText(item.getTitle());
                        break;
                    case R.id.sensor:
                        mMBinding.searchCat.setText(item.getTitle());
                        break;
                    case R.id.solution:
                        mMBinding.searchCat.setText(item.getTitle());
                        break;
                }
                return true;
            }
        });
        popup.show();
    }

    private List<GatewayBean> getGatewayData() {
        List<GatewayBean> gateways = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GatewayBean gateway = new GatewayBean();
            gateway.setName(NickName.generateName2() + "网关");
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            map.put("网关名称",gateway.getName());
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
