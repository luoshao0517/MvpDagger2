package com.tfkj.dagger2demo.base;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends Activity {
    protected ARouter mARouter;
    protected Unbinder mBind;
    //是否开启沉浸式状态栏
    private boolean isImmersionBar = true;
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivityLayout() != 0) {
            setContentView(getActivityLayout());
        }
        //初始化黄油刀
        mBind = ButterKnife.bind(this);
        //初始化沉浸式状态栏
        if(isImmersionBar){
            initImmersionBar();
        }
        //Arouter 注入
        mARouter = ARouter.getInstance();
        mARouter.inject(this);
        initView();
        initData();
    }

    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }

    /**
     * 初始化控件
     */
    protected void initView() {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * 获取文件
     *
     * @return id
     */
    public abstract int getActivityLayout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁黄油刀
        mBind.unbind();
        //销毁ImmersionBar
        mImmersionBar.destroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // 如果你的app可以横竖屏切换，并且适配4.4或者emui3手机请务必在onConfigurationChanged方法里添加这句话
        ImmersionBar.with(this).init();
    }
}
