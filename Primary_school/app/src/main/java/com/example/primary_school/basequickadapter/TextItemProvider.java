package com.example.primary_school.basequickadapter;

import android.util.Log;
import android.view.ViewGroup;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.primary_school.R;

import org.jetbrains.annotations.NotNull;

public class TextItemProvider extends BaseItemProvider<ProviderMultiEntity> {
    // item 类型
    @Override
    public int getItemViewType() {
        Log.e("getItemViewType2:", "getItemViewType: providerMultiEntity.TEXT;");
        return ProviderMultiEntity.TEXT;
    }

    /*
     * （可选）
     * 重写返回自己的 ViewHolder。
     * 默认返回 BaseViewHolder()
     */
    @NotNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Log.e("onCreateViewHolder2: ", "onCreateViewHolder2: " );
        return super.onCreateViewHolder(parent, viewType);
    }

    // 返回 item 布局 layout
    @Override
    public int getLayoutId() {
        Log.e("getLayoutId2: ", "getLayoutId2:R.layout.item_text_view " );
        return R.layout.item_text_view;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, ProviderMultiEntity providerMultiEntity) {
        // 设置 item 数据
        Log.e("convert2: ", "convert2: " );
        String a = String.valueOf(providerMultiEntity.getAge());

        baseViewHolder.setText(R.id.text_item3,providerMultiEntity.getName());

    }
}
