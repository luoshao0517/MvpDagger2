package com.tfkj.dagger2demo.di.component;

import com.tfkj.dagger2demo.di.module.ActivityModule;
import com.tfkj.dagger2demo.di.scope.ActivityScope;
import com.tfkj.dagger2demo.ui.MainActivity;
import com.tfkj.dagger2demo.ui.first.FirstActivity;

import dagger.Component;

/**
 * @author luodacheng
 * @date 2018-11-27
 */
@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(FirstActivity activity);
}
