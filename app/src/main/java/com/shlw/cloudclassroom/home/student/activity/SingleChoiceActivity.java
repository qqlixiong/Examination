package com.shlw.cloudclassroom.home.student.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.orm.SugarRecord;
import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.holder.home.student.SingleChoiceViewHolder;
import com.shlw.cloudclassroom.orm.TmQuestionSub;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 单选题
 */
public class SingleChoiceActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_single_choicer)
    RecyclerView rvSingleChoicer;

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("单选题");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_single_choice;
    }

    protected void initRecyclerView() {
//        List<String> list = new ArrayList<>();
//        String[] name = new String[]{"1.请选择下列哪一项是正确的","1.请选择下列哪一项是正确的","1.请选择下列哪一项是正确的","1.请选择下列哪一项是正确的"};

        /*for (int i=0;i<name.length;i++){
            HomeListBean homeListBean = new HomeListBean();
            homeListBean.imageId = resourceId[i];
            homeListBean.name = name[i];
            list.add(homeListBean);
        }*/
//        for(int i=0;i<name.length;i++){
//            list.add(name[i]);
//        }
        List<TmQuestionSub> list = TmQuestionSub.listAll(TmQuestionSub.class);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        rvSingleChoicer.setLayoutManager(linearLayoutManager);
//        rvSingleChoicer.addItemDecoration(new DividerListItemDecoration(this,
//                DividerListItemDecoration.VERTICAL_LIST));
        rvSingleChoicer.setAdapter(new ModelRecyclerAdapter<TmQuestionSub>(SingleChoiceViewHolder.class,list));
    }
}
