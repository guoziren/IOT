package com.ustc.iot.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.ustc.iot.R;
import com.ustc.iot.adapter.GatewayRecyclerAdapter;
import com.ustc.iot.adapter.indicator.ComponentAdapter;
import com.ustc.iot.databinding.ActivityComponentResultBinding;
import com.ustc.iot.fragment.gatewaycenter.GatewayBean;
import com.ustc.iot.fragment.search.ResultDialogFragment;
import com.ustc.iot.model.entity.ConditionQueryResponse;
import com.ustc.iot.network.ApiComponent;
import com.ustc.iot.network.ApiQuery;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.ArrayList;
import java.util.List;

public class ComponentResultActivity extends AppCompatActivity implements ComponentAdapter.OnItemClickListener {
    public static List<ConditionQueryResponse.DataBean.ListBean> list = new ArrayList<>();
    private ActivityComponentResultBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_component_result);

        init();
    }

    private void init() {
        ComponentAdapter adapter = new ComponentAdapter();
        setSupportActionBar(mBinding.toolbar);
        mBinding.recyclerview.setAdapter(adapter);
        if ( mBinding.recyclerview.getItemDecorationCount() == 0) {
            mBinding.recyclerview.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                    outRect.top = UIUtil.dip2px(view.getContext(),5);
                    outRect.bottom = UIUtil.dip2px(view.getContext(),5);;
                    outRect.left = UIUtil.dip2px(view.getContext(),15);;
                    outRect.right = UIUtil.dip2px(view.getContext(),15);;
                }
            });
        }
        adapter.setOnItemClickListener(this);
        adapter.setData(list);
    }

    private List<ConditionQueryResponse.DataBean.ListBean> getData() {
        return ApiQuery.queryComponentByModel(0).getData().getList();
    }

    @Override
    public void onClick(ConditionQueryResponse.DataBean.ListBean list) {
        ResultDialogFragment dialogFragment = new ResultDialogFragment(list);
        dialogFragment.show(getSupportFragmentManager(), "result");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        list.clear();
    }
}
