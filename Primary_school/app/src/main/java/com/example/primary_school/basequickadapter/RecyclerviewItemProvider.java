package com.example.primary_school.basequickadapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.primary_school.Framgment.RecyclerviewAdapter;
import com.example.primary_school.Framgment.Shouye;
import com.example.primary_school.R;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RecyclerviewItemProvider extends BaseItemProvider<ProviderMultiEntity> {

    private Data data;
    public static int position=0;
    RecyclerviewAdapter recyclerviewAdapter;
    // item 类型
    @Override
    public int getItemViewType() {
//        position++;
        return ProviderMultiEntity.IMG_TEXT;
    }
    /*
     * （可选）
     * 重写返回自己的 ViewHolder。
     * 默认返回 BaseViewHolder()
     */
    @NotNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }

    // 返回 item 布局 layout
    @Override
    public int getLayoutId() {
        return R.layout.recyclerview_item;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, ProviderMultiEntity providerMultiEntity) {
        // 设置 item 数据
        data = new Data();
        int[][] itemchildid = new int[][]{{R.id.image_jxkd1,R.id.text_jxkdtitle1},{R.id.image_jxkd2,R.id.text_jxkdtitle2},
                {R.id.image_jxkd3,R.id.text_jxkdtitle3},{R.id.image_jxkd4,R.id.text_jxkdtitle4},{R.id.image_jxkd5,R.id.text_jxkdtitle5},{R.id.image_jxkd6,R.id.text_jxkdtitle6}};
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 1; j++) {
                baseViewHolder.setImageResource(itemchildid[i][j],data.imgid(position));
                baseViewHolder.setText(itemchildid[i][j+1],data.titles(position));
                position++;
            }

        }



//        Log.e("position: ", ""+position);

    }

    public void initShouye(){
        List<Shouye> shouyeList = new ArrayList<>();
        String[] vids = new String[]{"1","2","3","4","5","6","7","8","9","10"};
        String[] titles = new String[]{"快速运算","如何实现满分作文","唐诗三百首","快乐英语","正反义词","可爱的小白兔","快速学习字典运用","计算器使用","正楷练习课","家长最关心的问题"};
        int[] imgs = new int[]{R.drawable.huge,R.drawable.cwt,R.drawable.dlrb,R.drawable.glnz,
                + R.drawable.hjh,R.drawable.ldh,R.drawable.lss,R.drawable.zly,R.drawable.zta,R.drawable.zyx};
        for (int i = 0; i < 1; i++) {
            Shouye shouye = new Shouye(vids[i],titles[i],imgs[i]);
            shouyeList.add(shouye);
        }
        recyclerviewAdapter.addData(shouyeList);
    }
}
