package com.example.a1111.term4_homework.student.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.example.a1111.term4_homework.R;
import com.example.a1111.term4_homework.util.L;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * An activity representing a single FirstItem detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link FirstItemListFragment}.
 */
public class FirstItemDetailActivity extends AppCompatActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private String url, title, videoid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_firstitem_detail_activity);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        videoid = intent.getStringExtra("videoid");

        L.e("information", url);

        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.student_videoplayer);
        jcVideoPlayerStandard
                .setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, title);
        jcVideoPlayerStandard.thumbImageView.setImageResource(R.mipmap.my_add);

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
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
