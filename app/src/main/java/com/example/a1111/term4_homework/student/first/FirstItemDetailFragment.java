package com.example.a1111.term4_homework.student.first;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a1111.term4_homework.R;
import com.example.a1111.term4_homework.model.STHomeModel;
import com.example.a1111.term4_homework.student.first.dummy.DummyContent;

/**
 * A fragment representing a single FirstItem detail screen.
 * This fragment is either contained in a {@link FirstItemListFragment}
 * in two-pane mode (on tablets) or a {@link FirstItemDetailActivity}
 * on handsets.
 */
public class FirstItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private STHomeModel.VideosBean mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FirstItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (getArguments().containsKey(ARG_ITEM_ID)) {
//            // Load the dummy content specified by the fragment
//            // arguments. In a real-world scenario, use a Loader
//            // to load content from a content provider.
//            mItem = (STHomeModel.VideosBean) getArguments().get("video");
//
//            Activity activity = this.getActivity();
//            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.student_toolbar_layout);
//            if (appBarLayout != null) {
//                appBarLayout.setTitle(mItem.getTitle());
//            }
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.student_firstitem_detail, container, false);

        // Show the dummy content as text in a TextView.
//        if (mItem != null) {
//            ((TextView) rootView.findViewById(R.id.firstitem_detail)).setText(mItem.getURL());
//        }

        return rootView;
    }
}
