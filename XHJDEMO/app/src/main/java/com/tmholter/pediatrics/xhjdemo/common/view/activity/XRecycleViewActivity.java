package com.tmholter.pediatrics.xhjdemo.common.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.tmholter.pediatrics.xhjdemo.R;
import com.tmholter.pediatrics.xhjdemo.common.presentation.adapter.XRecycleViewAdapter;
import com.tmholter.pediatrics.xhjdemo.common.presentation.presenter.XRecycleViewPresenter;
import com.tmholter.pediatrics.xhjdemo.common.presentation.presenter.impl.XRecycleViewPresenterIml;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ${LuoChen} on 2017/9/6 10:24.
 * email:luochen0519@foxmail.com
 */

public class XRecycleViewActivity extends AppCompatActivity implements XRecycleViewPresenter.View {


    @Bind(R.id.xrv)
    XRecyclerView xrv;
    private XRecycleViewPresenter.Presenter mPresenter;
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrecycle);
        ButterKnife.bind(this);

        mPresenter = new XRecycleViewPresenterIml();
        mPresenter.attachView(this);


        mGridLayoutManager = new GridLayoutManager(this, 3);
        xrv.setLayoutManager(mGridLayoutManager);
//        xrv.setArrowImageView();//设置刷新箭头
//        xrv.setFootView();//添加脚布局
//        xrv.addHeaderView();//添加头部局
        xrv.setLoadingMoreEnabled(true);//加载更多是否可用
        xrv.setPullRefreshEnabled(true);//升值下拉刷新是否可用

        xrv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrv.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);

        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                mPresenter.onRefresh();
            }

            @Override
            public void onLoadMore() {
                mPresenter.loadMore();
            }
        });

        mPresenter.initData();

    }

    @Override
    public void setAdapter(List<String> data) {
        XRecycleViewAdapter adapter = new XRecycleViewAdapter(this, R.layout.item_acitivty_xrecycle, data);
        xrv.setAdapter(adapter);
    }

    @Override
    public void refreshComplete() {
        xrv.refreshComplete();
    }

    @Override
    public void loadMoreComplete() {
        xrv.loadMoreComplete();
    }
}
