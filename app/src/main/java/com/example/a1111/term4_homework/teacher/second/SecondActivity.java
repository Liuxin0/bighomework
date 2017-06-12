package com.example.a1111.term4_homework.teacher.second;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1111.term4_homework.R;
import com.example.a1111.term4_homework.model.BaseModel;
import com.example.a1111.term4_homework.teacher.first.FirstItemListFragment;
import com.example.a1111.term4_homework.util.DataUtil;
import com.example.a1111.term4_homework.util.HttpRequest;
import com.example.a1111.term4_homework.util.HttpUtils;
import com.example.a1111.term4_homework.util.L;
import com.example.a1111.term4_homework.util.PictureUtil;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;

import static java.security.AccessController.getContext;

/**
 * Created by 1111 on 2017/6/3.
 */

public class SecondActivity extends AppCompatActivity {

    private EditText title, infor;
    private Button upload;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_second_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.teacher_second_toolbar);
        toolbar.setTitle("上传视频");

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        title = (EditText) findViewById(R.id.up_video_title);
        infor = (EditText) findViewById(R.id.up_video_inf);
        upload = (Button) findViewById(R.id.up_video_upload);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(title.getText() + "") || "".equals(infor.getText() + "")) {
                    Toast.makeText(SecondActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    upVideo();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, FirstItemListFragment.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private final int IMAGE_CODE = 1;

    private void upVideo() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "选择视频"), IMAGE_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != SecondActivity.RESULT_OK) {
            return;
        }
        final Uri uri = data.getData();
        if (requestCode == IMAGE_CODE) {
            try {
                Video(uri);
            } catch (Exception e) {
                e.getLocalizedMessage();
            }
        }
    }

    private void Video(Uri uri) {
        File file = null;
        try {
            file = new File(new URI(uri.toString()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
//        MediaMetadataRetriever metadataRetriever=new MediaMetadataRetriever();
//        metadataRetriever.setDataSource(getApplicationContext(),uri);
//        Bitmap bitmap=metadataRetriever.getFrameAtTime();
//        PictureUtil pictureUtil=new PictureUtil();
//        pictureUtil.savePicture(bitmap, Environment.getExternalStorageDirectory().getPath()
//                +"/voiceshare","video_image_only.jpg");
//        File file1=new File(Environment.getExternalStorageDirectory().getPath()
//                +"/voiceshare/video_image_only.jpg");
        DataUtil util = new DataUtil("userinformation", getApplicationContext());
        RequestParams params = new RequestParams();
        params.put("userid", util.getData("userid", ""));
        params.put("title", title.getText() + "");
        params.put("subject", infor.getText() + "");
        try {
            params.put("video", file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HttpRequest.post(getApplicationContext(), "http://www.baiguoqing.com:8080/Dazuoye/upload", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, org.apache.http.Header[] headers, byte[] bytes) {
                BaseModel model = new Gson().fromJson(new String(bytes), BaseModel.class);
                if (model.getState() != 0) {
                    Toast.makeText(SecondActivity.this, model.getMsg() + "", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SecondActivity.this, model.getMsg() + "", Toast.LENGTH_SHORT).show();
                }
                title.setText("");
                infor.setText("");
            }

            @Override
            public void onFailure(int i, org.apache.http.Header[] headers, byte[] bytes, Throwable throwable) {
                L.e("information", new String(bytes));
                title.setText("");
                infor.setText("");
            }
        });
    }

}
