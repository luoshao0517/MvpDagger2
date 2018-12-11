package com.tfkj.dagger2demo.ui;

import com.tfkj.dagger2demo.base.BaseMvpPresenter;

import javax.inject.Inject;

public class MainPresenter extends BaseMvpPresenter<MainContract.MainView> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }


    @Override
    public void startFirstActivity() {
        getView().startFirstActivity();
    }

    @Override
    public void startTextViewActivity(String title) {
        getView().startTextViewActivity(title);
    }

    @Override
    public void startChartActivity() {
        getView().startChartActivity();
    }
}
