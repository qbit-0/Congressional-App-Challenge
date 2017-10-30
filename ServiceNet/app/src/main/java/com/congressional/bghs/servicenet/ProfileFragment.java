package com.congressional.bghs.servicenet;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by duyph on 10/28/2017.
 */

public class ProfileFragment extends Fragment
{
    View view;
    ScrollView mProfileScrollView;
    LinearLayout mProfileLinearLayout;
    ConstraintLayout mProfileHeader;
    TextView mProfileFirstName;
    TextView mProfileLastName;
    LinearLayout mLocSection;
    ConstraintLayout mLocContent;
    ImageButton mLocExternalMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.profile, container, false);

        mProfileScrollView = (ScrollView) view.findViewById(R.id.sv_profile);
        mProfileLinearLayout = (LinearLayout) mProfileScrollView.findViewById(R.id.ll_profile);

        mProfileHeader = (ConstraintLayout) mProfileLinearLayout.findViewById(R.id.profile_header);
        mProfileFirstName = (TextView) mProfileHeader.findViewById(R.id.tv_profile_group_name);
        mProfileLastName = (TextView) mProfileHeader.findViewById(R.id.tv_profile_last_name);

        mLocSection = (LinearLayout) mProfileLinearLayout.findViewById(R.id.loc_section);
        mLocContent = (ConstraintLayout) mLocSection.findViewById(R.id.loc_content);
        mLocExternalMap = (ImageButton) mLocContent.findViewById(R.id.i_btn_external_map);

        mLocExternalMap.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String adressString = "13892 Yockey Street, CA";
                Uri.Builder uriBuilder = new Uri.Builder();
                Uri uri = uriBuilder.scheme("geo")
                        .path("0, 0")
                        .query(adressString)
                        .build();
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(view.getContext().getPackageManager()) != null)
                    startActivity(intent);
            }
        });

        return view;
    }
}
