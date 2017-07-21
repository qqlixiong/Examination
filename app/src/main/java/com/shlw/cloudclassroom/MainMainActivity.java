package com.shlw.cloudclassroom;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Space;
import android.widget.TextView;

import com.shlw.cloudclassroom.base.BaseFragment;
import com.shlw.cloudclassroom.direct.DirectFragment;
import com.shlw.cloudclassroom.exam.ExamFragment;
import com.shlw.cloudclassroom.interaction.InteractionFragment;
import com.shlw.cloudclassroom.my.activity.SettingActivity;
import com.shlw.cloudclassroom.base.BaseFragmentMainActivity;
import com.shlw.cloudclassroom.home.HomePageFragment;
import com.shlw.cloudclassroom.my.MyFragment;
import com.shlw.cloudclassroom.repository.RepositoryFragment;
import com.shlw.cloudclassroom.interfaces.ICheckedChanged;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;
import com.shlw.cloudclassroom.pubilc.util.LogUtil;
import com.shlw.cloudclassroom.pubilc.util.SharedPreferenceUtil;
import com.shlw.cloudclassroom.square.SquareFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class MainMainActivity extends BaseFragmentMainActivity {

    @Bind(R.id.rg_main)
    RadioGroup mRg_main;
    @Bind(R.id.ib_back)
    ImageButton ibBack;
    @Bind(R.id.space_left)
    Space spaceStart;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.space_right)
    Space spaceRight;
    @Bind(R.id.iv_setting)
    ImageView ivSetting;
    private int flag;
    private SharedPreferenceUtil sharedPreferenceUtil;
    private int[] radioIds;

    @Override
    protected int initFrameLayoutId() {
        return R.id.fl_content;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    protected void initView() {
        sharedPreferenceUtil = new SharedPreferenceUtil(this,Constant.SP);
        flag = sharedPreferenceUtil.get(Constant.FLAG,Constant.STUDENT);
        LogUtil.d("1为教师端,2为学生端:"+flag);
        ibBack.setVisibility(View.GONE);
        spaceStart.setVisibility(View.VISIBLE);
        switch (flag) {
            /*case Constant.STUDENT:
                show(rbRepository);
                break;

            case Constant.TEACHER:
                hide(rbRepository);
                break;

            default:
                show(rbRepository);
                break;*/
        }
    }

    protected void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
        @Override
        public void checkedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_exam:
                    position = 0;
                    spaceRight.setVisibility(View.VISIBLE);
                    ivSetting.setVisibility(View.GONE);
                    tvTitle.setText("考试");
                    break;
                case R.id.rb_interaction:
                    position = 1;
                    spaceRight.setVisibility(View.VISIBLE);
                    ivSetting.setVisibility(View.GONE);
                    tvTitle.setText("互动");
                    break;
                case R.id.rb_direct:
                    position = 2;
                    spaceRight.setVisibility(View.VISIBLE);
                    ivSetting.setVisibility(View.GONE);
                    tvTitle.setText("直播");
                    break;

                case R.id.rb_square:
                    position = 3;
                    spaceRight.setVisibility(View.VISIBLE);
                    ivSetting.setVisibility(View.GONE);
                    tvTitle.setText("广场");
                    break;

                case R.id.rb_my:
                    position = 4;
                    spaceRight.setVisibility(View.GONE);
                    ivSetting.setVisibility(View.VISIBLE);
                    tvTitle.setText("我的");
                    break;
                default:
                    position = 0;
                    spaceRight.setVisibility(View.VISIBLE);
                    ivSetting.setVisibility(View.GONE);
                    tvTitle.setText("考试");
                    break;
            }
        }
    }));
    mRg_main.check(R.id.rb_exam);
}

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new ExamFragment(),new InteractionFragment(),
                new DirectFragment(),new SquareFragment(),new MyFragment()};
    }

    @OnClick(R.id.iv_setting)
    public void onClick(View v) {
        IntentUtil.startActivity(this, SettingActivity.class);
    }

}