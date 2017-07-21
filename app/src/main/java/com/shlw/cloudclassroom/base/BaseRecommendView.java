package com.shlw.cloudclassroom.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.interaction.InteractionClassroomActivity;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;
import com.shlw.cloudclassroom.pubilc.util.RecyclerViewUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by john on 2017/4/27.
 */

public abstract class BaseRecommendView extends FrameLayout {

    @Bind(R.id.textView_more)
    public TextView textViewMore;
    @Bind(R.id.textView_name)
    public TextView textViewName;
    @Bind(R.id.rv_recommend)
    public RecyclerView rvRecommend;
    protected Context context;

    protected RecyclerViewUtil recyclerViewUtil;

    public BaseRecommendView(Context context) {
        this(context, null);
    }

    public BaseRecommendView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseRecommendView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.recommend_layout, this);
        ButterKnife.bind(this, view);
        initData();
        initRecyclerView();
    }

    public void initData() {
        recyclerViewUtil = RecyclerViewUtil.getInstance();
    }

    public abstract void initRecyclerView();

    @OnClick(R.id.rl_recommend_head)
    public void onViewClicked() {
        onClicked();
    }

    protected abstract void onClicked();
}
