package com.shlw.cloudclassroom.interaction;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class InteractionClassroomActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_interaction_classroom)
    RecyclerView rvInteractionClassroom;

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText(getIntent().getExtras().getString(Constant.NAME));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_interaction_classroom;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<Integer> list = new ArrayList<>();
        int[] ids = new int[]{R.drawable.kejian1,R.drawable.kejian2,R.drawable.kejian3};
        for(int i=0;i<ids.length;i++){
            list.add(ids[i]);
        }
        recyclerViewUtil.initRecyclerView(rvInteractionClassroom,list,
                new LinearLayoutManager(InteractionClassroomActivity.this,
                        LinearLayoutManager.VERTICAL,false),InteractionHolder.class);
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
