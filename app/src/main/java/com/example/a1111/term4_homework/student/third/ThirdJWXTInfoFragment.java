package com.example.a1111.term4_homework.student.third;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a1111.term4_homework.R;
import com.example.a1111.term4_homework.student.third.dummy.DummyContent;

import java.util.List;

/**
 * Created by 1111 on 2017/6/1.
 */

public class ThirdJWXTInfoFragment extends Fragment {
//    private boolean mTwoPane;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_jwxt_info, container,false);
//
//        View recyclerView = view.findViewById(R.id.seconditem_list);
//        assert recyclerView != null;
//        setupRecyclerView((RecyclerView) recyclerView);
//
//        if (view.findViewById(R.id.seconditem_detail_container) != null) {
//            // The detail container view will be present only in the
//            // large-screen layouts (res/values-w900dp).
//            // If this view is present, then the
//            // activity should be in two-pane mode.
//            mTwoPane = true;
//        }
//
//        return view;
//    }
//
//    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
//        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContent.ITEMS));
//    }
//
//    public class SimpleItemRecyclerViewAdapter
//            extends RecyclerView.Adapter<ThirdJWXTInfoFragment.SimpleItemRecyclerViewAdapter.ViewHolder> {
//
//        private final List<DummyContent.DummyItem> mValues;
//
//        public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items) {
//            mValues = items;
//        }
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.seconditem_list_content, parent, false);
//            return new ViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(final ThirdJWXTInfoFragment.SimpleItemRecyclerViewAdapter.ViewHolder holder, int position) {
//            holder.mItem = mValues.get(position);
//            holder.mIdView.setText(mValues.get(position).id);
//            holder.mContentView.setText(mValues.get(position).content);
//
//            holder.mView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mTwoPane) {
////                        Bundle arguments = new Bundle();
////                        arguments.putString(SecondItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
////                        SecondItemDetailFragment fragment = new SecondItemDetailFragment();
////                        fragment.setArguments(arguments);
////                        getActivity().getFragmentManager().beginTransaction()
////                                .replace(R.id.seconditem_detail_container, fragment)
////                                .commit();
//                    } else {
////                        Context context = v.getContext();
////                        Intent intent = new Intent(context, SecondItemDetailActivity.class);
////                        intent.putExtra(SecondItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
////
////                        context.startActivity(intent);
//                    }
//                }
//            });
//        }
//
//        @Override
//        public int getItemCount() {
//            return mValues.size();
//        }
//
//        public class ViewHolder extends RecyclerView.ViewHolder {
//            public final View mView;
//            public final TextView mIdView;
//            public final TextView mContentView;
//            public DummyContent.DummyItem mItem;
//
//            public ViewHolder(View view) {
//                super(view);
//                mView = view;
//                mIdView = (TextView) view.findViewById(R.id.student_firstitem_list_content_id);
//                mContentView = (TextView) view.findViewById(R.id.student_firstitem_list_content_main_content);
//            }
//
//            @Override
//            public String toString() {
//                return super.toString() + " '" + mContentView.getText() + "'";
//            }
//        }
//    }
}
