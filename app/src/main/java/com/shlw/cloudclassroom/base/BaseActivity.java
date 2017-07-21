package com.shlw.cloudclassroom.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.pubilc.util.RecyclerViewUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by john on 2017/4/15.
 */

public abstract class BaseActivity extends Activity {
    protected RecyclerViewUtil recyclerViewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData();
        initRecyclerView();
        setListener();
    }

    protected void initRecyclerView() {

    }

    public abstract int getLayoutId();

    public void initData(){
        recyclerViewUtil = RecyclerViewUtil.getInstance();
    }

    public void setListener(){}

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
