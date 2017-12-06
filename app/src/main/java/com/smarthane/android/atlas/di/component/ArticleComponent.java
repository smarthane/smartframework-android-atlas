package com.smarthane.android.atlas.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.di.module.ArticleModule;
import com.smarthane.android.atlas.mvp.ui.fragment.ArticleFragment;

import dagger.Component;

@ActivityScope
@Component(modules = ArticleModule.class, dependencies = AppComponent.class)
public interface ArticleComponent {
    void inject(ArticleFragment fragment);
}