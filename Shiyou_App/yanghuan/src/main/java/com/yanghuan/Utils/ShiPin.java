package com.yanghuan.Utils;

import java.io.Serializable;

/**
 * Created by 杨欢 on 2016/5/25.
 */
public class ShiPin implements Serializable {
    String name;
    String pic;
    String title;

    public ShiPin(String name, String pic, String title) {
        this.name = name;
        this.pic = pic;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
