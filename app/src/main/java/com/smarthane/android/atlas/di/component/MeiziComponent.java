package com.smarthane.android.atlas.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.di.module.MeiziModule;
import com.smarthane.android.atlas.mvp.ui.fragment.MeiziFragment;

import dagger.Component;

@ActivityScope
@Component(modules = MeiziModule.class, dependencies = AppComponent.class)
public interface MeiziComponent {
    void inject(MeiziFragment fragment);
}