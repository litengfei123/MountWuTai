package com.bupt.mountwutai.ui.activity;

import android.os.Bundle;

import com.bupt.mountwutai.R;
import com.bupt.mountwutai.base.BaseActivity;
import com.bupt.mountwutai.util.LogUtil;

public class SplishActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LogUtil.i(TAG, "-----");
                intent2Activity(MainActivity.class);
                finish();
            }
        }).start();
    }

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_splish);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected boolean isNeedInitBack() {
        return false;
    }

    @Override
    protected String getTopbarTitle() {
        return null;
    }
}
