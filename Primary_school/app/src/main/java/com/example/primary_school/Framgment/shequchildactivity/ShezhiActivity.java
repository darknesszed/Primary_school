package com.example.primary_school.Framgment.shequchildactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.primary_school.Framgment.dialogfragment.NetworkSetDialogFragment;
import com.example.primary_school.Framgment.dialogfragment.NetworkSetDialogFragmentdown;
import com.example.primary_school.R;

public class ShezhiActivity extends AppCompatActivity {
    private View contentViewGroup;
    private Switch aSwitch,bSwitch;
    private ImageView shezhi_fanhui;
    private NetworkSetDialogFragment networkSetDialogFragment;
    private NetworkSetDialogFragmentdown networkSetDialogFragmentdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shezhi);
        set_StatusBar();
        bindViewId();
        setSwitchOnChangeListener();
        setOnClickListener();

    }
    private void setOnClickListener(){
        shezhi_fanhui.setOnClickListener(onCL);

    }
    View.OnClickListener onCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.shezhi_fanhui:
                    finish();
                    break;
            }
        }
    };
    private void bindViewId(){
        aSwitch = findViewById(R.id.switch1);
        bSwitch = findViewById(R.id.switch2);
        shezhi_fanhui = findViewById(R.id.shezhi_fanhui);
    }

    private void setSwitchOnChangeListener(){
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    networkSetDialogFragment = new NetworkSetDialogFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    networkSetDialogFragment.setCancelable(true);
                    networkSetDialogFragment.show(fragmentManager,"networkSetDialogFragment");
                }else {
                    Toast.makeText(ShezhiActivity.this,"关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });
        bSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    networkSetDialogFragmentdown = new NetworkSetDialogFragmentdown();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    networkSetDialogFragmentdown.setCancelable(true);
                    networkSetDialogFragmentdown.show(fragmentManager,"networkSetDialogFragmentdown");
                }else {
                    Toast.makeText(ShezhiActivity.this,"关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void set_StatusBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//状态栏自动根据颜色深浅改变状态栏字体颜色
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //透明状态栏
        //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); //透明导航栏
        if (contentViewGroup == null) {
            contentViewGroup = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        }
//        --设置透明状态栏需要设置android:fitsSystemWindows="true" 或者在activity中设置，否着整个布局将会上移，导致布局出现问题
        contentViewGroup.setFitsSystemWindows(true);
    }
}
