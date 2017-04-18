package com.bupt.mountwutai.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bupt.mountwutai.R;
import com.bupt.mountwutai.base.BaseActivity;
import com.bupt.mountwutai.ui.activity.summary.SummaruFragment;
import com.bupt.mountwutai.util.LogUtil;

public class MainActivity extends BaseActivity {

    private TextView[] textViews = new TextView[5];// 图标下面的文字
    private ImageView[] imageButtons = new ImageView[5];// 显示图标

    private FragmentManager fragmentManager;
    private SummaruFragment summaruFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i(TAG, "onCreate");
    }

    public void navigation(View view) {
        int id = view.getId();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        showFragment(transaction, id);
    }

    // 设置导航条的背景颜色
    private void setBack(int x) {
        for (int i = 0; i < textViews.length; i++) {
            int color;
            if (i == x) {
                color = R.color.navigation_select;
            } else {
                color = R.color.navigation_unselect;
            }
            textViews[i].setTextColor(getResources().getColor(
                    color));
        }
    }

    @Override
    protected void initView() {
        textViews[0] = (TextView) findViewById(R.id.text1);
        textViews[1] = (TextView) findViewById(R.id.text2);
        textViews[2] = (TextView) findViewById(R.id.text3);
        textViews[3] = (TextView) findViewById(R.id.text4);
        textViews[4] = (TextView) findViewById(R.id.text5);
        imageButtons[0] = (ImageView) findViewById(R.id.rb1);
        imageButtons[1] = (ImageView) findViewById(R.id.rb2);
        imageButtons[2] = (ImageView) findViewById(R.id.rb3);
        imageButtons[3] = (ImageView) findViewById(R.id.rb4);
        imageButtons[4] = (ImageView) findViewById(R.id.rb5);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        showFragment(transaction, R.id.summary);
    }

    private void showFragment(FragmentTransaction transaction, int tag) {
        LogUtil.d(TAG, "showFragment is called and tag=" + tag + "transaction==null is " + (transaction == null));
        hideFragments(transaction);

        switch (tag) {
            case R.id.summary://概述
                setBack(0);
                imageButtons[0].setBackgroundResource(R.mipmap.home_selected);
                imageButtons[1].setBackgroundResource(R.mipmap.live_normal);
                imageButtons[2].setBackgroundResource(R.mipmap.yakongqi_normal);
                imageButtons[3].setBackgroundResource(R.mipmap.yewu_normal);
                imageButtons[4].setBackgroundResource(R.mipmap.geren_normal);
                if (summaruFragment == null) {
                    summaruFragment = new SummaruFragment();
                    transaction.add(R.id.container, summaruFragment);
                } else {
                    transaction.show(summaruFragment);
                }
                break;

            case R.id.guide://导游
                setBack(1);
                imageButtons[0].setBackgroundResource(R.mipmap.home_normal);
                imageButtons[1].setBackgroundResource(R.mipmap.live_selected);
                imageButtons[2].setBackgroundResource(R.mipmap.yakongqi_normal);
                imageButtons[3].setBackgroundResource(R.mipmap.yewu_normal);
                imageButtons[4].setBackgroundResource(R.mipmap.geren_normal);
                break;

            case R.id.buddhist://佛事
                setBack(2);
                imageButtons[0].setBackgroundResource(R.mipmap.home_normal);
                imageButtons[1].setBackgroundResource(R.mipmap.live_normal);
                imageButtons[2].setBackgroundResource(R.mipmap.yaokongqi_selected);
                imageButtons[3].setBackgroundResource(R.mipmap.yewu_normal);
                imageButtons[4].setBackgroundResource(R.mipmap.geren_normal);
                break;

            case R.id.service://服务
                setBack(3);
                imageButtons[0].setBackgroundResource(R.mipmap.home_normal);
                imageButtons[1].setBackgroundResource(R.mipmap.live_normal);
                imageButtons[2].setBackgroundResource(R.mipmap.yakongqi_normal);
                imageButtons[3].setBackgroundResource(R.mipmap.yewu_selected);
                imageButtons[4].setBackgroundResource(R.mipmap.geren_normal);
                break;

            case R.id.specialty://土特产
                setBack(4);
                imageButtons[0].setBackgroundResource(R.mipmap.home_normal);
                imageButtons[1].setBackgroundResource(R.mipmap.live_normal);
                imageButtons[2].setBackgroundResource(R.mipmap.yakongqi_normal);
                imageButtons[3].setBackgroundResource(R.mipmap.yewu_normal);
                imageButtons[4].setBackgroundResource(R.mipmap.geren_selected);
                break;

            default:
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    private void hideFragments(FragmentTransaction transaction) {
        LogUtil.i(TAG, "hideFragments is called");
        if (summaruFragment != null) {
            transaction.hide(summaruFragment);
        }
    }

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_main);
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
