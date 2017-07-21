package com.shlw.cloudclassroom.home.student.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.base.BaseFragment;
import com.shlw.cloudclassroom.holder.home.student.PathologyExamsViewHolder;
import com.shlw.cloudclassroom.holder.home.student.PathologyViewHolder;
import com.shlw.cloudclassroom.orm.TmQuestionType;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.repository.ChildQuestionBankFragment;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 考题
 */
public class ExaminationQuestionsFragment extends BaseFragment {

    @Bind(R.id.rv_high_fir_exam)
    RecyclerView rvHighFirExam;

    public static final ExaminationQuestionsFragment newInstance(String name)
    {
        ExaminationQuestionsFragment fragment = new ExaminationQuestionsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.NAME, name);
        fragment.setArguments(bundle);

        return fragment ;
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_examination;
    }

    protected void initRecyclerView() {
        List<String> list = new ArrayList<>();
        String[] name = new String[]{"单选题","填空题","多选题","解答题","案例分析","名词解释","共用题干","共用答案"};
        /*for (int i=0;i<name.length;i++){
            HomeListBean homeListBean = new HomeListBean();
            homeListBean.imageId = resourceId[i];
            homeListBean.name = name[i];
            list.add(homeListBean);
        }*/
        for(int i=0;i<name.length;i++){
            list.add(name[i]);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL, false);
        rvHighFirExam.setLayoutManager(linearLayoutManager);
//        rvHighFirExam.addItemDecoration(new DividerListItemDecoration(mContext,
//                DividerListItemDecoration.VERTICAL_LIST));
        rvHighFirExam.setAdapter(new ModelRecyclerAdapter<String>(PathologyExamsViewHolder.class,list));
    }
}
