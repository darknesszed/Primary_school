package com.example.primary_school.Entity;

import java.io.Serializable;

public class Shequxinxi implements Serializable {
    private int uuseravatar;//头像
    private String uusername;//用户名
    private String fabutime;//发布时间
    private String fabuneirong;//发布内容
    private int fabuImg;//发布的图片
    private int pinglunnum;//评论数
    private int dianzannum;//点赞数

    public Shequxinxi(int uuseravatar, String uusername, String fabutime, String fabuneirong, int fabuImg, int pinglunnum, int dianzannum) {
        this.uuseravatar = uuseravatar;
        this.uusername = uusername;
        this.fabutime = fabutime;
        this.fabuneirong = fabuneirong;
        this.fabuImg = fabuImg;
        this.pinglunnum = pinglunnum;
        this.dianzannum = dianzannum;
    }

    public int getUuseravatar() {
        return uuseravatar;
    }

    public String getUusername() {
        return uusername;
    }

    public String getFabutime() {
        return fabutime;
    }

    public String getFabuneirong() {
        return fabuneirong;
    }

    public int getFabuImg() {
        return fabuImg;
    }

    public int getPinglunnum() {
        return pinglunnum;
    }

    public int getDianzannum() {
        return dianzannum;
    }
}
