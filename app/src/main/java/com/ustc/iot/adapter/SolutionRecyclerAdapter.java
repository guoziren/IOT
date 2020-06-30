package com.ustc.iot.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ustc.iot.R;
import com.ustc.iot.model.entity.Solution;
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
public class SolutionRecyclerAdapter extends RecyclerView.Adapter<SolutionRecyclerAdapter.Holder> {
    private List<Solution> mSolutions = new ArrayList<>();
    private static final String TAG = "SolutionRecyclerAdapter";


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LogUtil.e(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solution,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        LogUtil.e(TAG, "onBindViewHolder: ");
        holder.itemView.setTag(position);
        holder.setData(mSolutions.get(position));
    }
    public void setData(List<Solution> solutions) {
        if (mSolutions != null){
            mSolutions.clear();
            mSolutions.addAll(solutions);
        }
        //更新UI
        notifyDataSetChanged();

    }
    @Override
    public int getItemCount() {
        return mSolutions.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull View itemView) {
            super(itemView);
        }
        public void setData(Solution solution){
//            if (gateway == null){
//                return;
//            }
            TextView tv_company = itemView.findViewById(R.id.company);
            TextView tv_name = itemView.findViewById(R.id.tv_value);
            TextView tv_created_person_name = itemView.findViewById(R.id.person);
            TextView address = itemView.findViewById(R.id.address);
            TextView intro = itemView.findViewById(R.id.intro);
            address.setText(solution.getAddress());
            intro.setText(solution.getDesc() + "");
            tv_company.setText(solution.getCompany());
            tv_name.setText(solution.getName());
            tv_created_person_name.setText(solution.getCreatedPersonName());
        }
    }
}
