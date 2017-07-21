package com.shlw.cloudclassroom.mvp.presenter;

import com.shlw.cloudclassroom.bean.HomeListBean;
import com.shlw.cloudclassroom.mvp.BasePresenter;
import com.shlw.cloudclassroom.mvp.imode.IMode;
import com.shlw.cloudclassroom.mvp.iview.IView;
import com.shlw.cloudclassroom.mvp.mode.ModeExams;
import com.shlw.cloudclassroom.mvp.mode.ModeExamsType;
import com.shlw.cloudclassroom.orm.TmQuestionType;
import com.shlw.cloudclassroom.pubilc.util.LogUtil;

import java.util.List;

/**
 * Created by lixiong on 16/11/10.
 */

public class PresenterExamsType extends BasePresenter<IView>{
    private IView iView;
    private IMode iMode = new ModeExamsType();

    public PresenterExamsType(IView iView) {
        this.iView = iView;
    }

    public void fetch(){
        iView.showLoading();
        if(iMode != null){
            iMode.loadData(new IMode.loadListener<TmQuestionType>() {
                @Override
                public void onComplete(List<TmQuestionType> list) {
                    LogUtil.i(list.toString());
                    iView.showData(list);
                }
            });
        }
    }
}
