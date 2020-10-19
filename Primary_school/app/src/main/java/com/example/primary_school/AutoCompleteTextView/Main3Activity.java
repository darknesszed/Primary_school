package com.example.primary_school.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import com.example.primary_school.Framgment.RecyclerviewAdapter;
import com.example.primary_school.Framgment.Shouye;
import com.example.primary_school.Framgment.dialog.MyDialog;
import com.example.primary_school.R;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

public class Main3Activity extends AppCompatActivity {
    private AutoCompleteTextView auto_seektips;
    private RecyclerviewAdapter recyclerviewAdapter;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        context = this;
//        RecyclerView recyclerView = findViewById(R.id.recycler_base);
////        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerviewAdapter = new RecyclerviewAdapter(this,null);
//        recyclerView.setAdapter(recyclerviewAdapter);
//        initShouye();
        AutoCompleteTextView auto_seekTips = findViewById(R.id.auto_seekTips);
        auto_seekTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog myDialo = new MyDialog(context,R.layout.fragment_switch,new int[R.id.btn_first]);
                myDialo.show();
            }
        });


    }
    public void initShouye(){
        List<Shouye> shouyeList = new ArrayList<>();
        String[] vids = new String[]{"109000","200000","30000","40000","556","90","700","114","997","34"};
        String[] titles = new String[]{"快速运算","如何实现满分作文","唐诗三百首","快乐英语","正反义词","可爱的小白兔","快速学习字典运用","计算器使用","正楷练习课","家长最关心的问题"};
        int[] imgs = new int[]{R.drawable.huge,R.drawable.cwt,R.drawable.dlrb,R.drawable.glnz,
                + R.drawable.hjh,R.drawable.ldh,R.drawable.lss,R.drawable.zly,R.drawable.zta,R.drawable.zyx};

        for (int i = 0; i < vids.length ; i++) {
            Shouye shouye = new Shouye(vids[i],titles[i],imgs[i]);
            shouyeList.add(shouye);
        }
        recyclerviewAdapter.addData(shouyeList);

    }
}
