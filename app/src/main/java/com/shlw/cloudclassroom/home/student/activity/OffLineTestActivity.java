package com.shlw.cloudclassroom.home.student.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.holder.home.student.OffLineTestViewHolder;
import com.shlw.cloudclassroom.mvp.MVPBaseActivity;
import com.shlw.cloudclassroom.mvp.iview.IView;
import com.shlw.cloudclassroom.mvp.presenter.PresenterOffLineTest;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 离线测试
 */
public class OffLineTestActivity extends MVPBaseActivity<IView, PresenterOffLineTest> implements IView<String> {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_layout)
    RecyclerView rvExams;

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("离线测试");
    }

    protected void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvExams.setLayoutManager(linearLayoutManager);
//        rvExams.addItemDecoration(new DividerListItemDecoration(this,
//                DividerListItemDecoration.VERTICAL_LIST));

    }

    @OnClick(R.id.ib_back)
    public void back(View view) {
        onBackPressed();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_off_line_test;
    }

    @Override
    protected void fetchPresenter() {
        mPresenter.fetch();
    }

    @Override
    protected PresenterOffLineTest createPresenter() {
        return new PresenterOffLineTest(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showData(List<String> list) {
        rvExams.setAdapter(new ModelRecyclerAdapter<String>(OffLineTestViewHolder.class, list));
    }

    @OnClick({R.id.up_data, R.id.mock_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.up_data:
                break;
            case R.id.mock_test:
                //模拟测试
                IntentUtil.startActivity(OffLineTestActivity.this, MockTestActivity.class);
                break;
        }
    }
}
