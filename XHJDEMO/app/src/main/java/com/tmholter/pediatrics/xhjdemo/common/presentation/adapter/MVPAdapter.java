package com.tmholter.pediatrics.xhjdemo.common.presentation.adapter;

import android.content.Context;

import com.tmholter.pediatrics.xhjdemo.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by ${LuoChen} on 2017/9/5 14:22.
 * email:luochen0519@foxmail.com
 */

public class MVPAdapter extends CommonAdapter<String> {

    public MVPAdapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        holder.setText(R.id.tv, s + " : " + holder.getAdapterPosition() + " , " + holder.getLayoutPosition());
    }
}
