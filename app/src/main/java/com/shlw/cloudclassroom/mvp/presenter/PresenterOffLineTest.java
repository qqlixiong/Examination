package com.shlw.cloudclassroom.mvp.presenter;

import com.shlw.cloudclassroom.bean.HomeListBean;
import com.shlw.cloudclassroom.mvp.BasePresenter;
import com.shlw.cloudclassroom.mvp.imode.IMode;
import com.shlw.cloudclassroom.mvp.iview.IView;
import com.shlw.cloudclassroom.mvp.mode.ModeExams;
import com.shlw.cloudclassroom.mvp.mode.ModeOffLineTest;

import java.util.List;

/**
 * Created by john on 2017/4/22.
 */

public class PresenterOffLineTest extends BasePresenter<IView> {
    private IView iView;
    private IMode iMode = new ModeOffLineTest();

    public PresenterOffLineTest(IView iView) {
        this.iView = iView;
    }

    public void fetch(){
        iView.showLoading();
        if(iMode != null){
            iMode.loadData(new IMode.loadListener<String>() {
                @Override
                public void onComplete(List<String> list) {
                    iView.showData(list);
                }
            });
        }
    }
}
