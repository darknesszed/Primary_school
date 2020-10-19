package com.example.firstapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView 适配器
 */
public class DemoAdapter extends
        RecyclerView.Adapter<DemoAdapter.DemoViewHolder>
{
    private List<Entity> data;
    private Context context;


    /**
     * 手动设置构造器
     */
    public DemoAdapter(Context context, List<Entity> data)
    {
        this.context = context;
        this.data = data;
    }


    public void addData(List<Entity> data)
    {
        if (this.data == null)
        {
            this.data = new ArrayList<>();
        }
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setData(List<Entity> data)
    {
        this.data = data;
        // 刷新列表数据
        notifyDataSetChanged();
    }



    /**
     * 提供具体的布局文件，然后转化为ViewHolder对象，
     * ViewHolder在创建Item子项时可以复用
     * @param parent 容器对象
     * @param viewType 具体布局文件的类型
     * @return DemoViewHolder对象工系统复用
     */
    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // 获取布局文件，并转化为一个View对象
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_demo, parent, false);
        // 构建ViewHolder对象
        return new DemoViewHolder(view);
    }


    /**
     * 将数据加载到布局文件里，即布局文件绑定数据
     * @param holder ViewHolder对象，指定一个具体的布局文件
     * @param position 当前位置的数据
     */
    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position)
    {
        holder.textView.setText(data.get(position).getMsg());
        String imgUrl = "http://pic.baike.soso.com/p/20131029/20131029105912-973228325.jpg";
        Glide.with(context).load(imgUrl).into(holder.img);
    }


    /**
     * 列表数据的总量
     * @return 返回列表数据的总量
     */
    @Override
    public int getItemCount()
    {
        return data == null ? 0 : data.size();
    }

    static class DemoViewHolder extends RecyclerView.ViewHolder
    {

        TextView textView;
        ImageView img;


        public DemoViewHolder(@NonNull View itemView)
        {
            super(itemView);
            // 初始化ItemView布局文件的控件
            textView = itemView.findViewById(R.id.tv_item);
            img = itemView.findViewById(R.id.img);

        }
    }



}
