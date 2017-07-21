package com.shlw.cloudclassroom.holder.home.teacher;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.adapter.RecyclerItemViewId;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 信息查询的数据
 * Created by john on 2017/4/15.
 */

@RecyclerItemViewId(R.layout.information_item)
public class InformationViewHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_information_name)
    TextView textViewInformationName;
    @Bind(R.id.textView_information_time)
    TextView textViewInformationTime;
    private int position;
    private Context context;

    public InformationViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 可以对itemview的任何一个view绑定监听，这里只是以onclick为例，当然也可以绑定onTouch,onLongClick等
     */
    @OnClick(R.id.rl_information)
    void onclick() {
        switch (position) {
            case 0:

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
        textViewInformationName.setText((String) item);
    }
}
