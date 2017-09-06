package com.tmholter.pediatrics.xhjdemo.common.presentation.presenter.impl;

import android.os.Handler;

import com.tmholter.pediatrics.xhjdemo.common.presentation.presenter.XRecycleViewPresenter;
import com.tmholter.pediatrics.xhjdemo.common.view.activity.XRecycleViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${LuoChen} on 2017/9/6 10:25.
 * email:luochen0519@foxmail.com
 */

public class XRecycleViewPresenterIml implements XRecycleViewPresenter.Presenter {
    private XRecycleViewPresenter.View activity;

    @Override
    public void attachView(XRecycleViewActivity view) {
        this.activity = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void initData() {
        List<String>  data = new ArrayList<>();
        for (int i = 0; i <50; i++) {
            data.add("lalal "+i);
        }
        activity.setAdapter(data);
    }

    @Override
    public void loadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.loadMoreComplete();
            }
        }, 3000);

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.refreshComplete();
            }
        }, 3000);
    }
}
