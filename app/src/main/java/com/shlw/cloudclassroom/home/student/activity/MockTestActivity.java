package com.shlw.cloudclassroom.home.student.activity;

import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class MockTestActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mock_test;
    }

    @OnClick(R.id.button_start)
    public void start(View view){
        IntentUtil.startActivity(this,TestActivity.class);
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("模拟测试");
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }
}
