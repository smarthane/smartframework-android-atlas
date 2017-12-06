package com.smarthane.android.atlas.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.smarthane.android.atlas.R;
import com.smarthane.android.atlas.mvp.model.entity.GankEntity;
import com.smarthane.android.atlas.mvp.ui.holder.WelfareHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */

public class WelfareAdapter extends BaseQuickAdapter<GankEntity.ResultsBean,WelfareHolder> {


    public WelfareAdapter( @Nullable List<GankEntity.ResultsBean> data) {
        super(R.layout.item_girls, data);
    }

    @Override
    protected void convert(WelfareHolder helper, GankEntity.ResultsBean item) {
        helper.mImageLoader.loadImage(helper.mAppComponent.appManager().getCurrentActivity() == null
                        ? helper.mAppComponent.application() : helper.mAppComponent.appManager().getCurrentActivity(),
                ImageConfigImpl
                        .builder()
                        .url(item.url)
                        .imageView((ImageView) helper.getView(R.id.ivImage))
                        .build());
    }
}
