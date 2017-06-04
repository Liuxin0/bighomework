package com.example.a1111.term4_homework.student.third;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1111.term4_homework.R;

/**
 * Created by 1111 on 2017/6/1.
 */

public class ThirdJWXTFragment extends Fragment {

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private Fragment fragments[];

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.jwxt_navigation_home:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.hide(fragments[1]).show(fragments[0]);
                    fragmentTransaction.commit();
                    return true;
                case R.id.jwxt_navigation_dashboard:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.hide(fragments[0]).show(fragments[1]);
                    fragmentTransaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jwxt_main, container);

        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.jwxt_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initFragment();
        return view;
    }

    private void initFragment() {
        fragments = new Fragment[2];

        fragmentManager = getFragmentManager();
        fragments[0] = new ThirdJWXTSetFragment();
        fragments[1] = new ThirdJWXTInfoFragment();


        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.jwxt_set_fragment,fragments[0]);
        fragmentTransaction.replace(R.id.jwxt_info_fragment,fragments[1]);
        fragmentTransaction.hide(fragments[1]);
        fragmentTransaction.commit();
    }
}
