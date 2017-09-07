package com.tmholter.pediatrics.xhjdemo.recycleviewpool;

import android.os.Bundle;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.tmholter.pediatrics.xhjdemo.R;


public class RecycleViewpollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.tabs);
        pagerTitleStrip.setTextSpacing(500);
        pagerTitleStrip.setGravity(Gravity.CENTER);
        pager.setAdapter(new PageAdapter(getSupportFragmentManager()));
    }

}