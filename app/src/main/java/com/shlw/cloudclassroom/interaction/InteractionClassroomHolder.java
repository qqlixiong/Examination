package com.shlw.cloudclassroom.interaction;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.adapter.RecyclerItemViewId;
import com.shlw.cloudclassroom.bean.HomeListBean;
import com.shlw.cloudclassroom.home.student.activity.HighFirExamMainActivity;
import com.shlw.cloudclassroom.home.student.activity.MockCenterActivity;
import com.shlw.cloudclassroom.home.student.activity.OffLineTestActivity;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

@RecyclerItemViewId(R.layout.interaction_classroom_item)
public class InteractionClassroomHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_interaction_classroom)
    ImageView ivInteractionClassroom;

    public InteractionClassroomHolder(View itemView) {
        super(itemView);
    }

    /**
     * 绑定我们的数据
     *
     * @param item    这是数据
     * @param adapter adapter 对象
     * @param context context对象
     * @param positon 当前位置
     */
    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int positon) {
        int id = (int) item;
        ivInteractionClassroom.setImageResource(id);
    }
}
