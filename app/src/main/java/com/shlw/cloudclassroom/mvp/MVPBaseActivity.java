package com.shlw.cloudclassroom.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shlw.cloudclassroom.base.BaseActivity;

/**
 * Created by lixiong on 16/11/10.
 */

public abstract class MVPBaseActivity<V,T extends BasePresenter<V>> extends BaseActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        fetchPresenter();
    }

    protected abstract void fetchPresenter();

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    protected abstract T createPresenter();
}
