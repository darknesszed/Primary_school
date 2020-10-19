package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetActivity extends AppCompatActivity {
    private Context context;

    private Button jump;
    private Button jump1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        context = this;
        jump=findViewById(R.id.tittle9);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                        Intent intent = new Intent(context, BottomActivity.class);
                        startActivity(intent);

                }




        });
        jump1=findViewById(R.id.tittle8);
        jump1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                        Intent intent2 = new Intent(context, RefreshDemoActivity.class);
                        startActivity(intent2);

                }




        });


    }

}
