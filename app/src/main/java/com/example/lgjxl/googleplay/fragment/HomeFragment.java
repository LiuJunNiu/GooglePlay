package com.example.lgjxl.googleplay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.example.lgjxl.googleplay.adapter.HomeAdapter;
import com.example.lgjxl.googleplay.fragment.base.BaseFragment;
import com.example.lgjxl.googleplay.view.LoadingPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niu on 2016/6/21.
 * 首页
 */

public class HomeFragment extends BaseFragment {


    private List<String> mDatas;

    @Override
    protected View onLoadSuccessView() {
//        TextView textView = new TextView(mActivity);
//        textView.setText("首页");

//        return textView;

        ListView listView = new ListView(mActivity);
//        listView.setCacheColorHint(Color.TRANSPARENT);
//        listView.setSelector(android.R.color.transparent);
//        listView.setDividerHeight(0);
//        listView.setScrollingCacheEnabled(false);




        HomeAdapter mHomeAdapter = new HomeAdapter(mDatas);

        //设置数据
        listView.setAdapter(mHomeAdapter);


        return listView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    @Override
    protected LoadingPager.LoadedResult onLoadingData() {

        //模拟随即数
//        LoadingPager.LoadedResult[] results = new LoadingPager.LoadedResult[]{LoadingPager.LoadedResult.EMPTY,
//                LoadingPager.LoadedResult.ERROR, LoadingPager.LoadedResult.SUCCESS};
//        Random rdm = new Random();
//        try {
//            Thread.sleep(1000);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        LoadingPager.LoadedResult result = results[rdm.nextInt(results.length)];
////        Log.e("TAG", "onLoadingData: -------"+result);
//        return result;

        mDatas = new ArrayList<>();

        for (int i=0;i<50;i++) {
            mDatas.add("随即数" + i);
        }

        return LoadingPager.LoadedResult.SUCCESS;
    }
}
