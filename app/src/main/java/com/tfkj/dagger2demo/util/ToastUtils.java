package com.tfkj.dagger2demo.util;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tfkj.dagger2demo.R;
import com.tfkj.dagger2demo.app.MyApplication;

/**
 * Created by Administrator on 2018/6/12 0012.
 */

public class ToastUtils {

    public static void showToast(String messages) {
        LayoutInflater inflater = LayoutInflater.from(MyApplication.getContext());
        //加載layout下的布局
        View view = inflater.inflate(R.layout.view_toast, null);
        TextView textView = view.findViewById(R.id.tv_msg);
        textView.setText(messages);
        Toast toast = new Toast(MyApplication.getContext());
        toast.setDuration(Toast.LENGTH_LONG);
        //添加视图文件
        toast.setView(view);
        toast.show();
    }

}
