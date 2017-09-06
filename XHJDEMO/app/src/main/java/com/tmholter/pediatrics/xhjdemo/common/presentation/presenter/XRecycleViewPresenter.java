package com.tmholter.pediatrics.xhjdemo.common.presentation.presenter;

import com.tmholter.pediatrics.xhjdemo.common.view.BaseView;
import com.tmholter.pediatrics.xhjdemo.common.view.activity.XRecycleViewActivity;

import java.util.List;

/**
 * Created by ${LuoChen} on 2017/9/6 10:24.
 * email:luochen0519@foxmail.com
 */

public interface XRecycleViewPresenter {

    interface View extends BaseView {

        void setAdapter(List<String> data);

        void refreshComplete();

        void loadMoreComplete();
    }

    interface Presenter extends BasePresenter<XRecycleViewActivity> {

        void initData();

        void loadMore();

        void onRefresh();
    }
}
