package com.example.primary_school.basequickadapter;

import android.opengl.Visibility;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.primary_school.Entity.Lianxi;
import com.example.primary_school.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaesquickLianxiAdapter extends BaseQuickAdapter<Lianxi,BaseViewHolder> {
    public BaesquickLianxiAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Lianxi lianxi) {
           baseViewHolder.setText(R.id.text_danyuan,lianxi.getDanyuan());
           baseViewHolder.setText(R.id.text_biaoti,lianxi.getBiaoti());
           baseViewHolder.setText(R.id.text_datinum,lianxi.getDatiqingkuang());
           baseViewHolder.setText(R.id.text_dtjieyu,lianxi.getDatijieyu());
           baseViewHolder.setImageResource(R.id.image_biaoqing,lianxi.getBiaoqingImg());
           if (lianxi.getDatiqingkuang().equals("暂未练习")){
            baseViewHolder.setVisible(R.id.relative_datijieyu, false);
          }else {
            baseViewHolder.setVisible(R.id.relative_datijieyu, true);
            baseViewHolder.setText(R.id.btnn_lianxi,"再练一次");
          }
        Log.e("isvisible", "isvisible"+ lianxi.isVisible());
//           baseViewHolder.setVisible(R.id.relative_datijieyu, lianxi.isVisible());
    }
}
