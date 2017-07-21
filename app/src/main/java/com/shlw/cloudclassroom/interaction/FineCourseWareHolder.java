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
public class FineCourseWareHolder extends ModelRecyclerAdapter.ModelViewHolder {
    @Bind(R.id.iv_interaction)
    ImageView ivInteraction;
    @Bind(R.id.tv_interaction)
    TextView tvInteraction;
    @Bind(R.id.tv_interaction_name)
    TextView tvInteractionName;
    @Bind(R.id.tv_interaction_time)
    TextView tvInteractionTime;
    private Context context;

    public FineCourseWareHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int positon) {
        this.context = context;
        int id = (int) item;
        ivInteraction.setImageResource(id);
        if (positon == 0) {
            tvInteraction.setText("课件名称可将名成课件名称课件名称");
        }
        if (positon == 1) {
            tvInteraction.setText("课件名称");
            tvInteractionTime.setText("收费");
            tvInteractionTime.setTextColor(Color.RED);
        }
        if (positon == 2) {
            tvInteraction.setText("课件名称");
            tvInteractionTime.setText("收费");
            tvInteractionTime.setTextColor(Color.RED);
        }
    }

    @OnClick(R.id.rl_interaction)
    public void onViewClicked() {
        IntentUtil.startActivity(context,InteractionDetailActivity.class);
    }
}
