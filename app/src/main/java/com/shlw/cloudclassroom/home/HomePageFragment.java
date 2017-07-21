package com.shlw.cloudclassroom.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.adapter.ModelRecyclerAdapter;
import com.shlw.cloudclassroom.base.BaseFragment;
import com.shlw.cloudclassroom.bean.HomeListBean;
import com.shlw.cloudclassroom.holder.home.student.HomePagerViewHolder;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.GlideImageLoader;
import com.shlw.cloudclassroom.view.DividerListItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class HomePageFragment extends BaseFragment {
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.rv_home_pager)
    RecyclerView rvHomePager;


    protected int getFragmentLayoutId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    protected void initData() {
        super.initData();
        initBanner();
    }

    protected void initRecyclerView() {
        List<HomeListBean> list = new ArrayList<>();
        int[] resourceId = null;
        String[] name = null;
        switch (flag){
            case Constant.STUDENT:
                resourceId = new int[]{R.drawable.exams,R.drawable.video,R.drawable.exam,R.drawable.circle,R.drawable.setting};
                name = new String[]{"考试","视频","互动学习","社交圈","设置"};
                break;

            case Constant.TEACHER:
                resourceId = new int[]{R.drawable.exams,R.drawable.video,R.drawable.exam};
                name = new String[]{"信息查询","成绩查询","在线排考"};
                break;
        }
        for (int i=0;i<resourceId.length;i++){
            HomeListBean homeListBean = new HomeListBean();
            homeListBean.imageId = resourceId[i];
            homeListBean.name = name[i];
            list.add(homeListBean);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,
                2,GridLayoutManager.VERTICAL, false);
        rvHomePager.setLayoutManager(gridLayoutManager);
        // 设置分割线 - 分割线需要自定义 & 还可以自定义分割线的样式
        // 没有提供默认的分割线
        rvHomePager.addItemDecoration(new DividerListItemDecoration(mContext,
                DividerListItemDecoration.VERTICAL_LIST,false));
        rvHomePager.addItemDecoration(new DividerListItemDecoration(mContext,
                DividerListItemDecoration.HORIZONTAL_LIST,false));
        ModelRecyclerAdapter<HomeListBean> homePagerAdapter =
                new ModelRecyclerAdapter<HomeListBean>(HomePagerViewHolder.class,list);
        rvHomePager.setAdapter(homePagerAdapter);
    }

    private void initBanner() {
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.ic_launcher);
        images.add(R.drawable.banner);
        images.add(R.mipmap.ic_launcher);
        List<String> titles = new ArrayList<>();
        titles.add("小机器人");
        titles.add("风景");
        titles.add("大机器人");
        //资源文件
//        Integer[] images={R.mipmap.ic_launcher,R.drawable.banner,R.mipmap.ic_launcher};
        //Uri
        /*Uri uri = resourceIdToUri(context, R.mipmap.ic_launcher);
        Uri[] images={uri};
        //文件对象
        File[] images={"文件对象","文件对象"};
        //raw 两种方式
        String[] images={"Android.resource://com.frank.glide/raw/raw_1"};
        String[] images={"android.resource://com.frank.glide/raw/"+R.raw.raw_1"};
        //ContentProvider
                String[] images={"content://media/external/images/media/139469"};
        //assets
        String[] images={"file:///android_asset/f003.gif"};
        //sd卡资源
        String[] images={"file://"+ Environment.getExternalStorageDirectory().getPath()+"/test.jpg"};*/
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}
