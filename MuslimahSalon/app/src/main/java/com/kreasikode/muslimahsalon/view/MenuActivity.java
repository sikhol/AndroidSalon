package com.kreasikode.muslimahsalon.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.kreasikode.muslimahsalon.viewFragment.AntrianFragment;
import com.kreasikode.muslimahsalon.viewFragment.DashboardFragment;
import com.kreasikode.muslimahsalon.viewFragment.PembayaranFragment;
import com.kreasikode.muslimahsalon.viewFragment.PendaftaranFragment;
import com.kreasikode.muslimahsalon.R;
import com.kreasikode.muslimahsalon.other.BottomNavigationViewHelper;

public class MenuActivity extends AppCompatActivity {

    private Toolbar topToolbar;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private DashboardFragment dashboardFragment;
    private PendaftaranFragment pendaftaranFragment;
    private AntrianFragment antrianFragment;
    private PembayaranFragment pembayaranFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        topToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(topToolbar);

        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        frameLayout = findViewById(R.id.main_frame);

        dashboardFragment = new DashboardFragment();
        pendaftaranFragment = new PendaftaranFragment();
        antrianFragment = new AntrianFragment();
        pembayaranFragment = new PembayaranFragment();

        if (savedInstanceState == null) {
            setFragment(dashboardFragment);
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        setFragment(dashboardFragment);
                        getSupportActionBar().setTitle("Dashboard");
                        return true;
                    case R.id.pendaftaran:
                        setFragment(pendaftaranFragment);
                        getSupportActionBar().setTitle("Pendaftaran");
                        return true;
                    case R.id.antrian:
                        setFragment(antrianFragment);
                        getSupportActionBar().setTitle("Antrian");
                        return true;
                    case R.id.pembayaran:
                        setFragment(pembayaranFragment);
                        getSupportActionBar().setTitle("Pembayaran");
                        return true;
                    default:
                        return false;
                }
            }
        });

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//        Menu menu = bottomNavigationView.getMenu();
//        MenuItem menuItem = menu.getItem(0);
//        menuItem.setChecked(true);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.home:
//                        break;
//
//                }
//                return false;
//            }
//        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
