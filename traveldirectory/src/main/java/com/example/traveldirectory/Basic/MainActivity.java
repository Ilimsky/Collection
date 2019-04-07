package com.example.traveldirectory.Basic;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.traveldirectory.A.AFragment;
import com.example.traveldirectory.B.BFragment;
import com.example.traveldirectory.C.CFragment;
import com.example.traveldirectory.D.DFragment;
import com.example.traveldirectory.News.NewsFragment;
import com.example.traveldirectory.R;
import com.example.traveldirectory.Tours.ToursFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    /*private int[] tabIcons = {
            R.drawable.ic_tab_kgs,
            R.drawable.ic_tab_kzt,
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager= findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        //setupTabIcons();                              // Установка иконок на панель
    }

    /*private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);     // Установка иконок на панель
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }*/

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new NewsFragment(), "News");
        adapter.addFrag(new ToursFragment(), "Tours");
        adapter.addFrag(new AFragment(), "Health resorts");
        adapter.addFrag(new BFragment(), "Hotels");
        adapter.addFrag(new CFragment(), "Guest houses");
        adapter.addFrag(new DFragment(), "Tickets");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        OnBackPressedListener backPressedListener = null;
        for (Fragment fragment: fm.getFragments()) {
            if (fragment instanceof  OnBackPressedListener) {
                backPressedListener = (OnBackPressedListener) fragment;
                break;
            }
        }

        if (backPressedListener != null) {
            backPressedListener.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }
}
