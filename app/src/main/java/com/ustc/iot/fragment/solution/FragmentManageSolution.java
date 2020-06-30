package com.ustc.iot.fragment.solution;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustc.iot.R;
import com.ustc.iot.adapter.SolutionRecyclerAdapter;
import com.ustc.iot.model.entity.Solution;
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
public class FragmentManageSolution extends Fragment {
    private static final String TAG = "FragmentManageSolution";

    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_manage_solution,container,false);
        mRecyclerView = view.findViewById(R.id.rv_solution);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        SolutionRecyclerAdapter adapter = new SolutionRecyclerAdapter();
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
        adapter.setData(getSensorData());
        return view;
    }
    private List<Solution> getSensorData() {
        List<Solution> solutions = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Solution solution = new Solution();
            solution.setCompany(NickName.generateName3(NickName.noun));
            solution.setName(NickName.generateName3(NickName.type));
            solution.setCreatedPersonName(NickName.generateName3(NickName.people));
            solution.setAddress(NickName.generateName3(NickName.address));
            solution.setDesc(NickName.generateName3(NickName.desc));
            solutions.add(solution);

        }
        LogUtil.d(TAG, "getSensorData: " + solutions.size());
        return solutions;
    }
}
