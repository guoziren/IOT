package com.ustc.iot.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ustc.iot.R;
import com.ustc.iot.fragment.gatewaycenter.GatewayBean;
import com.ustc.iot.util.LogUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 * 包名：      com.ustc.iot.adapter
 * 文件名：      GatewayRecyclerAdapter
 * 创建时间：      2020/5/28 7:43 PM
 *
 */
public class GatewayRecyclerAdapter extends RecyclerView.Adapter<GatewayRecyclerAdapter.Holder> {
    private List<GatewayBean>  mGatewayList = new ArrayList<>();
    private static final String TAG = "GatewayRecyclerAdapter";


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LogUtil.e(TAG, "onCreateViewHolder: ");
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gateway,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        LogUtil.e(TAG, "onBindViewHolder: ");
        holder.itemView.setTag(position);
        ((ViewGroup)holder.itemView).removeAllViews();
        holder.setData(mGatewayList.get(position));
    }
    public void setData(List<GatewayBean>  gateways) {
        if (mGatewayList != null){
            mGatewayList.clear();
            mGatewayList.addAll(gateways);
        }
        //更新UI
        notifyDataSetChanged();

    }
    @Override
    public int getItemCount() {
        return mGatewayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull View itemView) {
            super(itemView);
        }
        public void setData(GatewayBean gateway){

            LinkedHashMap<String, String> map = gateway.getMap();
            Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String ,String>  entry = iterator.next();
                LogUtil.d(TAG, "setData: " + entry.getKey() + "  " + entry.getValue());
            }

            for (String s : map.keySet()) {
                LinearLayout v = (LinearLayout) LayoutInflater.from(itemView.getContext()).inflate(R.layout.item_item_ll, (ViewGroup) itemView,false);

                TextView tv_name = v.findViewById(R.id.tv_name);
                TextView tv_value = v.findViewById(R.id.tv_value);
                tv_name.setText(s);
                tv_value.setText(map.get(s));
                ((ViewGroup) itemView).addView(v);
            }
        }
    }
}
