package com.ustc.iot.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ustc.iot.R;
import com.ustc.iot.fragment.sensor.SensorBean;
import com.ustc.iot.model.entity.Sensor;
import com.ustc.iot.util.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 * 包名：      com.ustc.iot.adapter
 * 文件名：      GatewayRecyclerAdapter
 * 创建时间：      2020/5/28 7:43 PM
 *
 */
public class SensorRecyclerAdapter extends RecyclerView.Adapter<SensorRecyclerAdapter.Holder> {
    private List<SensorBean> mSensorList = new ArrayList<>();
    private static final String TAG = "SensorRecyclerAdapter";


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LogUtil.e(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sensor,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        LogUtil.e(TAG, "onBindViewHolder: ");
        holder.itemView.setTag(position);
        holder.setData(mSensorList.get(position));
    }
    public void setData(List<SensorBean> gateways) {
        if (mSensorList != null){
            mSensorList.clear();
            mSensorList.addAll(gateways);
        }
        //更新UI
        notifyDataSetChanged();

    }
    @Override
    public int getItemCount() {
        return mSensorList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull View itemView) {
            super(itemView);
        }
        public void setData(SensorBean sensor){
//            if (gateway == null){
//                return;
//            }
//            TextView tv_num = itemView.findViewById(R.id.tv_num);
//            TextView tv_company = itemView.findViewById(R.id.tv_company);
//            TextView tv_name = itemView.findViewById(R.id.tv_name);
//            TextView tv_trade = itemView.findViewById(R.id.tv_created_person_name);
//            tv_num.setText("1");
//            tv_company.setText(sensor.getCompany());
//            tv_name.setText(sensor.getName());
//            tv_trade.setText(sensor.getTrade());
            TextView tv_name1 = itemView.findViewById(R.id.name);
            TextView tv_value1 = itemView.findViewById(R.id.value);
            tv_name1.setText("传感器名称");
            tv_value1.setText(sensor.getName());
            HashMap<String,String> map = sensor.getMap();
            for (String s : map.keySet()) {
                View v = LayoutInflater.from(itemView.getContext()).inflate(R.layout.item_item_ll, (ViewGroup) itemView,false);
                TextView tv_name = v.findViewById(R.id.tv_name);
                TextView tv_value = v.findViewById(R.id.tv_value);
                tv_name.setText(s);
                tv_value.setText(map.get(s));
                ((ViewGroup) itemView).addView(v);
            }
        }
    }
}
