package com.shlw.cloudclassroom.repository;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseFragment;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.holder.repository.ChildQuestionBankViewHolder;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.LogUtil;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 子题库
 */
public class ChildQuestionBankFragment extends BaseFragment {

    @Bind(R.id.rv_child_question_bank)
    RecyclerView rvChildQuestionBank;

    public static final ChildQuestionBankFragment newInstance(String name)
    {
        ChildQuestionBankFragment fragment = new ChildQuestionBankFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.NAME, name);
        LogUtil.i("标题："+name);
        fragment.setArguments(bundle);

        return fragment ;
    }

    @Override
    protected void initData() {
        super.initData();
        title = "子题库";
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_child_question_bank;
    }

    protected void initRecyclerView() {
        List<String> list = new ArrayList<>();
        String[] name = new String[]{"病理学","护理学","药理学","中医学"};
        /*for (int i=0;i<name.length;i++){
            HomeListBean homeListBean = new HomeListBean();
            homeListBean.imageId = resourceId[i];
            homeListBean.name = name[i];
            list.add(homeListBean);
        }*/
        for(int i=0;i<name.length;i++){
            list.add(name[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL, false);
        rvChildQuestionBank.setLayoutManager(linearLayoutManager);
//        rvChildQuestionBank.addItemDecoration(new DividerListItemDecoration(mContext,
//                DividerListItemDecoration.VERTICAL_LIST));
        rvChildQuestionBank.setAdapter(new ModelRecyclerAdapter<String>(ChildQuestionBankViewHolder.class,list));
    }
}
