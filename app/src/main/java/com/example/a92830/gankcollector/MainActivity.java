package com.example.a92830.gankcollector;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Fragment> fragmentList = new ArrayList<>();
    String titles[] = {"妹子","Android","Ios"};
    private MyFragmentPagerAdapter pagerAdapter;
    private TabLayout mSlidingTabs;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentList.add(new MeiziFragment());
        fragmentList.add(new AndroidFragment());
        fragmentList.add(new IosFragment());
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList,titles);
        mViewPager.setAdapter(pagerAdapter);
        mSlidingTabs.setupWithViewPager(mViewPager);
        mSlidingTabs.setTabMode(TabLayout.MODE_FIXED);
    }

    private void initView() {
        mSlidingTabs = (TabLayout) findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }
}
