package com.example.lgjxl.googleplay.fragment.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.lgjxl.googleplay.view.LoadingPager;

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
    private LoadingPager mLoadingPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //视图的共同点：
        //无网络；加载中；空页面

        //不同点：
        //成功后的界面

        //将共同点抽取出来

        //view应该包含加载中，空页面，错误界面，成功

        if (mLoadingPager == null) {
//            Log.e("TAG", "onCreateView: ------"+"创建新视图" );
            mLoadingPager = new LoadingPager(mActivity) {
                @Override
                protected View initSuccessView() {
                    return onLoadSuccessView();
                }

                @Override
                protected LoadedResult onLoadData() {
//                    Log.e("TAG", "onLoadData: --------"+"加载数据" );
                    return onLoadingData();
                }
            };
        } else {

            ViewParent parent = mLoadingPager.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(mLoadingPager);

            }
        }




        return mLoadingPager;
    }

//    /**
//     * 在这个里面去加载数据
//     * @param savedInstanceState
//     */
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        //数据加载
//        loadData();
//
//    }

    /**
     * 交给之类实现
     * @return
     */
    protected abstract View onLoadSuccessView();


    /**
     * 交给子类实现
     * @return int
     */
    protected abstract LoadingPager.LoadedResult onLoadingData();

    public void loadData() {
//        Log.e("TAG", "loadData: mloadingPager"+mLoadingPager.toString() );
        if (mLoadingPager != null) {
            mLoadingPager.loadData();
//            Log.e("TAG", "loadData:------- "+"开始加载数据" );
        }
    }

}
