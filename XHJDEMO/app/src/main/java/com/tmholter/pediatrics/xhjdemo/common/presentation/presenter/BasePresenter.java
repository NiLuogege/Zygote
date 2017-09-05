package com.tmholter.pediatrics.xhjdemo.common.presentation.presenter;

/**
 * @description
 * @author wuchangbin
 * @date 2016-8-16
 */
public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();

}