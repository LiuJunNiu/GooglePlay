package com.example.lgjxl.googleplay.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.lgjxl.googleplay.R;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addEvents();
    }

    private void addEvents() {
        mDrawerLayout.addDrawerListener(mDrawerToggle);

    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.tb_normal);
        mToolbar.setTitle("GooglePlay");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main);

        setSupportActionBar(mToolbar);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,
                R.string.drawer_open,R.string.drawer_close);
        mDrawerToggle.syncState();

    }



}
