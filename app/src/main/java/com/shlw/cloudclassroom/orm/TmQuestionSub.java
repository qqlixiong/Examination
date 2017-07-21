package com.shlw.cloudclassroom.orm;

import com.orm.SugarRecord;

import java.math.BigInteger;
import java.util.List;

/**
 * `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `content` varchar(2000) DEFAULT NULL,
 `sortby` int(2) DEFAULT NULL COMMENT '分题干排序',
 `qid` int(11) DEFAULT NULL COMMENT '问题id',
 `postdate` datetime DEFAULT NULL,
 `keydesc` text,
 `relapoint1` text COMMENT '相关知识点1',
 `relapoint2` text COMMENT '相关知识点2',
 `relapoint3` text COMMENT '相关知识点3',
 * Created by john on 2017/4/22.
 */

public class TmQuestionSub extends SugarRecord {
    public int id;
    public String content;
    public int sortby;
    public int qid;
    public String postdate;
    public String keydesc;
    public String relapoint1;
    public String relapoint2;
    public String relapoint3;
    public List<TmQuestionOptions> tmQuestionOptionses;

    public TmQuestionSub() {

    }

    public TmQuestionSub(int id, String content, int sortby, int qid, String postdate,
                         String keydesc, String relapoint1, String relapoint2,
                         String relapoint3) {
        this.id = id;
        this.content = content;
        this.sortby = sortby;
        this.qid = qid;
        this.postdate = postdate;
        this.keydesc = keydesc;
        this.relapoint1 = relapoint1;
        this.relapoint2 = relapoint2;
        this.relapoint3 = relapoint3;
    }

    @Override
    public String toString() {
        return "TmQuestionSub{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sortby=" + sortby +
                ", qid=" + qid +
                ", postdate='" + postdate + '\'' +
                ", keydesc='" + keydesc + '\'' +
                ", relapoint1='" + relapoint1 + '\'' +
                ", relapoint2='" + relapoint2 + '\'' +
                ", relapoint3='" + relapoint3 + '\'' +
                ", tmQuestionOptionses=" + tmQuestionOptionses +
                '}';
    }
}
