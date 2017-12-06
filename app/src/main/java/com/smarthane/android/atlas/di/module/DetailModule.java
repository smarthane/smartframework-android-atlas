package com.smarthane.android.atlas.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.mvp.contract.DetailContract;
import com.smarthane.android.atlas.mvp.model.DetailModel;

import dagger.Module;
import dagger.Provides;


@Module
public class DetailModule {
    private DetailContract.View view;

    /**
     * 构建DetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public DetailModule(DetailContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DetailContract.View provideDetailView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    DetailContract.Model provideDetailModel(DetailModel model) {
        return model;
    }
}