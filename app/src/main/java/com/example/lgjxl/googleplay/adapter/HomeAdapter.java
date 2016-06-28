package com.example.lgjxl.googleplay.adapter;

import com.example.lgjxl.googleplay.holder.AppItemHolder;
import com.example.lgjxl.googleplay.holder.BaseHolder;

import java.util.List;

/**
 * Created by niu on 2016/6/28.
 * 主页的adapter
 */

public class HomeAdapter extends SuperBaseAdapter<String> {


    public HomeAdapter(List<String> mDatas) {
        super(mDatas);
    }

    @Override
    protected BaseHolder<String> getItemHolder() {
        return new AppItemHolder();
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        HomeAdapterViewHolder homeAdapterViewHolder = null;
//        if (convertView == null) {
//            homeAdapterViewHolder = new HomeAdapterViewHolder();
//            convertView = View.inflate(UIUtils.getContext(), R.layout.item_tmp, null);
//            convertView.setTag(homeAdapterViewHolder);
//            homeAdapterViewHolder.tv1 = (TextView) convertView.findViewById(R.id.tmp_tv_1);
//            homeAdapterViewHolder.tv2 = (TextView) convertView.findViewById(R.id.tmp_tv_2);
//
//        } else {
//            homeAdapterViewHolder= (HomeAdapterViewHolder) convertView.getTag();
//        }
//
//        homeAdapterViewHolder.tv1.setText("头" + getItem(position));
//        homeAdapterViewHolder.tv2.setText("内容" + getItem(position));
//
//        return convertView;
//    }
//
//    class HomeAdapterViewHolder {
//
//        TextView tv1;
//        TextView tv2;
//
//    }

}
