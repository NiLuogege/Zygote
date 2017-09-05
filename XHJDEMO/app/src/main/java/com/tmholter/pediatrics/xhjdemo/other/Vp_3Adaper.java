package com.tmholter.pediatrics.xhjdemo.other;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.tmholter.pediatrics.xhjdemo.R;

/**
 * Created by ${LuoChen} on 2017/9/4 14:21.
 * email:luochen0519@foxmail.com
 */

class Vp_3Adaper extends PagerAdapter {

    private  Activity context;
    private  Activity activity;

    public Vp_3Adaper(Activity context) {
        this.context=context;
        this.activity=context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        View inflate =View.inflate(activity, R.layout.item_pager_list,null);

        RecyclerView recyclerView = (RecyclerView)inflate.findViewById(R.id.rv);
        recyclerView.requestDisallowInterceptTouchEvent(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        ViewpagerListAdapter viewpagerListAdapter=new ViewpagerListAdapter(context,20);

        recyclerView.setAdapter(viewpagerListAdapter);

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
}
