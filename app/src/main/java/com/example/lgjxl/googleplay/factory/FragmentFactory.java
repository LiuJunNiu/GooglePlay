package com.example.lgjxl.googleplay.factory;

import android.support.v4.app.Fragment;
import android.support.v4.util.SparseArrayCompat;

import com.example.lgjxl.googleplay.fragment.HomeFragment;

/**
 * Created by niu on 2016/6/21.
 * fragment工厂类
 */

public class FragmentFactory {

    //    private static Map<Integer, Fragment> mCaches = new HashMap<Integer, Fragment>();
    //是一个类似于map集合，性能提升至少50%，只是用于integer，object
    private static SparseArrayCompat<Fragment> mCaches = new SparseArrayCompat<>();

    public static Fragment getFragment(int position) {

//        <item>首页</item>
//        <item>应用</item>
//        <item>游戏</item>
//        <item>专题</item>
//        <item>推荐</item>
//        <item>分类</item>
//        <item>排行</item>

        Fragment fragment = mCaches.get(position);
        if (fragment != null) {
            return fragment;
        }

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new HomeFragment();
                break;
            case 2:
                fragment = new HomeFragment();
                break;
            case 3:
                fragment = new HomeFragment();
                break;
            case 4:
                fragment = new HomeFragment();
                break;
            case 5:
                fragment = new HomeFragment();
                break;
            case 6:
                fragment = new HomeFragment();
                break;
        }
        return fragment;
    }
}
