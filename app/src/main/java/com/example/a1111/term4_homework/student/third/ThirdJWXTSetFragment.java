package com.example.a1111.term4_homework.student.third;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1111.term4_homework.R;
import com.example.a1111.term4_homework.interface_.HttpCallbackListener;
import com.example.a1111.term4_homework.model.BaseModel;
import com.example.a1111.term4_homework.util.HttpUtils;
import com.example.a1111.term4_homework.util.L;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by 1111 on 2017/6/1.
 */

public class ThirdJWXTSetFragment extends Fragment {

    private EditText class_no, class_cno;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jwxt_set, container, false);

        class_no = (EditText) view.findViewById(R.id.choose_classno);
        class_cno = (EditText) view.findViewById(R.id.choose_cno);
        button = (Button) view.findViewById(R.id.choose_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(class_no.getText()) || "".equals(class_cno.getText())) {
                    Toast.makeText(getActivity(), "不能为空！！！", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("cnum", class_no.getText() + "");
                    map.put("cno", class_cno.getText() + "");
                    HttpUtils.post("http://www.baiguoqing.com:8080/Dazuoye/chooseclass", map, new HttpCallbackListener.StringCallBack() {
                        @Override
                        public void OnRequest(String response) {
                            BaseModel model = new Gson().fromJson(response, BaseModel.class);
                            if (model.getState() != 0) {
                                Toast.makeText(getActivity(), model.getMsg()+"", Toast.LENGTH_SHORT).show();
                            } else {
                                class_no.setText("");
                                class_cno.setText("");
                                Toast.makeText(getActivity(), model.getMsg()+"", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void OnFailure(Exception e) {
                            L.e("xk", e.getLocalizedMessage());
                        }
                    });
                }
            }
        });
        return view;
    }
}
