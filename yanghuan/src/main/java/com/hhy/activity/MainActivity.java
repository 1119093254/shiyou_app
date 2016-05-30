package com.hhy.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hhy.fragment.ConfigFragment;
import com.yanghuan.R;


/**
 * 项目
 */
public class MainActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    ConfigFragment mConfigFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hhy_activity_main);
        initData();

        //极光推送初始化
        //JPushInterface.init(MainActivity.this);
    }

    private void initData() {
        mConfigFragment = new ConfigFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        //middle部分默认显示mConfigFragment
        mFragmentTransaction.add(R.id.hhy_congfig_middle, mConfigFragment);
        mFragmentTransaction.commit();

    }


}
