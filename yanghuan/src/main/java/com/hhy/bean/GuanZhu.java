package com.hhy.bean;

import java.io.Serializable;

/**
 * Created by hanhongyang on 2016/5/16.
 */
public class GuanZhu implements Serializable {


    private int muid;
    private String guanzhu_top_text;
    private String guanzhu_below_text;
    private String url;
     //区分布局类型
    private int flag;

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    private boolean b;


    public GuanZhu() {
    }

    public GuanZhu(int muid,String guanzhu_top_text, String guanzhu_below_text, String url, int flag,boolean b) {
        this.muid = muid;
        this.guanzhu_top_text = guanzhu_top_text;
        this.guanzhu_below_text = guanzhu_below_text;
        this.url = url;
        this.flag = flag;
        this.b = b;

    }

    public String getGuanzhu_top_text() {
        return guanzhu_top_text;
    }

    public void setGuanzhu_top_text(String guanzhu_top_text) {
        this.guanzhu_top_text = guanzhu_top_text;
    }

    public String getGuanzhu_below_text() {
        return guanzhu_below_text;
    }

    public void setGuanzhu_below_text(String guanzhu_below_text) {
        this.guanzhu_below_text = guanzhu_below_text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    public int getMuid() {
        return muid;
    }

    public void setMuid(int muid) {
        this.muid = muid;
    }

    @Override
    public String toString() {
        return "GuanZhu{" +
                "muid=" + muid +
                ", guanzhu_top_text='" + guanzhu_top_text + '\'' +
                ", guanzhu_below_text='" + guanzhu_below_text + '\'' +
                ", url='" + url + '\'' +
                ", flag=" + flag +
                ", b=" + b +
                '}';
    }
}
