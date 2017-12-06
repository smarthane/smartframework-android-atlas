package com.smarthane.android.atlas.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.mvp.contract.ArticleContract;
import com.smarthane.android.atlas.mvp.model.ArticleModel;

import dagger.Module;
import dagger.Provides;


@Module
public class ArticleModule {
    private ArticleContract.View view;

    /**
     * 构建ArticleModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ArticleModule(ArticleContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ArticleContract.View provideArticleView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ArticleContract.Model provideArticleModel(ArticleModel model) {
        return model;
    }
}