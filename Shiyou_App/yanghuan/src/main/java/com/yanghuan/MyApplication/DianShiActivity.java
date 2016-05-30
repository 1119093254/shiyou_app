package com.yanghuan.MyApplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import com.yanghuan.R;
import com.yanghuan.Utils.Dianshi;
import com.yanghuan.Utils.ShiPin;
import com.yanghuan.adapters.DianshiAdapter;

import org.xutils.BuildConfig;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class DianShiActivity extends AppCompatActivity {
    DianshiAdapter dianshiAdapter;
    PullToRefreshListView  listView;
    List<Dianshi> list;
    List<ShiPin> mlist;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dian_shi);
        initXUtils();
        initView();
        initData();
        dianshiAdapter=new DianshiAdapter(list,DianShiActivity.this);
        listView.setAdapter(dianshiAdapter);
        //设置为Both，表明：上拉和下拉同时都适用
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        //初始化刷新操作
        initRefreshListView();
        //listview的监听事件
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new loadDataAsyncTask(DianShiActivity.this).execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                new loadDataAsyncTask(DianShiActivity.this).execute();
            }
        });
        String  activityName=getIntent().getStringExtra("1");
    }

    private void initXUtils() {
        x.Ext.init(getApplication());
        x.Ext.setDebug(BuildConfig.DEBUG);
    }


    private void initData() {
        list=new ArrayList<>();
        mlist=new ArrayList<>();
        ShiPin shiPin=new ShiPin("神雕侠侣","http://o6nj6n5ea.bkt.clouddn.com/yh_dsj8.jpg","更新11集");
        ShiPin shiPin1=new ShiPin("太阳的后裔","http://o6nj6n5ea.bkt.clouddn.com/yh_dsj7.jpg","更新11集");
        mlist.add(shiPin);
        mlist.add(shiPin1);
        mlist.add(shiPin);
        mlist.add(shiPin);
        Dianshi dianshi=new Dianshi("更新12集","http://o6nj6n5ea.bkt.clouddn.com/yh_dsj5.jpg","欢乐颂",mlist,"偶像电视剧");
        Dianshi dianshi1=new Dianshi("更新13集","http://o6nj6n5ea.bkt.clouddn.com/yh_dsj9.jpg","欢乐颂",mlist,"偶像电视剧");
        list.add(dianshi);
        list.add(dianshi1);
        list.add(dianshi);
        list.add(dianshi);
    }
    private void initData1() {
        list=new ArrayList<>();
        mlist=new ArrayList<>();
        ShiPin shiPin=new ShiPin("一起来看流星雨","http://o6nj6n5ea.bkt.clouddn.com/yh_dsj8.jpg","更新11集");
        ShiPin shiPin1=new ShiPin("甄嬛传","http://o6nj6n5ea.bkt.clouddn.com/yh_dsj7.jpg","更新11集");
        mlist.add(shiPin);
        mlist.add(shiPin1);

        Dianshi dianshi=new Dianshi("更新12集","http://o6nj6n5ea.bkt.clouddn.com/yh_dsj5.jpg","翻译官",mlist,"偶像电视剧");
        Dianshi dianshi1=new Dianshi("更新13集","http://o6nj6n5ea.bkt.clouddn.com/yh_dsj9.jpg","翻译官",mlist,"偶像电视剧");
        list.add(dianshi);
        list.add(dianshi1);
    }
    //内部类：实现数据加载的耗时操作
    static class loadDataAsyncTask extends AsyncTask<Void, Void, String> {
        private DianShiActivity activity;
        public loadDataAsyncTask(DianShiActivity activity) {
            this.activity = activity;
        }
        @Override
        protected String doInBackground(Void... params) {
            //用一个线程来模拟刷新
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //加载数据
            activity.initData1();
            return "success";
        }
        //对返回值进行操作
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if ("success".equals(s)) {
                //通知数据集改变，刷新页面
                activity.dianshiAdapter.notifyDataSetChanged();
                //刷新完成
                activity.listView.onRefreshComplete();
            }
        }
    }


    public void initRefreshListView() {
        ILoadingLayout startLables =listView.getLoadingLayoutProxy(true, false);
        startLables.setPullLabel("下拉刷新");
        startLables.setRefreshingLabel("正在拉");
        startLables.setReleaseLabel("放开刷新");
        ILoadingLayout endLabels = listView.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉加载");
        endLabels.setRefreshingLabel("正在载入...");
        endLabels.setReleaseLabel("放开加载...");
    }
    private void initView() {
        listView= (PullToRefreshListView) findViewById(R.id.activity_listview);
        imageView= (ImageView) findViewById(R.id.activity_dian_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
