package com.example.primary_school.Framgment.tab;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.primary_school.Framgment.RecyclerviewAdapter;
import com.example.primary_school.Framgment.Shouye;
import com.example.primary_school.R;
import com.example.primary_school.basequickadapter.MyProviderMultiAdapter;
import com.example.primary_school.basequickadapter.ProviderMultiEntity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

public class Fragment_tuijian extends Fragment {
    private List<Shouye> shouyeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerviewAdapter;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_tuijie_fragment,container,false);
        initrecyclerview_tuijian();
        SmartRefreshLayout smartRefreshLayout = view.findViewById(R.id.smartrefresh_tuijian);
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

    public void myUpdateOperation(){
        recyclerView = view.findViewById(R.id.tabrecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        MyProviderMultiAdapter myProviderMultiAdapter = new MyProviderMultiAdapter();
        recyclerView.setAdapter(myProviderMultiAdapter);
        Log.e("mainactivity", "onCreate: " +1);
        List<ProviderMultiEntity> data = new ArrayList<>();
        ProviderMultiEntity entity = new ProviderMultiEntity();
        for (int i = 0; i <15; i++) {
            entity.setName("da");
            entity.setAge(9);
            data.add(entity);
        }
        myProviderMultiAdapter.setList(data);
    }
    public void initrecyclerview_tuijian(){
        recyclerView = view.findViewById(R.id.tabrecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        MyProviderMultiAdapter myProviderMultiAdapter = new MyProviderMultiAdapter();
        recyclerView.setAdapter(myProviderMultiAdapter);
        Log.e("mainactivity", "onCreate: " +1);
        List<ProviderMultiEntity> data = new ArrayList<>();
        ProviderMultiEntity entity = new ProviderMultiEntity();
        for (int i = 0; i <16; i++) {
            entity.setName("da");
            entity.setAge(9);
            data.add(entity);
        }
        myProviderMultiAdapter.setList(data);
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
