package com.shlw.cloudclassroom.home.student.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarRecord;
import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.orm.TmQuestionOptions;
import com.shlw.cloudclassroom.orm.TmQuestionSub;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.LogUtil;
import com.shlw.cloudclassroom.pubilc.util.ViewUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 试题详情
 */
public class TestQuestionsDetailActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.activity_prepare_test_question)
    TextView activityPrepareTestQuestion;
    @Bind(R.id.vote_submit_select_image_a)
    ImageView voteSubmitSelectImageA;
    @Bind(R.id.vote_submit_select_text_a)
    TextView voteSubmitSelectTextA;
    @Bind(R.id.vote_submit_select_image_b)
    ImageView voteSubmitSelectImageB;
    @Bind(R.id.vote_submit_select_text_b)
    TextView voteSubmitSelectTextB;
    @Bind(R.id.vote_submit_select_image_c)
    ImageView voteSubmitSelectImageC;
    @Bind(R.id.vote_submit_select_text_c)
    TextView voteSubmitSelectTextC;
    @Bind(R.id.vote_submit_select_image_d)
    ImageView voteSubmitSelectImageD;
    @Bind(R.id.vote_submit_select_text_d)
    TextView voteSubmitSelectTextD;
    @Bind(R.id.vote_submit_select_image_e)
    ImageView voteSubmitSelectImageE;
    @Bind(R.id.vote_submit_select_text_e)
    TextView voteSubmitSelectTextE;
    @Bind(R.id.vote_submit_select_image_f)
    ImageView voteSubmitSelectImageF;
    @Bind(R.id.vote_submit_select_text_f)
    TextView voteSubmitSelectTextF;
    @Bind(R.id.activity_prepare_test_layout_a)
    RelativeLayout activityPrepareTestLayoutA;
    @Bind(R.id.activity_prepare_test_layout_b)
    RelativeLayout activityPrepareTestLayoutB;
    @Bind(R.id.activity_prepare_test_layout_c)
    RelativeLayout activityPrepareTestLayoutC;
    @Bind(R.id.activity_prepare_test_layout_d)
    RelativeLayout activityPrepareTestLayoutD;
    @Bind(R.id.activity_prepare_test_layout_e)
    RelativeLayout activityPrepareTestLayoutE;
    @Bind(R.id.activity_prepare_test_layout_f)
    RelativeLayout activityPrepareTestLayoutF;
    @Bind(R.id.vote_submit_select_image_g)
    ImageView voteSubmitSelectImageG;
    @Bind(R.id.vote_submit_select_text_g)
    TextView voteSubmitSelectTextG;
    @Bind(R.id.activity_prepare_test_layout_g)
    RelativeLayout activityPrepareTestLayoutG;
    @Bind(R.id.vote_submit_select_image_h)
    ImageView voteSubmitSelectImageH;
    @Bind(R.id.vote_submit_select_text_h)
    TextView voteSubmitSelectTextH;
    @Bind(R.id.activity_prepare_test_layout_h)
    RelativeLayout activityPrepareTestLayoutH;
    @Bind(R.id.vote_submit_select_image_i)
    ImageView voteSubmitSelectImageI;
    @Bind(R.id.vote_submit_select_text_i)
    TextView voteSubmitSelectTextI;
    @Bind(R.id.activity_prepare_test_layout_i)
    RelativeLayout activityPrepareTestLayoutI;
    @Bind(R.id.vote_submit_select_image_j)
    ImageView voteSubmitSelectImageJ;
    @Bind(R.id.vote_submit_select_text_j)
    TextView voteSubmitSelectTextJ;
    @Bind(R.id.activity_prepare_test_layout_j)
    RelativeLayout activityPrepareTestLayoutJ;
    @Bind(R.id.textView_content_a)
    TextView textViewContentA;
    @Bind(R.id.textView_content_b)
    TextView textViewContentB;
    @Bind(R.id.textView_content_c)
    TextView textViewContentC;
    @Bind(R.id.textView_content_d)
    TextView textViewContentD;
    @Bind(R.id.textView_content_e)
    TextView textViewContentE;
    @Bind(R.id.textView_content_f)
    TextView textViewContentF;
    @Bind(R.id.textView_content_g)
    TextView textViewContentG;
    @Bind(R.id.textView_content_h)
    TextView textViewContentH;
    @Bind(R.id.textView_content_i)
    TextView textViewContentI;
    @Bind(R.id.textView_content_j)
    TextView textViewContentJ;

    private int position;

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_questions_detail;
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("试题详情");
        position = getIntent().getExtras().getInt(Constant.POSITION);

        initQuestionSub();
    }

    private void initQuestionSub() {
        LogUtil.i("单选试题:"+TmQuestionSub.listAll(TmQuestionSub.class).toString());
        initViewStatus();
        TmQuestionSub tmQuestionSub = SugarRecord.findById(TmQuestionSub.class,
                (long)(position+1));
        activityPrepareTestQuestion.setText(tmQuestionSub.content);
        LogUtil.i("试题序号："+position+",试题详情："+tmQuestionSub.toString());
        List<TmQuestionOptions> tmQuestionOptions = TmQuestionOptions.find(TmQuestionOptions.class,
                "qid =?", String.valueOf(tmQuestionSub.qid));
        if(tmQuestionOptions.size()==0){
            return;
        }
        LogUtil.i("试题选项详情："+tmQuestionOptions.toString());
        for (int i = 0; i < tmQuestionOptions.size(); i++) {
            TmQuestionOptions tmQuestionOption = tmQuestionOptions.get(i);
            String salisa = tmQuestionOption.salisa;
            String content = tmQuestionOption.soption;
            boolean isAnswer = tmQuestionOption.isAnswer;
            if (salisa.equals("A")) {
                initSingleSelectStatus(activityPrepareTestLayoutA, textViewContentA,voteSubmitSelectTextA,
                        voteSubmitSelectImageA, "A.", content, isAnswer);
            } else if (salisa.equals("B")) {
                initSingleSelectStatus(activityPrepareTestLayoutB, textViewContentB,voteSubmitSelectTextB,
                        voteSubmitSelectImageB, "B.", content, isAnswer);
            } else if (salisa.equals("C")) {
                initSingleSelectStatus(activityPrepareTestLayoutC, textViewContentC,voteSubmitSelectTextC,
                        voteSubmitSelectImageC, "C.", content, isAnswer);
            } else if (salisa.equals("D")) {
                initSingleSelectStatus(activityPrepareTestLayoutD, textViewContentD,voteSubmitSelectTextD,
                        voteSubmitSelectImageD, "D.", content, isAnswer);
            } else if (salisa.equals("E")) {
                initSingleSelectStatus(activityPrepareTestLayoutE, textViewContentE,voteSubmitSelectTextE,
                        voteSubmitSelectImageE, "E.", content, isAnswer);
            } else if (salisa.equals("F")) {
                initSingleSelectStatus(activityPrepareTestLayoutF, textViewContentF,voteSubmitSelectTextF,
                        voteSubmitSelectImageF, "F.", content, isAnswer);
            } else if (salisa.equals("G")) {
                initSingleSelectStatus(activityPrepareTestLayoutG, textViewContentG,voteSubmitSelectTextG,
                        voteSubmitSelectImageG, "G.", content, isAnswer);
            } else if (salisa.equals("H")) {
                initSingleSelectStatus(activityPrepareTestLayoutH, textViewContentH,voteSubmitSelectTextH,
                        voteSubmitSelectImageH, "H.", content, isAnswer);
            } else if (salisa.equals("I")) {
                initSingleSelectStatus(activityPrepareTestLayoutI, textViewContentI,voteSubmitSelectTextI,
                        voteSubmitSelectImageI, "I.", content, isAnswer);
            } else if (salisa.equals("J")) {
                initSingleSelectStatus(activityPrepareTestLayoutJ, textViewContentJ,voteSubmitSelectTextJ,
                        voteSubmitSelectImageJ, "J.", content, isAnswer);
            }
        }
    }

    /**
     * 初始化view的显示状态
     */
    private void initViewStatus() {
        ViewUtils.hideView(activityPrepareTestLayoutA);
        ViewUtils.hideView(activityPrepareTestLayoutB);
        ViewUtils.hideView(activityPrepareTestLayoutC);
        ViewUtils.hideView(activityPrepareTestLayoutD);
        ViewUtils.hideView(activityPrepareTestLayoutE);
        ViewUtils.hideView(activityPrepareTestLayoutF);
        ViewUtils.hideView(activityPrepareTestLayoutG);
        ViewUtils.hideView(activityPrepareTestLayoutH);
        ViewUtils.hideView(activityPrepareTestLayoutI);
        ViewUtils.hideView(activityPrepareTestLayoutJ);
    }

    //初始化view的选择状态
    private void initSingleSelectStatus(View layout, TextView tv,TextView textView, ImageView imageView,
                                        String text, String content, boolean isAnswer) {
        ViewUtils.showView(layout);
        tv.setText(content);
        textView.setText(text);
        if (isAnswer) {
            imageView.setImageResource(R.drawable.ic_practice_test_right);
        } else {
            imageView.setImageResource(R.drawable.ic_practice_test_normal);
        }
    }

    @OnClick({R.id.activity_prepare_test_upLayout, R.id.activity_prepare_test_nextLayout})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_prepare_test_upLayout:
                position--;
                break;
            case R.id.activity_prepare_test_nextLayout:
                position++;
                break;
        }
        swapQuestion();
    }

    /**
     * 上一题或下一题
     */
    public void swapQuestion() {
        if (position < 0) {
            position = 0;
            Toast.makeText(this, "已经是第一题了!", Toast.LENGTH_LONG).show();
            return;
        }
        int size = TmQuestionSub.listAll(TmQuestionSub.class).size();
        if (position >= size) {
            Toast.makeText(this, "已经是最后一题了!", Toast.LENGTH_LONG).show();
            position = size - 1;
            return;
        }
        initQuestionSub();
    }
}
