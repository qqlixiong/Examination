package com.shlw.cloudclassroom.orm;

import com.orm.SugarRecord;

/**
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 `dname` varchar(50) DEFAULT NULL,
 `remark` varchar(50) DEFAULT NULL,
 `adminid` int(11) DEFAULT '1',
 `cdate` datetime DEFAULT NULL,
 `status` varchar(2) DEFAULT '1',
 `parentid` int(11) DEFAULT '0',
 `uuid` varchar(40) DEFAULT NULL COMMENT '唯一标示',
 * Created by john on 2017/4/22.
 */

public class TmQuestionDb extends SugarRecord {
    public int id;
    public String dname;
    public String remark;
    public int adminid;
    public String cdate;
    public String status;
    public int parentid;
    public String uuid;

    public TmQuestionDb() {
    }

    public TmQuestionDb(int id, String dname, String remark, int adminid, String cdate, String status, int parentid, String uuid) {
        this.id = id;
        this.dname = dname;
        this.remark = remark;
        this.adminid = adminid;
        this.cdate = cdate;
        this.status = status;
        this.parentid = parentid;
        this.uuid = uuid;
    }
}
