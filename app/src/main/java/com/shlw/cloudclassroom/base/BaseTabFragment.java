package com.shlw.cloudclassroom.base;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ViewPagerAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2017/4/20.
 */

public class BaseTabFragment extends BaseFragment{
    @Bind(R.id.tabLayout)
    public TabLayout tabLayout;
    @Bind(R.id.viewPager)
    public ViewPager viewPager;
    public List<String> titles;

    public ArrayList<BaseFragment> fragments;

    public ViewPagerAdapter adapter;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_tab;
    }

    @Override
    protected void initData() {
        super.initData();
        //初始化数据
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        addFragment();
        addTile();
/*
        // 先强制设置到指定页面

 try {
            Field field = viewPager.getClass().getField("mCurItem");
            field.setAccessible(true);
            field.setInt(viewPager, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }



// 切换到指定页面
        viewPager.setCurrentItem(2);*/
        //设置ViewPager的适配器
        adapter = new ViewPagerAdapter(getFragmentManager(),fragments,titles);

        // 通过数据修改
//        adapter.notifyDataSetChanged();

        viewPager.setAdapter(adapter);

        //关联ViewPager
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(1).select();
        //设置固定的
//        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    protected void addFragment() {
    }

    protected void addTile() {
    }
}
