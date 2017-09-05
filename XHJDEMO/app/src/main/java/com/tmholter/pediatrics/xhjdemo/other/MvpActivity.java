package com.tmholter.pediatrics.xhjdemo.other;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.tmholter.pediatrics.xhjdemo.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

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
    @Bind(R.id.rv)
    RecyclerView rv;

    private List<String> mDatas = new ArrayList<>();
    private LoadMoreWrapper mLoadMoreWrapper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity);
        ButterKnife.bind(this);


        initDatas();

        rv.setLayoutManager(new LinearLayoutManager(this));


        CommonAdapter commonAdapter=new CommonAdapter<String>(this,R.layout.item_rv_mvp,mDatas){

            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.tv,s + " : " + holder.getAdapterPosition() + " , " + holder.getLayoutPosition());
            }
        };

        HeaderAndFooterWrapper headerAndFooterWrapper=new  HeaderAndFooterWrapper(commonAdapter);
        TextView textView_1 = new TextView(this);
        textView_1.setText("header_1");
        headerAndFooterWrapper.addHeaderView(textView_1);

        TextView textView_2 = new TextView(this);
        textView_2.setText("header_2");
        headerAndFooterWrapper.addHeaderView(textView_2);


        mLoadMoreWrapper = new LoadMoreWrapper(headerAndFooterWrapper);
        mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        for (int i = 0; i < 10; i++)
                        {
                            mDatas.add("Add:" + i);
                        }
                        mLoadMoreWrapper.notifyDataSetChanged();

                    }
                }, 3000);
            }
        });

        rv.setAdapter(mLoadMoreWrapper);
    }

    private void initDatas()
    {
        for (int i = 'A'; i <= 'K'; i++)
        {
            mDatas.add((char) i + "");
        }
    }
}
