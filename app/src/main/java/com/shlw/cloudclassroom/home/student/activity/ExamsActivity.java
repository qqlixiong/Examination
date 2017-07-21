package com.shlw.cloudclassroom.home.student.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.bean.HomeListBean;
import com.shlw.cloudclassroom.holder.home.student.ExamsViewHolder;
import com.shlw.cloudclassroom.mvp.MVPBaseActivity;
import com.shlw.cloudclassroom.mvp.iview.IView;
import com.shlw.cloudclassroom.mvp.presenter.PresenterExams;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 考试的页面
 */
public class ExamsActivity extends MVPBaseActivity<IView,PresenterExams> implements IView<HomeListBean>{

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_layout)
    RecyclerView rvExams;

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("考试");
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_layout;
    }

    protected void initRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,
                2,GridLayoutManager.VERTICAL, false);
        rvExams.setLayoutManager(gridLayoutManager);
        rvExams.addItemDecoration(new DividerListItemDecoration(this,
                DividerListItemDecoration.VERTICAL_LIST,false));
        rvExams.addItemDecoration(new DividerListItemDecoration(this,
                DividerListItemDecoration.HORIZONTAL_LIST,false));

    }

    @Override
    protected void fetchPresenter() {
        mPresenter.fetch();
    }

    @Override
    protected PresenterExams createPresenter() {
        return new PresenterExams(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showData(List<HomeListBean> list) {
        rvExams.setAdapter(new ModelRecyclerAdapter<HomeListBean>(ExamsViewHolder.class,list));
    }
}
