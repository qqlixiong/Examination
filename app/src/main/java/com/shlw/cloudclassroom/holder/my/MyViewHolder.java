package com.shlw.cloudclassroom.holder.my;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.adapter.RecyclerItemViewId;
import com.shlw.cloudclassroom.bean.MyBean;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 考试的数据
 * Created by john on 2017/4/15.
 */

@RecyclerItemViewId(R.layout.my_item)
public class MyViewHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.imageView_my)
    ImageView imageViewMy;
    @Bind(R.id.textView_my)
    TextView textViewMy;
    private int position;
    private Context context;

    public MyViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 可以对itemview的任何一个view绑定监听，这里只是以onclick为例，当然也可以绑定onTouch,onLongClick等
     */
    @OnClick(R.id.rl_my)
    void onclick() {
        Intent intent;
        switch (position) {
            case 0:

                break;

            case 1:

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
        MyBean myBean = (MyBean) item;
        imageViewMy.setImageResource(myBean.resId);
        textViewMy.setText(myBean.name);
    }
}
