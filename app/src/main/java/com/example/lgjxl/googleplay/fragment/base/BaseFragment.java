package com.example.lgjxl.googleplay.fragment.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @ProjectName:GooglePlay
 * @PackageName:com.example.lgjxl.googleplay.fragment.base
 * @Describle:所有fragment的基类;加载视图子类必须实现，加载到activity时加载数据，需要时实现
 * @Author:LiuJun
 * @Data:2016-04-28 23:23
 * @ModifyAuthor:LiuJun
 * @ModifyTime:04-28 23:23
 * @ModifyDescrible:
 * @Version:
 */
public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;//加载Fragment的Activity
    protected View rootView;//Fragment中的根视图
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = initView();
        container.addView(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initData();
    }

    //由子类决定要不要实现
    protected void initData() {

    }

    protected abstract View initView();//子类必须实现


}
