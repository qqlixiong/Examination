package com.shlw.cloudclassroom.interaction;

import android.view.View;
import android.widget.RadioGroup;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseFragment;
import com.shlw.cloudclassroom.base.BaseFragmentMainActivity;
import com.shlw.cloudclassroom.interfaces.ICheckedChanged;
import com.shlw.cloudclassroom.pubilc.util.ViewUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class InteractionDetailActivity extends BaseFragmentMainActivity {

    @Bind(R.id.rg_interaction_detail)
    RadioGroup rgInteractionDetail;
    @Bind(R.id.left_view)
    View leftView;
    @Bind(R.id.right_view)
    View rightView;

    @Override
    protected int initFrameLayoutId() {
        return R.id.fl_interaction_detail;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_interaction_detail;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new ClassFragment(),new DocumentFragment()};
    }

    @Override
    protected void setListener() {
        rgInteractionDetail.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_class:
                        position = 0;
                        ViewUtils.showView(leftView);
                        ViewUtils.hideView(rightView);
                        break;
                    case R.id.rb_document:
                        position = 1;
                        ViewUtils.showView(rightView);
                        ViewUtils.hideView(leftView);
                        break;
                    default:
                        position = 0;
                        ViewUtils.showView(leftView);
                        ViewUtils.hideView(rightView);
                        break;
                }
            }
        }));
        rgInteractionDetail.check(R.id.rb_class);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
