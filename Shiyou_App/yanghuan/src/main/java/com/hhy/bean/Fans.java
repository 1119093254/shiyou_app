package com.hhy.bean;

import java.io.Serializable;

/**
 * Created by hanhongyang on 2016/5/16.
 */
public class Fans implements Serializable {
    private int tou_image;
    private String text;
    private int right_image;

    public Fans() {
    }

    public Fans(int tou_image, String text, int right_image) {
        this.tou_image = tou_image;
        this.text = text;
        this.right_image = right_image;
    }

    public int getTou_image() {
        return tou_image;
    }

    public void setTou_image(int tou_image) {
        this.tou_image = tou_image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRight_image() {
        return right_image;
    }

    public void setRight_image(int right_image) {
        this.right_image = right_image;
    }

    @Override
    public String toString() {
        return "Fans{" +
                "tou_image=" + tou_image +
                ", text='" + text + '\'' +
                ", right_image=" + right_image +
                '}';
    }
}
