package com.shlw.cloudclassroom.home.student.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.holder.home.student.PathologyViewHolder;
import com.shlw.cloudclassroom.mvp.MVPBaseActivity;
import com.shlw.cloudclassroom.mvp.iview.IView;
import com.shlw.cloudclassroom.mvp.presenter.PresenterExamsType;
import com.shlw.cloudclassroom.orm.TmQuestionType;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 包括  病理学  。。。
 */
public class ExamsTypeActivity extends MVPBaseActivity<IView,PresenterExamsType> implements IView<TmQuestionType>{

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_pathology)
    RecyclerView rvPathology;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pathology;
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText(getIntent().getExtras().getString(Constant.NAME));
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }

    protected void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        rvPathology.setLayoutManager(linearLayoutManager);
//        rvPathology.addItemDecoration(new DividerListItemDecoration(this,
//                DividerListItemDecoration.VERTICAL_LIST));

    }

    @Override
    protected void fetchPresenter() {
        mPresenter.fetch();
    }

    @Override
    protected PresenterExamsType createPresenter() {
        return new PresenterExamsType(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showData(List<TmQuestionType> list) {
        rvPathology.setAdapter(new ModelRecyclerAdapter<TmQuestionType>(PathologyViewHolder.class,list));
    }
}
