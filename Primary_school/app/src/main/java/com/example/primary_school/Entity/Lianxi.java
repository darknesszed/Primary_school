package com.example.primary_school.Entity;

import java.io.Serializable;

public class Lianxi implements Serializable {
    private String danyuan;
    private String biaoti;
    private String datiqingkuang;
    private String datijieyu;
    private int biaoqingImg;
    private boolean isVisible;



    public Lianxi(String danyuan,String biaoti,String datiqingkuang,String datijieyu,int biaoqingImg,boolean isVisible) {
        this.danyuan = danyuan;
        this.biaoti = biaoti;
        this.datiqingkuang = datiqingkuang;
        this.datijieyu = datijieyu;
        this.biaoqingImg = biaoqingImg;
        this.isVisible = isVisible;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public String getDanyuan() {
        return danyuan;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public String getDatiqingkuang() {
        return datiqingkuang;
    }

    public String getDatijieyu() {
        return datijieyu;
    }

    public int getBiaoqingImg() {
        return biaoqingImg;
    }
}
