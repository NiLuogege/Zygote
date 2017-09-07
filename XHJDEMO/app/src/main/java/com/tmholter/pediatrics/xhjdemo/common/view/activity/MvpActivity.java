package com.tmholter.pediatrics.xhjdemo.common.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tmholter.pediatrics.xhjdemo.R;
import com.tmholter.pediatrics.xhjdemo.common.presentation.adapter.MVPAdapter;
import com.tmholter.pediatrics.xhjdemo.common.presentation.presenter.MVPPresenter;
import com.tmholter.pediatrics.xhjdemo.common.presentation.presenter.impl.MVPPresenterImpl;
import com.tmholter.pediatrics.xhjdemo.common.view.view.BetterRecyclerView;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ${LuoChen} on 2017/9/4 17:55.
 * email:luochen0519@foxmail.com
 */

public class MvpActivity extends AppCompatActivity implements MVPPresenter.View {
    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.rv)
    BetterRecyclerView rv;

    private MVPPresenter.Presenter mMvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity);
        ButterKnife.bind(this);

        mMvpPresenter = new MVPPresenterImpl();
        mMvpPresenter.attachView(this);
        mMvpPresenter.initData();

    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setAdapter(List<String> datas) {
        rv.setLayoutManager(new LinearLayoutManager(this));


        MVPAdapter commonAdapter = new MVPAdapter(this, R.layout.item_rv_mvp, datas);

        HeaderAndFooterWrapper headerAndFooterWrapper = new HeaderAndFooterWrapper(commonAdapter);
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

                mMvpPresenter.loadMore();
            }
        });

        rv.setAdapter(mLoadMoreWrapper);
    }

    @Override
    public void notifyAdapter() {
        mLoadMoreWrapper.notifyDataSetChanged();
    }


    private LoadMoreWrapper mLoadMoreWrapper;



}
