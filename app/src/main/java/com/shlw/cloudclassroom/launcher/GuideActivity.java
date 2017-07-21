package com.shlw.cloudclassroom.launcher;

import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shlw.cloudclassroom.MainMainActivity;
import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.GuildPagerAdapter;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;
import com.shlw.cloudclassroom.pubilc.util.LogUtil;
import com.shlw.cloudclassroom.pubilc.util.ScreenUtils;
import com.shlw.cloudclassroom.pubilc.util.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class GuideActivity extends BaseActivity implements View.OnClickListener ,NoStatusBar{
    @Bind(R.id.vp_guide)
    ViewPager vpGuide;
    @Nullable
    @Bind(R.id.tv_imm_exp)
    TextView tvImmExp;
    private List<View> images = new ArrayList<>();
    private int[] image = new int[]{R.drawable.guide_a, R.drawable.guide_b, R.drawable.guide_c, R.drawable.guide_d};
    private int currentPage;
     //存放小圆点指示图片的数
    private ImageView icons[]=new ImageView[image.length];

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initData() {
        //将图片添加到list<view>集合中
        for (int i = 0; i < image.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(image[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            images.add(iv);
        }
        GuildPagerAdapter adapter = new GuildPagerAdapter(images);
        vpGuide.setAdapter(adapter);

        //初始化小圆点图片指示
        init();

        vpGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < image.length; i++) {
                    icons[i].setEnabled(true);
                }
                //将当前下标的指示图片  选中
                icons[position].setEnabled(false);
                //currentpage后面要用
                currentPage = position;
                if (position == 3) {
                    //设置可见,如果用按钮也可以实现activity的跳转,两种跳转功能都具备
                    ViewUtils.showView(tvImmExp);
                    tvImmExp.setOnClickListener(GuideActivity.this);
                } else {
                    ViewUtils.goneView(tvImmExp);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置ViewPager的滑动监听,为了滑动到最后一页,继续滑动实现页面的跳转
        vpGuide.setOnTouchListener(new View.OnTouchListener() {
            float startX;

            float endX;


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();

                        break;
                    case MotionEvent.ACTION_UP:
                        endX = event.getX();
                        //获取屏幕的宽度
                        int width = ScreenUtils.widthPixels(getApplicationContext());
                        //根据滑动的距离来切换界面
                        LogUtil.i("当前的页面索引值为：" + currentPage);
                        if (currentPage == 3 && startX - endX >= (width / 5)) {
                            startActivity();
                        }

                        break;
                }
                return false;
            }
        });

    }

    private void init() {
        LinearLayout layout=(LinearLayout) findViewById(R.id.layout);

        for (int i = 0; i < icons.length; i++) {
            //将布局中的指示图片放进数组里
            icons[i]=(ImageView) layout.getChildAt(i);
            //设置是否响应事件
            icons[i].setEnabled(true);
            //给指示图片添加下标
            icons[i].setTag(i);
            icons[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    vpGuide.setCurrentItem((Integer) v.getTag());
                }
            });
            icons[0].setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        startActivity();
    }

    private void startActivity() {
        IntentUtil.startActivity(this,MainMainActivity.class);
        finish();
    }
}
