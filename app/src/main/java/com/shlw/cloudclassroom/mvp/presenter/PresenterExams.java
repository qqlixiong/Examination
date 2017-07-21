package com.shlw.cloudclassroom.mvp.presenter;

import com.shlw.cloudclassroom.bean.HomeListBean;
import com.shlw.cloudclassroom.mvp.BasePresenter;
import com.shlw.cloudclassroom.mvp.imode.IMode;
import com.shlw.cloudclassroom.mvp.iview.IView;
import com.shlw.cloudclassroom.mvp.mode.ModeExams;

import java.util.List;

/**
 * Created by lixiong on 16/11/10.
 */

public class PresenterExams extends BasePresenter<IView>{
    private IView iView;
    private IMode iMode = new ModeExams();

    public PresenterExams(IView iView) {
        this.iView = iView;
    }

    public void fetch(){
        iView.showLoading();
        if(iMode != null){
            iMode.loadData(new IMode.loadListener<HomeListBean>() {
                @Override
                public void onComplete(List<HomeListBean> list) {
                    iView.showData(list);
                }
            });
        }
    }
}
