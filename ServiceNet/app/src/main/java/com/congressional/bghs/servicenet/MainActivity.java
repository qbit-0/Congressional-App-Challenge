package com.congressional.bghs.servicenet;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    android.app.FragmentManager mFragmentManager;

    NavigationView mNavigationView;
    DrawerLayout mDrawer;
    View mHeaderView;
    TextView mUsernameTextView;
    TextView mNameTextView;
    TextView mEmailAdressTextView;
    View mAppBar;
    View mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFragmentManager = getFragmentManager();

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        mHeaderView = mNavigationView.getHeaderView(0);

        mUsernameTextView = (TextView) mHeaderView.findViewById(R.id.tv_username);
        mUsernameTextView.setText(Variables.username);

        mNameTextView = (TextView) mHeaderView.findViewById(R.id.tv_name);
        mNameTextView.setText(Variables.firstName + " " + Variables.lastName);

        mEmailAdressTextView = (TextView) mHeaderView.findViewById(R.id.tv_email_adress);
        mEmailAdressTextView.setText(Variables.emailAdress);

        mAppBar = findViewById(R.id.i_app_bar_provider_search);
        mContent = mAppBar.findViewById(R.id.i_content_main);

        mFragmentManager.beginTransaction()
                .replace(R.id.i_content_main, new WelcomeFragment())
                .commit();
        setTitle(R.string.nav_welcome_label);
    }

    @Override
    public void onBackPressed()
    {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawer.isDrawerOpen(GravityCompat.START))
        {
            mDrawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.provider_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_settings:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.nav_search:
                mFragmentManager.beginTransaction()
                        .replace(R.id.i_content_main, new SearchFragment())
                        .commit();
                setTitle(R.string.nav_search_label);
                break;
            case R.id.nav_service:
                mFragmentManager.beginTransaction()
                        .replace(R.id.i_content_main, new ServiceFragment())
                        .commit();
                setTitle(R.string.nav_service_label);
                break;
            case R.id.nav_profile:
                mFragmentManager.beginTransaction()
                        .replace(R.id.i_content_main, new ProfileFragment())
                        .commit();
                setTitle(R.string.nav_profile_label);
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_welcome:
                mFragmentManager.beginTransaction()
                        .replace(R.id.i_content_main, new WelcomeFragment())
                        .commit();
                setTitle(R.string.nav_welcome_label);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
