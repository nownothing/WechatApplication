package com.example.wechatapplication;

public class WeChat {
    String name;
    String msg;
    int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public WeChat(String name, String msg, int image) {
        this.name = name;
        this.msg = msg;
        this.image = image;
    }
}
