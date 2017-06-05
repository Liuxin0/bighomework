package com.example.a1111.term4_homework.model;

/**
 * Created by "GKpoter" on 2017/6/5.
 */

public class LoginModel {
    /**
     * state : 1
     * msg :
     * user : {"userid":1,"username":"0151122384","password":"0151122384","truename":"白国青","sex":"男","school":"内蒙古大学","dept":"软件工程","collage":"计算机学院","kind":1,"course":"高数,英语,体育"}
     */

    private int state;
    private String msg;
    private UserBean user;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * userid : 1
         * username : 0151122384
         * password : 0151122384
         * truename : 白国青
         * sex : 男
         * school : 内蒙古大学
         * dept : 软件工程
         * collage : 计算机学院
         * kind : 1
         * course : 高数,英语,体育
         */

        private int userid;
        private String username;
        private String password;
        private String truename;
        private String sex;
        private String school;
        private String dept;
        private String collage;
        private int kind;
        private String course;

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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTruename() {
            return truename;
        }

        public void setTruename(String truename) {
            this.truename = truename;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public String getCollage() {
            return collage;
        }

        public void setCollage(String collage) {
            this.collage = collage;
        }

        public int getKind() {
            return kind;
        }

        public void setKind(int kind) {
            this.kind = kind;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }
    }
}
