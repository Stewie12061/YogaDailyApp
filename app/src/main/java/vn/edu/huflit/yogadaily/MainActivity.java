package vn.edu.huflit.yogadaily;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import me.itangqi.waveloadingview.WaveLoadingView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        display(R.id.mnuHome);
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                display(item.getItemId());

                return true;
            }
        });


    }

    void display(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.mnuHome:
//                toolbar.setTitle("Home");
                fragment = new HomeFragment();
                break;
            case R.id.mnuFood:
//                toolbar.setTitle("Food");
                fragment = new FoodFragment();
                break;
            case R.id.mnuDashboard:
//                toolbar.setTitle("Dashboard");
                fragment = new DashboardFragment();
                break;
            case R.id.mnuBMI:
//                toolbar.setTitle("BMI");
                fragment = new BmiFragment();
                break;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.commit();
    }
}