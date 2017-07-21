package com.shlw.cloudclassroom.interaction;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.pubilc.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class FineCourseWareActivity extends InteractionClassroomActivity {

    @Override
    protected void initRecyclerView() {
        List<Integer> list = new ArrayList<>();
        int[] ids = new int[]{R.drawable.kejian1,R.drawable.kejian2,R.drawable.kejian3};
        for(int i=0;i<ids.length;i++){
            list.add(ids[i]);
        }
        recyclerViewUtil.initRecyclerView(rvInteractionClassroom,list,
                new LinearLayoutManager(FineCourseWareActivity.this,
                        LinearLayoutManager.VERTICAL,false),FineCourseWareHolder.class);
    }
}
