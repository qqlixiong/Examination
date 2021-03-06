package com.shlw.cloudclassroom.home.student.activity;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseFragment;
import com.shlw.cloudclassroom.base.BaseFragmentActivity;
import com.shlw.cloudclassroom.base.BaseFragmentMainActivity;
import com.shlw.cloudclassroom.home.student.fragment.ExaminationQuestionsFragment;
import com.shlw.cloudclassroom.home.student.fragment.HighExamFragment;
import com.shlw.cloudclassroom.home.student.fragment.MistakesFragment;
import com.shlw.cloudclassroom.interfaces.ICheckedChanged;

import butterknife.Bind;
import butterknife.OnClick;

import static android.R.attr.fragment;

public class HighFirExamMainActivity extends BaseFragmentMainActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rg_rp_main)
    RadioGroup rgRpMain;

    @Override
    protected int initFrameLayoutId() {
        return R.id.fl_content;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_high;
    }

    @Override
    protected void initView() {
        tvTitle.setText("高频试题");
    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new ExaminationQuestionsFragment(),new MistakesFragment()};
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

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }
}
