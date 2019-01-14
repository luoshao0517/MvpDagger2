package com.tfkj.dagger2demo.ui;

import com.tfkj.dagger2demo.base.BasePresenter;
import com.tfkj.dagger2demo.base.BaseView;

public interface MainContract {
    interface MainView extends BaseView {
        void startFirstActivity();
        void startTextViewActivity(String title);
        void startChartActivity();
        void startTextSizeActivity();
    }

    interface Presenter extends BasePresenter<MainView> {
        void startFirstActivity();
        void startTextViewActivity(String title);
        void startChartActivity();
        void startTextSizeActivity();
    }
}
