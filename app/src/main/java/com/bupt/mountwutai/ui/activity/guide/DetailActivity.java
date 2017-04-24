package com.bupt.mountwutai.ui.activity.guide;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bupt.mountwutai.R;
import com.bupt.mountwutai.base.BaseActivity;
import com.bupt.mountwutai.consts.CodeConstants;

public class DetailActivity extends BaseActivity implements View.OnClickListener {

    private TextView titileTextView;//标题
    private ImageView showImageView;//详情页图片
    private TextView contentTextView;//显示内容

    int type = 0;//0 为五爷庙，1为塔院寺，2为游客中心

    public static int[] images = {R.mipmap.wuyetemple, R.mipmap.tayuantemple, R.mipmap.touristcentre};
    public static String[] titles = {"走进五爷庙", "走进塔院寺", "走进游客中心"};
    public static String[] contonts = {"山西五爷庙的五龙王殿原来是卷棚顶，1917年重建时改为单檐歇山顶，四出廊，五脊六兽，" +
            "正脊置铜宝刹，前有卷棚抱厦，雕梁画栋，绚丽多彩。殿内除了供金脸龙王老五外，" +
            "在他背后也左右排列了大爷、二爷、龙母、三爷、雨的塑像。民间传说五爷本来是黑脸，但文殊菩萨为了广济众生，" +
            "化成了五龙王，所以黑脸变成了金脸。文殊菩萨化成的五龙王很喜欢看戏，所以在五龙王殿的对面便修了一座古式戏台，" +
            "专门为五爷演戏。正因为如此，一直到今天，五台山在六月法会期间，名角，名戏都必须安排在万佛阁演出，意思是给五龙王唱戏。",
            "塔院寺位于五台山台怀镇显通寺南侧，是五台山著名的五大禅处之一。" +
                    "这里原来是显通寺的塔院，明代重修舍利塔后独成一寺，因院内有大白塔，故名塔院寺。 耸入云天的大白塔，是寺内的主要标志。" +
                    "塔全称为释迦牟尼舍利塔，俗称大白塔。塔身拨地而起凌空高耸，在五台山群寺簇拥之下颇为壮观，" +
                    "人们把它做为五台山的标志。此塔通高七十五点三米，环周八十三点三米。塔基为正方形，" +
                    "塔身状如藻瓶，粗细相间，方圆搭配，造型优美。塔顶盖铜板八块成圆形，按乾、坎、艮、震、巽、离、坤、兑等八卦地位安置。" +
                    "塔顶中装铜顶一枚，高约五米，覆盘二十一米多，饰有垂檐三十六块，长两米多；" +
                    "每块垂檐底端挂风钟三个，连同塔腰风钟在内，全塔共有二百五十二个。风欢铃动，叮铛作响。",
            "五台山游客中心位于五台山新旅游服务基地金岗库乡大甘河村，是新旅游服务基地“一心三区”" +
                    "（游客接待中心、旅游服务接待区、移民商住区和管理服务区）的核心内容之一，" +
                    "总投资4300余万元（建筑主体工程投资2727万元，室内装饰装潢工程投资1600万元），建筑面积达11923平方米"};

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void initView() {
        type = getIntent().getIntExtra(CodeConstants.TYPE, 0);
        findViewById(R.id.top_back).setVisibility(View.VISIBLE);
        findViewById(R.id.top_back).setOnClickListener(this);
        findViewById(R.id.detail_play).setOnClickListener(this);
        findViewById(R.id.popimg).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.myButton)).setText("详情");
        titileTextView = (TextView) findViewById(R.id.detail_title);
        showImageView = (ImageView) findViewById(R.id.detail_imageview);
        contentTextView = (TextView) findViewById(R.id.detail_contenet);
        showImageView.setBackgroundResource(images[type]);
        titileTextView.setText(titles[type]);
        contentTextView.setText(contonts[type]);
    }

    @Override
    protected boolean isNeedInitBack() {
        return false;
    }

    @Override
    protected String getTopbarTitle() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_back:
                finish();
                break;
            case R.id.detail_play://播放按钮
                showToast("======");
                break;
        }
    }
}
