package com.tfkj.dagger2demo.app;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.tfkj.dagger2demo.di.component.AppComponent;
import com.tfkj.dagger2demo.di.component.DaggerAppComponent;
import com.tfkj.dagger2demo.di.module.AppModule;
import com.tfkj.dagger2demo.di.module.HttpModule;
import com.tfkj.dagger2demo.util.CrashHandler;

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
        Utils.init(this);
        ARouter.init(mInstance);
        //log日志抓取
        CrashHandler.getInstance().init(this);
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

    public static Context getContext(){
        return getContext();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
