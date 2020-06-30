package com.ustc.iot.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.ustc.iot.R;
import com.ustc.iot.adapter.GatewayPagerAdapter;
import com.ustc.iot.adapter.SensorPagerAdapter;
import com.ustc.iot.adapter.SolutionPagerAdapter;
import com.ustc.iot.adapter.indicator.GatewayIndicatorAdapter;
import com.ustc.iot.adapter.indicator.SensorIndicatorAdapter;
import com.ustc.iot.adapter.indicator.SolutionIndicatorAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPagerGateway;
    private ViewPager mPagerSensor;
    private LinearLayout mGatewayLLButton;
    private LinearLayout mSensorLLButton;
    private LinearLayout mGatewayLL;
    private LinearLayout mSensorLL;
    private MagicIndicator mGatewayIndicator;
    private MagicIndicator mSensorIndicator;
    private GatewayIndicatorAdapter mGatewayIndicatorAdapter;
    private SensorIndicatorAdapter msensorIndicatorAdapter;
    private LinearLayout mSolutionLL;
    private MagicIndicator mSolutionIndicator;
    private SolutionIndicatorAdapter mSolutionIndicatorAdapter;
    private LinearLayout mSolutionLLButton;
    private ViewPager mPagerSolution;
    private LinearLayout mDashboardLLButton;
    private LinearLayout mDashboardLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        mGatewayLLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGatewayLL.setVisibility(View.VISIBLE);
                mSensorLL.setVisibility(View.GONE);
                mSolutionLL.setVisibility(View.GONE);
                mDashboardLL.setVisibility(View.GONE);
            }
        });
        mSensorLLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGatewayLL.setVisibility(View.GONE);
                mSensorLL.setVisibility(View.VISIBLE);
                mSolutionLL.setVisibility(View.GONE);
                mDashboardLL.setVisibility(View.GONE);
            }
        });
        mSolutionLLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGatewayLL.setVisibility(View.GONE);
                mSensorLL.setVisibility(View.GONE);
                mDashboardLL.setVisibility(View.GONE);
                mSolutionLL.setVisibility(View.VISIBLE);
            }
        });
        mDashboardLLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGatewayLL.setVisibility(View.GONE);
                mSensorLL.setVisibility(View.GONE);
                mSolutionLL.setVisibility(View.GONE);
                mDashboardLL.setVisibility(View.VISIBLE);
            }
        });



        mGatewayIndicatorAdapter.setOnIndicatorTabClickListener(new GatewayIndicatorAdapter.OnIndicatorTabClickListener() {
            @Override
            public void onTabClick(int index) {
                mPagerGateway.setCurrentItem(index);
            }
        });
        msensorIndicatorAdapter.setOnIndicatorTabClickListener(new SensorIndicatorAdapter.OnIndicatorTabClickListener() {
            @Override
            public void onTabClick(int index) {
                mPagerSensor.setCurrentItem(index);
            }
        });
        mSolutionIndicatorAdapter.setOnIndicatorTabClickListener(new SolutionIndicatorAdapter.OnIndicatorTabClickListener() {
            @Override
            public void onTabClick(int index) {
                mPagerSolution.setCurrentItem(index);
            }
        });
    }

    private void initView() {
        mPagerGateway = findViewById(R.id.pager_gateway);
        mPagerSensor = findViewById(R.id.pager_sensor);
        mPagerSolution = findViewById(R.id.pager_solution);
//        Toolbar toobar = findViewById(R.id.toolbar);
//        toobar.setTitle("物联网组网分析引擎");
//        setSupportActionBar(toobar);
        //网关中心
        mGatewayLLButton = findViewById(R.id.main_l1);
        //传感器中心
        mSensorLLButton = findViewById(R.id.main_l2);
        //仪表盘
        mDashboardLLButton = findViewById(R.id.main_l3);
        //解决方案中心
        mSolutionLLButton = findViewById(R.id.main_l4);

        mGatewayLL = findViewById(R.id.ll_gateway);
        mGatewayLL.setVisibility(View.VISIBLE);
        mSensorLL = findViewById(R.id.ll_sensor);
        mDashboardLL = findViewById(R.id.ll_dashboard);
        mSolutionLL = findViewById(R.id.ll_solution);
        //指示器
        mGatewayIndicator = findViewById(R.id.main_gateway_indicator);
        mSensorIndicator = findViewById(R.id.main_sensor_indicator);
        mSolutionIndicator = findViewById(R.id.main_solution_indicator);

        mGatewayIndicator.setBackgroundColor(this.getResources().getColor(R.color.mainColor));
        //创建网关Indicator的适配器
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);//平分宽度
        mGatewayIndicatorAdapter = new GatewayIndicatorAdapter(this);
        commonNavigator.setAdapter(mGatewayIndicatorAdapter);
        mGatewayIndicator.setNavigator(commonNavigator);

        mSensorIndicator.setBackgroundColor(this.getResources().getColor(R.color.mainColor));
        //创建传感器Indicator的适配器
        CommonNavigator commonNavigator2 = new CommonNavigator(this);
        commonNavigator2.setAdjustMode(true);//平分宽度
        msensorIndicatorAdapter = new SensorIndicatorAdapter(this);
        commonNavigator2.setAdapter(msensorIndicatorAdapter);
        mSensorIndicator.setNavigator(commonNavigator2);

        mSolutionIndicator.setBackgroundColor(this.getResources().getColor(R.color.mainColor));
        //创建解决方案Indicator的适配器
        CommonNavigator commonNavigator3 = new CommonNavigator(this);
        commonNavigator3.setAdjustMode(true);//平分宽度
        mSolutionIndicatorAdapter = new SolutionIndicatorAdapter(this);
        commonNavigator3.setAdapter(mSolutionIndicatorAdapter);
        mSolutionIndicator.setNavigator(commonNavigator3);

        //绑定指示器和viewpager
        ViewPagerHelper.bind(mSensorIndicator,mPagerSensor);
        ViewPagerHelper.bind(mGatewayIndicator,mPagerGateway);
        ViewPagerHelper.bind(mSolutionIndicator,mPagerSolution);




        FragmentManager fragmentManager = getSupportFragmentManager();
        GatewayPagerAdapter gatewayPagerAdapter = new GatewayPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mPagerGateway.setAdapter(gatewayPagerAdapter);

        SensorPagerAdapter sensorPagerAdapter = new SensorPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mPagerSensor.setAdapter(sensorPagerAdapter);

        SolutionPagerAdapter solutionPagerAdapter = new SolutionPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mPagerSolution.setAdapter(solutionPagerAdapter);

    }
}
