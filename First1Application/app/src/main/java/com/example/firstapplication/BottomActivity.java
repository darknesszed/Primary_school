package com.example.firstapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.firstapplication.ui.dashboard.DashboardFragment;
import com.example.firstapplication.ui.home.HomeFragment;
import com.example.firstapplication.ui.notifications.NotificationsFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class BottomActivity extends AppCompatActivity {
//    private HomeFragment homeFragment;
//    private DashboardFragment dashboardFragment;
//    private NotificationsFragment notificationsFragment;
    private Context context;
    private Button head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom
        );
        context = this;
//        NavigationView navigationView=findViewById(R.id.nav_host_fragment);
//        NavigationView temp = navigationView.getHeaderView(0).findViewById(R.id.navigation_home);
//
//
//
//        h
//        head=findViewById(R.id.home_button);
//
//        head.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                startTarget();
//
//            }
//        });
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard,
                R.id.navigation_notifications).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);



//
    }
//    private void startTarget()
//    {
//        Intent intent = new Intent(context, SetActivity.class);
//        startActivity(intent);
//    }

}