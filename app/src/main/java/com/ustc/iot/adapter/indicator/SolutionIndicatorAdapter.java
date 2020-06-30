package com.ustc.iot.adapter.indicator;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/*
 * 包名：      com.blts.himalaya.adapters
 * 文件名：      IndicatorAdapter
 * 创建时间：      2020/4/8 9:30 AM
 *
 */
public class SolutionIndicatorAdapter extends CommonNavigatorAdapter {

    private final String[] mTitle;
    private OnIndicatorTabClickListener mListener;

    public SolutionIndicatorAdapter(Context context) {
//        mTitle = context.getResources().getStringArray();
        mTitle = new String[]{"创建解决方案", "解决方案管理"};
    }

    @Override
    public int getCount() {
        if (mTitle != null){
            return mTitle.length;
        }
        return 0;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
        colorTransitionPagerTitleView.setNormalColor(Color.parseColor("#aaffffff"));
        colorTransitionPagerTitleView.setSelectedColor(Color.parseColor("#ffffff"));
        colorTransitionPagerTitleView.setTextSize(18);
        colorTransitionPagerTitleView.setText(mTitle[index]);
        colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换viewpager
                if (mListener != null){
                    mListener.onTabClick(index);
                }
            }
        });
        return colorTransitionPagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
        linePagerIndicator.setColors(Color.parseColor("#ffffff"));
        return linePagerIndicator;
    }

    public void setOnIndicatorTabClickListener(OnIndicatorTabClickListener listener){
        this.mListener = listener;
    }

    public interface OnIndicatorTabClickListener{
        void onTabClick(int index);
    }
}
