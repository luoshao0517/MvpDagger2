package com.tfkj.dagger2demo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tfkj.dagger2demo.app.MyApplication;
import com.tfkj.dagger2demo.di.component.ActivityComponent;
import com.tfkj.dagger2demo.di.component.DaggerActivityComponent;
import com.tfkj.dagger2demo.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * @author luodacheng
 * @date 2018-11-26
 * Activity mvp 基类
 */
public abstract class BaseMvpActivity<V extends BaseView, P extends BaseMvpPresenter<V>> extends Activity {
    @Inject
    protected P mPresenter;
    protected ARouter mARouter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivityLayout() != 0) {
            setContentView(getActivityLayout());
        }
        ButterKnife.bind(this);
        initInject();
        //Arouter 注入
        mARouter = ARouter.getInstance();
        mARouter.inject(this);
        //创建连接
        if (!mPresenter.isViewAttached()) {
            mPresenter.subscribe((V) this);
        }
        initView();
        initData();
    }

    protected abstract void initInject();

    protected void initView(){}

    protected void initData(){}

    /**
     * 获取文件
     *
     * @return id
     */
    public abstract int getActivityLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消连接
        if (mPresenter.isViewAttached()) {
            mPresenter.unSubscribe();
        }
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .activityModule(new ActivityModule())
                .build();
    }
}
