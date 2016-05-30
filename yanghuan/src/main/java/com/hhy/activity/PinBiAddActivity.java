package com.hhy.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hhy.adapter.PingBiAddAdapter;
import com.hhy.bean.UserInfo;
import com.hhy.bean.User_Pingbi;
import com.yanghuan.BuildConfig;
import com.yanghuan.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PinBiAddActivity extends AppCompatActivity {
    List<User_Pingbi> mList;
    User_Pingbi mUser_pingbi;
    PingBiAddAdapter mAdapter;
    PullToRefreshListView mPullToRefreshListView;
    RelativeLayout mRelativeLayout;
    String url;
    String biaozhi;
    int uid;

    TextView mTextView;
    boolean flag = false;
    FragmentManager mFragmentManager;
    FragmentTransaction mTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pingbi_add);

        //初始化xUtils
        initXUtils();
        initView();
        initData();

        //设置刷新模式，下拉刷新，上拉加载都行
        //设置刷新模式为BOTH才可以上拉和下拉都能起作用,必须写在前面
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        //设置刷新时头部的状态（即显示的图标和文字）
        initStatus();
        setAdapter();
        setListener();
    }

    private void setListener() {
        mPullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position = position-1;
                uid = mList.get(position).getUid();
                Toast.makeText(PinBiAddActivity.this, uid+"", Toast.LENGTH_SHORT).show();
                ImageView imageView = (ImageView) view.findViewById(R.id.hhy_pingbi_dagou);
                if (imageView.isShown()) {
                    imageView.setVisibility(View.GONE);
                    mTextView.setVisibility(View.GONE);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                    mTextView.setVisibility(View.VISIBLE);

                }

            }
        });

        //点击完成返回PingBiTaFragment页面
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams(url);
                if("pingbita".equals(biaozhi)){
                    params.addQueryStringParameter("uid", uid+"");
                }
                if("notsee".equals(biaozhi)){
                    params.addQueryStringParameter("pingbicannot", uid+"");
                }
               if("blacklist".equals(biaozhi)){
                   params.addQueryStringParameter("blacklist", uid+"");
               }
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                       /* //查询成功
                        Gson gson = new Gson();
                        UserInfo userInfo = null;
                        Type type = new TypeToken<List<UserInfo>>() {
                        }.getType();
                        List<UserInfo> lists = gson.fromJson(result, type);
                        Toast.makeText(PinBiAddActivity.this, lists.toString(), Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < lists.size(); i++) {
                            userInfo = lists.get(i);
                            if (userInfo != null) {
                                flag = true;
                            }
                            Toast.makeText(PinBiAddActivity.this, userInfo.toString(), Toast.LENGTH_SHORT).show();
                            guanZhu = new GuanZhu(userInfo.getUname(), userInfo.getUsign(), userInfo.getUrl(), 1, true);
                            mList.add(guanZhu);
                        }
                        if (flag) {
                            mAdapter.notifyDataSetChanged();
                        }*/
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
                //关闭该Activity
                finish();
            }
        });
    }

    private void initXUtils() {
        x.Ext.init(getApplication());
        x.Ext.setDebug(BuildConfig.DEBUG);
    }

    private void initStatus() {
        //设置头部下拉刷新时的样式
        ILoadingLayout topLayout = mPullToRefreshListView.getLoadingLayoutProxy(true, false);
        topLayout.setPullLabel("下拉刷新");
        topLayout.setRefreshingLabel("正在拼命加载中...");
        topLayout.setReleaseLabel("放开刷新");

    }

    static class loadDataAsyn extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            try {
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //mGuanZhuActivity.initData();
            return "success";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if ("success".equals(s)) {
                //到时需从数据库中去数据

                // mMainActivity.mArrayAdapter.notifyDataSetChanged();//通知界面刷新
                // mMainActivity.mPullToRefreshListView.onRefreshComplete();//表示刷新完成
            }
        }
    }

    private void initView() {
        url = "http://10.201.1.148:8888/HttpServer/HttpServer";
        mTextView = (TextView) findViewById(R.id.hhy_pingbi_add_wancheng);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.hhy_pingbiadd_relative);
        mPullToRefreshListView = (PullToRefreshListView) findViewById(R.id.hhy_pingbi_add_listview);

        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();

        Intent intent = getIntent();
        biaozhi = intent.getStringExtra("biaozhi");
        Toast.makeText(PinBiAddActivity.this, biaozhi, Toast.LENGTH_SHORT).show();
    }

    private void initData() {
        mList = new ArrayList<User_Pingbi>();
        mUser_pingbi = new User_Pingbi(1,  "http://img3.imgtn.bdimg.com/it/u=2165175176,3806470859&fm=21&gp=0.jpg","uname","usign", 0);
        mList.add(mUser_pingbi);
        selectDataBase();

    }

    private void setAdapter() {

        mAdapter = new PingBiAddAdapter(mList,PinBiAddActivity.this);
        mPullToRefreshListView.setAdapter(mAdapter);
    }

    private void selectDataBase() {
        //查收查询数据库，取出数据
        RequestParams params = new RequestParams(url);
        params.addQueryStringParameter("concern", "concern");
        //params.addQueryStringParameter("mPath", mPath);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //查询成功
                Gson gson = new Gson();
                UserInfo userInfo = null;
                Type type = new TypeToken<List<UserInfo>>() {
                }.getType();
                List<UserInfo> lists = gson.fromJson(result, type);
                //Toast.makeText(PinBiAddActivity.this, lists.toString(), Toast.LENGTH_SHORT).show();
                for (int i = 0; i < lists.size(); i++) {
                    userInfo = lists.get(i);
                    if (userInfo != null) {
                        flag = true;
                    }
                    Toast.makeText(PinBiAddActivity.this, userInfo.toString(), Toast.LENGTH_SHORT).show();
                    mUser_pingbi = new User_Pingbi(userInfo.getUid(),userInfo.getUrl(),userInfo.getUname(), userInfo.getUsign(),1);
                    mList.add(mUser_pingbi);
                }
                if (flag) {
                    setAdapter();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
