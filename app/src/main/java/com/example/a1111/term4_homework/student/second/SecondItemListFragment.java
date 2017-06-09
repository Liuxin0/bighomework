package com.example.a1111.term4_homework.student.second;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.a1111.term4_homework.R;
import com.example.a1111.term4_homework.interface_.HttpCallbackListener;
import com.example.a1111.term4_homework.model.STHomeModel;
import com.example.a1111.term4_homework.student.first.dummy.DummyContent;
import com.example.a1111.term4_homework.util.DataUtil;
import com.example.a1111.term4_homework.util.HttpUtils;
import com.example.a1111.term4_homework.util.L;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * An activity representing a list of FirstItems. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link SecondItemListFragment} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class SecondItemListFragment extends Fragment {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    View recyclerView;
    SimpleItemRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seconditem_list_student, container);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = view.findViewById(R.id.seconditem_list);

        getData();

        return view;
    }

    //
    private void getData() {
        HashMap<String, String> map = new HashMap<>();
        DataUtil util = new DataUtil("userinformation", getActivity());
        map.put("userid", util.getData("userid", ""));
        HttpUtils.get("http://183.175.12.176:8080/getwvideo", map, new HttpCallbackListener.StringCallBack() {
            @Override
            public void OnRequest(String response) {
                STHomeModel model = new Gson().fromJson(response, STHomeModel.class);
                if (model.getState() != 0) {
                    adapter = new SimpleItemRecyclerViewAdapter(model.getVideos());
                    callback.success();
                } else {
                    L.e("home", model.getMsg());
                }
            }

            @Override
            public void OnFailure(Exception e) {
                L.e("home", e.getLocalizedMessage());
            }
        });
    }


    interface Callback {
        void success();
    }

    Callback callback = new Callback() {
        @Override
        public void success() {
            ((RecyclerView) recyclerView).setAdapter(adapter);
        }
    };

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<STHomeModel.VideosBean> mValues;

        public SimpleItemRecyclerViewAdapter(List<STHomeModel.VideosBean> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.seconditem_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).getVideoid() + "");
            holder.mContentView.setText("标题" + mValues.get(position).getTitle()
                    + "  课程" + mValues.get(position).getSubject());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, SecondItemDetailActivity.class);
                    intent.putExtra("videoid",mValues.get(position).getVideoid()+"");
                    intent.putExtra("title",mValues.get(position).getTitle());
                    intent.putExtra("url",mValues.get(position).getURL());
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public STHomeModel.VideosBean mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.student_seconditem_list_content_id);
                mContentView = (TextView) view.findViewById(R.id.student_seconditem_list_content_main_content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
