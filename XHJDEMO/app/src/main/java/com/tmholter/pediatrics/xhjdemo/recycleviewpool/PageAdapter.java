package com.tmholter.pediatrics.xhjdemo.recycleviewpool;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by LK on 2017/6/18.
 * 动脑学院 版权所有
 */

public class PageAdapter extends FragmentPagerAdapter {
    private static final String TAG = "PageAdapter";

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    RecyclerView.RecycledViewPool mPool = new RecyclerView.RecycledViewPool(){
        @Override
        public RecyclerView.ViewHolder getRecycledView(int viewType) {
            RecyclerView.ViewHolder scrap = super.getRecycledView(viewType);
            Log.e(TAG, "get holder from pool: "+scrap );
            return scrap;
        }

        @Override
        public void putRecycledView(RecyclerView.ViewHolder scrap) {
            super.putRecycledView(scrap);
            Log.e(TAG, "put holder to pool: " + scrap);
        }

        @Override
        public String toString() {
            return "ViewPool in adapter "+ Integer.toHexString(hashCode());
        }
    };

    @Override
    public Fragment getItem(int position) {
        RecyclerViewFragment f = new RecyclerViewFragment();
        f.mPool = mPool;
        return f;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TAG + "我曹 pos:"+position;
    }
}
