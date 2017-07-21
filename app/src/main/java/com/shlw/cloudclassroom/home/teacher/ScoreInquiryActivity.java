package com.shlw.cloudclassroom.home.teacher;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.holder.home.teacher.InformationViewHolder;
import com.shlw.cloudclassroom.holder.home.teacher.ScoreInquiryViewHolder;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 成绩查询
 */
public class ScoreInquiryActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_score_inquiry)
    RecyclerView rvScoreInquiry;

    @Override
    public int getLayoutId() {
        return R.layout.activity_score_inquiry;
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("成绩查询");
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        String[] name = new String[]{
                "中医理论基础摸底考试",
                "中医理论基础摸底考试",
                "中医理论基础摸底考试"};
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
        rvScoreInquiry.setLayoutManager(linearLayoutManager);
//        rvScoreInquiry.addItemDecoration(new DividerListItemDecoration(this,
//                DividerListItemDecoration.VERTICAL_LIST));
        rvScoreInquiry.setAdapter(new ModelRecyclerAdapter<String>(ScoreInquiryViewHolder.class,list));
    }

}
