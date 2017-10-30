package com.congressional.bghs.servicenet;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class ProviderProfileActivity extends AppCompatActivity
{
    Context context;
    ScrollView mProfileScrollView;
    LinearLayout mProfileLinearLayout;
    Button mConfirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_profile);

        context = this;

        mProfileScrollView = (ScrollView) findViewById(R.id.sv_profile);
        mProfileLinearLayout = (LinearLayout) mProfileScrollView.findViewById(R.id.ll_profile);
        mConfirmButton = (Button) mProfileLinearLayout.findViewById(R.id.btn_confirm);

        mConfirmButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Class destination = MatchActivity.class;
                Intent intent = new Intent(context, destination);
                startActivity(intent);
            }
        });
    }
}