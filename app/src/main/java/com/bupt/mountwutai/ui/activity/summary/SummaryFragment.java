package com.bupt.mountwutai.ui.activity.summary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bupt.mountwutai.R;
import com.bupt.mountwutai.base.BaseFragment;
import com.bupt.mountwutai.consts.CallBack;
import com.bupt.mountwutai.consts.CodeConstants;
import com.bupt.mountwutai.ui.activity.CommonFragment;
import com.bupt.mountwutai.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wyf on 2017/4/18.
 */

public class SummaryFragment extends BaseFragment {

    //下拉按钮
    TextView myButton;
    ImageView popImage;
    LinearLayout mypoplayout;
    Boolean isdown = true;
    //PopupWindow对象声明
    PopupWindow pw;

    ArrayList<String> list;
    //当前选中的列表项位置
    int clickPsition = -1;

    private FrameLayout frameLayout;
    private List<CommonFragment> frgmentList;
    private FragmentManager fManager;

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_summary);
        fManager = getChildFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        frameLayout = (FrameLayout) findViewById(R.id.fragment_summary);
        initView();
        fTransaction.add(R.id.fragment_summary,frgmentList.get(0));
        fTransaction.commitAllowingStateLoss();
    }

    private void initView() {
        frgmentList = new ArrayList<>();
        frgmentList.add(CommonFragment.newFragment(CodeConstants.TEPMLE_SUMMARY));
        frgmentList.add(CommonFragment.newFragment(CodeConstants.TEPMLE_SUMMARY));
        frgmentList.add(CommonFragment.newFragment(CodeConstants.TEPMLE_SUMMARY));
        frgmentList.add(CommonFragment.newFragment(CodeConstants.TEPMLE_SUMMARY));

        mypoplayout = (LinearLayout) findViewById(R.id.mypoplayout);
        myButton = (TextView) findViewById(R.id.myButton);
        popImage = (ImageView) findViewById(R.id.popimg);
        //获得要显示的数据
        list = getList();
        //设置默认显示的Text
        myButton.setText(list.get(0));
        mypoplayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showPopWindow();
            }
        });
    }

    //展示popwindow
    private void showPopWindow() {
        if (isdown) {
            isdown = false;
            myButton.setBackgroundResource(R.mipmap.sanjiao);
            popImage.setImageResource(R.mipmap.up);
        }
        Utils.showPopupwindow(activity, list, inflater,
                mypoplayout, new CallBack() {
                    @Override
                    public void itemClick(int position) {
                        myButton.setText(list.get(position));
                        switch (position) {
                            case 0://寺庙一览

                                break;

                            case 1://地方风情

                                break;

                            case 2://佛教圣地

                                break;

                            case 3://历史传说

                                break;
                        }
                        if (clickPsition != position) {
                            clickPsition = position;
                        }
                    }

                    @Override
                    public void dismiss() {
                        isdown = true;
                        myButton.setBackgroundResource(R.color.transparent);
                        popImage.setImageResource(R.mipmap.down);
                    }
                });

    }

    //得到list集合的方法
    public ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("寺庙一览");
        list.add("地方风情");
        list.add("佛教圣地");
        list.add("历史传说");
        return list;
    }
}
