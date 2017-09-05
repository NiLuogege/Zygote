package com.tmholter.pediatrics.xhjdemo.common.view;


public interface BaseView<T> {

    void initView();

    void setPresenter(T presenter);

}
