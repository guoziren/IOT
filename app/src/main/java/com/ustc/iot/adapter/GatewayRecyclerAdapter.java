package com.ustc.iot.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ustc.iot.R;
import com.ustc.iot.model.Gateway;
import com.ustc.iot.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 * 包名：      com.ustc.iot.adapter
 * 文件名：      GatewayRecyclerAdapter
 * 创建时间：      2020/5/28 7:43 PM
 *
 */
public class GatewayRecyclerAdapter extends RecyclerView.Adapter<GatewayRecyclerAdapter.Holder> {
    private List<Gateway> mGatewayList = new ArrayList<>();
    private static final String TAG = "GatewayRecyclerAdapter";


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LogUtil.e(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gateway,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        LogUtil.e(TAG, "onBindViewHolder: ");
        holder.itemView.setTag(position);
        holder.setData(mGatewayList.get(position));
    }
    public void setData(List<Gateway> gateways) {
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
        public void setData(Gateway gateway){
//            if (gateway == null){
//                return;
//            }
            TextView tv_num = itemView.findViewById(R.id.tv_num);
            TextView tv_company = itemView.findViewById(R.id.tv_company);
            TextView tv_name = itemView.findViewById(R.id.tv_name);
            TextView tv_trade = itemView.findViewById(R.id.tv_trade);
            tv_num.setText("1");
            tv_company.setText(gateway.getCompany());
            tv_name.setText(gateway.getName());
            tv_trade.setText(gateway.getTrade());
        }
    }
}
