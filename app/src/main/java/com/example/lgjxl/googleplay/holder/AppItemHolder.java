package com.example.lgjxl.googleplay.holder;

import android.view.View;
import android.widget.TextView;

import com.example.lgjxl.googleplay.R;
import com.example.lgjxl.googleplay.holder.base.BaseHolder;
import com.example.lgjxl.googleplay.utils.UIUtils;

/**
 * Created by niu on 2016/6/28.
 * holder实现类
 */

public class AppItemHolder extends BaseHolder<String> {

    private TextView tv1;
    private TextView tv2;

    @Override
    protected View initView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.item_tmp, null);
        tv1 = (TextView) view.findViewById(R.id.tmp_tv_1);
        tv2 = (TextView) view.findViewById(R.id.tmp_tv_2);
        return view;
    }

    @Override
    protected void refreshUI(String data) {

        //给View设置数据
        tv1.setText("头" + data);
        tv2.setText("内容" + data);
    }
}
