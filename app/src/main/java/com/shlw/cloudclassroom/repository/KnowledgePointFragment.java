package com.shlw.cloudclassroom.repository;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseFragment;
import com.shlw.cloudclassroom.pubilc.Constant;

/**
 * 知识点
 */
public class KnowledgePointFragment extends BaseFragment {

    public static final KnowledgePointFragment newInstance(String name)
    {
        KnowledgePointFragment fragment = new KnowledgePointFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.NAME, name);
        fragment.setArguments(bundle);

        return fragment ;
    }

    @Override
    protected void initData() {
        super.initData();
        title = "知识点";
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_knowledge_point;
    }

}
