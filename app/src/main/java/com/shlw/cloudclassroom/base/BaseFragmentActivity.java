package com.shlw.cloudclassroom.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by john on 2017/4/21.
 */

public abstract class BaseFragmentActivity extends FragmentActivity{

    protected Fragment fragment;
    protected int layout_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData();
        //初始化Fragment
        initFragment();
        addFragment();
    }

    protected void addFragment(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(layout_id,fragment);
        transaction.commit();
    }

    protected abstract void initFragment();

    protected abstract void initData();

    protected abstract int getLayoutId();
}
