package com.shlw.cloudclassroom.holder.home.student;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.home.student.activity.SingleChoiceActivity;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.adapter.RecyclerItemViewId;
import com.shlw.cloudclassroom.orm.TmQuestionType;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 病理学的数据
 * Created by john on 2017/4/15.
 */

@RecyclerItemViewId(R.layout.examination_questions_item)
public class PathologyViewHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_num)
    TextView textViewNum;
    @Bind(R.id.textView_name)
    TextView textViewName;
    private int position;
    private Context context;

    public PathologyViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 可以对itemview的任何一个view绑定监听，这里只是以onclick为例，当然也可以绑定onTouch,onLongClick等
     */
    @OnClick(R.id.rl_pathology)
    void onclick() {
        switch (position) {
            case 0:
                Intent intent = new Intent(context, SingleChoiceActivity.class);
                context.startActivity(intent);
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
        TmQuestionType tmQuestionType = (TmQuestionType) item;
        textViewName.setText((String) tmQuestionType.name);
    }
}
