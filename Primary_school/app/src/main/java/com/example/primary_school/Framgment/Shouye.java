package com.example.primary_school.Framgment;

import java.io.Serializable;

public class Shouye implements Serializable {
    private String vid;
    private String title;
    private int img;

    public Shouye(String vid, String title, int img) {
        this.vid = vid;
        this.title = title;
        this.img = img;
    }

    public String getVid() {
        return vid;
    }

    public String getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }
}
