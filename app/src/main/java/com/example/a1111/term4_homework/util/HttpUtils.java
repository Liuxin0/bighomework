package com.example.a1111.term4_homework.util;

import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.a1111.term4_homework.interface_.HttpCallbackListener;
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by "GKpoter" on 2017/5/17.
 */

public class HttpUtils {
    private HttpUtils() {
    }

    private final static String BASE_URL = "";
    private static OkHttpUtils okHttpUtils = null;

    /**
     * @param url
     * @param params
     * @param listener
     */
    public static void get(final String url, @Nullable final HashMap<String, String> params,
                           final HttpCallbackListener.StringCallBack listener) {
        if (okHttpUtils == null) {
            okHttpUtils = OkHttpUtils.getInstance();
        }
        GetBuilder getBuilder = okHttpUtils.get()
                .url(BASE_URL + url);
        if(params!=null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                getBuilder.addParams(entry.getKey(), entry.getValue());
            }
        }
        getBuilder.build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        listener.OnFailure(e);
                    }

                    @Override
                    public void onResponse(String response) {
                        listener.OnRequest(response);
                    }
                });
    }

    /**
     * @param url
     * @param params
     * @param listener
     */
    public static void post(final String url, @NonNull final HashMap<String, String> params,
                            final HttpCallbackListener.StringCallBack listener) {
        if (okHttpUtils == null) {
            okHttpUtils = OkHttpUtils.getInstance();
        }
        PostFormBuilder postFromBuilder = okHttpUtils.post()
                .url(BASE_URL + url);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            postFromBuilder.addParams(entry.getKey(), entry.getValue());
        }
        postFromBuilder.build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        listener.OnFailure(e);
                    }

                    @Override
                    public void onResponse(String response) {
                        listener.OnRequest(response);
                    }
                });
    }

    /**
     * @param url
     * @param object
     * @param listener
     */
    public static void postJson(final String url, @NonNull Object object,
                                final HttpCallbackListener.StringCallBack listener) {
        if (okHttpUtils == null) {
            okHttpUtils = OkHttpUtils.getInstance();
        }
        OkHttpUtils.postString()
                .url(BASE_URL + url)
                .content(new Gson().toJson(object))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        listener.OnFailure(e);
                    }

                    @Override
                    public void onResponse(String response) {
                        listener.OnRequest(response);
                    }
                });
    }

    /**
     * @param url
     * @param file
     * @param listener
     */
    public static void postFile(final String url, @NonNull final File file,
                                final HttpCallbackListener.StringCallBack listener) {
        if (okHttpUtils == null) {
            okHttpUtils = OkHttpUtils.getInstance();
        }
        OkHttpUtils.postFile()
                .url(BASE_URL + url)
                .file(file)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        listener.OnFailure(e);
                    }

                    @Override
                    public void onResponse(String response) {
                        listener.OnRequest(response);
                    }
                });
    }

    /**
     * @param url
     * @param fileName
     * @param listener
     */
    public static void downLoadFile(final String url, final String fileName,
                                    final HttpCallbackListener.FileCallBack listener) {
        if (okHttpUtils == null) {
            okHttpUtils = OkHttpUtils.getInstance();
        }
        OkHttpUtils.get()
                .url(BASE_URL + url)
                .build()
                .execute(new FileCallBack(
                        Environment.getExternalStorageDirectory().getAbsolutePath(), fileName) {
                    @Override
                    public void inProgress(float progress) {
                        listener.OnProgress(progress);
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                        listener.OnFailure(e);
                    }

                    @Override
                    public void onResponse(File file) {
                        listener.OnRequest(file);
                    }
                });
    }
}
