package com.example.drawerallactivities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class NavigationDrawerFragment extends Fragment {

    private ActionBarDrawerToggle mDrawerToggle;
    public DrawerLayout mDrawerLayout;
    public TextView txt1, txt2;
    public ImageView closeNav;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        initView(view);
        clickListener(view);
        return view;
    }



    // -------------------------------------------------------------------------------------------------
    private void initView(View view) {

        closeNav = view.findViewById(R.id.closeNav);
        txt1 = view.findViewById(R.id.txt1);
        txt2 = view.findViewById(R.id.txt2);

    }

    private void clickListener(View view) {

        closeNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();

            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "txt1 clicked", Toast.LENGTH_SHORT).show();

            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "txt2 clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void setUp(DrawerLayout drawerLayout) {
        mDrawerLayout = drawerLayout;
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

}
