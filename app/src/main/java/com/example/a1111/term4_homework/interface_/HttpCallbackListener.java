package com.example.a1111.term4_homework.interface_;

import java.io.File;

/**
 * Created by "GKpoter" on 2017/5/17.
 */

public class HttpCallbackListener {

    /**
     * httpListener
     */
    private HttpCallbackListener(){}

    public interface StringCallBack{
        /**
         *
         * @param response
         */
        void OnRequest(String response);

        /**
         *
         * @param e
         */
        void OnFailure(Exception e);
    }

    public interface FileCallBack{
        /**
         *
         * @param file
         */
        void OnRequest(File file);

        /**
         *
         * @param e
         */
        void OnFailure(Exception e);

        /**
         *
         * @param progress
         */
        void OnProgress(float progress);
    }

}
