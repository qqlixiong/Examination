package com.shlw.cloudclassroom.orm;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

/**
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 `dbid` int(11) DEFAULT NULL,
 `sectionid` int(11) DEFAULT NULL COMMENT '所属章节tm_paper_section的id',
 `qtype` int(11) DEFAULT NULL,
 `qqfd` int(11) DEFAULT NULL,
 `qlevel` int(11) DEFAULT NULL,
 `qfrom` int(11) DEFAULT NULL,
 `status` varchar(2) DEFAULT NULL,
 `content` text,
 `postdate` datetime DEFAULT NULL,
 `skey` text,
 `keydesc` text,
 `adminid` int(11) DEFAULT NULL,
 `branchs` text COMMENT '分题干',
 `courseid` int(11) DEFAULT NULL COMMENT '所属课程id',
 `distinguish` float(2,2) DEFAULT NULL,
 `relapoint1` text COMMENT '相关知识点1',
 `relapoint2` text COMMENT '相关知识点2',
 `relapoint3` text COMMENT '相关知识点3',
 * Created by john on 2017/4/22.
 */
public class TmQuestion extends SugarRecord {
    public int id;
    public int dbid;
    public int sectionid;
    public int qtype;
    public int qqfd;
    public int qlevel;
    public int qfrom;
    public String status;
    public String content;
    public String postdate;
    public String skey;
    public String keydesc;
    public int adminid;
    public String branchs;
    public int courseid;
    public float distinguish;
    public String relapoint1;
    public String relapoint2;
    public String relapoint3;

    public TmQuestion() {
    }

    public TmQuestion(int id, int dbid, int sectionid, int qtype, int qqfd, int qlevel, int qfrom, String status, String content, String postdate, String skey, String keydesc, int adminid, String branchs, int courseid, float distinguish, String relapoint1, String relapoint2, String relapoint3) {
        this.id = id;
        this.dbid = dbid;
        this.sectionid = sectionid;
        this.qtype = qtype;
        this.qqfd = qqfd;
        this.qlevel = qlevel;
        this.qfrom = qfrom;
        this.status = status;
        this.content = content;
        this.postdate = postdate;
        this.skey = skey;
        this.keydesc = keydesc;
        this.adminid = adminid;
        this.branchs = branchs;
        this.courseid = courseid;
        this.distinguish = distinguish;
        this.relapoint1 = relapoint1;
        this.relapoint2 = relapoint2;
        this.relapoint3 = relapoint3;
    }
}
