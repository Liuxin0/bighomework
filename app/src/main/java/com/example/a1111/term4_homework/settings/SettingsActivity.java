package com.example.a1111.term4_homework.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.a1111.term4_homework.R;
import com.example.a1111.term4_homework.login.LoginActivity;
import com.example.a1111.term4_homework.teacher.first.FirstItemListFragment;
import com.example.a1111.term4_homework.util.DataUtil;
import com.example.a1111.term4_homework.util.FinishListActivity;

public class SettingsActivity extends AppCompatActivity {

    private CardView exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        ////注册finish()
        FinishListActivity.getInstance().addActivity(this);

        //显示个人信息
        setText();

        Toolbar toolbar = (Toolbar) findViewById(R.id.settings_toolbar);
        toolbar.setTitle("个人信息");

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.settings_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "欢迎使用云课堂>_<", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        exit = (CardView) findViewById(R.id.settings_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), LoginActivity.class);
                clearCookies();
                startActivity(intent);
                FinishListActivity.getInstance().exit();
            }
        });
    }

    private void setText(){
        TextView studentIdText = (TextView) findViewById(R.id.student_id);
        TextView trueNameText = (TextView) findViewById(R.id.student_name);
        TextView sexText = (TextView) findViewById(R.id.student_sex);
        TextView deptText = (TextView) findViewById(R.id.student_dept);
        TextView cloText = (TextView) findViewById(R.id.student_clo);
        DataUtil util=new DataUtil("userinformation",getApplicationContext());
        studentIdText.setText(util.getData("username","未绑定"));
        trueNameText.setText(util.getData("truename","未绑定"));
        sexText.setText(util.getData("sex","未绑定"));
        deptText.setText(util.getData("dept","未绑定"));
        cloText.setText(util.getData("collage","未绑定"));
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

    private void clearCookies(){
        //清除登录数据
        DataUtil util=new DataUtil("userinformation",getApplicationContext());
        util.clearData();
    }
}
