package com.congressional.bghs.servicenet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MatchActivity extends AppCompatActivity
{
    Context context;

    ScrollView mMatchScrollView;
    LinearLayout mMatchLinearLayout;
    LinearLayout mLocSection;
    LinearLayout mLocContent;
    ImageButton mExteralMapButton;
    Button mConfirmMatchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        context = this;

        mMatchScrollView = (ScrollView) findViewById(R.id.sv_profile);
        mMatchLinearLayout = (LinearLayout) mMatchScrollView.findViewById(R.id.ll_profile);
        mLocSection = (LinearLayout) mMatchLinearLayout.findViewById(R.id.loc_section);
        mLocContent = (LinearLayout) mLocSection.findViewById(R.id.loc_section);
        mExteralMapButton = (ImageButton) mLocContent.findViewById(R.id.i_btn_external_map);
        mConfirmMatchButton = (Button) mMatchLinearLayout.findViewById(R.id.btn_confirm_match);

        mExteralMapButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String adressString = "9401 WESTMINSTER AVE, GARDEN GROVE, CA";
                Uri.Builder uriBuilder = new Uri.Builder();
                Uri uri = uriBuilder.scheme("geo")
                        .path("0, 0")
                        .query(adressString)
                        .build();
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(context.getPackageManager()) != null)
                    startActivity(intent);
            }
        });

        mConfirmMatchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Class destination = MainActivity.class;
                Intent intent = new Intent(context, destination);
                Variables.matched = true;
                startActivity(intent);
            }
        });
    }
}
