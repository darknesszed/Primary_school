package com.example.primary_school.Framgment.tab;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primary_school.Framgment.Shouye;
import com.example.primary_school.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter2 extends RecyclerView.Adapter<RecyclerviewAdapter2.ViewHolder> {
    private List<Shouye> shouyeArrayList;
    private ViewHolder viewHolder;
    private Shouye shouye;
    private int count=0;
    private Context context;
    public RecyclerviewAdapter2(Context context, List<Shouye> shouye) {
        Log.e("构造函数", "addData: "+count);
        this.context = context;
        this.shouyeArrayList = shouye;
    }

    public void addData(List<Shouye> shouyeList) {
        Log.e("addData", "addData: "+count);
        if (this.shouyeArrayList == null)
        {
            this.shouyeArrayList = new ArrayList<>();
        }
        this.shouyeArrayList = shouyeList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2;
        Button button;
        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            imageView = itemView.findViewById(R.id.image_item);
//            textView1 = itemView.findViewById(R.id.text_item1);
//            textView2 = itemView.findViewById(R.id.text_item2);
//            button = itemView.findViewById(R.id.btn_gk);


        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        viewHolder = new ViewHolder(view);
        Log.e("viewholder", "onCreateViewHolder: "+count );
        return viewHolder;
    }
    public void updateData(List<Shouye> data){
        this.shouyeArrayList = data;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter2.ViewHolder holder, int position) {
        Log.e("position", "onBindViewHolder position: "+position );
        shouye = shouyeArrayList.get(position);
        count=position;

        holder.imageView.setImageResource(shouye.getImg());
        holder.textView1.setText(shouye.getTitle());
        holder.textView2.setText(shouye.getVid());

    }

    @Override
    public int getItemCount() {
        Log.e("shouyeArrayList.size(): ",""+shouyeArrayList.size() );
        return 4;
    }

}
