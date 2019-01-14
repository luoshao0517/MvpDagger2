package com.tfkj.dagger2demo.ui.textsize;

import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.SPUtils;
import com.tfkj.dagger2demo.R;
import com.tfkj.dagger2demo.base.BaseActivity;
import com.tfkj.dagger2demo.common.Constance;
import com.tfkj.dagger2demo.ui.textsize.event.TextSizeEvent;
import com.tfkj.dagger2demo.ui.textsize.listener.ResponseOnTouch;
import com.tfkj.dagger2demo.view.CustomSeekbar;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author luodacheng
 * @date 2019/01/14
 */
@Route(path = Constance.ACTIVITY_URL_TEXTSIZE)
public class ChangeTextSizeActivity extends BaseActivity implements ResponseOnTouch {
    @BindView(R.id.customSeekBar)
    CustomSeekbar seekBar;
    @BindView(R.id.tv_size)
    TextView tvSize;
    private float textSize;
    @Override
    public int getActivityLayout() {
        return R.layout.activity_change_text_size;
    }

    @Override
    protected void initView() {
        super.initView();
        //这个集合用于给自定义SeekBar设置界点级别，集合里有几个数据，就有几个界点
        ArrayList<String> volume_sections = new ArrayList<String>();
        volume_sections.add("小");
        volume_sections.add("标准");
        volume_sections.add("大");
        float aFloat = SPUtils.getInstance(Constance.SP_NAME).getFloat(Constance.TEXT_SIZE_FLOAT);
        tvSize.setTextSize(Constance.TEXT_SIZE*aFloat);
        seekBar.initData(volume_sections);
        //设置默认级别
        if(aFloat == 0.8f){
            seekBar.setProgress(0);
        }else if(aFloat == 1f){
            seekBar.setProgress(1);
        }else if(aFloat == 1.2f){
            seekBar.setProgress(2);
        }
//        activity实现了下面的接口ResponseOnTouch，每次touch会回调onTouchResponse
        seekBar.setResponseOnTouch(this);
    }

    @Override
    public void onTouchResponse(int volume) {
        Toast.makeText(this, "volume-->" + volume, Toast.LENGTH_SHORT).show();
        //参数volume就是级别，如果我们集合有4个数据 那么volume的取值就为0、1、2、3
//        Constance.TEXT_SIZE = volume;
        //这里写sharedpreferences保存该静态变量
        switch (volume) {
            case 0:
                textSize =0.8f;
                break;
            case 1:
                textSize =1f;
                break;
            case 2:
                textSize =1.2f;
                break;
            default:
                break;
        }
        EventBus.getDefault().post(new TextSizeEvent(textSize));
        SPUtils.getInstance(Constance.SP_NAME).put(Constance.TEXT_SIZE_FLOAT,textSize);
        tvSize.setTextSize(Constance.TEXT_SIZE*textSize);
    }
}
