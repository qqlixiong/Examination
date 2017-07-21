package com.shlw.cloudclassroom.mvp.mode;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.bean.HomeListBean;
import com.shlw.cloudclassroom.mvp.imode.IMode;
import com.shlw.cloudclassroom.orm.TmQuestionOptions;
import com.shlw.cloudclassroom.orm.TmQuestionSub;
import com.shlw.cloudclassroom.orm.TmQuestionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiong on 16/11/10.
 */

public class ModeOffLineTest implements IMode {
    @Override
    public void loadData(loadListener listener) {
        List<TmQuestionType> tmQuestionTypes = TmQuestionType.listAll(TmQuestionType.class);
        if(tmQuestionTypes.size() == 0){
            TmQuestionType tmQuestionType01 = new TmQuestionType(1, "单选题", 3, "多选", 5);
            tmQuestionType01.save();
            TmQuestionType tmQuestionType02 = new TmQuestionType(2, "多选题", 4, "简答", 6);
            tmQuestionType02.save();
            TmQuestionType tmQuestionType03 = new TmQuestionType(2, "填空题", 4, "简答", 6);
            tmQuestionType03.save();
            TmQuestionType tmQuestionType04 = new TmQuestionType(4, "共用备选答案选择题", 0, "多选", 0);
            tmQuestionType04.save();
            TmQuestionType tmQuestionType05 = new TmQuestionType(5, "共用题干选择题", 0, "多选", 0);
            tmQuestionType05.save();
            TmQuestionType tmQuestionType06 = new TmQuestionType(6, "名词解释", 0, "多选", 0);
            tmQuestionType06.save();
            TmQuestionType tmQuestionType07 = new TmQuestionType(7, "论述题", 0, "多选", 0);
            tmQuestionType07.save();
            TmQuestionType tmQuestionType08 = new TmQuestionType(8, "病例分析", 0, "多选", 0);
            tmQuestionType08.save();
        }
        List<TmQuestionSub> tmQuestionSubs = TmQuestionSub.listAll(TmQuestionSub.class);
        if(tmQuestionSubs.size()==0){
            String[] contents = new String[]{"根据病人的临床表现，不应考虑的诊断是?",
                    "可限制大腿的外展和旋外运动的是：",
                    "连于髂前下棘的下方和股骨的转子间线的是：", "髋关节关节囊的纤维层呈环形增厚，环绕股骨颈的中部的是："};
            for (int i = 0; i < contents.length; i++) {
                TmQuestionSub tmQuestionSub = new TmQuestionSub(i, contents[i], 0, i, "", "", "", "", "");
                tmQuestionSub.save();
            }
        }

        List<TmQuestionOptions> tmQuestionOptionses = TmQuestionOptions.listAll(TmQuestionOptions.class);
        if(tmQuestionOptionses.size()==0){
            String[] salisa = new String[]{"A", "B", "C", "D"};
            String[] salisa1 = new String[]{"A", "B", "C", "D","E"};
            String[] salisa2 = new String[]{"A", "B", "C", "D","E","F"};
            for (int i = 0; i < salisa.length; i++) {
                TmQuestionOptions tmQuestionOptions = new TmQuestionOptions(salisa[i], 0, "血管" + i, 1, false);
                tmQuestionOptions.save();
            }
            for (int i = 0; i < salisa1.length; i++) {
                TmQuestionOptions tmQuestionOptions = new TmQuestionOptions(salisa1[i], 1, "纤维组织" + i, 2, false);
                tmQuestionOptions.save();
            }
            for (int i = 0; i < salisa2.length; i++) {
                TmQuestionOptions tmQuestionOptions = new TmQuestionOptions(salisa2[i], 2, "肌组织--髋关节关节囊的纤维层呈环形增厚---髋关节关节囊的纤维层呈环形增厚---髋关节关节囊的纤维层呈环形增厚---髋关节关节囊的纤维层呈环形增厚----髋关节关节囊的纤维层呈环形增厚----髋关节关节囊的纤维层呈环形增厚---髋关节关节囊的纤维层呈环形增厚---髋关节关节囊的纤维层呈环形增厚---髋关节关节囊的纤维层呈环形增厚---髋关节关节囊的纤维层呈环形增厚---髋关节关节囊的纤维层呈环形增厚" + i, 3, false);
                tmQuestionOptions.save();
            }
            for (int i = 0; i < salisa.length; i++) {
                TmQuestionOptions tmQuestionOptions = new TmQuestionOptions(salisa[i], 3, "神经组织" + i, 4, false);
                tmQuestionOptions.save();
            }
        }

        List<String> list = new ArrayList<>();
        String[] name = new String[]{"病理学","护理学","药理学","中医学"};
        for (int i=0;i<name.length;i++){
            list.add(name[i]);
        }
        listener.onComplete(list);
    }
}
