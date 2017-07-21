package com.shlw.cloudclassroom.holder.home.student;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.home.student.activity.ExamsCenterActivity;
import com.shlw.cloudclassroom.home.student.activity.PracticeTestActivity;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.adapter.RecyclerItemViewId;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 模拟中心的数据
 * Created by john on 2017/4/15.
 */

@RecyclerItemViewId(R.layout.mock_center_item)
public class MockCenterViewHolder extends ModelRecyclerAdapter.ModelViewHolder {
    @Bind(R.id.imageView_mock_center)
    ImageView imageViewMockCenter;
    private int position;
    private Context context;

    public MockCenterViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 可以对itemview的任何一个view绑定监听，这里只是以onclick为例，当然也可以绑定onTouch,onLongClick等
     */
    @OnClick(R.id.rl_mock_center)
    void onclick() {
        switch (position) {
            case 0:
                IntentUtil.startActivity(context, ExamsCenterActivity.class);
                break;

            case 1:
                IntentUtil.startActivity(context, PracticeTestActivity.class);
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
        imageViewMockCenter.setImageResource((Integer) item);
    }
}
