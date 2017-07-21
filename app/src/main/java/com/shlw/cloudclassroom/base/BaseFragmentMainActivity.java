package com.shlw.cloudclassroom.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.interfaces.ICheckedChanged;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by john on 2017/4/16.
 */

public abstract class BaseFragmentMainActivity extends FragmentActivity {

    protected List<BaseFragment> mBaseFragment;
    /**
     * 选中的Fragment的对应的位置
     */
    protected int position;
    /**
     * 上次切换的Fragment
     */
    protected Fragment mContent;
    protected int frameLayoutId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        //初始化Fragment
        initFragment();
        frameLayoutId = initFrameLayoutId();
        //设置RadioGroup的监听
        setListener();
    }

    protected abstract int initFrameLayoutId();

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected void initFragment(){
        mBaseFragment = Arrays.asList(initClass());
    }

    protected abstract BaseFragment[] initClass();

    protected abstract void setListener();

    /**
     * @param from 刚显示的Fragment,马上就要被隐藏了
     * @param to   马上要切换到的Fragment，一会要显示
     */
    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if (!to.isAdded()) {
                //to没有被添加
                //from隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //添加to
                ft.add(frameLayoutId, to).commit();
            } else {
                //to已经被添加
                // from隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //显示to
                ft.show(to).commit();
            }
        }

    }

    protected class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        private ICheckedChanged iCheckedChanged;

        public MyOnCheckedChangeListener(ICheckedChanged iCheckedChanged) {
            this.iCheckedChanged = iCheckedChanged;
        }

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            iCheckedChanged.checkedChanged(group,checkedId);

            //根据位置得到对应的Fragment
            Fragment to = getFragment();
            //替换
            switchFragment(mContent, to);

        }
    }

    /**
     * 根据位置得到对应的Fragment
     *
     * @return
     */
    protected BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }

}
