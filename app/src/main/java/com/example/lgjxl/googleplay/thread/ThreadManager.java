package com.example.lgjxl.googleplay.thread;

/**
 * Created by niu on 2016/6/27.
 * 线程池管理类
 */

public class ThreadManager {

    private static ThreadPoolProxy mLongPool;
    private static final  Object mLock = new Object();
    /**
     * 获得长时间的线程池
     * @return mLongPool
     */
    public synchronized static ThreadPoolProxy getLongPool() {
        if (mLongPool == null) {
            synchronized (mLock) {
                if (mLongPool == null) {
                    mLongPool = new ThreadPoolProxy(5, 5, 0);
                }
            }
        }
        return mLongPool;
    }

}
