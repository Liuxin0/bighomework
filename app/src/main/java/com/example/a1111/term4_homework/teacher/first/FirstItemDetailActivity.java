package com.example.a1111.term4_homework.teacher.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.a1111.term4_homework.R;
import com.example.a1111.term4_homework.interface_.HttpCallbackListener;
import com.example.a1111.term4_homework.model.BaseModel;
import com.example.a1111.term4_homework.util.DataUtil;
import com.example.a1111.term4_homework.util.HttpUtils;
import com.example.a1111.term4_homework.util.L;
import com.google.gson.Gson;

import java.util.HashMap;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * An activity representing a single FirstItem detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link FirstItemListFragment}.
 */
public class FirstItemDetailActivity extends AppCompatActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private String url, title, videoid, subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_firstitem_detail_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.teacher_detail_toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        videoid = intent.getStringExtra("videoid");
        subject = intent.getStringExtra("subject");

        L.e("information", url);

        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.student_videoplayer);
        jcVideoPlayerStandard
                .setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, title);
        jcVideoPlayerStandard.thumbImageView.setImageResource(R.mipmap.my_add);

        TextView textView = (TextView) findViewById(R.id.student_video_subject);
        textView.setText("        " + subject);

        DataUtil util = new DataUtil("userinformation", getApplicationContext());
        upwatch(util.getData("userid", ""), videoid);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(FirstItemDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(FirstItemDetailFragment.ARG_ITEM_ID));
            FirstItemDetailFragment fragment = new FirstItemDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .add(R.id.teacher_firstitem_detail_container, fragment)
                    .commit();
        }
    }

    private void upwatch(String userid, String videoid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userid", userid);
        map.put("videoid", videoid);
        HttpUtils.post("http://www.baiguoqing.com:8080/Dazuoye/videolog", map, new HttpCallbackListener.StringCallBack() {
            @Override
            public void OnRequest(String response) {
                BaseModel model = new Gson().fromJson(response, BaseModel.class);
                if (model.getState() != 0) {

                }
            }

            @Override
            public void OnFailure(Exception e) {
                if (e != null)
                    L.e("informaton", e.getLocalizedMessage());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, FirstItemListFragment.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
