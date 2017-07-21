package com.shlw.cloudclassroom.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.LogUtil;
import com.shlw.cloudclassroom.pubilc.util.SharedPreferenceUtil;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    /**
     * 学生端和教师端的标记
     */
    public int flag;
    /**
     * 标题
     */
    public String title;
    /**
     * 上下文
     */
    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(getFragmentLayoutId(), null);
        ButterKnife.bind(this, view);
        return view;
    }

    /**
     * 强制子类重写，实现子类特有的ui
     * @return
     */
    protected abstract int getFragmentLayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        initRecyclerView();
    }

    /**
     * 当孩子需要初始化数据，或者联网请求绑定数据，展示数据的 等等可以重写该方法
     */
    protected void initData() {
        SharedPreferenceUtil sharedPreferenceUtil = new SharedPreferenceUtil(mContext, Constant.SP);
        flag = sharedPreferenceUtil.get(Constant.FLAG,Constant.STUDENT);
        /*Bundle bundle = getArguments();
        LogUtil.i("initData() ："+bundle);
        if(bundle != null){
            title = bundle.getString(Constant.NAME,"");
        }*/
    }

    protected void initRecyclerView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
