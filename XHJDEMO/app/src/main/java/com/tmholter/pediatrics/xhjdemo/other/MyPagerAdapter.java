package com.tmholter.pediatrics.xhjdemo.other;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.tmholter.pediatrics.xhjdemo.R;

/**
 * Created by ${LuoChen} on 2017/9/1 14:39.
 * email:luochen0519@foxmail.com
 */

public class MyPagerAdapter extends PagerAdapter {
    private  Activity activity;

    public MyPagerAdapter(Activity activity) {
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        View inflate =View.inflate(activity, R.layout.item_pager,null);
//        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_pager, container, false);
        container.addView(inflate);
        return inflate;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public float getPageWidth(int position) {
        return 1f;
    }
}
