package com.smarthane.android.atlas.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.mvp.contract.MeiziContract;
import com.smarthane.android.atlas.mvp.model.MeiziModel;

import dagger.Module;
import dagger.Provides;


@Module
public class MeiziModule {
    private MeiziContract.View view;

    /**
     * 构建MeiziModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MeiziModule(MeiziContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MeiziContract.View provideMeiziView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MeiziContract.Model provideMeiziModel(MeiziModel model) {
        return model;
    }
}