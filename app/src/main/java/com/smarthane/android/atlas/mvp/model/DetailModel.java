package com.smarthane.android.atlas.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.smarthane.android.atlas.app.GreenDaoHelper;
import com.smarthane.android.atlas.app.greendao.DaoGankEntityDao;
import com.smarthane.android.atlas.mvp.contract.DetailContract;
import com.smarthane.android.atlas.mvp.model.api.service.CommonService;
import com.smarthane.android.atlas.mvp.model.entity.DaoGankEntity;
import com.smarthane.android.atlas.mvp.model.entity.GankEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


@ActivityScope
public class DetailModel extends BaseModel implements DetailContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public DetailModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
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

    @Override
    public Observable<GankEntity> getRandomGirl() {
        Observable<GankEntity> randomGirl = mRepositoryManager.obtainRetrofitService(CommonService.class)
                .getRandomGirl();
        return randomGirl;
    }

    @Override
    public List<DaoGankEntity> queryById(String id) {
        return GreenDaoHelper.getDaoSession().getDaoGankEntityDao()
                .queryBuilder()
                .where(DaoGankEntityDao.Properties._id.eq(id))
                .list();
    }

    @Override
    public void removeByid(String id) {
        GreenDaoHelper.getDaoSession().getDaoGankEntityDao()
                .queryBuilder()
                .where(DaoGankEntityDao.Properties._id.eq(id))
                .buildDelete().executeDeleteWithoutDetachingEntities();
    }

    @Override
    public void addGankEntity(DaoGankEntity entity) {
        GreenDaoHelper.getDaoSession().getDaoGankEntityDao().insert(entity);
    }


}