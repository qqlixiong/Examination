package com.shlw.cloudclassroom.login.bean;

/**
 * Created by john on 2017/5/9.
 */

public class LoginBeanNo {
    /**
     * code : 10011
     * status : 0
     * msg : 用户不存在！
     * data : -1
     */

    private int code;
    private int status;
    private String msg;
    private int data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
