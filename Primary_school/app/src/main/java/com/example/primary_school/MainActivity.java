package com.example.primary_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.primary_school.Framgment.Fragment_Shouye;
import com.example.primary_school.Framgment.Fragment_jpk;
import com.example.primary_school.Framgment.Fragment_lianxi;
import com.example.primary_school.Framgment.Fragment_me;
import com.example.primary_school.Framgment.Fragment_shequ;
import com.example.primary_school.Framgment.Viewpage_Fragment_Adapter;
import com.example.primary_school.Framgment.dialog.MyDialog;
import com.example.primary_school.Framgment.dialogfragment.MyDialogFragment;
import com.example.primary_school.circleimageview.CircleImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    public List<Fragment> fragments;
    private Context context;
    private Toolbar mToolbar;
    private Viewpage_Fragment_Adapter viewpage_fragment_adapter;
    private Fragment_Shouye fragment_shouye;
    private Fragment_jpk fragment_jpk;

    private TextView serach,grade_text;
    private CircleImageView circleImageView;
    private ImageButton btn_touxiang;
    public String mgrade;
    private Drawable imgres;


    private MyDialogFragment myDialogFragment;
    private MyDialog myDialo;
    private LinearLayout kefu,lianxi_cuoti;
    private RelativeLayout toolbar_touxiang,theme;
    private ViewPager viewPager;
    private Button btn_shouye,btn_me,btn_jinpinke,btn_lianxi,btn_shequ,toolbar_lianxi,toolbar_cuoti;
    private View contentViewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mToolbar =findViewById(R.id.toolbar);
        setActionBar(mToolbar);
        set_StatusBar();
        theme = findViewById(R.id.theme);
        context = this;

        btn_shouye = findViewById(R.id.btn_shouye);
        btn_jinpinke = findViewById(R.id.btn_jinpinke);
        btn_lianxi = findViewById(R.id.btn_lianxi);
        btn_shequ = findViewById(R.id.btn_shequ);
        btn_me = findViewById(R.id.btn_me);
        viewPager = findViewById(R.id.viewpage);
        initviewpager();

        serach = findViewById(R.id.toolbar_search);
        kefu = findViewById(R.id.toolbar_jpk);

        lianxi_cuoti = findViewById(R.id.toolbar_lianxi);
        toolbar_lianxi = findViewById(R.id.btn_toolbar_lianxi);
        toolbar_cuoti = findViewById(R.id.btn_toolbar_cuoti);
        toolbar_touxiang = findViewById(R.id.toolbar_touxiang);
        btn_touxiang = findViewById(R.id.btn_touxiang);
        grade_text = findViewById(R.id.grade_text);
        circleImageView = findViewById(R.id.circleImageView);

        btn_shouye.setOnClickListener(listener_button);
        btn_jinpinke.setOnClickListener(listener_button);
        btn_lianxi.setOnClickListener(listener_button);
        btn_shequ.setOnClickListener(listener_button);
        btn_me.setOnClickListener(listener_button);
        toolbar_lianxi.setOnClickListener(listener_button);
        toolbar_cuoti.setOnClickListener(listener_button);
        btn_touxiang.setOnClickListener(listener_button);



        btn_shouye.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home, 0, 0);
    }
    View.OnClickListener listener_button = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = 0;
            switch (view.getId()){
                case R.id.btn_shouye:
                    position = 0;
                    viewPager.setCurrentItem(0);//切换到对应的fragment
                    //选中时更改图片
                    btn_shouye.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home, 0, 0);
                    break;
                case R.id.btn_jinpinke:
                    position = 1;
                    viewPager.setCurrentItem(1);
                    btn_jinpinke.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jingpinke3, 0, 0);
                    break;
                case R.id.btn_lianxi:
                    position = 2;
                    viewPager.setCurrentItem(2);
                    btn_lianxi.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.lianxi1, 0, 0);
                    break;
                case R.id.btn_shequ:
                    position = 3;
                    viewPager.setCurrentItem(3);
                    btn_shequ.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.shequ, 0, 0);
                    break;
                case R.id.btn_me:
                    position = 4;
                    viewPager.setCurrentItem(4);
                    btn_me.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.me1, 0, 0);
                    break;

                case R.id.btn_toolbar_lianxi:
                    position=2;
                    toolbar_lianxi.setBackgroundResource(R.drawable.lianxibtnbg11);
                    toolbar_cuoti.setBackgroundResource(R.drawable.cuotibtnbg11);
                    break;
                case R.id.btn_toolbar_cuoti:
                    position=2;
                    toolbar_cuoti.setBackgroundResource(R.drawable.cuotibtnbg1);
                    toolbar_lianxi.setBackgroundResource(R.drawable.lianxibtnbg);
                    break;
                case R.id.btn_touxiang:
                    mgrade = grade_text.getText().toString();
                    imgres = circleImageView.getBackground();//获取头像资源
                    myDialogFragment = new MyDialogFragment(mgrade,imgres);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    myDialogFragment.setCancelable(true);//点击非Dialog退出Dialog
                    myDialogFragment.show(fragmentManager,"mydialogfragment");
                    setTouxiang();
                    position = viewPager.getCurrentItem();
//                    myDialo = new MyDialog(context,R.layout.fragment_switch,new int[R.id.btn_first]);
//                    myDialo.show();
                    break;

//                    myDialogFragment.setShowsDialog(MainActivity.this,REQUEST_CODE);
//                    myDialogFragment.showNow(getFragmentManager(),"mydialogfragment");
                default:
                    viewPager.setCurrentItem(0);
                    break;
            }
            setToolbar(position);
        }
    };

    public void setToolbar(int position){
        if (position == 0){
            serach.setVisibility(View.VISIBLE);
            kefu.setVisibility(View.INVISIBLE);
            lianxi_cuoti.setVisibility(View.INVISIBLE);
            toolbar_touxiang.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.VISIBLE);
            theme.setBackgroundResource(R.color.white);
        }
        if (position == 1){
            serach.setVisibility(View.INVISIBLE);
            kefu.setVisibility(View.VISIBLE);
            lianxi_cuoti.setVisibility(View.INVISIBLE);
            toolbar_touxiang.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.VISIBLE);
//            theme.setBackgroundColor(Color.parseColor("#00BFFF"));#FFF0F5
            theme.setBackgroundColor(Color.parseColor("#FFF0F5"));
        }
        if (position == 2){
            serach.setVisibility(View.INVISIBLE);
            kefu.setVisibility(View.INVISIBLE);
            lianxi_cuoti.setVisibility(View.VISIBLE);
            toolbar_touxiang.setVisibility(View.INVISIBLE);
            mToolbar.setVisibility(View.VISIBLE);
            theme.setBackgroundColor(Color.parseColor("#00BFFF"));
        }
        if (position == 3){
            //View.GONE---->不可见，但这个View在ViewGroup中不保留位置，会重新layout，不再占用空间，那后面的view就会取代他的位置，
            mToolbar.setVisibility(View.GONE);
            theme.setBackgroundColor(Color.WHITE);
        }
        if (position == 4){
            mToolbar.setVisibility(View.GONE);
            theme.setBackgroundColor(Color.parseColor("#00BFFF"));
        }
    }

    public void initviewpager(){
        Log.e("activity", "initviewpager: ");
        Fragment_Shouye fragment_shouye = new Fragment_Shouye(null);
        Fragment_jpk fragment_jpk = new Fragment_jpk();
        Fragment_lianxi fragment_lianxi = new Fragment_lianxi();
        Fragment_shequ fragment_shequ = new Fragment_shequ();
        Fragment_me fragment_me = new Fragment_me();
        fragments = new ArrayList<Fragment>();
        fragments.add(fragment_shouye);
        fragments.add(fragment_jpk);
        fragments.add(fragment_lianxi);
        fragments.add(fragment_shequ);
        fragments.add(fragment_me);

        viewpage_fragment_adapter =new Viewpage_Fragment_Adapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewpage_fragment_adapter);
        viewPager.addOnPageChangeListener(this);


    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setdrawbletop(position);
    }

    private void setdrawbletop(int position) {
        if (position==0){
            btn_shouye.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home, 0, 0);

        }else {
            btn_shouye.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home1, 0, 0);
        }
        if (position==1){
            btn_jinpinke.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jingpinke3, 0, 0);
        }else {
            btn_jinpinke.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.jingpinke1, 0, 0);
        }
        if (position==2){
            btn_lianxi.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.lianxi1, 0, 0);
        }else {
            btn_lianxi.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.lianxi, 0, 0);
        }
        if (position==3){
            btn_shequ.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.shequ, 0, 0);
        }else {
            btn_shequ.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.shequ1, 0, 0);
        }

        if (position==4){
            btn_me.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.me1, 0, 0);
        }else {
            btn_me.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.me, 0, 0);
        }
        setToolbar(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * 实现Dialogment中的接口获取dialogment传回来的数据
     */
    public void setTouxiang(){
        myDialogFragment.setOnDialogListener(new MyDialogFragment.OnDialogListener() {
            @Override
            public void onDialogClick(String grade) {
                grade_text.setText(grade);
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




