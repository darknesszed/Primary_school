package com.example.primary_school.basequickadapter;

import android.util.Log;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.example.primary_school.Framgment.RecyclerviewAdapter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyProviderMultiAdapter extends BaseProviderMultiAdapter<ProviderMultiEntity> {
    RecyclerviewItemProvider recyclerviewItemProvider;
    public int position=0;
    public MyProviderMultiAdapter() {
        super();
        // 注册 Provider
//        addItemProvider(new );
        addItemProvider(new GridlayoutItemProvider());
        addItemProvider(new RecyclerviewItemProvider());

//        addItemProvider(new TextItemProvider());

//
//        Log.e("构造方法", "MyProviderMultiAdapter: ");
    }

    /**
     * 自行根据数据、位置等信息，返回 item 类型
     */
    @Override
    protected int getItemType(@NotNull List<? extends ProviderMultiEntity> list, int i) {
        // i 的最大值等于ProviderMultiEntity实体数量-1，
        //i<1表示ProviderMultiEntity.IMG的item只有一条
        if (i<5){
            GridlayoutItemProvider.position=2*i;
            return ProviderMultiEntity.Gridlayout;
        }
        //i>=1表示ProviderMultiEntity.IMG_TEXT的item有maxi-1
        if (i==5){
//            Log.e("position", "getItemType: "+position );
            if (position==10){
                position--;
            }
            recyclerviewItemProvider.position = i-5;//循环添加条目时，需指定下标才能给对应的条目添加数据，将下标传递到itemprovider
            position++;
            return ProviderMultiEntity.IMG_TEXT;
        }
        if (i>5 && i < 11){
            i=i-6;
//            Log.e("i>5 && i < 11", "i: "+i );
            GridlayoutItemProvider.position=2*i;
            return ProviderMultiEntity.Gridlayout;
        }
        if (i>=11){
            i=i-11;
//            Log.e("i>=11", "i: "+i );
            GridlayoutItemProvider.position=2*i;
            return ProviderMultiEntity.Gridlayout;
        }
        return 0;
    }
}
