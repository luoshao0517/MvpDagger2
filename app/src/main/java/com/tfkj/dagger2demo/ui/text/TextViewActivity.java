package com.tfkj.dagger2demo.ui.text;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tfkj.dagger2demo.R;
import com.tfkj.dagger2demo.base.BaseActivity;
import com.tfkj.dagger2demo.common.BundleCommon;
import com.tfkj.dagger2demo.common.Constance;
import com.tfkj.dagger2demo.view.AlignTextView;

import butterknife.BindView;

/**
 * @author luodacheng
 * @date 2018-12-07
 */
@Route(path = Constance.ACTIVITY_URL_TEXTVIEW)
public class TextViewActivity extends BaseActivity {
    @BindView(R.id.text_view)
    TextView textView;
    @BindView(R.id.text_view_al)
    AlignTextView textViewAl;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @Autowired(name = BundleCommon.TITLE)
    String title;
    @Override
    public int getActivityLayout() {
        return R.layout.activity_text_view;
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(title);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<300;i++){
            if(i%2==0){
                stringBuilder.append("1234456；");
            }else if(i%3==0){
                stringBuilder.append("abdasdwe;");
            }else if(i%5==0){
                stringBuilder.append("中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中" +
                        "中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中");
            }
        }
        textView.setText(stringBuilder);
        textViewAl.setText(stringBuilder);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(tvTitle).statusBarAlpha(0.3f).init();
    }
}
