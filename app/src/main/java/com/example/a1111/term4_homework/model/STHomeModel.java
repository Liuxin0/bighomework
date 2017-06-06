package com.example.a1111.term4_homework.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by "GKpoter" on 2017/6/6.
 */

public class STHomeModel {

    /**
     * state : 1
     * msg :
     * videos : [{"videoid":1,"title":"逗比一号","URL":"http://www.baidu.com","subject":"逗比","granter":2,"watchNum":0,"update":"Sat Jun 03 17:17:22 GMT+08:00 2017"}]
     */

    private int state;
    private String msg;
    private List<VideosBean> videos;

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

    public List<VideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosBean> videos) {
        this.videos = videos;
    }

    public static class VideosBean implements Serializable {
        /**
         * videoid : 1
         * title : 逗比一号
         * URL : http://www.baidu.com
         * subject : 逗比
         * granter : 2
         * watchNum : 0
         * update : Sat Jun 03 17:17:22 GMT+08:00 2017
         */

        private int videoid;
        private String title;
        private String URL;
        private String subject;
        private int granter;
        private int watchNum;
        private String update;

        public int getVideoid() {
            return videoid;
        }

        public void setVideoid(int videoid) {
            this.videoid = videoid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getURL() {
            return URL;
        }

        public void setURL(String URL) {
            this.URL = URL;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public int getGranter() {
            return granter;
        }

        public void setGranter(int granter) {
            this.granter = granter;
        }

        public int getWatchNum() {
            return watchNum;
        }

        public void setWatchNum(int watchNum) {
            this.watchNum = watchNum;
        }

        public String getUpdate() {
            return update;
        }

        public void setUpdate(String update) {
            this.update = update;
        }
    }
}
