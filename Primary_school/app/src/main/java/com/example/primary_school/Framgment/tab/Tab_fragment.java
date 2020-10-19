package com.example.primary_school.Framgment.tab;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.primary_school.Framgment.RecyclerviewAdapter;
import com.example.primary_school.Framgment.Shouye;
import com.example.primary_school.R;
import com.example.primary_school.basequickadapter.MyProviderMultiAdapter;
import com.example.primary_school.basequickadapter.ProviderMultiEntity;

import java.util.ArrayList;
import java.util.List;

public class Tab_fragment extends Fragment {
   private int contentLayoutId;
   private List<Shouye> shouyeList = new ArrayList<>();
   private RecyclerView recyclerView;
   private RecyclerviewAdapter recyclerviewAdapter;
   private View view;
   private Context context;
    public Tab_fragment(int contentLayoutId) {
        super(contentLayoutId);
        this.contentLayoutId=contentLayoutId;
    }

    /**
     * ViewPager+Fragment使用的还是比较频繁的，但是当我打开应用第一次进入时很正常，
     * 然而第二次进入的时候却显示的是空白，当时感觉很是迷茫，可是仔细一查，
     * 原来是第二次加载的时候重复调用了onCreateView()这个方法，重新new了一个pageadapter导致子fragment不显示，
     * 问题的解决方法就是在onCreateView()方法里面加入如下代.
     * if (view!=null){
     *             ViewGroup parent = (ViewGroup) view.getParent();
     *             if (parent!=null){
     *                 parent.removeView(view);
     *             }
     *             return view;
     *         }
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //解决复用问题
        if (view!=null){
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent!=null){
                parent.removeView(view);
            }
            return view;
        }
        context = getActivity();
        view = inflater.inflate(contentLayoutId,container,false);
        switch (contentLayoutId){
            case R.layout.tab_tuijie_fragment:
                initrecyclerview_tuijian();
                break;
            case R.layout.tab_2_fragment:
                init_tabrecyclerview_mzbk();
                break;
            case R.layout.tab_3_fragment:
                init_tabrecyclerview_yuwen();
                break;
            case R.layout.tab_4_fragment:
                init_tabrecyclerview_shuxue();
                break;
            case R.layout.tab_5_fragment:
                init_tabrecyclerview_english();
                break;
            case R.layout.tab_6_fragment:
                init_tabrecyclerview_gushihui();
                break;
            default:
                initrecyclerview_tuijian();
                break;
        }
//        if (contentLayoutId==R.layout.tab_tuijie_fragment){
////            initrecyclerview_tuijian();
//        }
        return view;
    }
    private void myUpdateOperation() {
        initShouye();
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
    public void init_tabrecyclerview_mzbk(){
        recyclerView = view.findViewById(R.id.tabrecyclerview_mzbk);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(context,null);
        recyclerView.setAdapter(recyclerviewAdapter);
        initShouye();
    }

    public void init_tabrecyclerview_yuwen(){
            recyclerView = view.findViewById(R.id.tabrecyclerview_yuwen);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerviewAdapter = new RecyclerviewAdapter(context,null);
            recyclerView.setAdapter(recyclerviewAdapter);
            initShouye();
    }
    public void init_tabrecyclerview_shuxue(){
        recyclerView = view.findViewById(R.id.tabrecyclerview_shuxue);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(context,null);
        recyclerView.setAdapter(recyclerviewAdapter);
        initShouye();
    }
    public void init_tabrecyclerview_english(){
        recyclerView = view.findViewById(R.id.tabrecyclerview_english);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(context,null);
        recyclerView.setAdapter(recyclerviewAdapter);
        initShouye();
    }
    public void init_tabrecyclerview_gushihui(){
        recyclerView = view.findViewById(R.id.tabrecyclerview_gushihui);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(context,null);
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
