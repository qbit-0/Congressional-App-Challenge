package com.congressional.bghs.servicenet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ProviderProfileActivity extends AppCompatActivity
{
    ScrollView mProfileScrollView;
    LinearLayout mProfileLinearLayout;
    LinearLayout mTimeSection;
    LinearLayout mFromSection;
    TextView mFromDate;
    TextView mFromTime;
    LinearLayout mLocSection;
    LinearLayout mProximitySection;
    TextView mProximityTextView;
    Button mConfirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_profile);

        mProfileScrollView = (ScrollView) findViewById(R.id.sv_profile);
        mProfileLinearLayout = (LinearLayout) mProfileScrollView.findViewById(R.id.ll_profile);
        mTimeSection = (LinearLayout) mProfileLinearLayout.findViewById(R.id.time_section);
        mFromSection = (LinearLayout) mTimeSection.findViewById(R.id.from_section);
        mFromDate = (TextView) mFromSection.findViewById(R.id.tv_from_date);
        mFromTime = (TextView) mFromSection.findViewById(R.id.tv_from_time);
        mLocSection = (LinearLayout) mProfileLinearLayout.findViewById(R.id.loc_section);
        mProximitySection = (LinearLayout) mLocSection.findViewById(R.id.proximity_section);
        mProximityTextView = (TextView) mProximitySection.findViewById(R.id.et_proximity);
        mConfirmButton = (Button) mProfileLinearLayout.findViewById(R.id.btn_confirm);
    }
}
