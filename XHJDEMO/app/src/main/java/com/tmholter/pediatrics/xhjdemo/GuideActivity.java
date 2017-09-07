package com.tmholter.pediatrics.xhjdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tmholter.pediatrics.xhjdemo.common.view.activity.MvpActivity;
import com.tmholter.pediatrics.xhjdemo.common.view.activity.PullToRefershScollViewActivity;
import com.tmholter.pediatrics.xhjdemo.common.view.activity.XRecycleViewActivity;
import com.tmholter.pediatrics.xhjdemo.other.MainActivity;
import com.tmholter.pediatrics.xhjdemo.recycleviewpool.RecycleViewpollActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ${LuoChen} on 2017/9/6 15:55.
 * email:luochen0519@foxmail.com
 */

public class GuideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_1)
    public void click_1(){
        startActivity(new Intent(this, MainActivity.class));
    }

    @OnClick(R.id.btn_2)
    public void click_2(){
        startActivity(new Intent(this, MvpActivity.class));
    }

    @OnClick(R.id.btn_3)
    public void click_3(){
        startActivity(new Intent(this, XRecycleViewActivity.class));
    }

    @OnClick(R.id.btn_4)
    public void click_4(){
        startActivity(new Intent(this, PullToRefershScollViewActivity.class));
    }
    @OnClick(R.id.btn_5)
    public void click_5(){
        startActivity(new Intent(this, RecycleViewpollActivity.class));
    }
}
