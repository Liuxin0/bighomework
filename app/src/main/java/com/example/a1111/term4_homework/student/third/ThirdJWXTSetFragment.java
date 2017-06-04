package com.example.a1111.term4_homework.student.third;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1111.term4_homework.R;

/**
 * Created by 1111 on 2017/6/1.
 */

public class ThirdJWXTSetFragment  extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jwxt_set,container,false);
        return view;
    }
}
