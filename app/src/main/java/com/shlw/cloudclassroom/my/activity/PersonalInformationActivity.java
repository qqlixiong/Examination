package com.shlw.cloudclassroom.my.activity;

import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 个人信息
 */
public class PersonalInformationActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("个人信息");
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_information;
    }
}
