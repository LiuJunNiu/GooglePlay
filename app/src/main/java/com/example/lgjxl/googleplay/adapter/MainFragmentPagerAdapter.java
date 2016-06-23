package com.example.lgjxl.googleplay.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.lgjxl.googleplay.R;
import com.example.lgjxl.googleplay.factory.FragmentFactory;
import com.example.lgjxl.googleplay.utils.UIUtils;

/**
 * Created by niu on 2016/6/21.
 * fragment适配器
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] titles;

    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        titles = UIUtils.getStringArray(R.array.main_titles);
        for (int i=0;i<titles.length;i++) {
            Log.e("TAG", "initData: "+titles[i] );
        }
    }

//    public MainFragmentPagerAdapter(Context context,String[] titles) {
////        super(fm);
//        this.context = context;
//        this.titles = titles;
//    }

    @Override
    public Fragment getItem(int position) {

        return FragmentFactory.getFragment(position);
    }

    @Override
    public int getCount() {
        if (titles != null) {
            return titles.length;
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles[position];
    }
}
