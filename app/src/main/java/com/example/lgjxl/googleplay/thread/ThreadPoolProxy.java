package com.example.lgjxl.googleplay.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by niu on 2016/6/27.
 * 线程池管理类
 */

public class ThreadPoolProxy {
    private ThreadPoolExecutor mExecutor;
    private int corePoolSize;
    private int maximumPoolSize;
    private long keepAliveTime;

    public ThreadPoolProxy(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
    }

    /**
     * 执行任务
     * @param task
     */
    public void execute(Runnable task) {

        initThreadPoolExecutor();

        mExecutor.execute(task);                                                    //把任务加入队列

    }

    private synchronized void initThreadPoolExecutor() {
        if (mExecutor == null||mExecutor.isShutdown()||mExecutor.isTerminated()) {

            TimeUnit unit=TimeUnit.MILLISECONDS;
            BlockingQueue<Runnable> workQueue=new LinkedBlockingDeque<>();
            ThreadFactory threadFactory= Executors.defaultThreadFactory();
            RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();//不做处理
            mExecutor = new ThreadPoolExecutor(corePoolSize,                        //核心线程数
                                                maximumPoolSize,                    //最大线程数
                                                keepAliveTime,                      //保持活动时间
                                                unit,                               //时间单位
                                                workQueue,                          //任务队列
                                                threadFactory,                      //线程工厂
                                                handler);                           //错误捕获器
        }
    }

    public Future<?> submit(Runnable task) {
        initThreadPoolExecutor();
        return mExecutor.submit(task);
    }

    public void remove(Runnable task) {
        if (mExecutor != null) {
            mExecutor.remove(task);
        }
    }
}
