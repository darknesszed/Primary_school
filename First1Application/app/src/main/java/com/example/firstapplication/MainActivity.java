package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;

    private Button main;

    private EditText edtUsername;
    private EditText edtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        main=findViewById(R.id.button);
        edtUsername = findViewById(R.id.user);
        edtPwd = findViewById(R.id.password);


        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                login();


            }
        });


    }
    private void login()
    {
        String user = edtUsername.getText().toString();
        String password = edtPwd.getText().toString();
        if (TextUtils.isEmpty(user)||TextUtils.isEmpty(password))
        {
            // Toast 提示用户输入必要信息
            Toast.makeText(context, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
            return;
        }


        startTarget();

    }

    private void startTarget()
    {
        Intent intent = new Intent(context, SetActivity.class);
        startActivity(intent);
    }
}

