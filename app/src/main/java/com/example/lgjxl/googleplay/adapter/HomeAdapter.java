package com.example.lgjxl.googleplay.adapter;

import com.example.lgjxl.googleplay.adapter.base.SuperBaseAdapter;
import com.example.lgjxl.googleplay.holder.AppItemHolder;
import com.example.lgjxl.googleplay.holder.base.BaseHolder;

import java.util.List;

/**
 * Created by niu on 2016/6/28.
 * 主页的adapter
 */

public class HomeAdapter extends SuperBaseAdapter<String> {


    public HomeAdapter(List<String> mDatas) {
        super(mDatas);
    }

    @Override
    protected BaseHolder<String> getItemHolder() {
        return new AppItemHolder();
    }

}
