package com.tfkj.dagger2demo.ui.first;

import com.tfkj.dagger2demo.base.BaseMvpPresenter;

import javax.inject.Inject;

public class FirstPresenter extends BaseMvpPresenter<FirstContract.FirstView> implements FirstContract.Presenter{
    @Inject
    public FirstPresenter() {
    }

    @Override
    public void showToast(String name) {
        getView().showToast(name);
    }
}
