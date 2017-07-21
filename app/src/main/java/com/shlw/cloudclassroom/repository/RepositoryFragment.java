package com.shlw.cloudclassroom.repository;

import com.shlw.cloudclassroom.base.BaseTabFragment;

public class RepositoryFragment extends BaseTabFragment {

    @Override
    protected void addFragment() {
        super.addFragment();
//        fragments.add(ChildQuestionBankFragment.newInstance("子题库"));
//        fragments.add(KnowledgePointFragment.newInstance("知识点"));
        fragments.add(new ChildQuestionBankFragment());
        fragments.add(new KnowledgePointFragment());
    }

    @Override
    protected void addTile() {
        super.addTile();
        titles.add("子题库");
        titles.add("知识点");
    }
}
