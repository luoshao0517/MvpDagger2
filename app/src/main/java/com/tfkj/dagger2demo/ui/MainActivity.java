package com.tfkj.dagger2demo.ui;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tfkj.dagger2demo.R;
import com.tfkj.dagger2demo.base.BaseMvpActivity;
import com.tfkj.dagger2demo.bean.Person;
import com.tfkj.dagger2demo.common.BundleCommon;
import com.tfkj.dagger2demo.common.Constance;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = Constance.ACTIVITY_URL_MAIN)
public class MainActivity extends BaseMvpActivity<MainContract.MainView, MainPresenter> implements MainContract.MainView {

    private String TAG = "MainActivity";

    @BindView(R.id.tv)
    TextView tv;

    @Inject
    Person mPerson;

    @Override
    protected void initView() {
        tv.setText(TAG);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @OnClick(R.id.tv)
    public void showToast() {
        mPerson.setName("小明");
        mPresenter.startActivity();

    }

    @Override
    public int getActivityLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void startActivity() {
        mARouter.build(Constance.ACTIVITY_URL_FIRST)
                .withParcelable(BundleCommon.PERSON, mPerson)
                .withTransition(R.anim.anim_in, R.anim.anim_out)
                .navigation(this,123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 123:
                Log.e(TAG,"收到了来自第二个页面的数据"+resultCode);
                break;
            default:
                break;
        }
    }
}
