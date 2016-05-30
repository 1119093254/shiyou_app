package com.yanghuan.FrageMents;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.yanghuan.MyViews.HorizontalListView;
import com.yanghuan.R;
import com.yanghuan.Utils.picture;
import com.yanghuan.adapters.HorenListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨欢 on 2016/5/23.
 */
public class WsFragement extends Fragment {
    HorenListAdapter adapter;
    List<picture> mlist;
    GridView gridView;
    View mView;
    Context mContext;
  /*  HorizontalListView */
  HorizontalListView listView;
    List<picture> list;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext=activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.weishi,null);
        initView();
        initData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                Toast.makeText(getContext(), "你点击的是第"+(arg2+1)+"张图片", Toast.LENGTH_SHORT).show();
            }
        });
        return mView;
    }

    private void initView() {
        listView = (HorizontalListView) mView.findViewById(R.id.listView);
        gridView= (GridView) mView.findViewById(R.id.weishi_gridView);
    }
    private void initData() {
        list=new ArrayList<>();
        picture pic1=new picture("电视","http://o6nj6n5ea.bkt.clouddn.com/yh_dsj7.jpg","");
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);
        list.add(pic1);

        mlist=new ArrayList<>();
        picture pic=new picture("电视","http://o6nj6n5ea.bkt.clouddn.com/yh_dsj8.jpg","");
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);
        mlist.add(pic);

        adapter=new HorenListAdapter(mContext,mlist);
        listView.setAdapter(adapter);


      int si=mlist.size();
        if(si==1){
            gridView.setNumColumns(1);
        }
        else if(si==2||si==4){

           gridView.setNumColumns(2);
        }
        else {
            gridView.setNumColumns(3);
        }

        adapter=new HorenListAdapter(mContext,list);;
        gridView.setAdapter(adapter);

    }


}
