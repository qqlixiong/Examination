package com.shlw.cloudclassroom.home.student.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.holder.home.student.ExamsCenterViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 题库中心
 */
public class ExamsCenterActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_exams_center)
    RecyclerView rvExamsCenter;

    @OnClick(R.id.ib_back)
    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("题库中心");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_exams_center;
    }

    protected void initRecyclerView() {
        List<String> list = new ArrayList<>();
        String[] name = new String[]{"病理学", "护理学", "药理学", "中医学"};
        /*for (int i=0;i<name.length;i++){
            HomeListBean homeListBean = new HomeListBean();
            homeListBean.imageId = resourceId[i];
            homeListBean.name = name[i];
            list.add(homeListBean);
        }*/
        for (int i = 0; i < name.length; i++) {
            list.add(name[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        rvExamsCenter.setLayoutManager(linearLayoutManager);
//        rvExamsCenter.addItemDecoration(new DividerListItemDecoration(this,
//                DividerListItemDecoration.VERTICAL_LIST));
        rvExamsCenter.setAdapter(new ModelRecyclerAdapter<String>(ExamsCenterViewHolder.class, list));
    }
}
