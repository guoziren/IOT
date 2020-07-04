package com.ustc.iot.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.ustc.iot.R;
import com.ustc.iot.databinding.ActivitySearchBinding;
import com.ustc.iot.fragment.search.SearchFragment;
import com.ustc.iot.fragment.search.SearchFragment2;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding mBinding;
    private SearchFragment2 mSearchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_search);
        init();
    }

    private void init() {
        setSupportActionBar(mBinding.toolbar);
        mBinding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(mSearchFragment == null)
            mSearchFragment = new SearchFragment2();
        transaction.replace(R.id.content,mSearchFragment);
        transaction.commit();
    }



}
