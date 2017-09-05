package com.tmholter.pediatrics.xhjdemo.other;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tmholter.pediatrics.xhjdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ${LuoChen} on 2017/9/4 14:32.
 * email:luochen0519@foxmail.com
 */

public class ViewpagerListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Activity context;
    private final Activity activity;
    private final int count;

    public ViewpagerListAdapter(Activity context, int i) {
        this.context = context;
        this.activity = context;
        this.count = i;
    }

    @Override
    public int getItemCount() {
        return count;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = context.getLayoutInflater().inflate(R.layout.item_vp_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        ((ViewHolder) holder).tv.setText(position+"");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv)
        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
