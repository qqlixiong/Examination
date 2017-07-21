package com.shlw.cloudclassroom.orm;

import com.orm.SugarRecord;

/**
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 `qid` int(11) DEFAULT NULL,
 `uid` int(11) DEFAULT NULL,
 `cdate` datetime DEFAULT NULL,
 `detailid` int(11) DEFAULT NULL,
 * Created by john on 2017/4/22.
 */

public class TmQuestionCollection extends SugarRecord {
    public int id;
    public int qid;
    public int uid;
    public String cdate;
    public int detailid;

    public TmQuestionCollection() {
    }

    public TmQuestionCollection(int id, int qid, int uid, String cdate, int detailid) {
        this.id = id;
        this.qid = qid;
        this.uid = uid;
        this.cdate = cdate;
        this.detailid = detailid;
    }
}
