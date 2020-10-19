package com.example.primary_school.lunbotu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.primary_school.AutoCompleteTextView.Main3Activity;
import com.example.primary_school.MainActivity;
import com.example.primary_school.R;
import android.widget.Toast;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import java.util.ArrayList;
import java.util.List;
public class LunbotuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunbotu);

//            List images = new ArrayList();
//            images.add("http://kwimg2.kuwo.cn/star/upload/66/85/1575256374021_.jpg");
//            images.add("http://kwimg2.kuwo.cn/star/upload/71/68/1575818166158_.jpg");
//            images.add("http://kwimg1.kuwo.cn/star/upload/68/54/1575429173078_.jpg");
//
//            //初始化标题数据
//            List titles = new ArrayList();
//            titles.add("《绿皮书》：如果我不像黑人，又不是白人，你告诉我，我到底算是什么");
//            titles.add("《何以为家》：一部所有中国父母都应该去看的影片");
//            titles.add("《想见你》：台湾偶像剧的突破之作");
//            titles.add("《都挺好》：结局真的是大团圆吗？那是和解也是妥协");

//        Banner banner = (Banner) findViewById(R.id.banner);
//            //设置图片加载器
//            banner.setImageLoader(new GlideImageLoader());
//            //设置图片集合
//            banner.setImages(images);
//            //设置轮播时间（设置2.5秒切换下一张图片）
//            //设置标题集合（当banner样式有显示title时）
//            banner.setBannerTitles(titles);
//            //设置自动轮播，默认为true
//            banner.isAutoPlay(true);
//            banner.setDelayTime(2500);
//            //banner设置方法全部调用完毕时最后调用
//            //设置轮播的动画效果
////            banner.setBannerAnimation(Transformer.ZoomOutSlide);
//            banner.setBannerAnimation(Transformer.ForegroundToBackground);
//
//            //设置banner显示样式（带标题的样式）
//            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//            //设置指示器位置（当banner模式中有指示器时）
//            banner.setIndicatorGravity(BannerConfig.CENTER);
//            banner.start();
//
//            //增加点击事件
//            banner.setOnBannerListener(new OnBannerListener() {
//                @Override
//                public void OnBannerClick(int position) {
//                    Toast.makeText(LunbotuActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
//                }
//            });
        initluntotu();

        }

        public void initluntotu(){
            List images = new ArrayList();
            images.add("http://kwimg2.kuwo.cn/star/upload/66/85/1575256374021_.jpg");
            images.add("http://kwimg2.kuwo.cn/star/upload/71/68/1575818166158_.jpg");
            images.add("http://kwimg1.kuwo.cn/star/upload/68/54/1575429173078_.jpg");

            //初始化标题数据
            List titles = new ArrayList();
            titles.add("《绿皮书》：如果我不像黑人，又不是白人，你告诉我，我到底算是什么");
            titles.add("《何以为家》：一部所有中国父母都应该去看的影片");
            titles.add("《想见你》：台湾偶像剧的突破之作");
            Banner banner = (Banner) findViewById(R.id.banner);
            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            banner.setImages(images);
            //设置轮播时间（设置2.5秒切换下一张图片）
            //设置标题集合（当banner样式有显示title时）
            banner.setBannerTitles(titles);
            //设置自动轮播，默认为true
            banner.isAutoPlay(true);
            banner.setDelayTime(2500);
            //banner设置方法全部调用完毕时最后调用
            //设置轮播的动画效果
//            banner.setBannerAnimation(Transformer.ZoomOutSlide);
            banner.setBannerAnimation(Transformer.ForegroundToBackground);

            //设置banner显示样式（带标题的样式）
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
            //设置指示器位置（当banner模式中有指示器时）
            banner.setIndicatorGravity(BannerConfig.CENTER);
            banner.start();

            //增加点击事件
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(LunbotuActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }



}
