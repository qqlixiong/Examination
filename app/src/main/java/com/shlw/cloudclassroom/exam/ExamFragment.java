package com.shlw.cloudclassroom.exam;


import android.view.View;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseBannerFragment;
import com.shlw.cloudclassroom.home.student.activity.HighFirExamMainActivity;
import com.shlw.cloudclassroom.home.student.activity.MockTestActivity;
import com.shlw.cloudclassroom.home.student.activity.OffLineTestActivity;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;

import butterknife.OnClick;

/**
 * 考试
 */
public class ExamFragment extends BaseBannerFragment {

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_exam;
    }

    @OnClick({R.id.iv_a, R.id.iv_b, R.id.iv_c, R.id.iv_d, R.id.iv_e, R.id.iv_f})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_a:
                IntentUtil.startActivity(mContext,RepositoryActivity.class);
                break;
            case R.id.iv_b:
                IntentUtil.startActivity(mContext,HighFirExamMainActivity.class);
                break;
            case R.id.iv_c:
                break;
            case R.id.iv_d:
                IntentUtil.startActivity(mContext,OffLineTestActivity.class);
                break;
            case R.id.iv_e:
                break;
            case R.id.iv_f:
                break;
        }
    }
}
