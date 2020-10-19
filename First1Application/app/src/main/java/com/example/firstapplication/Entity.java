package com.example.firstapplication;

import java.io.Serializable;

// Java方式序列化
public class Entity implements Serializable
{

    private String msg;

    public int getImgRes()
    {
        return imgRes;
    }

    public void setImgRes(int imgRes)
    {
        this.imgRes = imgRes;
    }

    private int imgRes;

    public Entity(String msg)
    {
        this.msg = msg;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}
