package com.shlw.cloudclassroom.orm;

import com.orm.SugarRecord;

import java.math.BigInteger;

/**
 * `salisa` varchar(10) DEFAULT NULL,
 `qid` int(11) DEFAULT NULL,
 `soption` varchar(500) DEFAULT NULL,
 `subid` bigint(20) DEFAULT NULL
 * Created by john on 2017/4/22.
 */

public class TmQuestionOptions extends SugarRecord {
    public String salisa;
    public int qid;
    public String soption;
    public int subid;
    public boolean isAnswer;//单选答案，true为此答案是学生选择的答案，false为学生没有选择此答案

    public TmQuestionOptions() {
    }

    public TmQuestionOptions(String salisa, int qid, String soption, int subid, boolean isAnswer) {
        this.salisa = salisa;
        this.qid = qid;
        this.soption = soption;
        this.subid = subid;
        this.isAnswer = isAnswer;
    }

    @Override
    public String toString() {
        return "TmQuestionOptions{" +
                "salisa='" + salisa + '\'' +
                ", qid=" + qid +
                ", soption='" + soption + '\'' +
                ", subid=" + subid +
                ", isAnswer=" + isAnswer +
                '}';
    }
}
