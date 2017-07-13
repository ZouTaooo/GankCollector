package com.example.a92830.gankcollector;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.a92830.gankcollector.Adapter.MyFragmentPagerAdapter;
import com.example.a92830.gankcollector.fragment.AndroidFragment;
import com.example.a92830.gankcollector.fragment.IosFragment;
import com.example.a92830.gankcollector.fragment.MeiziFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fragment> fragmentList = new ArrayList<>();

    String titles[] = {"妹子", "Android", "Ios"};

    private MyFragmentPagerAdapter pagerAdapter;

    private TabLayout mSlidingTabs;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mSlidingTabs = (TabLayout) findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        fragmentList.add(new MeiziFragment());
        fragmentList.add(new AndroidFragment());
        fragmentList.add(new IosFragment());
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mSlidingTabs.setupWithViewPager(mViewPager);
        mSlidingTabs.setTabMode(TabLayout.MODE_FIXED);
    }
}
