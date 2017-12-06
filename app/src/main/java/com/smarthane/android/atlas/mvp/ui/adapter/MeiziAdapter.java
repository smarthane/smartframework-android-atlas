package com.smarthane.android.atlas.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.smarthane.android.atlas.R;
import com.smarthane.android.atlas.mvp.model.entity.DaoGankEntity;
import com.smarthane.android.atlas.mvp.ui.holder.WelfareHolder;

import java.util.List;

/**
 * Created by zhy on 17-7-20.
 */

public class MeiziAdapter extends BaseQuickAdapter<DaoGankEntity,WelfareHolder> {

    public MeiziAdapter(@Nullable List<DaoGankEntity> data) {
        super(R.layout.girls_item, data);
    }

    @Override
    protected void convert(WelfareHolder helper, DaoGankEntity item) {
        ImageView view = helper.getView(R.id.network_imageview);
        Glide.with(helper.mAppComponent.appManager().getCurrentActivity() == null
                ? helper.mAppComponent.application() : helper.mAppComponent.appManager().getCurrentActivity())
                .load(item.url)
                .into(view);
    }


}
