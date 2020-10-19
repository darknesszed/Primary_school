package com.example.primary_school.basequickadapter;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.primary_school.Entity.Lianxi;
import com.example.primary_school.Entity.Shequxinxi;
import com.example.primary_school.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaesquickshequAdapter extends BaseQuickAdapter<Shequxinxi,BaseViewHolder> {
    public BaesquickshequAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Shequxinxi shequxinxi) {
        if (shequxinxi!=null){
            if (shequxinxi.getFabuImg()!=0){
                baseViewHolder.setGone(R.id.image_userfabbu, false);
                baseViewHolder.setImageResource(R.id.image_userfabbu,shequxinxi.getFabuImg());
            }else {
                baseViewHolder.setGone(R.id.image_userfabbu, true);
            }
            baseViewHolder.setImageResource(R.id.uusertouxing,shequxinxi.getUuseravatar())
                          .setText(R.id.uusername,shequxinxi.getUusername())
                          .setText(R.id.fabutime,shequxinxi.getFabutime())
                          .setText(R.id.shequneiirong,shequxinxi.getFabuneirong())
                          .setText(R.id.btn_pinglun,  String.valueOf(shequxinxi.getPinglunnum()))
                          .setText(R.id.btn_shequdianzan,String.valueOf(shequxinxi.getDianzannum()));



        }


    }

    @Override
    public void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        super.setOnItemClickListener(listener);
    }
}
