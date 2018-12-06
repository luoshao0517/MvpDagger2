package com.tfkj.dagger2demo.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tfkj.dagger2demo.di.component.AppComponent;
import com.tfkj.dagger2demo.di.component.DaggerAppComponent;
import com.tfkj.dagger2demo.di.module.AppModule;
import com.tfkj.dagger2demo.di.module.HttpModule;

/**
 * @author luodacheng
 * @date 2018-11-27
 */
public class MyApplication extends Application {

    private static AppComponent appComponent;

    private static MyApplication mInstance;

    private boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
        if(isDebug){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(mInstance);
    }

    /**
     * 获取AppComponent.
     *
     * @return AppComponent
     */
    public static synchronized AppComponent getAppComponent() {
        if (null == appComponent) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(getInstance()))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }

    public static MyApplication getInstance() {
        return mInstance;
    }

    public static void setInstance(MyApplication mInstance) {
        MyApplication.mInstance = mInstance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
