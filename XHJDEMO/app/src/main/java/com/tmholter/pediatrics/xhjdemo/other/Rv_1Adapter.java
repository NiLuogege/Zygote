package com.tmholter.pediatrics.xhjdemo.other;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tmholter.pediatrics.xhjdemo.R;

/**
 * Created by ${LuoChen} on 2017/9/1 16:07.
 * email:luochen0519@foxmail.com
 */

public class Rv_1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  Activity context;

    @Override
    public int getItemCount() {
        return 20;
    }

    public Rv_1Adapter(Activity context) {
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv_1, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }


}
