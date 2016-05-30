package com.hhy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hhy.bean.OtherInfoBean;
import com.yanghuan.R;

import java.util.List;

/**
 * Created by hanhongyang on 2016/5/30.
 */
public class OtherInfoAdapter extends BaseAdapter{
    List<OtherInfoBean> mBeanList;
    Context mContext;
    LayoutInflater mInflater;

    public OtherInfoAdapter(List<OtherInfoBean> beanList, Context context) {
        mBeanList = beanList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        SimpleDraweeView mSimpleDraweeView;
        TextView mUnameText,mUsignText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.otherinfo_item_zujin,null);

        }

        return null;
    }
}
