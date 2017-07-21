package com.shlw.cloudclassroom.mvp.mode;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.bean.HomeListBean;
import com.shlw.cloudclassroom.mvp.imode.IMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiong on 16/11/10.
 */

public class ModeExams implements IMode {
    @Override
    public void loadData(loadListener listener) {
        List<HomeListBean> list = new ArrayList<>();
        int[] resourceId = new int[]{R.drawable.mock_center,R.drawable.highfir_exam,R.drawable.skill,R.drawable.onlineexam,R.drawable.line};
        String[] name = new String[]{"模拟中心","高频错题","技能考核","在线考试","离线测试"};
        for (int i=0;i<resourceId.length;i++){
            HomeListBean homeListBean = new HomeListBean();
            homeListBean.imageId = resourceId[i];
            homeListBean.name = name[i];
            list.add(homeListBean);
        }
        listener.onComplete(list);
    }
}
