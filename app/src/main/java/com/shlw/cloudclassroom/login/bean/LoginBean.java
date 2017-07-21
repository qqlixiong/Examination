package com.shlw.cloudclassroom.login.bean;

/**
 * Created by john on 2017/5/9.
 */

public class LoginBean {

    /**
     * code : 10011
     * status : 0
     * msg : 用户不存在！
     * data : {"userid":1421792,"username":"lw001","nickname":"周周","userType":1,"token":"MTQ5Mjk3MTY0Nn2Is7CFtpuWrsyhow"}
     */

    private int code;
    private int status;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userid : 1421792
         * username : lw001
         * nickname : 周周
         * userType : 1
         * token : MTQ5Mjk3MTY0Nn2Is7CFtpuWrsyhow
         */

        private int userid;
        private String username;
        private String nickname;
        private int userType;
        private String token;

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
