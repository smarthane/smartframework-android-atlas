package com.smarthane.android.atlas.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.mvp.contract.WelfareContract;
import com.smarthane.android.atlas.mvp.model.WelfareModel;

import dagger.Module;
import dagger.Provides;


@Module
public class WelfareModule {
    private WelfareContract.View view;

    /**
     * 构建WelfareModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public WelfareModule(WelfareContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    WelfareContract.View provideWelfareView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    WelfareContract.Model provideWelfareModel(WelfareModel model) {
        return model;
    }
}