package com.jqs.servert.utils;

/**
 * Created by qiangsheng on 2016/5/10.
 */
import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by mhdong on 2016/5/10.
 */
public class MyApplication extends Application{
    private String url = "http://10.201.1.150:8080/HttpServert/httpServlet";
    //Application的onCreate早于所有的Activity的onCreate方法
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        // 是否输出debug日志, 开启debug会影响性能.
        x.Ext.setDebug(BuildConfig.DEBUG);
    }

    public String getUrl() {
        return url;
    }
}
