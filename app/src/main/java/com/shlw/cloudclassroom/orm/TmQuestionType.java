package com.shlw.cloudclassroom.orm;

import com.orm.SugarRecord;

/**
 * `id` int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(200) NOT NULL COMMENT '题型名称',
 `status` int(2) DEFAULT '0' COMMENT '为1是可用的状态',
 `remark` varchar(200) DEFAULT NULL COMMENT '备注',
 `status2` int(11) DEFAULT NULL,
 * Created by john on 2017/4/22.
 */

public class TmQuestionType extends SugarRecord<TmQuestionType> {
    public int id;
    public String name;
    public int status;
    public String remark;
    public int status2;

    public TmQuestionType() {
    }

    public TmQuestionType(int id, String name, int status, String remark, int status2) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.remark = remark;
        this.status2 = status2;
    }

    @Override
    public String toString() {
        return "TmQuestionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", status2=" + status2 +
                '}';
    }
}
