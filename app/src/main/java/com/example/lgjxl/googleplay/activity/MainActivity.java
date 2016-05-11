package com.example.lgjxl.googleplay.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.example.lgjxl.googleplay.R;
import com.example.lgjxl.googleplay.activity.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        DrawerLayout drawerLayout = new DrawerLayout(this);
    }

    @Override
    protected void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.tb_normal);
        mToolbar.setTitle("GooglePlay");
        setSupportActionBar(mToolbar);
        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setNavigationIcon(R.drawable.ic_drawer_am);

    }


}
