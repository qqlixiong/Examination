package com.shlw.cloudclassroom.my.activity;

import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class ChangePasswordActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("修改密码");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_change_password;
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }
}
