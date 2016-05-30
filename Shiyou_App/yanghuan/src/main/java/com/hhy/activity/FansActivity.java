package com.hhy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.hhy.adapter.FansAdapter;
import com.hhy.bean.Fans;
import com.yanghuan.R;

import java.util.ArrayList;
import java.util.List;

public class FansActivity extends AppCompatActivity {
    List<Fans> mList;
    ListView mListView;
    FansAdapter mFansAdapter;
    ImageView mImageView;
    boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hhy_activity_fans);
        initView();
        initData();
        addlistener();
        setAdapter();

    }

    private void addlistener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //跳转到某一粉丝的详细介绍页面上
              /*  Fans fans = mList.get(position);
                Intent intent = new Intent(FansActivity.this,DetailActivity.class);
                intent.putExtra("data",fans);
                startActivity(intent);*/
            }
        });
    }


    private void initView() {
        mListView = (ListView) findViewById(R.id.fans_listview);

    }

    private void initData() {
        mList = new ArrayList<Fans>();
        //从数据库上获取图片时用Glide进行加载
        Fans fans1 = new Fans(R.drawable.icon_uzao, "逸凡", R.drawable.card_icon_addattention);
        Fans fans2 = new Fans(R.drawable.icon_xiang, "逸凡", R.drawable.card_icon_addattention);
        Fans fans3 = new Fans(R.drawable.icon, "逸凡", R.drawable.card_icon_addattention);
        Fans fans4 = new Fans(R.drawable.icon_uzao, "逸凡", R.drawable.card_icon_addattention);
        Fans fans5 = new Fans(R.drawable.icon, "逸凡", R.drawable.card_icon_addattention);
        Fans fans6 = new Fans(R.drawable.icon_xiang, "逸凡", R.drawable.card_icon_addattention);
        mList.add(fans1);
        mList.add(fans2);
        mList.add(fans3);
        mList.add(fans4);
        mList.add(fans5);
        mList.add(fans6);
    }

    private void setAdapter() {
        mFansAdapter = new FansAdapter(mList,FansActivity.this);
        mListView.setAdapter(mFansAdapter);

    }


}

