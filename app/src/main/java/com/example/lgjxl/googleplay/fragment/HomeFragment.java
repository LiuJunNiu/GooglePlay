package com.example.lgjxl.googleplay.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.lgjxl.googleplay.fragment.base.BaseFragment;

/**
 * Created by niu on 2016/6/21.
 * 首页
 */

public class HomeFragment extends BaseFragment {
    @Override
    protected View initView() {
        TextView textView = new TextView(mActivity);
        textView.setText("首页");

        return textView;
    }
}
