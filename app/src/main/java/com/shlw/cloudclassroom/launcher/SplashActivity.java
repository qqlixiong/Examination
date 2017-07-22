package com.shlw.cloudclassroom.launcher;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;

import com.shlw.cloudclassroom.MainMainActivity;
import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.login.LoginActivity;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;
import com.shlw.cloudclassroom.pubilc.util.SharedPreferenceUtil;

public class SplashActivity extends BaseActivity implements NoStatusBar{
    private boolean isFirstLauncher;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == Constant.SPLASH_WHAT){
                startNextActivity();
            }
        }
    };

    private void startNextActivity() {
        if (!isFirstLauncher){
            isFirstLauncher = true;
            SharedPreferenceUtil sharedPreferenceUtil = new SharedPreferenceUtil(SplashActivity.this,Constant.SP);
            if(sharedPreferenceUtil.get(Constant.LOGIN_SUCCESS,false)){
                IntentUtil.startActivity(SplashActivity.this, MainMainActivity.class);
            }else {
                IntentUtil.startActivity(SplashActivity.this, LoginActivity.class);
            }
            finish();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        startNextActivity();
        return super.onTouchEvent(event);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initData() {
        super.initData();
        handler.sendEmptyMessageDelayed(Constant.SPLASH_WHAT,2000);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
