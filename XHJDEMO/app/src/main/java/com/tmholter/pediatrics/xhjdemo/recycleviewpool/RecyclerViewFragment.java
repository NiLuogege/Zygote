package com.tmholter.pediatrics.xhjdemo.recycleviewpool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LK on 2017/6/18.
 * 动脑学院 版权所有
 */

public class RecyclerViewFragment extends Fragment {
    private static final String TAG = "RecyclerViewFragment";
    RecyclerView.RecycledViewPool mPool;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView view = new RecyclerView(inflater.getContext());
        LinearLayoutManager layout = new LinearLayoutManager(inflater.getContext());
        layout.setRecycleChildrenOnDetach(true);
        view.setLayoutManager(layout);
        if (mPool != null) {
            // 设置共享池
            view.setRecycledViewPool(mPool);
            Log.e(TAG, "using view pool :" + mPool);
        }
        view.setAdapter(new DemoAdapter());
        view.setItemViewCacheSize(10);
        return view;
    }
}
