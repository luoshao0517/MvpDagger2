package com.tfkj.dagger2demo.ui.first;

import android.widget.TextView;

import com.tfkj.dagger2demo.R;
import com.tfkj.dagger2demo.base.BaseMvpActivity;

import butterknife.BindView;

public class FirstActivity extends BaseMvpActivity<FirstContract.FirstView, FirstPresenter> implements FirstContract.FirstView {

    @BindView(R.id.name)
    TextView nameTv;
    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getActivityLayout() {
        return R.layout.activity_first;
    }

    @Override
    public void showToast(String name) {
        nameTv.setText(name);
    }

    @Override
    protected void initView() {
        super.initView();
        String names = getIntent().getStringExtra("name");
        mPresenter.showToast(names);
    }
}
