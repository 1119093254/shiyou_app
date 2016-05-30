package com.hhy.bean;

import java.io.Serializable;

/**
 * Created by hanhongyang on 2016/5/30.
 */
public class OtherInfoBean implements Serializable {
    private String iconUrl;
    private String uname;
    private String usign;

    public OtherInfoBean(String iconUrl, String uname, String usign) {
        this.iconUrl = iconUrl;
        this.uname = uname;
        this.usign = usign;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsign() {
        return usign;
    }

    public void setUsign(String usign) {
        this.usign = usign;
    }

    @Override
    public String toString() {
        return "OtherInfoBean{" +
                "iconUrl='" + iconUrl + '\'' +
                ", uname='" + uname + '\'' +
                ", usign='" + usign + '\'' +
                '}';
    }
}
