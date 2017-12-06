package com.smarthane.android.atlas.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.smarthane.android.atlas.mvp.contract.CollectContract;

import javax.inject.Inject;


@ActivityScope
public class CollectModel extends BaseModel implements CollectContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public CollectModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

}