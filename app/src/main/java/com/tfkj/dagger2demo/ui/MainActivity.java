package com.tfkj.dagger2demo.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tfkj.dagger2demo.R;
import com.tfkj.dagger2demo.base.BaseMvpActivity;
import com.tfkj.dagger2demo.bean.Person;
import com.tfkj.dagger2demo.common.BundleCommon;
import com.tfkj.dagger2demo.common.Constance;
import com.tfkj.dagger2demo.util.ARouterUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = Constance.ACTIVITY_URL_MAIN)
public class MainActivity extends BaseMvpActivity<MainContract.MainView, MainPresenter> implements MainContract.MainView {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView( R.id.btn_text_view)
    Button btnTextView;
    private String TAG = "MainActivity";

    @Inject
    Person mPerson;

    @Override
    protected void initInject() {
        mActivityComponent.inject(this);
    }


    @OnClick({R.id.btn_dagger_mvp, R.id.btn_text_view,R.id.btn_text_chart})
    public void showToast(View v) {
        switch (v.getId()) {
            case R.id.btn_dagger_mvp:
                mPerson.setName("小明");
                mPresenter.startFirstActivity();
                break;
            case R.id.btn_text_view:
                mPresenter.startTextViewActivity(btnTextView.getText().toString());
                break;
            case R.id.btn_text_chart:
                mPresenter.startChartActivity();
                break;
            default:
                break;
        }

    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText("小Demo");
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(tvTitle).statusBarAlpha(0.3f).init();
    }

    @Override
    public int getActivityLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void startFirstActivity() {
        ARouterUtils.switchToFirstActivity(BundleCommon.PERSON, mPerson);
    }

    @Override
    public void startTextViewActivity(String title) {
        ARouterUtils.switchToTextViewActivity(title);
    }

    @Override
    public void startChartActivity() {
        ARouterUtils.switchToChartActivity();
    }
}
