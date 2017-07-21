package com.shlw.cloudclassroom.interaction;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseRecommendView;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/5/10.
 */

public class FineCourseWareView extends BaseRecommendView{
    public FineCourseWareView(Context context) {
        super(context);
    }

    public FineCourseWareView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FineCourseWareView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void initData() {
        super.initData();
        textViewName.setText("精品课件");
    }

    @Override
    public void initRecyclerView() {
        List<Integer> list = new ArrayList<>();
        int[] ids = new int[]{R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};
        for(int i=0;i<ids.length;i++){
            list.add(ids[i]);
        }
        recyclerViewUtil.initNSVRecyclerView(rvRecommend,list,
                new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false),
                InteractionClassroomHolder.class);
    }

    @Override
    protected void onClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.NAME,textViewName.getText().toString());
        IntentUtil.startActivity(context,FineCourseWareActivity.class,bundle);
    }
}
