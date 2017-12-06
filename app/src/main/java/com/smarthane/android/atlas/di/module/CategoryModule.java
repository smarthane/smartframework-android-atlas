package com.smarthane.android.atlas.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.mvp.contract.CategoryContract;
import com.smarthane.android.atlas.mvp.model.CategoryModel;

import dagger.Module;
import dagger.Provides;


@Module
public class CategoryModule {
    private CategoryContract.View view;

    /**
     * 构建CategoryModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public CategoryModule(CategoryContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    CategoryContract.View provideCategoryView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    CategoryContract.Model provideCategoryModel(CategoryModel model) {
        return model;
    }
}