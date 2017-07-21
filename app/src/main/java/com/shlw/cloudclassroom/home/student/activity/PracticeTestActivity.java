package com.shlw.cloudclassroom.home.student.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.holder.home.student.PracticeTestViewHolder;
import com.shlw.cloudclassroom.holder.home.student.SingleChoiceViewHolder;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 模拟考试
 */
public class PracticeTestActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_practice_test)
    RecyclerView rvPracticeTest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_practice_test;
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("考试列表");
    }

    protected void initRecyclerView() {
        List<String> list = new ArrayList<>();
        String[] name = new String[]{"临床第一阶段模拟考试",
                "临床第一阶段模拟考试",
                "临床第一阶段模拟考试",
                "临床第一阶段模拟考试",
                "临床第一阶段模拟考试",
                "临床第一阶段模拟考试",
                "临床第一阶段模拟考试",
                "临床第一阶段模拟考试",
                "临床第一阶段模拟考试",
                "临床第一阶段模拟考试",
                "临床第一阶段模拟考试"};
        /*for (int i=0;i<name.length;i++){
            HomeListBean homeListBean = new HomeListBean();
            homeListBean.imageId = resourceId[i];
            homeListBean.name = name[i];
            list.add(homeListBean);
        }*/
        for(int i=0;i<name.length;i++){
            list.add(name[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        rvPracticeTest.setLayoutManager(linearLayoutManager);
//        rvPracticeTest.addItemDecoration(new DividerListItemDecoration(this,
//                DividerListItemDecoration.VERTICAL_LIST));
        rvPracticeTest.setAdapter(new ModelRecyclerAdapter<String>(PracticeTestViewHolder.class,list));
    }
}
