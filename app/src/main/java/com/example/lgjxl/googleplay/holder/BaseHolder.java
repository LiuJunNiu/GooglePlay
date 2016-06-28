package com.example.lgjxl.googleplay.holder;

import android.view.View;

/**
 * Created by niu on 2016/6/28.
 * baseViewHolder
 */

public abstract class BaseHolder<T> {

    protected View mRootView;//根视图
    protected T data;           //数据

    public BaseHolder() {
        mRootView = initView();
        mRootView.setTag(this);             //设置标记

    }

    /**
     * 实现view布局
     * @return View
     */
    protected abstract View initView();


    /**
     * 获取根布局
     * @return View
     */
    public View getRootView() {
        return mRootView;
    }

    public void setData(T data) {
        //设置数据
        this.data = data;
        //改变UI
        refreshUI(data);

    }

    protected abstract void refreshUI(T data);
}
