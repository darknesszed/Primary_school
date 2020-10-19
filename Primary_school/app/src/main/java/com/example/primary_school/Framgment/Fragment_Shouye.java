package com.example.primary_school.Framgment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.primary_school.Framgment.dialogfragment.MyDialogFragment;
import com.example.primary_school.Framgment.tab.Fragment_english;
import com.example.primary_school.Framgment.tab.Fragment_gushihui;
import com.example.primary_school.Framgment.tab.Fragment_mzbk;
import com.example.primary_school.Framgment.tab.Fragment_shuxue;
import com.example.primary_school.Framgment.tab.Fragment_tuijian;
import com.example.primary_school.Framgment.tab.Fragment_yuwen;
import com.example.primary_school.Framgment.tab.InitFragment;
import com.example.primary_school.Framgment.tab.TabViewpager_fragment_Adapter;
import com.example.primary_school.R;
import com.example.primary_school.circleimageview.CircleImageView;
import com.example.primary_school.lunbotu.GlideImageLoader;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Shouye extends Fragment implements ViewPager.OnPageChangeListener {
    public static final int REQUEST_CODE=1;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Banner banner;
    private List<Shouye> shouyeList = new ArrayList<>();
    private MyDialogFragment myDialogFragment;
    private TextView textView,textView1;
    private Grade grade;
    private String mgrade;
    private int imgres;
    private CircleImageView circleImageView;
    private ViewPager viewPager;
    private InitFragment initFragment;
    private TabLayout tabLayout;
    private TabViewpager_fragment_Adapter tabViewpager_fragment_adapter;
    private View view;
    private SmartRefreshLayout smartRefreshLayout;
    private FragmentStatePagerAdapter fragmentStatePagerAdapter;
    private Fragment_mzbk fragment_mzbk;
    private Fragment_tuijian fragment_tuijian;
    private Fragment_yuwen fragment_yuwen;
    private Fragment_shuxue fragment_shuxue;
    private Fragment_english fragment_english;
    private Fragment_gushihui fragment_gushihui;
    private Handler mHandler;//用于通知更新Fragement中的ui
    private int mposition;

    public Fragment_Shouye(String mgrade) {
        this.mgrade = mgrade;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view!=null){
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent!=null){
                parent.removeView(view);
            }
            return view;
        }
        view = inflater.inflate(R.layout.fragment_shouye,container,false);
        banner = view.findViewById(R.id.banner);
        initlunbotu();

        viewPager = view.findViewById(R.id.viewpage_tab);
        initFragment = new InitFragment();
        tabViewpager_fragment_adapter = new TabViewpager_fragment_Adapter(getChildFragmentManager(),initFragment.list_Fragment(),initFragment.list_titles());
        viewPager.setAdapter(tabViewpager_fragment_adapter);
        tabLayout = view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        AppBarLayout mAppBar = view.findViewById(R.id.appbar);
        smartRefreshLayout = view.findViewById(R.id.smartrefresh);
        //设置 Header 为 Material样式
        smartRefreshLayout.setRefreshHeader(new MaterialHeader(getActivity()).setShowBezierWave(true));
        mAppBar.addOnOffsetChangedListener((AppBarLayout.BaseOnOffsetChangedListener) (appBarLayout, i) -> {
            if (i >= 0) {
                smartRefreshLayout.setEnabled(true); //当滑动到顶部的时候开启
            } else {
                smartRefreshLayout.setEnabled(false); //否则关闭
            }
        });
        viewPager.addOnPageChangeListener(this);
        fragmentStatePagerAdapter = (FragmentStatePagerAdapter) viewPager.getAdapter();
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                smartRefreshLayout.finishRefresh(2000);
                refresh();
//                smartRefreshLayout.autoRefresh(4000);//延迟400毫秒后自动刷新
//                updateData();
            }
        });






//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                imageView.setVisibility(View.VISIBLE);
//
//                myDialogFragment = new MyDialogFragment(mgrade,imgres);
//                myDialogFragment.setTargetFragment(Fragment_Shouye.this,REQUEST_CODE);
//                myDialogFragment.showNow(getFragmentManager(),"mydialogfragment");
//              myPopupMenu(view);
//
//
//            }
//        });

        return view;
    }

    public void updateData() {
        viewPager = view.findViewById(R.id.viewpage_tab);
        initFragment = new InitFragment();
        tabViewpager_fragment_adapter = new TabViewpager_fragment_Adapter(getChildFragmentManager(),initFragment.list_Fragment(),initFragment.list_titles());
        viewPager.setAdapter(tabViewpager_fragment_adapter);
        tabLayout = view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            mgrade = data.getStringExtra("GRADE");
            if (mgrade!=null){
                textView.setText(mgrade);
            }
//            myDialogFragment.dismiss();
        }
    }

    public void initShouye(){
        String[] vids = new String[]{"1","2","3","4","5","6","7","8","9","10"};
        String[] titles = new String[]{"快速运算","如何实现满分作文","唐诗三百首","快乐英语","正反义词","可爱的小白兔","快速学习字典运用","计算器使用","正楷练习课","家长最关心的问题"};
        int[] imgs = new int[]{R.drawable.huge,R.drawable.cwt,R.drawable.dlrb,R.drawable.glnz,
                + R.drawable.hjh,R.drawable.ldh,R.drawable.lss,R.drawable.zly,R.drawable.zta,R.drawable.zyx};

        for (int i = 0; i < vids.length ; i++) {
            Shouye shouye = new Shouye(vids[i],titles[i],imgs[i]);
            shouyeList.add(shouye);
        }
    }
    public void setgrade(){
        grade = new Grade(mgrade);
    }

    public void initlunbotu(){
        List images = new ArrayList();
        images.add("http://kwimg2.kuwo.cn/star/upload/66/85/1575256374021_.jpg");
        images.add("http://kwimg2.kuwo.cn/star/upload/71/68/1575818166158_.jpg");
        images.add("http://kwimg1.kuwo.cn/star/upload/68/54/1575429173078_.jpg");

        //初始化标题数据
        List titles = new ArrayList();
        titles.add("《绿皮书》：如果我不像黑人，又不是白人，你告诉我，我到底算是什么");
        titles.add("《何以为家》：一部所有中国父母都应该去看的影片");
        titles.add("《想见你》：台湾偶像剧的突破之作");
//        Banner banner = (Banner) findViewById(R.id.banner);
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
                Toast.makeText(getActivity(), "position"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * mposition获取viewpager的对应下标，即对应的fragment
     * 下拉刷新对应fragment的数据
     */
    public void refresh(){
        mposition = viewPager.getCurrentItem();//获取viewpager对应下标，即对应的fragment
        Log.e("refresh","refresh "+mposition );
        switch (mposition){
            case 0:
                fragment_tuijian = (Fragment_tuijian) fragmentStatePagerAdapter.instantiateItem(viewPager,mposition);//指定viewpager中的某个Fragment
                fragment_tuijian.myUpdateOperation();
                break;
            case 1:
                fragment_mzbk = (Fragment_mzbk) fragmentStatePagerAdapter.instantiateItem(viewPager,mposition);
                fragment_mzbk.myUpdateOperation();
                break;
            case 2:
                fragment_yuwen = (Fragment_yuwen) fragmentStatePagerAdapter.instantiateItem(viewPager,mposition);
                fragment_yuwen.myUpdateOperation();
                break;
            case 3:
                fragment_shuxue = (Fragment_shuxue) fragmentStatePagerAdapter.instantiateItem(viewPager,mposition);
                fragment_shuxue.myUpdateOperation();
                break;
            case 4:
                fragment_english = (Fragment_english) fragmentStatePagerAdapter.instantiateItem(viewPager,mposition);
                fragment_english.myUpdateOperation();
                break;
            case 5:
                fragment_gushihui = (Fragment_gushihui) fragmentStatePagerAdapter.instantiateItem(viewPager,mposition);
                fragment_gushihui.myUpdateOperation();
                break;
            default:
                Log.e("refresh:", "refresh: " );
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

//    @SuppressLint("RestrictedApi")
//    private void myPopupMenu(View v) {
//        //定义PopupMenu对象
//        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
//
//        //设置PopupMenu对象的布局
////        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
//        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
//        //设置PopupMenu的点击事件
//        try {
//            Field[] fields = popupMenu.getClass().getDeclaredFields();
//            for (Field field : fields) {
//                if ("mPopup".equals(field.getName())) {
//                    field.setAccessible(true);
//                    Object menuPopupHelper = field.get(popupMenu);
//                    Class<?> classPopupHelper = Class.forName(menuPopupHelper
//                            .getClass().getName());
//                    Method setForceIcons = classPopupHelper.getMethod(
//                            "setForceShowIcon", boolean.class);
//                    setForceIcons.invoke(menuPopupHelper, true);
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Toast.makeText(getActivity(), "点击了----" + item.getTitle(), Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//        //显示菜单
//        popupMenu.show();
//
//    }
}
