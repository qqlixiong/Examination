package com.shlw.cloudclassroom.home.student.fragment;

import com.shlw.cloudclassroom.base.BaseTabFragment;
import com.shlw.cloudclassroom.repository.KnowledgePointFragment;

/**
 * 高频试题
 */
public class HighExamFragment extends BaseTabFragment {

    @Override
    protected void addFragment() {
        super.addFragment();
        fragments.add(ExaminationQuestionsFragment.newInstance("考题"));
        fragments.add(MistakesFragment.newInstance("错题"));
    }
}
