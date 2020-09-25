package com.example.drawerallactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BaseActivity extends PersianAppcompatActivity {

    public NavigationDrawerFragment mNavigationDrawerFragment;
    public DrawerLayout mDrawer_layout;
    ImageView img_open_nav;

    BroadcastReceiver connectivityReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


        initView();

        mNavigationDrawerFragment.setUp(mDrawer_layout);



        //check network broadcast reciever
        GeneralTools tools = GeneralTools.getInstance();
        connectivityReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                tools.doCheckNetwork(BaseActivity.this, findViewById(R.id.root_main));
            }
        };

    }

    private void initView() {

        mDrawer_layout = (DrawerLayout) findViewById(R.id.mDrawer_layout);
        img_open_nav = findViewById(R.id.img_open_nav);
        img_open_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(mDrawer_layout);
            }
        });

        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.mNavigation_drawer_fragment);

    }



    private void openDrawer(DrawerLayout mDrawerLayout) {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            mDrawerLayout.closeDrawer(GravityCompat.END);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.END);
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocalManager.setLocale(base));

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(connectivityReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(connectivityReceiver);
        super.onDestroy();
    }
}