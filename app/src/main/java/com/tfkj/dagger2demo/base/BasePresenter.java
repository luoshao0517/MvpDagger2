package com.tfkj.dagger2demo.base;

/**
 * @author luodacheng
 * @date 2018-11-26
 * 不带 MVP presenter 接口
 */
public interface BasePresenter<V extends BaseView> {

    void subscribe(V baseView);

    void unSubscribe();
}
