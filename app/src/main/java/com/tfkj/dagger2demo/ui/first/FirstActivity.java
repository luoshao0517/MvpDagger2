package com.tfkj.dagger2demo.ui.first;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tfkj.dagger2demo.R;
import com.tfkj.dagger2demo.base.BaseMvpActivity;
import com.tfkj.dagger2demo.bean.Person;
import com.tfkj.dagger2demo.common.BundleCommon;
import com.tfkj.dagger2demo.common.Constance;

import butterknife.BindView;

@Route(path = Constance.ACTIVITY_URL_FIRST)
public class FirstActivity extends BaseMvpActivity<FirstContract.FirstView, FirstPresenter> implements FirstContract.FirstView {

    @BindView(R.id.name)
    TextView nameTv;
    @Autowired(name = BundleCommon.PERSON)
    Person mPerson;

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
        setResult(123);
        mPresenter.showToast(mPerson.getName());
    }
}
