package com.example.primary_school.Framgment.shouyechildactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.primary_school.R;

import java.util.LinkedHashMap;

import cn.jzvd.JZDataSource;
import cn.jzvd.JZMediaInterface;
import cn.jzvd.JZUtils;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class JiaoZiVideoPlayerActivity extends AppCompatActivity {
    private MyJzvdStd jzvdStd;
    private long progressposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiao_zi_video_player);
        initData();

    }

    private void initData(){
        long position = 1000;

        jzvdStd = findViewById(R.id.jiaozi_videoplayer);

        String video1080 = "https://vd3.bdstatic.com/mda-kg0dke1c4fi292pr/v1-cae/mda-kg0dke1c4fi292pr.mp4?playlist=null&pd=20&vt=1";
        String video720 = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";
        String video480 = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("蓝光1080",video1080);
        linkedHashMap.put("高清720",video720);
        linkedHashMap.put("标清480",video480);
        JZDataSource jzDataSource = new JZDataSource(linkedHashMap,"饺子闭眼睛");
//        jzDataSource.looping = true;//循环播放
        jzDataSource.currentUrlIndex=1;//指定初始url
//        jzvdStd.WIFI_TIP_DIALOG_SHOWED=true;//取消播放时在非WIFIDialog提示，默认false
        jzvdStd.setUp(jzDataSource,MyJzvdStd.SCREEN_NORMAL);
//        Jzvd.setVideoImageDisplayType(Jzvd.VIDEO_IMAGE_DISPLAY_TYPE_ORIGINAL);//原始大小
//        Jzvd.setVideoImageDisplayType(Jzvd.VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP);//填充屏幕
//        Jzvd.setVideoImageDisplayType(Jzvd.VIDEO_IMAGE_DISPLAY_TYPE_ADAPTER);
//        jzvdStd.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
//                , "饺子闭眼睛");
//        jzvdStd.posterImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        progressposition = jzvdStd.getCurrentPositionWhenPlaying();
        Log.e("getCurrentPositionWhenPlaying()", "onPause: "+progressposition );
        Jzvd.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        Jzvd.SAVE_PROGRESS = false;//是否保存进度，默认true

    }
}
