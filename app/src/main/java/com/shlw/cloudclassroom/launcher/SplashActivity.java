package com.shlw.cloudclassroom.launcher;

import android.os.Handler;
import android.os.Message;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.login.LoginActivity;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

public class SplashActivity extends BaseActivity implements NoStatusBar{

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == Constant.SPLASH_WHAT){
                IntentUtil.startActivity(SplashActivity.this, LoginActivity.class);
                finish();
            }
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initData() {
        super.initData();
        handler.sendEmptyMessageDelayed(Constant.SPLASH_WHAT,2000);
    }
}
