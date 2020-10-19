package com.example.primary_school.Framgment.dialogfragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.primary_school.R;

public class NetworkSetDialogFragmentdown extends DialogFragment{
    private Button btn_net1,btn_net2;
    public String grade;
    public OnDialogListener mlistener;
    public NetworkSetDialogFragmentdown() {
        super();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfragment_netsetdown,container,false);
        final Window window = getDialog().getWindow();
        //设置背景为透明
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btn_net1 = view.findViewById(R.id.btn_net1);
        btn_net2 = view.findViewById(R.id.btn_net2);

        btn_net1.setOnClickListener(onClickListener);
        btn_net2.setOnClickListener(onClickListener);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.80), ViewGroup.LayoutParams.WRAP_CONTENT);//宽度设置
        }
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
                int position = 0;
                switch (v.getId()){
                    case R.id.btn_net1:
                        position = 0;
                        dismiss();
                        break;
                    case R.id.btn_net2:
                        position = 1;
                        dismiss();
                        break;
                    default:
                        position=0;
                }


            }
        };

    public void mdismiss(final Button button){
        btn_net1.setOnClickListener(new View.OnClickListener() {
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



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
        setStyle(DialogFragment.STYLE_NORMAL,R.style.NoticeDialogStyle);
    }

}


