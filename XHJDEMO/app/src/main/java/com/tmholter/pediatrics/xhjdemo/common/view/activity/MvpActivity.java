package com.tmholter.pediatrics.xhjdemo.common.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.tmholter.pediatrics.xhjdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ${LuoChen} on 2017/9/4 17:55.
 * email:luochen0519@foxmail.com
 */

public class MvpActivity extends AppCompatActivity{

    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity);
        ButterKnife.bind(this);
    }
}
