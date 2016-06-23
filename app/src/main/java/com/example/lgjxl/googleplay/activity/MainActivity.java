package com.example.lgjxl.googleplay.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.lgjxl.googleplay.R;
import com.example.lgjxl.googleplay.adapter.MainFragmentPagerAdapter;
import com.example.lgjxl.googleplay.utils.UIUtils;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MainFragmentPagerAdapter mMainFragmentPagerAdapter;
    private String[] mTitles;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        addEvents();
    }

    private void initData() {
        Log.e("TAG", "initData: "+"加載數據" );

        mTitles = UIUtils.getStringArray(R.array.main_titles);
        for (int i=0;i<mTitles.length;i++) {
            Log.e("TAG", "initData: "+mTitles[i] );
        }
        mMainFragmentPagerAdapter = new MainFragmentPagerAdapter(fragmentManager);
        mViewPager.setAdapter(mMainFragmentPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    private void addEvents() {


    }

    private void initView() {
        fragmentManager = getSupportFragmentManager();
        mToolbar = (Toolbar) findViewById(R.id.tb_normal);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(R.string.app_title);
        mToolbar.setLogo(R.mipmap.ic_launcher);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,                      //创建开关
                R.string.drawer_open,R.string.drawer_close);
        mDrawerToggle.syncState();                                                                  //必须同步
        mDrawerLayout.addDrawerListener(mDrawerToggle);                                             //添加打开的监听
        mTabLayout = (TabLayout) findViewById(R.id.tabs_main);
        mViewPager = (ViewPager) findViewById(R.id.vp_main);

        Log.e("TAG", "initData: "+"加載試圖" );

    }



}
