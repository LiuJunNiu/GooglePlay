package com.example.lgjxl.googleplay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.lgjxl.googleplay.R;

/**
 * Created by niu on 2016/6/23.
 * 新建一个容器用来保存图片
 */

public class LoadingPager extends FrameLayout {

    //view应该包含加载中，空页面，错误界面，成功
    private View mLoadingView;


    public LoadingPager(Context context) {
        super(context);
        initView();
    }

    public LoadingPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        //创建图
        if (mLoadingView == null) {
            mLoadingView = View.inflate(getContext(), R.layout.pager_loading, null);
        }

        //添加到自己中
        addView(mLoadingView);
    }


}
