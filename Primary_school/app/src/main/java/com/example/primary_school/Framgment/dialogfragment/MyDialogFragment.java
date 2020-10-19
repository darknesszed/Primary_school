package com.example.primary_school.Framgment.dialogfragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.primary_school.Framgment.Fragment_Shouye;
import com.example.primary_school.Framgment.Grade;
import com.example.primary_school.R;
import com.example.primary_school.circleimageview.CircleImageView;

import java.util.List;

public class MyDialogFragment extends DialogFragment{
    private Button btn_first,btn_two,btn_three,btn_four,btn_five,btn_six,position;
    public String grade;
    private ImageView queding,quxiao;
    private Grade mgrade;
    private Drawable img;
    private CircleImageView circleImageView;
    public OnDialogListener mlistener;
    public MyDialogFragment(String agrade, Drawable img) {
        super();
        this.grade = agrade;
        this.img = img;
        Log.e("s", "MyDialogFragment: "+grade);
    }



    //设置dialogment在底部显示
//    @Override
//    public void onStart() {
//        super.onStart();
//        Window window = getDialog().getWindow();
//        WindowManager.LayoutParams params = window.getAttributes();
//        params.gravity = Gravity.BOTTOM;
//        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        window.setAttributes(params);
//        //设置背景透明
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_switch,container,false);
        //设置背景为透明
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btn_first = view.findViewById(R.id.btn_first);
        btn_two = view.findViewById(R.id.btn_two);
        btn_three = view.findViewById(R.id.btn_three);
        btn_four = view.findViewById(R.id.btn_four);
        btn_five = view.findViewById(R.id.btn_five);
        btn_six = view.findViewById(R.id.btn_six);
        queding = view.findViewById(R.id.queding);
        quxiao = view.findViewById(R.id.quxiao);

        circleImageView = view.findViewById(R.id.circleImageView1);
        circleImageView.setBackground(img);//设置头像
        setStyle();


        btn_first.setOnClickListener(onClickListener);
        btn_two.setOnClickListener(onClickListener);
        btn_three.setOnClickListener(onClickListener);
        btn_four.setOnClickListener(onClickListener);
        btn_five.setOnClickListener(onClickListener);
        btn_six.setOnClickListener(onClickListener);
        quxiao.setOnClickListener(onClickListener);

        return view;
    }

    /**
     * 写一个接口将数据传到activity
     */
    public interface OnDialogListener{
        void onDialogClick(String grade);
    }
    public void setOnDialogListener(OnDialogListener dialogListener){
        this.mlistener = dialogListener;
    }






        View.OnClickListener  onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_first:
                        btn_first.setBackgroundResource(R.drawable.shape2);
                        queding.setVisibility(View.VISIBLE);
//                        quxiao.setVisibility(View.VISIBLE);
                        position = btn_first;
                        break;
                    case R.id.btn_two:

                        btn_two.setBackgroundResource(R.drawable.shape2);
                        queding.setVisibility(View.VISIBLE);
//                        quxiao.setVisibility(View.VISIBLE);
                        position = btn_two;
                        break;
                    case R.id.btn_three:
                        btn_three.setBackgroundResource(R.drawable.shape2);
                        queding.setVisibility(View.VISIBLE);
//                        quxiao.setVisibility(View.VISIBLE);
                        position = btn_three;
                        break;
                    case R.id.btn_four:
                        btn_four.setBackgroundResource(R.drawable.shape2);
                        queding.setVisibility(View.VISIBLE);
//                        quxiao.setVisibility(View.VISIBLE);
                        position = btn_four;
                        break;
                    case R.id.btn_five:
                        btn_five.setBackgroundResource(R.drawable.shape2);
                        queding.setVisibility(View.VISIBLE);
//                        quxiao.setVisibility(View.VISIBLE);
                        position = btn_five;
                        break;
                    case R.id.btn_six:
                        btn_six.setBackgroundResource(R.drawable.shape2);
                        queding.setVisibility(View.VISIBLE);
//                        quxiao.setVisibility(View.VISIBLE);
                        position = btn_six;
                        break;

                    case R.id.quxiao:
                        dismiss();
                        break;
                    default:
                        position = btn_first;
                }
                mdismiss(position);

            }
        };

    public void mdismiss(final Button button){
        if (button==btn_first){
            btn_two.setBackgroundResource(R.drawable.shape1);
            btn_three.setBackgroundResource(R.drawable.shape1);
            btn_four.setBackgroundResource(R.drawable.shape1);
            btn_five.setBackgroundResource(R.drawable.shape1);
            btn_six.setBackgroundResource(R.drawable.shape1);
        }
        if (button==btn_two){
            btn_first.setBackgroundResource(R.drawable.shape1);
            btn_three.setBackgroundResource(R.drawable.shape1);
            btn_four.setBackgroundResource(R.drawable.shape1);
            btn_five.setBackgroundResource(R.drawable.shape1);
            btn_six.setBackgroundResource(R.drawable.shape1);
        }
        if (button==btn_three){
            btn_two.setBackgroundResource(R.drawable.shape1);
            btn_first.setBackgroundResource(R.drawable.shape1);
            btn_four.setBackgroundResource(R.drawable.shape1);
            btn_five.setBackgroundResource(R.drawable.shape1);
            btn_six.setBackgroundResource(R.drawable.shape1);
        }
        if (button==btn_four){
            btn_two.setBackgroundResource(R.drawable.shape1);
            btn_three.setBackgroundResource(R.drawable.shape1);
            btn_first.setBackgroundResource(R.drawable.shape1);
            btn_five.setBackgroundResource(R.drawable.shape1);
            btn_six.setBackgroundResource(R.drawable.shape1);
        }
        if (button==btn_five){
            btn_two.setBackgroundResource(R.drawable.shape1);
            btn_three.setBackgroundResource(R.drawable.shape1);
            btn_four.setBackgroundResource(R.drawable.shape1);
            btn_first.setBackgroundResource(R.drawable.shape1);
            btn_six.setBackgroundResource(R.drawable.shape1);
        }
        if (button==btn_six){
            btn_two.setBackgroundResource(R.drawable.shape1);
            btn_three.setBackgroundResource(R.drawable.shape1);
            btn_four.setBackgroundResource(R.drawable.shape1);
            btn_five.setBackgroundResource(R.drawable.shape1);
            btn_first.setBackgroundResource(R.drawable.shape1);
        }
        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getgrade(button);
                dismiss();
            }
        });
    }
    //将数据传递到Fragment_Shouye
    public void getgrade(Button button){
        mlistener.onDialogClick(button.getText().toString());
//        Intent intent = new Intent();
//        intent.putExtra("GRADE",button.getText().toString());
//        getTargetFragment().onActivityResult(Fragment_Shouye.REQUEST_CODE, Activity.RESULT_OK,intent);
    }
    public void setStyle(){
        if (grade.equals("一年级")){
            btn_first.setBackgroundResource(R.drawable.shape2);
        }
        if (grade.equals("二年级")){
            btn_two.setBackgroundResource(R.drawable.shape2);
        }
        if (grade.equals("三年级")) {
            btn_three.setBackgroundResource(R.drawable.shape2);
        }
        if (grade.equals("四年级")){
            btn_four.setBackgroundResource(R.drawable.shape2);
        }
        if (grade.equals("五年级")){
            btn_five.setBackgroundResource(R.drawable.shape2);
        }
        if (grade.equals("六年级")){
            btn_six.setBackgroundResource(R.drawable.shape2);
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
        setStyle(DialogFragment.STYLE_NORMAL,R.style.NoticeDialogStyle);
    }

    //    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog dialog =  new AlertDialog.Builder(getActivity())
//                .setTitle("神灯")
//                .setMessage("来选择你要实现的一个愿望把")
//                .setPositiveButton("车子", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                })
//                .setNegativeButton("房子", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                }).create();
//        return dialog;
//
//    }
}


