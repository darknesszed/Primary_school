package com.example.firstapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表类型数据展示
 */
public class RecyclerViewDemoActivity extends AppCompatActivity
{

    private RecyclerView recyclerView;

    private Context context;

    private DemoAdapter adapter;

    private List<Entity> data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_recyler_view_demo);
        recyclerView = findViewById(R.id.recycler_view);

        // 第一步：设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        // 设置适配器
        adapter = new DemoAdapter(context,null);
        recyclerView.setAdapter(adapter);

        initData();
    }


    private void initData()
    {
        data = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            Entity entity = new Entity("index: " + i);
            data.add(entity);
        }

        adapter.setData(data);
    }
}
