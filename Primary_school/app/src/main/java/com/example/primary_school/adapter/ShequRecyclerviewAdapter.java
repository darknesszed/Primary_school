package com.example.primary_school.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primary_school.Coor4Activity;
import com.example.primary_school.Entity.Shequxinxi;
import com.example.primary_school.Framgment.Shouye;
import com.example.primary_school.R;
import com.example.primary_school.circleimageview.CircleImageView;

import java.util.ArrayList;
import java.util.List;

public class ShequRecyclerviewAdapter extends RecyclerView.Adapter<ShequRecyclerviewAdapter.ViewHolder> {
    private List<Shequxinxi> shequArrayList;
    private ViewHolder viewHolder;
    private Shequxinxi shequxinxi;
    private int count=0;
    private Context context;
    static int flag=0;

    public ShequRecyclerviewAdapter(Context context, List<Shequxinxi> shequxinxis) {
        this.context = context;
        this.shequArrayList = shequxinxis;
        notifyDataSetChanged();
    }

    public void addData(List<Shequxinxi> shequxinxis) {
        if (this.shequArrayList == null)
        {
            this.shequArrayList = new ArrayList<>();
        }
        this.shequArrayList= shequxinxis;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_shequ_item,parent,false);
        viewHolder = new ViewHolder(view);

        return viewHolder;
    }
//    public void updateData(List<Shouye> data){
//        this.shouyeArrayList = data;
//        notifyDataSetChanged();
//    }

    @Override
    public void onBindViewHolder(@NonNull ShequRecyclerviewAdapter.ViewHolder holder, int position) {
//        Log.e("position", "onBindViewHolder position: "+position );
        shequxinxi = shequArrayList.get(position);
        count=position;

        holder.uusertouxing.setImageResource(shequxinxi.getUuseravatar());
        holder.uusername.setText(shequxinxi.getUusername());
        holder.fabutime.setText(shequxinxi.getFabutime());
        holder.shequneiirong.setText(shequxinxi.getFabuneirong());
        holder.btn_pinglun.setText(String.valueOf(shequxinxi.getPinglunnum()));

        if (shequxinxi.getFabuImg()==0){
            holder.fabuImg.setVisibility(View.GONE);
        }else {
            holder.fabuImg.setVisibility(View.VISIBLE);
            holder.fabuImg.setImageResource(shequxinxi.getFabuImg());
        }
        holder.btn_shequdianzan.setText(String.valueOf(shequxinxi.getDianzannum()));
        holder.btn_shequdianzan.setTag(position);
        holder.btn_shequdianzanqx.setTag(position);
        holder.shequbtn_guanzhu.setTag(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Coor4Activity.class);
                shequxinxi = shequArrayList.get(position);
                intent.putExtra("imgurl",shequxinxi.getFabuImg());
                context.startActivity(intent);
                ActivityOptions.makeSceneTransitionAnimation((Activity) context,v,"sharedView").toBundle();
            }
        });

        holder.shequbtn_guanzhu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (flag==0){
                            holder.shequbtn_guanzhu.setText("已关注");
                            holder.shequbtn_guanzhu.setBackgroundResource(R.drawable.shequbtnbg1);
                            holder.shequbtn_guanzhu.setTextColor(Color.parseColor("#505050"));
                            flag=1;
                        }
                        else if (flag==1){
                            holder.shequbtn_guanzhu.setText("+关注");
                            holder.shequbtn_guanzhu.setBackgroundResource(R.drawable.shequbtnbg);
                            holder.shequbtn_guanzhu.setTextColor(Color.parseColor("#16DF1E"));
                            flag=0;
                        }
                    }
                }
        );

        holder.btn_shequdianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btn_shequdianzan.getText();
                int dianzannum = Integer.valueOf((String) holder.btn_shequdianzan.getText());
                dianzannum++;
                holder.btn_shequdianzan.setVisibility(View.INVISIBLE);
                holder.btn_shequdianzanqx.setVisibility(View.VISIBLE);
                holder.btn_shequdianzanqx.setText(String.valueOf(dianzannum));
            }
        });
        holder.btn_shequdianzanqx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btn_shequdianzanqx.getText();
                int dianzannum = Integer.valueOf((String) holder.btn_shequdianzanqx.getText());
                dianzannum--;
                holder.btn_shequdianzanqx.setVisibility(View.INVISIBLE);
                holder.btn_shequdianzan.setVisibility(View.VISIBLE);
                holder.btn_shequdianzan.setText(String.valueOf(dianzannum));
            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//        public void onClick(View v) {
////                Intent intent = new Intent(context, Coor4Activity.class);
////                context.startActivity(intent);
//            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
//        }
//    });

    }

    @Override
    public int getItemCount() {
        return shequArrayList.size();
    }

    public interface OnItemClickListener{
        void onItemclick(View view,int position);
    }
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnChidClickListener){
        this.mOnItemClickListener = mOnChidClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
            ImageView fabuImg;
            CircleImageView uusertouxing;
            TextView uusername,fabutime,shequneiirong,btn_pinglun,btn_shequdianzan,btn_shequdianzanqx;
            Button shequbtn_guanzhu;

            public ViewHolder(@NonNull View view) {
                super(view);
                uusertouxing = view.findViewById(R.id.uusertouxing);
                uusername = view.findViewById(R.id.uusername);
                fabutime = view.findViewById(R.id.fabutime);
                shequneiirong = view.findViewById(R.id.shequneiirong);
                btn_pinglun = view.findViewById(R.id.btn_pinglun);
                btn_shequdianzan = view.findViewById(R.id.btn_shequdianzan);
                btn_shequdianzanqx = view.findViewById(R.id.btn_shequdianzanqx);
                fabuImg = view.findViewById(R.id.image_userfabbu);
                shequbtn_guanzhu = view.findViewById(R.id.shequbtn_guanzhu);



            }

        }


}
