package com.shlw.cloudclassroom.home.teacher;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.holder.home.teacher.OnlineTestingArrangementViewHolder;
import com.shlw.cloudclassroom.holder.home.teacher.ScoreInquiryViewHolder;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 在线排考
 */
public class OnlineTestingArrangementActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_online_testing_arrangement)
    RecyclerView rvOnlineTestingArrangement;

    @Override
    public int getLayoutId() {
        return R.layout.activity_online_testing_arrangement;
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("在线排考");
    }

    @OnClick(R.id.ib_back)
    public void back(View view) {
        onBackPressed();
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        String[] name = new String[]{
                "解剖学模拟",
                "解剖学模拟",
                "解剖学模拟"};
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
        rvOnlineTestingArrangement.setLayoutManager(linearLayoutManager);
//        rvOnlineTestingArrangement.addItemDecoration(new DividerListItemDecoration(this,
//                DividerListItemDecoration.VERTICAL_LIST));
        rvOnlineTestingArrangement.setAdapter(new ModelRecyclerAdapter<String>(OnlineTestingArrangementViewHolder.class,list));
    }
}
