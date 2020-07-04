package com.ustc.iot.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ustc.iot.R;
import com.ustc.iot.databinding.ActivityHomeBinding;
import com.ustc.iot.fragment.project.ProjectFragment;
import com.ustc.iot.fragment.search.SearchFragment2;
import com.ustc.iot.fragment.usermanagement.UserFragment;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mHomeBinding;
    private ProjectFragment mProjectFragment;
    private UserFragment mUserFragment;
    private SearchFragment2 mSearchFragment2;

    public ActivityHomeBinding getHomeBinding() {
        return mHomeBinding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mHomeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        setSupportActionBar(mHomeBinding.toolbar);
        init();
    }

    private void init() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (mProjectFragment == null){
            mProjectFragment = new ProjectFragment();
        }
        transaction.replace(R.id.mainContent,mProjectFragment);
        transaction.commit();

        mHomeBinding.bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.project_center:
                        if (mProjectFragment == null){
                            mProjectFragment = new ProjectFragment();
                        }
                        transaction.replace(R.id.mainContent,mProjectFragment);
                        transaction.commit();
                        break;
                    case R.id.search_icon:
//                        showMenu(mHomeBinding.bottomView);
//                        startActivity(new Intent(HomeActivity.this,SearchActivity.class));
                        if ( mSearchFragment2 == null){
                        mSearchFragment2 = new SearchFragment2();
                        }
                        transaction.replace(R.id.mainContent,mSearchFragment2);
                        transaction.commit();
                        break;
                    case R.id.user_center:
                        if (mUserFragment == null){
                            mUserFragment = new UserFragment();
                        }
                        transaction.replace(R.id.mainContent,mUserFragment);
                        transaction.commit();
                        break;
                }
                return true;
            }
        });
    }

}
