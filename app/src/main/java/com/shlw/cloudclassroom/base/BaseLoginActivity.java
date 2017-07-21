package com.shlw.cloudclassroom.base;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.pubilc.util.CustomCountDownTimer;

/**
 * Created by john on 2017/4/23.
 */

public abstract class BaseLoginActivity extends BaseActivity{
    public CustomCountDownTimer countDownTimer;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void initCountDownTimer(final Button view) {
        countDownTimer = new CustomCountDownTimer(60000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                view.setBackground(getResources().getDrawable(R.drawable.gray));
                view.setText(millisUntilFinished/1000+"s");
                view.setTextColor(getResources().getColor(R.color.white));
                view.setEnabled(false);
            }

            @Override
            public void onFinish() {
                view.setBackground(getResources().getDrawable(R.drawable.getcode));
                view.setText("");
                view.setEnabled(true);
            }
        };
    }
}
