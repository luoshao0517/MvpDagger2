package com.tfkj.dagger2demo.ui.login;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Handler;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tfkj.dagger2demo.base.BaseActivity;
import com.tfkj.dagger2demo.util.ARouterUtils;

import io.reactivex.functions.Consumer;
/**
 * @author luodacheng
 * @date 2018-12-06
 */
public class LoginActivity extends BaseActivity {
    private Handler handler;
    @Override
    public int getActivityLayout() {
        return 0;
    }


    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.transparentStatusBar().init();
    }

    @SuppressLint({"CheckResult", "InlinedApi"})
    @Override
    protected void initView() {
        super.initView();
        handler = new Handler();
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (!aBoolean) {
                    System.exit(0);
                } else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ARouterUtils.switchToMainActivity();
                            finish();
                        }
                    },3000);
                }
            }
        });
    }
}
