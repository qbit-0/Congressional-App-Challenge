package com.congressional.bghs.servicenet;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by duyph on 10/28/2017.
 */

public class WelcomeFragment extends Fragment
{
    Context context;
    View view;
    ScrollView mWelcomeScrollView;
    LinearLayout mWelcomeLayout;
    LinearLayout mAppointmentSection;
    LinearLayout mAppointmentContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.welcome, container, false);
        context = view.getContext();

        mWelcomeScrollView = (ScrollView) view.findViewById(R.id.sv_welcome);
        mWelcomeLayout = (LinearLayout) mWelcomeScrollView.findViewById(R.id.ll_welcome);
        mAppointmentSection = (LinearLayout) mWelcomeLayout.findViewById(R.id.appointments_section);
        mAppointmentContent = (LinearLayout) mAppointmentSection.findViewById(R.id.appointment_content);

        if (Variables.matched)
            mAppointmentContent.setVisibility(View.VISIBLE);

        return view;
    }
}
