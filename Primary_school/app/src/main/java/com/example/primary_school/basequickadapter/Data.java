package com.example.primary_school.basequickadapter;

import com.example.primary_school.R;

public class Data {
    public int imgid(int position){
        int[] imgs = new int[]{R.drawable.huge,R.drawable.cwt,R.drawable.dlrb,R.drawable.glnz,
                + R.drawable.hjh,R.drawable.ldh,R.drawable.lss,R.drawable.zly,R.drawable.zta,R.drawable.zyx};
        return imgs[position];
    }
    public String videonums(int position){
        String[] videonums = new String[]{"100","2000","336","455","560","60000","70","89","900","1034"};
        return videonums[position];
    }
    public String titles(int position){
        String[] titles = new String[]{"快速运算","如何实现满分作文","唐诗三百首","快乐英语","正反义词",
                "可爱的小白兔","快速学习字典运用","计算器使用","正楷练习课","家长最关心的问题"};
        return titles[position];
    }
}
