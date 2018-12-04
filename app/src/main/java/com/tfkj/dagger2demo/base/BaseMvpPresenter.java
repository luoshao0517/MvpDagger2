package com.tfkj.dagger2demo.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author luodacheng
 * @date 2018-11-26
 * 带 mvp 的presenter基类
 */
public class BaseMvpPresenter<V extends BaseView> implements BasePresenter<V> {

    /**
     * View接口类型的弱引用
     */
    protected WeakReference<V> mWeakReference;

    protected CompositeDisposable mDisposable;

    /**
     * 建立连接
     *
     * @param baseView
     */
    @Override
    public void subscribe(V baseView) {
        mWeakReference = new WeakReference<>(baseView);
        mDisposable = new CompositeDisposable();
    }

    /**
     * 取消连接
     */
    @Override
    public void unSubscribe() {
        if (mWeakReference != null) {
            mWeakReference.clear();
            mWeakReference = null;
        }
        mDisposable.clear();
    }

    /**
     * 获取View
     *
     * @return
     */
    public V getView() {
        return mWeakReference.get();
    }

    /**
     * 判断是否连接
     *
     * @return
     */
    public boolean isViewAttached() {
        return mWeakReference != null && mWeakReference.get() != null;
    }
}
