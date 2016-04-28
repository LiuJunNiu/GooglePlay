package com.example.lgjxl.googleplay.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.example.lgjxl.googleplay.R;

/**
 * @ProjectName:GooglePlay
 * @PackageName:com.example.lgjxl.googleplay.activity.base
 * @Describle:所有activity的基类；提供toolbar，内容由子类修改
 * @Author:LiuJun
 * @Data:2016-04-28 23:19
 * @ModifyAuthor:LiuJun
 * @ModifyTime:04-28 23:19
 * @ModifyDescrible:
 * @Version:
 */
public abstract class BaseActivity extends Activity{
    protected Toolbar mToolbar;//提供toolbar
    protected FrameLayout mContentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mToolbar = (Toolbar) findViewById(R.id.tb_base_activity_title);
        mContentView = (FrameLayout) findViewById(R.id.fl_base_activity_content);

        initView();//初始化视图
        initData();//加载数据
        addListener();//添加监听
    }

    protected void addListener() {
    }

    protected void initData() {

    }

    protected void initView() {
    }


}
