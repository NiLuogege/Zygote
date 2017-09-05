package com.tmholter.pediatrics.xhjdemo.common.presentation.presenter;

import com.tmholter.pediatrics.xhjdemo.common.view.BaseView;
import com.tmholter.pediatrics.xhjdemo.common.view.activity.MvpActivity;

import java.util.List;

/**
 * Created by ${LuoChen} on 2017/9/4 18:05.
 * email:luochen0519@foxmail.com
 */

public interface MVPPresenter {

    interface View extends BaseView{

        void showToast(String str);

        void setAdapter(List<String> datas);

        void notifyAdapter();
    }

    interface Presenter extends BasePresenter<MvpActivity>{

        void initData();//获取数据

        void loadMore();
    }





}
