package com.shlw.cloudclassroom.home.student.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.holder.home.student.MockCenterViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 模拟中心
 */
public class MockCenterActivity extends BaseActivity {

    @Bind(R.id.rv_mock_center)
    RecyclerView rvMockCenter;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mock_center;
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("模拟中心");
    }

    protected void initRecyclerView() {
        List<Integer> list = new ArrayList<>();
        int[] resourceId = new int[]{R.drawable.examcenter, R.drawable.mock_exam, R.drawable.examrecord};
        for (int i = 0; i < resourceId.length; i++) {
            list.add(resourceId[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        rvMockCenter.setLayoutManager(linearLayoutManager);
        rvMockCenter.setAdapter(new ModelRecyclerAdapter<Integer>(MockCenterViewHolder.class, list));
    }
}
