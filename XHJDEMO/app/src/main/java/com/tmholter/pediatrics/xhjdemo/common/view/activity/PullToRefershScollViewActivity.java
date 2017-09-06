package com.tmholter.pediatrics.xhjdemo.common.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.tmholter.pediatrics.xhjdemo.R;
import com.tmholter.pediatrics.xhjdemo.common.view.view.PullScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ${LuoChen} on 2017/9/6 14:11.
 * email:luochen0519@foxmail.com
 */

public class PullToRefershScollViewActivity extends AppCompatActivity {
    @Bind(R.id.psv)
    PullScrollView psv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_pulltorefersh);
        ButterKnife.bind(this);

        psv.autoRefresh();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("PullToRefershScollViewA", "数据加载成功");
                psv.stopRefresh();
            }
        }, 2000);

        psv.setOnRefreshListener(new PullScrollView.onRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("PullToRefershScollViewA", "数据加载成功");
                        psv.stopRefresh();
                    }
                }, 2000);
            }
        });
    }


    @OnClick(R.id.tv)
    public void click() {
        Toast.makeText(this, "lalal", Toast.LENGTH_LONG).show();
    }


}
