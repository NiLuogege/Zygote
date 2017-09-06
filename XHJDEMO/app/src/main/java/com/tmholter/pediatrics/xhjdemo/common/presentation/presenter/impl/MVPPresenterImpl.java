package com.tmholter.pediatrics.xhjdemo.common.presentation.presenter.impl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;

import com.tmholter.pediatrics.xhjdemo.common.presentation.presenter.MVPPresenter;
import com.tmholter.pediatrics.xhjdemo.common.view.activity.MvpActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by ${LuoChen} on 2017/9/5 13:49.
 * email:luochen0519@foxmail.com
 */

public class MVPPresenterImpl implements MVPPresenter.Presenter{


    private MVPPresenter.View activity;

    private List<String> mDatas = new ArrayList<>();

    public MVPPresenterImpl() {

    }


    @Override
    public void attachView(MvpActivity view) {
        this.activity=view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void initData() {
        for (int i = 'A'; i <= 'K'; i++)
        {
            mDatas.add((char) i + "");
        }

        OkHttpUtils.get()
                .url("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png")
                .build()
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        activity.showToast("数据加载失败");
                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        Log.e("MVPPresenterImpl", "onResponse");
                        activity.setAdapter(mDatas);
                    }
                });

    }

    @Override
    public void loadMore() {
        OkHttpUtils.get()
                .url("http://rap.taobao.org/mockjs/7569/invitation/getInvitations")
                .build()
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        activity.showToast("数据加载失败");
                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {

                        Log.e("MVPPresenterImpl", "onResponse");

                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 10; i++) {
                                    mDatas.add("Add:" + i);
                                }
                                activity.notifyAdapter();
                            }
                        });
                    }
                });
    }


}
