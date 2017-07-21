package com.shlw.cloudclassroom.exam;

import android.widget.RadioGroup;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseFragment;
import com.shlw.cloudclassroom.base.BaseFragmentMainActivity;
import com.shlw.cloudclassroom.interfaces.ICheckedChanged;
import com.shlw.cloudclassroom.repository.ChildQuestionBankFragment;
import com.shlw.cloudclassroom.repository.KnowledgePointFragment;

import butterknife.Bind;
import butterknife.OnClick;

public class RepositoryActivity extends BaseFragmentMainActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rg_rp_main)
    RadioGroup rgRpMain;

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new ChildQuestionBankFragment(),new KnowledgePointFragment()};
    }

    @Override
    protected void setListener() {
        rgRpMain.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_a:
                        position = 0;
                        break;

                    case R.id.rb_b:
                        position = 1;
                        break;
                }
            }
        }));
        rgRpMain.check(R.id.rb_a);
    }

    @Override
    protected int initFrameLayoutId() {
        return R.id.fl_content;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_repository;
    }

    @Override
    protected void initView() {
        tvTitle.setText("知识库");
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
