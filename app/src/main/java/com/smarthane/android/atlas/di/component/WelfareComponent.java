package com.smarthane.android.atlas.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.smarthane.android.atlas.di.module.WelfareModule;
import com.smarthane.android.atlas.mvp.ui.fragment.WelfareFragment;

import dagger.Component;

@ActivityScope
@Component(modules = WelfareModule.class, dependencies = AppComponent.class)
public interface WelfareComponent {
    void inject(WelfareFragment fragment);
}