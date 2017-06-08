package com.example.a1111.term4_homework.model;

/**
 * Created by "GKpoter" on 2017/6/8.
 */

public class BaseModel {
    /**
     * state : 1
     * msg : 选课成功！
     */

    private int state;
    private String msg;

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
}
