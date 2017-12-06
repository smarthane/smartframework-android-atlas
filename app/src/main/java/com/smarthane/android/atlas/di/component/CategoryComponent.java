package com.smarthane.android.atlas.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.di.module.CategoryModule;
import com.smarthane.android.atlas.mvp.ui.fragment.CategoryFragment;

import dagger.Component;

@ActivityScope
@Component(modules = CategoryModule.class, dependencies = AppComponent.class)
public interface CategoryComponent {
    void inject(CategoryFragment fragment);
}