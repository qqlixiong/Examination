package com.shlw.cloudclassroom.holder.home.student;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.adapter.RecyclerItemViewId;
import com.shlw.cloudclassroom.home.student.activity.ExamsTypeActivity;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 题库中心的数据
 * Created by john on 2017/4/15.
 */

@RecyclerItemViewId(R.layout.exams_center_item)
public class OffLineTestViewHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_num)
    TextView textViewNum;
    @Bind(R.id.textView_name)
    TextView textViewName;
    private int position;
    private Context context;
    private String item;

    public OffLineTestViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 可以对itemview的任何一个view绑定监听，这里只是以onclick为例，当然也可以绑定onTouch,onLongClick等
     */
    @OnClick(R.id.rl_exams_center)
    void onclick() {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.NAME,item);
        IntentUtil.startActivity(context, ExamsTypeActivity.class,bundle);
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
        this.position = positon;
        this.context = context;
        this.item = (String) item;
        textViewName.setText((String) item);
    }
}
