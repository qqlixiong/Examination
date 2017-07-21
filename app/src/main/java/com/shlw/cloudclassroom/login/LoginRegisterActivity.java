package com.shlw.cloudclassroom.login;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.base.BaseLoginActivity;
import com.shlw.cloudclassroom.pubilc.util.CustomCountDownTimer;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginRegisterActivity extends BaseLoginActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.get_code_button)
    Button getCodeButton;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_register;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("注册");
        initCountDownTimer(getCodeButton);
    }

    /**
     * 获取验证码
     */

    @OnClick(R.id.get_code_button)
    public void getCode(){
        countDownTimer.start();
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }
}
