package com.example.primary_school.Framgment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.primary_school.Entity.Shequxinxi;
import com.example.primary_school.R;
import com.example.primary_school.adapter.ShequRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_shequ extends Fragment {
    private RecyclerView recycler_shequ;
    private List<Shequxinxi> shequxinxiList;
    private TextView diancg,dianqx;
    int dianzannum;
    private BaseQuickAdapter baseQuickshequAdapter;
    private ShequRecyclerviewAdapter shequRecyclerviewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shequ,container,false);
        recycler_shequ = view.findViewById(R.id.recycler_shequ);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler_shequ.setLayoutManager(layoutManager);
        initshequData();
        shequRecyclerviewAdapter = new ShequRecyclerviewAdapter(getActivity(),shequxinxiList);

        recycler_shequ.setAdapter(shequRecyclerviewAdapter);
//        baseQuickshequAdapter = new BaesquickshequAdapter(R.layout.recycler_shequ_item,shequxinxiList);
//        recycler_shequ.setAdapter(baseQuickshequAdapter);

        return view;
    }

    public void recyclerItemClick(){
        baseQuickshequAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {

                TextView diancg = view.findViewById(R.id.btn_shequdianzan);
                TextView jubao = view.findViewById(R.id.btn_shequjubao);

                if (view.getId()==R.id.btn_shequdianzan){
                    int dianzannum = Integer.valueOf((String) diancg.getText());
                    dianzannum++;
                    diancg.setVisibility(View.INVISIBLE);
//                    TextView dianqx = view.findViewById(R.id.btn_shequdianzanqx);
//                    dianqx.setVisibility(View.VISIBLE);
//                    dianqx.setText(String.valueOf(dianzannum));
                }
//                switch (view.getId()){
//                    case R.id.btn_shequdianzan:
//                        Toast.makeText(getActivity(),"R.id.btn_shequdianzan",Toast.LENGTH_LONG).show();
//                        int dianzannum = Integer.valueOf((String) diancg.getText());
//                        dianzannum++;
//                        diancg.setVisibility(View.INVISIBLE);
////                        dianqx.setVisibility(View.VISIBLE);
//                        dianqx.setText(String.valueOf(dianzannum));
//
//                        break;
//                    case R.id.btn_shequdianzanqx:
//                        int dianzannum1 = Integer.valueOf((String) dianqx.getText());
//                        dianzannum1--;
//                        dianqx.setText(String.valueOf(dianzannum1));
////                        dianqx.setVisibility(View.GONE);
////                        diancg.setVisibility(View.VISIBLE);
//                        break;
//                 }
            }
        });
    }
    public void initshequData(){
        shequxinxiList = new ArrayList<>();
        int[] uuseravatars = new int[]{R.drawable.zly,R.drawable.cwt,R.drawable.dlrb,R.drawable.glnz,
                + R.drawable.hjh,R.drawable.ldh,R.drawable.lss,R.drawable.huge,R.drawable.zta,R.drawable.zyx};

        String[] uusernames = new String[]{"初一思","小甜心","男子汉↑","可爱如我","超强小王子",
                "我会算一加一","like apple","猜猜我是谁","结局不会太完美","温柔的佳佳"};
        String[] fabutime = new String[]{"18小时前","20小时前","21小时前","22小时前","23小时前",
                "1天前","2天前","5天前","6天前","7天前","8天前"};
        String[] fabuneirong = new String[]{"加油吧！我们作为新时代的接班人，理应努力。","少壮不努力，老大徒伤悲","哪位姐姐可以教我数学呀！！！",
                "成绩不太好，要努力呀", "今天学得还不错！我还可以学得更好。开心^-^","数学，烦死人了啊啊啊啊啊","Hi 早上好啊！",
                "1.不要被任何人打乱自己的脚步，因为没有谁会像你一样清楚和在乎自己的梦想。\n2.就算路不坦荡，也要做自己的太阳! \n3.不念过往，不为未来，珍惜现在。 \n4.什么时候离光明最近？那就是你觉得黑暗太黑的时候。 \n5.只要有勇气，整片蓝天便是你的。",".生活确实很艰难，让我们常常无力抵抗，但我们不妨换个心态，换种心情，给自己减负，为生活发一块糖。","常怀感恩的人是幸福的人，懂得感恩的人是快乐的人，经常感恩的人是成功的人，朋友，在教师节到来的时候，让我们一起祝愿，一起送上我们感恩的问候吧!"};

        int[] fabuImgs = new int[]{R.drawable.shequimg1,R.drawable.cwt,R.drawable.huitailang,R.drawable.shequimg2,R.drawable.shequimg3,R.drawable.shequimg4,R.drawable.lss,R.drawable.huge,R.drawable.zta,R.drawable.zyx};
        int[] pinglunnum = {10,23,666,9,4,5,8,33,23,44};
        int[] dianzannum = {1001,23,666,99,34,565,788,33,1123,444};

        for (int i = 0; i < uuseravatars.length ; i++) {
            if(i>5){
                Shequxinxi shequxinxi = new Shequxinxi(uuseravatars[i],uusernames[i],fabutime[i],fabuneirong[i],0,pinglunnum[i],dianzannum[i]);
                shequxinxiList.add(shequxinxi);
                Log.e("initshequData:", "initshequData: "+i);
                continue;

            }
                Shequxinxi shequxinxi = new Shequxinxi(uuseravatars[i],uusernames[i],fabutime[i],fabuneirong[i],fabuImgs[i],pinglunnum[i],dianzannum[i]);
                shequxinxiList.add(shequxinxi);






        }
    }
}
