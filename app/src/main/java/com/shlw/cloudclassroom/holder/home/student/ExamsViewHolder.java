package com.shlw.cloudclassroom.holder.home.student;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.home.student.activity.HighFirExamMainActivity;
import com.shlw.cloudclassroom.home.student.activity.MockCenterActivity;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.adapter.RecyclerItemViewId;
import com.shlw.cloudclassroom.bean.HomeListBean;
import com.shlw.cloudclassroom.home.student.activity.OffLineTestActivity;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 考试的数据
 * Created by john on 2017/4/15.
 */

@RecyclerItemViewId(R.layout.home_item_layout)
public class ExamsViewHolder extends ModelRecyclerAdapter.ModelViewHolder {
    @Bind(R.id.imageView_home)
    ImageView imageViewHome;
    @Bind(R.id.textView_home)
    TextView textViewHome;
    private int position;
    private Context context;

    public ExamsViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 可以对itemview的任何一个view绑定监听，这里只是以onclick为例，当然也可以绑定onTouch,onLongClick等
     */
    @OnClick(R.id.rl_home)
    void onclick() {
        Intent intent;
        switch (position) {
            case 0:
                IntentUtil.startActivity(context, MockCenterActivity.class);
                break;

            case 1:
                IntentUtil.startActivity(context, HighFirExamMainActivity.class);
                break;

            case 4:
                IntentUtil.startActivity(context, OffLineTestActivity.class);
                break;
        }
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
        HomeListBean homeListBean = (HomeListBean) item;
        imageViewHome.setImageResource(homeListBean.imageId);
        textViewHome.setText(homeListBean.name);
    }
}
