package com.example.primary_school.lunbotu;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Banner框架自身没有图片加载器，因此需要自定义一个图片加载器或者使用框架，这里使用的是AndroidImageSlider框架
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide
                .with(context)
                .load(path)
                .centerCrop()
                .into(imageView);
    }
}
