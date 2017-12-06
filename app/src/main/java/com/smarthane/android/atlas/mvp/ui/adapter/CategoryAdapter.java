package com.smarthane.android.atlas.mvp.ui.adapter;

import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;
import com.smarthane.android.atlas.R;
import com.smarthane.android.atlas.mvp.model.entity.GankEntity;
import com.smarthane.android.atlas.mvp.ui.holder.CategoryItemHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/7/4.
 */

public class CategoryAdapter extends DefaultAdapter<GankEntity.ResultsBean> {

    public CategoryAdapter(List<GankEntity.ResultsBean> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<GankEntity.ResultsBean> getHolder(View v, int viewType) {
        return new CategoryItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_android;
    }

}
