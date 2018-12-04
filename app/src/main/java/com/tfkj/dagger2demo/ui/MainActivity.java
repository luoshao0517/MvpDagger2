package com.tfkj.dagger2demo.ui;

import android.content.Intent;
import android.widget.TextView;

import com.tfkj.dagger2demo.R;
import com.tfkj.dagger2demo.base.BaseMvpActivity;
import com.tfkj.dagger2demo.bean.Person;
import com.tfkj.dagger2demo.ui.first.FirstActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<MainContract.MainView, MainPresenter> implements MainContract.MainView {

    private String TAG = "MainActivity";

    @BindView(R.id.tv)
    TextView tv;

    @Inject
    Person mPerson;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @OnClick(R.id.tv)
    public void showToast() {
        tv.setText(TAG);
        mPerson.setName("王二小");
        mPresenter.startActivity();

    }

    @Override
    public int getActivityLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void startActivity() {
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra("name",mPerson.getName());
        startActivity(intent);
    }
}
