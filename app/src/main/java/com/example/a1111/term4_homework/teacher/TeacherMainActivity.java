package com.example.a1111.term4_homework.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.a1111.term4_homework.R;
import com.example.a1111.term4_homework.settings.SettingsActivity;
import com.example.a1111.term4_homework.teacher.second.SecondActivity;

public class TeacherMainActivity extends AppCompatActivity {

//    private Fragment fragment;
//    private FragmentManager fragmentManager;
//    private FragmentTransaction fragmentTransaction;
    private long exitTime = 0;
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.hide(fragments[1]).show(fragments[0]);
//                    fragmentTransaction.commit();
//                    return true;
//                case R.id.navigation_dashboard:
//                    fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.hide(fragments[0]).show(fragments[1]);
//                    fragmentTransaction.commit();
//                    return true;
//            }
//            return false;
//        }
//
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.teacher_main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
        toolbar.setNavigationIcon(R.mipmap.my_user);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SettingsActivity.class);
                startActivity(intent);
            }
        });

//        InitFragments();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.teacher_first_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SecondActivity.class);
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.teacher_main_navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }


//    private void InitFragments() {
//        fragment = new Fragment();
//
//        fragmentManager = getFragmentManager();
//
//        fragment = fragmentManager.findFragmentById(R.id.teacher_firstitem_container);
//
//        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.commit();
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN
                && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
