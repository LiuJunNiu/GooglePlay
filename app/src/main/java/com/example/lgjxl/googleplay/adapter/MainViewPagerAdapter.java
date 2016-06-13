package com.example.lgjxl.googleplay.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by niu on 2016/6/13.
 */

public class MainViewPagerAdapter extends PagerAdapter {

    private Context context;
    private String[] titles;

    public MainViewPagerAdapter(Context context,String[] titles) {
        this.context = context;
        this.titles = titles;
    }

    @Override
    public int getCount() {

        return titles.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView textView = new TextView(context);
        textView.setText(titles[position]);
        textView.setTextSize(120);
        textView.setGravity(Gravity.CENTER);
        container.addView(textView);
        return textView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles[position];
    }
}
