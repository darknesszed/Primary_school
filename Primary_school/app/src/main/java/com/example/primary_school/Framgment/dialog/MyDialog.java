package com.example.primary_school.Framgment.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.primary_school.R;

public class MyDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private int themeResId;
    private int[] listenItem;
    public MyDialog(@NonNull Context context, int themeResId,int[] listenItem) {
        super(context, R.style.MyDialog);
        this.context = context;
        this.themeResId = themeResId;
        this.listenItem = listenItem;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER);//设置dialog居中显示
//        dialogWindow.setWindowAnimations();//设置动画效果
        setContentView(themeResId);

        WindowManager windowManager = ((Activity)context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = display.getWidth()*4/5;// 设置dialog宽度为屏幕的4/5
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(true);//点击外部Dialog消失
        //遍历控件id添加点击注册
        for(int id:listenItem){
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
