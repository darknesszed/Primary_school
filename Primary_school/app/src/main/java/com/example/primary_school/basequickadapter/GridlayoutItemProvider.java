package com.example.primary_school.basequickadapter;

import android.util.Log;
import android.view.ViewGroup;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.primary_school.R;

import org.jetbrains.annotations.NotNull;

public class GridlayoutItemProvider extends BaseItemProvider<ProviderMultiEntity> {
    private Data data;
    public static int position=0;
    // item 类型
    @Override
    public int getItemViewType() {
//        Log.e("getItemViewType: ", "getItemViewType: ");
        return ProviderMultiEntity.Gridlayout;
    }

    /*
     * （可选）
     * 重写返回自己的 ViewHolder。
     * 默认返回 BaseViewHolder()
     */
    @NotNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
//        Log.e("onCreateViewHolder() returned: ", "onCreateViewHolder() returned: "  );
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
//        viewHolder = new RecyclerviewAdapter.ViewHolder(view);

        return super.onCreateViewHolder(parent, viewType);
    }
    // 返回 item 布局 layout
    @Override
    public int getLayoutId() {
//        Log.e("getLayoutId: " , "getLayoutId: " );
        return R.layout.item_gridlayout_view;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, ProviderMultiEntity providerMultiEntity) {
        // 设置 item 数据
//        Log.e("convert1: ", "convert: ");
        data = new Data();
        baseViewHolder.setImageResource(R.id.image_viedo1,data.imgid(position));
        baseViewHolder.setText(R.id.text_videotitle1,data.titles(position));
        baseViewHolder.setText(R.id.text_videonum1,"视频·"+data.videonums(position)+"次播放 ");

        baseViewHolder.setImageResource(R.id.image_viedo2,data.imgid(position+1));
        baseViewHolder.setText(R.id.text_videotitle2,data.titles(position+1));
        baseViewHolder.setText(R.id.text_videonum2,"视频·"+data.videonums(position+1)+"次播放 ");

    }
}
