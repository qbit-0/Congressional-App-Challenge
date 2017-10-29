package com.congressional.bghs.servicenet;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

/**
 * Created by duyph on 10/28/2017.
 */

public class SearchFragment extends Fragment
{
    View view;

    ConstraintLayout mSearchBar;
    ImageButton mSearchButton;

    ScrollView mContentScrollView;
    LinearLayout mSearchContent;
    LinearLayout mSearchResults;
    ConstraintLayout mClickableResult;
    ProgressBar mSearchProgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.search, container, false);

        mSearchBar = (ConstraintLayout) view.findViewById(R.id.search_bar);
        mSearchButton = (ImageButton) mSearchBar.findViewById(R.id.search_button);

        mContentScrollView = (ScrollView) view.findViewById(R.id.sv_content);
        mSearchContent = (LinearLayout) mContentScrollView.findViewById(R.id.search_content);
        mSearchResults = (LinearLayout) mSearchContent.findViewById(R.id.search_results);
        mClickableResult = (ConstraintLayout) mSearchResults.findViewById(R.id.search_result_clickable);
        mSearchProgressBar = (ProgressBar) mSearchContent.findViewById(R.id.search_progress_bar);

        mSearchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mSearchProgressBar.setVisibility(View.VISIBLE);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        mSearchProgressBar.setVisibility(View.INVISIBLE);
                        mSearchResults.setVisibility(View.VISIBLE);
                    }
                }, 500);
            }
        });

        mClickableResult.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Class destination = ProviderProfileActivity.class;
                Intent intent = new Intent(view.getContext(), destination);
                startActivity(intent);
            }
        });

        return view;
    }
}
