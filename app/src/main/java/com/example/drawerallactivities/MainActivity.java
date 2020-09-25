package com.example.drawerallactivities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);  delete this line

        // add drawerlayout
        LayoutInflater inflater=(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_main,null,false);
        mDrawer_layout.addView(contentView,0);



        btn =findViewById(R.id.btn);
        btn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,SecondActivity.class)));
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}