package com.example.lgjxl.googleplay.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lgjxl.googleplay.holder.BaseHolder;

import java.util.List;

/**
 * Created by niu on 2016/6/28.
 * baseadapter抽取基类
 */

public abstract class SuperBaseAdapter<T> extends BaseAdapter {

    private List<T> mDatas;

    public SuperBaseAdapter(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas!=null?mDatas.size():0;
    }

    @Override
    public T getItem(int position) {

        return mDatas!=null?mDatas.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BaseHolder baseHolder = null;

        if (convertView == null) {
            baseHolder = getItemHolder();
            convertView = baseHolder.getRootView();

        } else {
            baseHolder = (BaseHolder) convertView.getTag();
        }

        T data = getItem(position);

        baseHolder.setData(data);

        return convertView;
    }

    protected abstract BaseHolder<T> getItemHolder();

}

