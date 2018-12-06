package com.tfkj.dagger2demo.util;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tfkj.dagger2demo.bean.Person;
import com.tfkj.dagger2demo.common.Constance;
import com.tfkj.dagger2demo.ui.first.FirstActivity;

public class ARouterUtils {
    /**
     * {@link FirstActivity}
     */
    public static void switchToFirstActivity(String name, Person person){
        ARouter.getInstance().build(Constance.ACTIVITY_URL_FIRST).withParcelable(name,person).navigation();
    }
}
