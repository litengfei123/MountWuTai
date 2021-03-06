package com.bupt.mountwutai.ui.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bupt.mountwutai.R;
import com.bupt.mountwutai.adapter.BusinessTypeListAdapter;
import com.bupt.mountwutai.base.BaseActivity;
import com.bupt.mountwutai.consts.CodeConstants;
import com.bupt.mountwutai.customdata.BroadcastingCenterDate;
import com.bupt.mountwutai.entity.mian.BusinessTypeListBean;
import com.bupt.mountwutai.util.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * 电视业务
 */

public class BusinessTypeListActivity extends BaseActivity {

    private ListView businessTypeListView;
    private BusinessTypeListAdapter adapter;
    private int[] icons = {R.mipmap.buiness_tv1, R.mipmap.buiness_tv2, R.mipmap.buiness_tv3};

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_addr_info);
    }

    @Override
    protected void initView() {
        businessTypeListView = (ListView) findViewById(R.id.addr_info_listview);
        List<BusinessTypeListBean> beanList = (List<BusinessTypeListBean>)
                Utils.parseData(BroadcastingCenterDate.tv_service, new Gson(),
                        new TypeToken<List<BusinessTypeListBean>>() {
                        });
        for (int i = 0; i < beanList.size(); i++) {
            beanList.get(i).setIcon(icons[i]);
        }
        adapter = new BusinessTypeListAdapter(BusinessTypeListActivity.this, beanList);
        businessTypeListView.setAdapter(adapter);
        businessTypeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString(CodeConstants.ID, adapter.getList().get(position).getTitle());
                switch (position) {
                    case 0:
                        bundle.putString(CodeConstants.TYPE, CodeConstants.BUSINESS_TV1);
                        break;
                    case 1:
                        bundle.putString(CodeConstants.TYPE, CodeConstants.BUSINESS_TV2);
                        break;
                    case 2:
                        bundle.putString(CodeConstants.TYPE, CodeConstants.BUSINESS_TV3);
                        break;
                }
                intent2Activity(ServiceCommonListActivity.class, bundle);
            }
        });
    }

    @Override
    protected boolean isNeedInitBack() {
        return true;
    }

    @Override
    protected String getTopbarTitle() {
        return "电视业务";
    }
}
