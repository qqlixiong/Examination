package com.shlw.cloudclassroom.interaction;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.adapter.RecyclerItemViewId;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

@RecyclerItemViewId(R.layout.interaction_item)
public class InteractionHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_interaction)
    ImageView ivInteraction;
    @Bind(R.id.tv_interaction)
    TextView tvInteraction;
    @Bind(R.id.tv_interaction_name)
    TextView tvInteractionName;
    @Bind(R.id.tv_interaction_time)
    TextView tvInteractionTime;
    private Context context;

    public InteractionHolder(View itemView) {
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
        this.context = context;
        int id = (int) item;
        ivInteraction.setImageResource(id);
        if (positon == 1) {
            tvInteraction.setText("医疗互动教学项目实验");
            tvInteractionTime.setText("VIP");
            tvInteractionTime.setTextColor(Color.RED);
        }
        if (positon == 2) {
            tvInteraction.setText("人体免疫系统探究");
            tvInteractionTime.setText("VIP");
            tvInteractionTime.setTextColor(Color.RED);
        }
    }

    @OnClick(R.id.rl_interaction)
    public void onViewClicked() {
        IntentUtil.startActivity(context,InteractionDetailActivity.class);
    }
}
