package com.example.primary_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Coor4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coor4);
        ImageView imageView = findViewById(R.id.shequimageView);
        Intent intent = getIntent();
        int imgurl = intent.getIntExtra("imgurl",R.drawable.huge);
        if (imgurl!=0){
            Glide.with(this).load(imgurl).into(imageView);
        }else {
            Glide.with(this).load(R.drawable.huge).into(imageView);
        }
        Log.e("imgurl", ": "+imgurl);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAfterTransition(Coor4Activity.this);

            }
        });
    }
}
