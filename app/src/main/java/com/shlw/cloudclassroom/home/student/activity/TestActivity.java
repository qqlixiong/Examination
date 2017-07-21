package com.shlw.cloudclassroom.home.student.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.orm.TmQuestionOptions;
import com.shlw.cloudclassroom.orm.TmQuestionSub;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;
import com.shlw.cloudclassroom.pubilc.util.LogUtil;
import com.shlw.cloudclassroom.pubilc.util.ViewUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.up)
    Button up;
    @Bind(R.id.next)
    Button next;
    @Bind(R.id.refer)
    Button refer;
    @Bind(R.id.time)
    TextView time;
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
    private List<TmQuestionSub> tmQuestionSubs;
    //哪个试题
    private int position;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("生理考试");
        //所有的问题
        tmQuestionSubs = TmQuestionSub.listAll(TmQuestionSub.class);
        activityPrepareTestQuestion.setText(tmQuestionSubs.get(position).content);
        for (TmQuestionSub tmQuestionSub0 : tmQuestionSubs) {
            tmQuestionSub0.tmQuestionOptionses = TmQuestionOptions.find(TmQuestionOptions.class,
                    "qid =?", String.valueOf(tmQuestionSub0.qid));
            for(TmQuestionOptions tmQuestionOption : tmQuestionSub0.tmQuestionOptionses){
                tmQuestionOption.isAnswer = false;
            }
        }
        initQuestionSub();
    }

    //初始化具体的题目
    private void initQuestionSub() {
        activityPrepareTestQuestion.setText(tmQuestionSubs.get(position).content);
        TmQuestionSub tmQuestionSub = tmQuestionSubs.get(position);
        initViewStatus();
        for (int i = 0; i < tmQuestionSub.tmQuestionOptionses.size(); i++) {
            TmQuestionOptions tmQuestionOption = tmQuestionSub.tmQuestionOptionses.get(i);
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

    @OnClick(R.id.ib_back)
    public void back(View view) {
        onBackPressed();
    }

    /**
     * 上一题或下一题
     */
    public void swapQuestion() {
        if (position < 0) {
            position = 0;
            Toast.makeText(TestActivity.this, "已经是第一题了!", Toast.LENGTH_LONG).show();
            return;
        }
        int size = tmQuestionSubs.size();
        if (position >= size) {
            Toast.makeText(TestActivity.this, "已经是最后一题了!", Toast.LENGTH_LONG).show();
            position = size - 1;
            return;
        }
        initQuestionSub();
    }

    /**
     * 提交
     */
    @OnClick(R.id.refer)
    public void refer(View view) {
        for(TmQuestionSub tmQuestionSub : tmQuestionSubs){
            for(TmQuestionOptions options : tmQuestionSub.tmQuestionOptionses){
                options.save();
            }
        }
        LogUtil.i("提交保存到数据库的选项答案："+TmQuestionOptions.listAll(TmQuestionOptions.class));
        Toast.makeText(this,"提交成功",Toast.LENGTH_LONG).show();
        IntentUtil.startActivity(this,OffLineTestActivity.class);
    }

    @OnClick({R.id.activity_prepare_test_layout_a, R.id.activity_prepare_test_layout_b,
            R.id.activity_prepare_test_layout_c, R.id.activity_prepare_test_layout_d,
            R.id.activity_prepare_test_layout_e, R.id.activity_prepare_test_layout_f,
            R.id.activity_prepare_test_layout_g, R.id.activity_prepare_test_layout_h,
            R.id.activity_prepare_test_layout_i, R.id.activity_prepare_test_layout_j})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_prepare_test_layout_a:
                update(0, R.drawable.ic_practice_test_right, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal);
                break;
            case R.id.activity_prepare_test_layout_b:
                update(1, R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_right,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal);
                break;
            case R.id.activity_prepare_test_layout_c:
                update(2, R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_right, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal);
                break;
            case R.id.activity_prepare_test_layout_d:
                update(3, R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_right,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal);
                break;

            case R.id.activity_prepare_test_layout_e:
                update(4, R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_right, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal);
                break;

            case R.id.activity_prepare_test_layout_f:
                update(5, R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_right,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal);
                break;

            case R.id.activity_prepare_test_layout_g:
                update(6, R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_right, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal);
                break;

            case R.id.activity_prepare_test_layout_h:
                update(7, R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_right,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal);
                break;

            case R.id.activity_prepare_test_layout_i:
                update(8, R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_right, R.drawable.ic_practice_test_normal);
                break;

            case R.id.activity_prepare_test_layout_j:
                update(9, R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_normal,
                        R.drawable.ic_practice_test_normal, R.drawable.ic_practice_test_right);
                break;
        }
    }

    private void update(int index, int... drawableId) {
        List<TmQuestionOptions> tmQuestionOptionsList = tmQuestionSubs.get(position).tmQuestionOptionses;
        for (int i = 0; i < tmQuestionOptionsList.size(); i++) {
            if (i == index) {
                tmQuestionOptionsList.get(i).isAnswer = true;
            } else {
                tmQuestionOptionsList.get(i).isAnswer = false;
            }
        }
        for (int i = 0; i < drawableId.length; i++) {
            switch (i) {
                case 0:
                    if (ViewUtils.isShowView(voteSubmitSelectImageA)) {
                        voteSubmitSelectImageA.setImageResource(drawableId[i]);
                    }
                    break;

                case 1:
                    if (ViewUtils.isShowView(voteSubmitSelectImageB)) {
                        voteSubmitSelectImageB.setImageResource(drawableId[i]);
                    }
                    break;

                case 2:
                    if (ViewUtils.isShowView(voteSubmitSelectImageC)) {
                        voteSubmitSelectImageC.setImageResource(drawableId[i]);
                    }
                    break;

                case 3:
                    if (ViewUtils.isShowView(voteSubmitSelectImageD)) {
                        voteSubmitSelectImageD.setImageResource(drawableId[i]);
                    }
                    break;

                case 4:
                    if (ViewUtils.isShowView(voteSubmitSelectImageE)) {
                        voteSubmitSelectImageE.setImageResource(drawableId[i]);
                    }
                    break;

                case 5:
                    if (ViewUtils.isShowView(voteSubmitSelectImageF)) {
                        voteSubmitSelectImageF.setImageResource(drawableId[i]);
                    }
                    break;

                case 6:
                    if (ViewUtils.isShowView(voteSubmitSelectImageG)) {
                        voteSubmitSelectImageG.setImageResource(drawableId[i]);
                    }
                    break;

                case 7:
                    if (ViewUtils.isShowView(voteSubmitSelectImageH)) {
                        voteSubmitSelectImageH.setImageResource(drawableId[i]);
                    }
                    break;

                case 8:
                    if (ViewUtils.isShowView(voteSubmitSelectImageI)) {
                        voteSubmitSelectImageI.setImageResource(drawableId[i]);
                    }
                    break;

                case 9:
                    if (ViewUtils.isShowView(voteSubmitSelectImageJ)) {
                        voteSubmitSelectImageJ.setImageResource(drawableId[i]);
                    }
                    break;
            }
        }
    }

    @OnClick({R.id.up, R.id.next})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.up:
                position--;
                break;
            case R.id.next:
                position++;
                break;
        }
        swapQuestion();
    }
}
