package com.example.lgjxl.googleplay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.lgjxl.googleplay.fragment.base.BaseFragment;
import com.example.lgjxl.googleplay.view.LoadingPager;

import java.util.Random;

/**
 * Created by niu on 2016/6/21.
 * 首页
 */

public class HomeFragment extends BaseFragment {

    @Override
    protected View onLoadSuccessView() {
        TextView textView = new TextView(mActivity);
        textView.setText("首页");

        return textView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    @Override
    protected LoadingPager.LoadedResult onLoadingData() {

        LoadingPager.LoadedResult[] results = new LoadingPager.LoadedResult[]{LoadingPager.LoadedResult.EMPTY,
                LoadingPager.LoadedResult.ERROR, LoadingPager.LoadedResult.SUCCESS};
        Random rdm = new Random();
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LoadingPager.LoadedResult result = results[rdm.nextInt(results.length)];
//        Log.e("TAG", "onLoadingData: -------"+result);
        return result;
    }
}
