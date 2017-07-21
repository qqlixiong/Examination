package com.shlw.cloudclassroom.base;

import com.shlw.cloudclassroom.Application;
import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.pubilc.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.transformer.DefaultTransformer;

import butterknife.Bind;

/**
 * Created by john on 2017/4/28.
 */

public abstract class BaseBannerFragment extends BaseFragment{
    @Bind(R.id.banner)
    Banner banner;

    @Override
    protected void initData() {
        super.initData();
        banner.setBannerAnimation(DefaultTransformer.class);
        banner.setImages(Application.images)
                .setImageLoader(new GlideImageLoader())
                .start();
    }
}
