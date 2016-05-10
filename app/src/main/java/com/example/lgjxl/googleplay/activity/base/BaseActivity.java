package com.example.lgjxl.googleplay.activity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by niu on 2016/5/10.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initToolBar();
    }

    protected abstract void initView();

    protected abstract void initToolBar() ;

}
