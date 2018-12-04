package com.tfkj.dagger2demo.ui.first;

import com.tfkj.dagger2demo.base.BasePresenter;
import com.tfkj.dagger2demo.base.BaseView;

public class FirstContract {
    interface FirstView extends BaseView {
        void showToast(String name);
    }

    interface Presenter extends BasePresenter<FirstView> {
        void showToast(String name);
    }
}
