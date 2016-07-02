package com.example.lgjxl.googleplay;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.RequestQueue;

/**
 * Created by niu on 2016/6/13.
 * 项目全局初始化
 */

public class BaseApplication extends Application {

    private static Context context;
    private static Thread mMainThread;
    private static long mMainThreadId;
    private static Handler mMainHandler;
    private static Looper mMainLooper;
    private static RequestQueue requestQueue;                           //请求队列

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static Handler getMainHandler() {
        return mMainHandler;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    public static Context getContext(){
        return context;
    }
    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
        this.mMainThread = Thread.currentThread();
        this.mMainThreadId = mMainThread.getId();
        this.mMainHandler = new Handler();
        this.mMainLooper = getMainLooper();
        this.requestQueue = NoHttp.newRequestQueue(); }
}
