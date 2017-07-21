package com.shlw.cloudclassroom.mvp.mode;

import com.orm.SugarRecord;
import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.bean.HomeListBean;
import com.shlw.cloudclassroom.mvp.imode.IMode;
import com.shlw.cloudclassroom.orm.TmQuestionOptions;
import com.shlw.cloudclassroom.orm.TmQuestionSub;
import com.shlw.cloudclassroom.orm.TmQuestionType;
import com.shlw.cloudclassroom.pubilc.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiong on 16/11/10.
 */

public class ModeExamsType implements IMode {
    @Override
    public void loadData(loadListener listener) {
        listener.onComplete(TmQuestionType.listAll(TmQuestionType.class));
    }
}
