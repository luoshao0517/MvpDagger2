package com.tfkj.dagger2demo.di.module;

import com.tfkj.dagger2demo.app.MyApplication;

import dagger.Module;

/**
 * @author luodacheng
 * @date 2018-11-27
 */
@Module
public class AppModule {
    private MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }
}