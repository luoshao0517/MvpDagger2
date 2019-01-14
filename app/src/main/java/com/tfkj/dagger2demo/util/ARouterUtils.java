package com.tfkj.dagger2demo.util;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tfkj.dagger2demo.bean.Person;
import com.tfkj.dagger2demo.common.BundleCommon;
import com.tfkj.dagger2demo.common.Constance;
import com.tfkj.dagger2demo.ui.MainActivity;
import com.tfkj.dagger2demo.ui.first.FirstActivity;
import com.tfkj.dagger2demo.ui.mpchart.ChartActivity;
import com.tfkj.dagger2demo.ui.text.TextViewActivity;
import com.tfkj.dagger2demo.ui.textsize.ChangeTextSizeActivity;

public class ARouterUtils {
    /**
     * {@link FirstActivity}
     */
    public static void switchToFirstActivity(String name, Person person){
        ARouter.getInstance().build(Constance.ACTIVITY_URL_FIRST).withParcelable(name,person).navigation();
    }
    /**
     * {@link MainActivity}
     */
    public static void switchToMainActivity(){
        ARouter.getInstance().build(Constance.ACTIVITY_URL_MAIN).navigation();
    }

    /**
     * {@link TextViewActivity}
     */
    public static void switchToTextViewActivity(String name){
        ARouter.getInstance().build(Constance.ACTIVITY_URL_TEXTVIEW).withString(BundleCommon.TITLE,name).navigation();
    }

    /**
     * {@link ChartActivity}
     */
    public static void switchToChartActivity(){
        ARouter.getInstance().build(Constance.ACTIVITY_URL_CHART).navigation();
    }
    /**
     * {@link ChangeTextSizeActivity}
     */
    public static void switchToChangetTextSizeActivity(){
        ARouter.getInstance().build(Constance.ACTIVITY_URL_TEXTSIZE).navigation();
    }
}
