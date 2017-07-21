package com.shlw.cloudclassroom.home.teacher;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.holder.home.teacher.InformationViewHolder;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 信息查询
 */
public class InformationSearchActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_information)
    RecyclerView rvInformation;

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("信息查询");
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        String[] name = new String[]{
                "临床第一阶段模拟考试",
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
        rvInformation.setLayoutManager(linearLayoutManager);
//        rvInformation.addItemDecoration(new DividerListItemDecoration(this,
//                DividerListItemDecoration.VERTICAL_LIST));
        rvInformation.setAdapter(new ModelRecyclerAdapter<String>(InformationViewHolder.class,list));
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_information_search;
    }

}
