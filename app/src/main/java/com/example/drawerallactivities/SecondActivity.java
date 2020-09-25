package com.example.drawerallactivities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);  delete this line

        LayoutInflater inflater=(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_second,null,false);
        mDrawer_layout.addView(contentView,0);



    }
}