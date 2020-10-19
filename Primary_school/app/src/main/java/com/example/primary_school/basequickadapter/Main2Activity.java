package com.example.primary_school.basequickadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.primary_school.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView recyclerView = findViewById(R.id.recycler_base);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyProviderMultiAdapter myProviderMultiAdapter = new MyProviderMultiAdapter();
        recyclerView.setAdapter(myProviderMultiAdapter);
        Log.e("mainactivity", "onCreate: " +1);
        List<ProviderMultiEntity> data = new ArrayList<>();
        ProviderMultiEntity entity = new ProviderMultiEntity();
        for (int i = 0; i <12; i++) {
            entity.setName("da");
            entity.setAge(9);
            data.add(entity);
            Log.e("entity1", "entity:"+entity.getName()+" "+entity.getAge() );

        }

        myProviderMultiAdapter.setList(data);

    }
}
