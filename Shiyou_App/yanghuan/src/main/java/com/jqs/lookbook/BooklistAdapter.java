package com.jqs.lookbook;

/**
 * Created by qiangsheng on 2016/4/20.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yanghuan.R;

import java.util.List;

public class BooklistAdapter extends BaseAdapter {//优化listview

    private List<String> booklist;
    private LayoutInflater inflater;

    public BooklistAdapter(List booklist, Context context) {
        this.booklist = booklist;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return booklist.size();
    }

    @Override
    public Object getItem(int arg0) {
        return booklist.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.booklist_item, null);
        TextView booklistOrderTv = (TextView) convertView
                .findViewById(R.id.booklist_order_tv);
        TextView booklistTitleTv = (TextView) convertView
                .findViewById(R.id.booklist_title_tv);

        booklistOrderTv.setText(""+position);
        booklistTitleTv.setText(booklist.get(position));

        return convertView;
    }

}

