package com.shlw.cloudclassroom.my.activity;

import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("设置");
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }

    @OnClick(R.id.textView_change_password)
    public void changePassword(View view){
        IntentUtil.startActivity(this,ChangePasswordActivity.class);
    }
}
