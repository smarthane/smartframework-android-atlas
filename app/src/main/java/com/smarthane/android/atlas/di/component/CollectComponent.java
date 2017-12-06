package com.smarthane.android.atlas.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.di.module.CollectModule;
import com.smarthane.android.atlas.mvp.ui.fragment.CollectFragment;

import dagger.Component;

@ActivityScope
@Component(modules = CollectModule.class, dependencies = AppComponent.class)
public interface CollectComponent {
    void inject(CollectFragment fragment);
}