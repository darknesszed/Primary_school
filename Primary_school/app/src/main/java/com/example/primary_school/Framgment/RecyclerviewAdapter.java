package com.example.primary_school.Framgment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primary_school.Framgment.shouyechildactivity.JiaoZiVideoPlayerActivity;
import com.example.primary_school.Framgment.shouyechildactivity.VideoActivity;
import com.example.primary_school.R;
import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
    private List<Shouye> shouyeArrayList = new ArrayList<>();
    private ViewHolder viewHolder;
    private Shouye shouye;
    private int count=0;
    private Context context;
    public RecyclerviewAdapter(Context context,List<Shouye> shouye) {
//        Log.e("构造函数", "addData: "+count);
        this.context = context;
        this.shouyeArrayList = shouye;
    }

    public void addData(List<Shouye> shouyeList) {
//        Log.e("addData", "addData: "+count);
        if (this.shouyeArrayList == null)
        {
            this.shouyeArrayList = new ArrayList<>();
        }
        this.shouyeArrayList=shouyeList;
//        this.shouyeArrayList = shouyeList;
        notifyDataSetChanged();
//        notifyItemRangeInserted(this.shouyeArrayList.size()-shouyeList.size(),shouyeList.size());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2;
        Button button;
        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_viedo);
            textView1 = itemView.findViewById(R.id.text_videotitle);
            textView2 = itemView.findViewById(R.id.text_videonum);
//            button = itemView.findViewById(R.id.btn_gk);


        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_tabs,parent,false);
        viewHolder = new ViewHolder(view);
//        Log.e("viewholder", "onCreateViewHolder: "+count );
        return viewHolder;
    }
    public void updateData(List<Shouye> data){
        this.shouyeArrayList = data;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.ViewHolder holder, int position) {
//        Log.e("position", "onBindViewHolder position: "+position );
        shouye = shouyeArrayList.get(position);
        count=position;
        holder.imageView.setImageResource(shouye.getImg());
        holder.textView1.setText(shouye.getTitle());
        int videonum = Integer.parseInt(shouye.getVid());
        if (videonum>100000){
            holder.textView2.setText("视频·100000+次播放");
        }else {
            holder.textView2.setText("视频·"+shouye.getVid()+"次播放");
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
//        Log.e("shouyeArrayList.size(): ",""+shouyeArrayList.size() );
        return shouyeArrayList==null? 0 : shouyeArrayList.size();
    }

}
