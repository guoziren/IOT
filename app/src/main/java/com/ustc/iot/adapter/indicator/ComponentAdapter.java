package com.ustc.iot.adapter.indicator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ustc.iot.R;
import com.ustc.iot.fragment.gatewaycenter.GatewayBean;
import com.ustc.iot.model.entity.ConditionQueryResponse;
import com.ustc.iot.util.LogUtil;
import com.ustc.iot.util.ReflectUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.Holder> {
    private List<ConditionQueryResponse.DataBean.ListBean> mComponentList = new ArrayList<>();
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
        holder.setData(mComponentList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onClick(mComponentList.get(position));
                }
            }
        });
    }
    public void setData(List<ConditionQueryResponse.DataBean.ListBean>  gateways) {
        if (mComponentList != null){
            mComponentList.clear();
            mComponentList.addAll(gateways);
        }
        //更新UI
        notifyDataSetChanged();

    }
    @Override
    public int getItemCount() {
        return mComponentList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull View itemView) {
            super(itemView);
        }
        public void setData(ConditionQueryResponse.DataBean.ListBean gateway){
//            String[] fieldNames = ReflectUtil.getFieldName(gateway);
            String[] fieldNames = {"model","industrialGrade","otherDesc"};
            for (int i = 0; i < fieldNames.length; i++) {
                LinearLayout v = (LinearLayout) LayoutInflater.from(itemView.getContext()).inflate(R.layout.item_item_ll, (ViewGroup) itemView,false);

                TextView tv_name = v.findViewById(R.id.tv_name);
                TextView tv_value = v.findViewById(R.id.tv_value);
                tv_name.setText(ReflectUtil.getString(fieldNames[i])+" : ");
                Object value = ReflectUtil.getFieldValueByName(fieldNames[i],gateway);

                tv_value.setText(String.valueOf(value));
                ((ViewGroup) itemView).addView(v);
            }


        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    OnItemClickListener mOnItemClickListener;
     public interface OnItemClickListener{
        void onClick(ConditionQueryResponse.DataBean.ListBean list);
   }

}
