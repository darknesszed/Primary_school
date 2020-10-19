package com.example.primary_school.Framgment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.primary_school.Entity.Lianxi;
import com.example.primary_school.R;
import com.example.primary_school.basequickadapter.BaesquickLianxiAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Fragment_lianxi extends Fragment {
    private Button btn_popup;
    private RecyclerView recyclerView;
    private BaseQuickAdapter mBaseQuickAdapter;
    private List<Lianxi> lianxilist;
    private boolean isvisible = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lianxi,container,false);
        btn_popup = view.findViewById(R.id.text_pupomeun);
        recyclerView = view.findViewById(R.id.recycler_lianxi);
        recyclerView.setNestedScrollingEnabled(false);//解决recyclerview与NestedScrollView的滑动冲突
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        initLianxiData();
        mBaseQuickAdapter = new BaesquickLianxiAdapter(R.layout.recycler_lianxi_ltem,lianxilist);

        recyclerView.setAdapter(mBaseQuickAdapter);
//        mBaseQuickAdapter.addChildClickViewIds(R.id.btnn_lianxi);
//        mBaseQuickAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
//                Button button = view.findViewById(R.id.btnn_lianxi);
//                TextView textView = view.findViewById(R.id.text_dtjieyu);
//
//                if (view.getId()==R.id.btnn_lianxi){
//                    button.setText("再练一次");
//
////                    textView.setVisibility(View.INVISIBLE);
//                    ((Lianxi)mBaseQuickAdapter.getData().get(position)).setVisible(isvisible);
//                    mBaseQuickAdapter.notifyItemChanged(position);
//                    if (isvisible==false){
//                        isvisible = true;
//                    }else {
//                        isvisible = false;
//                    }
//                }
//
////                mBaseQuickAdapter.notifyDataSetChanged();
//            }
//        });
        btn_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_popup.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.shangla,0);
                myPopupMenu(v);
            }
        });
        return view;
    }


    public void initLianxiData(){
        lianxilist = new ArrayList<>();
        String[] danyuans = new String[]{"第一单元","第二单元","第三单元","第四单元","第五单元","第六单元","第七单元","第八单元","第九单元","第十单元"};
        String[] biaotis = new String[]{"一、四则运算","一、观察物体(二)","一、运算定律","一、小数的意义和性质","一、三角形的特性(1)",
                "一、小数的加法和减法(1)","一、数学广角","一、小数的加法和减法(2)","二、三角形的特性(2)","家长最关心的问题"};
        String[] datiqingkuang = new String[]{"暂未练习","9/12 答对数/总题数","12/12 答对数/总题数","4/12 答对数/总题数","9/12 答对数/总题数",
                "7/12 答对数/总题数","9/10 答对数/总题数","6/9 答对数/总题数","2/12 答对数/总题数","12/12 答对数/总题数","11/12 答对数/总题数"};
        String[] datijieyu = new String[]{" 还不错哟！还可以更好^-^"," 还不错哟！还可以更好^-^"," 可真厉害，再接再励吧^-^"," 成绩不太好，要努力呀",
                " 还不错哟！还可以更好^-^"," 还不错哟！还可以更好^-^"," 还不错哟！还可以更好^-^"," 还不错哟！还可以更好^-^"," 还不错哟！还可以更好^-^"," 还不错哟！还可以更好^-^"};

        int[] biaoqingImgs = new int[]{R.drawable.biaoqing_weixiao,R.drawable.biaoqing_shangxin,R.drawable.biaoqing_kaixin};
        boolean[] visible = {true,true,true,true,true,true,true,true,true,true};
        for (int i = 0; i < danyuans.length ; i++) {
            int r = 0;
            if (i==2){
                r=2 ;
            }
            if (i==3){
                r=1;
            }
            if (i==9){
                Log.e("datijieyu[i]", "datijieyu: "+datijieyu[i]+" "+datiqingkuang[i]);
            }
            Lianxi lianxi = new Lianxi(danyuans[i],biaotis[i],datiqingkuang[i],datijieyu[i],biaoqingImgs[r],visible[i]);
            lianxilist.add(lianxi);
        }
    }

        @SuppressLint("RestrictedApi")
    private void myPopupMenu(View v) {
        //定义PopupMenu对象
        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
        //设置PopupMenu对象的布局
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        //设置PopupMenu的点击事件
        try {
            Field[] fields = popupMenu.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popupMenu);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper
                            .getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod(
                            "setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                btn_popup.setText(item.getTitle());
                Toast.makeText(getActivity(), "您选择了" + item.getTitle()+"册", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                btn_popup.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.xiala,0);
            }
        });
        //显示菜单
        popupMenu.show();

    }
}
