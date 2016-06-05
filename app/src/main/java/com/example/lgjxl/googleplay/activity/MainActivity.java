package com.example.lgjxl.googleplay.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import com.example.lgjxl.googleplay.R;
import com.example.lgjxl.googleplay.activity.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        DrawerLayout drawerLayout = new DrawerLayout(this);
    }

    @Override
    protected void initToolBar() {

    }


}
