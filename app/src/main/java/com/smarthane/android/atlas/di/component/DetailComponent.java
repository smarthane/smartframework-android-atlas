package com.smarthane.android.atlas.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.di.module.DetailModule;
import com.smarthane.android.atlas.mvp.ui.activity.DetailActivity;

import dagger.Component;

@ActivityScope
@Component(modules = DetailModule.class, dependencies = AppComponent.class)
public interface DetailComponent {
    void inject(DetailActivity activity);
}