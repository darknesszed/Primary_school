package com.example.primary_school.Framgment.tab;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.primary_school.Framgment.RecyclerviewAdapter;
import com.example.primary_school.Framgment.Shouye;
import com.example.primary_school.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fragment_english extends Fragment {
    private List<Shouye> shouyeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerviewAdapter;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_5_fragment,container,false);
        init_tabrecyclerview_english();
        SmartRefreshLayout smartRefreshLayout = view.findViewById(R.id.smartrefresh_english);
        smartRefreshLayout.setEnableRefresh(false);//false关闭下拉刷新
        //设置 Footer 为 球脉冲
        smartRefreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                smartRefreshLayout.finishLoadMore(1000);
                myUpdateOperation();
            }
        });
        return view;
    }
    public void myUpdateOperation() {
        String[] vids = new String[]{"109000","200000","30000","40000","556","90","700","114","997","34"};
        String[] titles = new String[]{"快速运算","如何实现满分作文","唐诗三百首","快乐英语","正反义词","可爱的小白兔","快速学习字典运用","计算器使用","正楷练习课","家长最关心的问题"};
        int[] imgs = new int[]{R.drawable.huge,R.drawable.cwt,R.drawable.dlrb,R.drawable.glnz,
                + R.drawable.hjh,R.drawable.ldh,R.drawable.lss,R.drawable.zly,R.drawable.zta,R.drawable.zyx};
        Random random = new Random();
        int imgs_randow;
        String vids_randow,titles_randow;
        for (int i = 0; i < vids.length ; i++) {
            int r = random.nextInt(9);
            vids_randow = vids[i];
            titles_randow = titles[i];
            imgs_randow = imgs[i];

            vids[i] = vids[r];
            titles[i] = titles[r];
            imgs[i] = imgs[r];

            vids[r] = vids_randow;
            titles[r] = titles_randow;
            imgs[r] = imgs_randow;
        }
        for (int i = 0; i < vids.length; i++) {
            Shouye shouye = new Shouye(vids[i],titles[i],imgs[i]);
            Log.e("myUpdateOperation() ","myUpdateOperation: "+ vids[i]+titles[i]+imgs[i]);
            shouyeList.add(shouye);
        }
        recyclerviewAdapter.addData(shouyeList);
    }
    public void init_tabrecyclerview_english(){
        recyclerView = view.findViewById(R.id.tabrecyclerview_english);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(getActivity(),null);
        recyclerView.setAdapter(recyclerviewAdapter);
        initShouye();
    }

    public void initShouye(){
        String[] vids = new String[]{"109000","200000","30000","40000","556","90","700","114","997","34"};
        String[] titles = new String[]{"快速运算","如何实现满分作文","唐诗三百首","快乐英语","正反义词","可爱的小白兔","快速学习字典运用","计算器使用","正楷练习课","家长最关心的问题"};
        int[] imgs = new int[]{R.drawable.huge,R.drawable.cwt,R.drawable.dlrb,R.drawable.glnz,
                + R.drawable.hjh,R.drawable.ldh,R.drawable.lss,R.drawable.zly,R.drawable.zta,R.drawable.zyx};

        for (int i = 0; i < vids.length ; i++) {
            Shouye shouye = new Shouye(vids[i],titles[i],imgs[i]);
            shouyeList.add(shouye);
        }
        recyclerviewAdapter.addData(shouyeList);

    }
}
