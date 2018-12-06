package com.tfkj.dagger2demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tfkj.dagger2demo.app.MyApplication;
import com.tfkj.dagger2demo.di.component.ActivityComponent;
import com.tfkj.dagger2demo.di.component.DaggerActivityComponent;
import com.tfkj.dagger2demo.di.module.ActivityModule;

import javax.inject.Inject;

/**
 * @author luodacheng
 * @date 2018-11-26
 * Activity mvp 基类
 */
public abstract class BaseMvpActivity<V extends BaseView, P extends BaseMvpPresenter<V>> extends BaseActivity {
    @Inject
    protected P mPresenter;
    protected ActivityComponent mActivityComponent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityComponent();
        //创建连接
        if (!mPresenter.isViewAttached()) {
            mPresenter.subscribe((V) this);
        }
        doPresenter();
    }

    protected abstract void doPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消连接
        if (mPresenter.isViewAttached()) {
            mPresenter.unSubscribe();
        }
    }

    /**
     * 注入初始化
     */
    protected abstract void initInject();

    protected void initActivityComponent(){
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .activityModule(new ActivityModule())
                .build();
        initInject();
    }
}
