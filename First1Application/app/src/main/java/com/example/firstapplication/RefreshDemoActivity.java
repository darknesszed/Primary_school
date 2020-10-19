package com.example.firstapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 下拉刷新示例
 */
public class RefreshDemoActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;

    private DemoAdapter adapter;

    private List<Entity> data;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_demo);
        // recyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter = new DemoAdapter(this,null);
        recyclerView.setAdapter(adapter);

        // refreshLayout
        refreshLayout = findViewById(R.id.refresh_layout);
//        refreshLayout.setRefreshHeader(new ClassicsHeader(this));
//        refreshLayout.setRefreshFooter(new ClassicsFooter(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener()
        {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout)
            {
                loadData();
                refreshLayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener()
        {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout)
            {
                loadData();
                refreshLayout.finishLoadMore(2000);
            }
        });

        loadData();

    }

    /**
     * 模拟加载数据
     */
    private void loadData()
    {
        data = new ArrayList<>();
        for (int i = 0; i < 20; i ++)
        {
            Entity entity = new Entity("index: " + i);
            data.add(entity);
        }

        adapter.addData(data);

    }
}
