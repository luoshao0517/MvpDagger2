package com.tfkj.dagger2demo.di.component;

import com.tfkj.dagger2demo.di.module.AppModule;
import com.tfkj.dagger2demo.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author luodacheng
 * @date 2018-11-27
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
}
