package com.congressional.bghs.servicenet;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity
{
    final Context context = this;

    EditText mUsernameTextView;
    Button mLoginButton;
    ProgressBar mLoginProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameTextView = (EditText) findViewById(R.id.et_username);
        mLoginButton = (Button) findViewById(R.id.btn_login);
        mLoginProgressBar = (ProgressBar) findViewById(R.id.pb_login);

        View.OnClickListener clickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Handler handler = new Handler();
                mLoginButton.setVisibility(View.INVISIBLE);
                mLoginProgressBar.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Class destination = SearchProviderActivity.class;
                        Variables.username = mUsernameTextView.getText().toString();
                        Variables.emailAdress = Variables.username + "@gmail.com";
                        Variables.firstName = "Benedict";
                        Variables.lastName = "Cucumberpatch";
                        Intent intent = new Intent(context, destination);
                        startActivity(intent);
                    }
                }, 1000);
            }
        };
        mLoginButton.setOnClickListener(clickListener);
    }
}