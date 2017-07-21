package com.shlw.cloudclassroom.my;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.my.activity.PersonalInformationActivity;
import com.shlw.cloudclassroom.base.BaseFragment;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.bean.MyBean;
import com.shlw.cloudclassroom.holder.my.MyViewHolder;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;


public class MyFragment extends BaseFragment {

    @Bind(R.id.textView_name)
    TextView textViewName;
    @Bind(R.id.rv_my)
    RecyclerView rvMy;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    protected void initRecyclerView() {
        List<MyBean> list = new ArrayList<>();
        int[] resId = null;
        String[] name = null;
        switch (flag){
            case Constant.STUDENT:
                resId = new int[]{R.drawable.setting,R.drawable.highfir_exam};
                name = new String[]{"我的收藏","我的错题"};
                break;

            case Constant.TEACHER:
                resId = new int[]{R.drawable.setting};
                name = new String[]{"敬请期待"};
                break;
        }
        for (int i=0;i<name.length;i++){
            MyBean myBean = new MyBean();
            myBean.resId = resId[i];
            myBean.name = name[i];
            list.add(myBean);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL, false);
        rvMy.setLayoutManager(linearLayoutManager);
//        rvMy.addItemDecoration(new DividerListItemDecoration(mContext,
//                DividerListItemDecoration.VERTICAL_LIST));
        rvMy.setAdapter(new ModelRecyclerAdapter<MyBean>(MyViewHolder.class,list));
    }

    @OnClick(R.id.imageView_my)
    public void onClick(View view){
        IntentUtil.startActivity(mContext, PersonalInformationActivity.class);
    }
}
