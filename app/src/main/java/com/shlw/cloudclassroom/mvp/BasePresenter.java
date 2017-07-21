package com.shlw.cloudclassroom.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by lixiong on 16/11/10.
 */

public class BasePresenter<T>{

    protected WeakReference<T> mViewRef;

    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }

    public void detachView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public T getView(){
        return mViewRef.get();
    }
}
