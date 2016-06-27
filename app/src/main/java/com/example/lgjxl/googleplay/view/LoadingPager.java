package com.example.lgjxl.googleplay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.lgjxl.googleplay.R;
import com.example.lgjxl.googleplay.thread.ThreadManager;
import com.example.lgjxl.googleplay.utils.UIUtils;

/**
 * Created by niu on 2016/6/23.
 * 新建一个容器用来保存图片
 */

public abstract class LoadingPager extends FrameLayout {

    private final static int STATE_NONE = 0;                //没有状态
    private final static int STATE_LOADING = 1;
    private final static int STATE_EMPTY = 2;
    private final static int STATE_ERROR = 3;
    private final static int STATE_SUCCESS = 4;

    //view应该包含加载中，空页面，错误界面，成功
    private View mLoadingView;                      //加载中
    private View mEmptyView;                        //数据空
    private View mErrorView;                        //错误
    private View mSuccessView;                      //成功的view

    private Button mRetryView;                      //联网重试

    private int mCurrentState = STATE_NONE;      //默认状态

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
            addView(mLoadingView);
        }


        if (mEmptyView == null) {
            mEmptyView = View.inflate(getContext(), R.layout.pager_empty, null);
            addView(mEmptyView);
        }


        if (mErrorView == null) {
            mErrorView = View.inflate(getContext(), R.layout.pager_error, null);
            mRetryView = (Button) mErrorView.findViewById(R.id.error_btn_retry);
            mRetryView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadData();
                }
            });
            addView(mErrorView);
        }


        safeUpdateUI();
    }

    private void safeUpdateUI() {
        UIUtils.post(new Runnable() {
            @Override
            public void run() {
                updateUI();
            }
        });
    }

    private void updateUI() {
        mLoadingView.setVisibility(mCurrentState==STATE_NONE||mCurrentState == STATE_LOADING ? VISIBLE : GONE);
        mEmptyView.setVisibility(mCurrentState == STATE_EMPTY ? VISIBLE : GONE);
        mErrorView.setVisibility(mCurrentState == STATE_ERROR ? VISIBLE : GONE);

        if (mCurrentState == STATE_SUCCESS && mSuccessView == null) {
            //需要创建成功的view
            mSuccessView = initSuccessView();
            addView(mSuccessView);
        }
        //成功的view
        if (mSuccessView != null) {
            mSuccessView.setVisibility(mCurrentState == STATE_SUCCESS ? VISIBLE : GONE);
        }
    }

    /**
     * 让子类去实现
     * @return view
     */
    protected abstract View initSuccessView();

    protected abstract LoadedResult onLoadData();
    /**
     * 记载数据，一般都在分线程
     */
    public void loadData() {

        //如果现在是成功的页面就不去加载
        if (mCurrentState != STATE_SUCCESS && mCurrentState != STATE_LOADING) {

            mCurrentState = STATE_LOADING;
            safeUpdateUI();
//            new Thread(new LoadDataTask()).start();
            ThreadManager.getLongPool().execute(new LoadDataTask());
        }

    }

    class LoadDataTask implements Runnable{
        @Override
        public void run() {
            //去加载数据

            //数据有没有成功
            mCurrentState = onLoadData().getState();
            //状态决定view状态


            //在子线程中执行会报错，需要handler
            safeUpdateUI();

        }
    }

    public enum LoadedResult {

        EMPTY(STATE_EMPTY),ERROR(STATE_ERROR), SUCCESS(STATE_SUCCESS);

        private int state;
        private LoadedResult(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }

    }


}
