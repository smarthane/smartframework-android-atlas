package com.smarthane.android.atlas.mvp.ui.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.smarthane.android.atlas.R;
import com.smarthane.android.atlas.di.component.DaggerDetailComponent;
import com.smarthane.android.atlas.di.module.DetailModule;
import com.smarthane.android.atlas.mvp.contract.DetailContract;
import com.smarthane.android.atlas.mvp.model.entity.GankEntity;
import com.smarthane.android.atlas.mvp.presenter.DetailPresenter;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;
import static com.smarthane.android.atlas.app.ARouterPaths.MAIN_DETAIL;
import static com.smarthane.android.atlas.app.EventBusTags.EXTRA_DETAIL;

@Route(path = MAIN_DETAIL)
public class DetailActivity extends BaseActivity<DetailPresenter> implements DetailContract.View {


    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private GankEntity.ResultsBean entity;
    private boolean isFavorite;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .detailModule(new DetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_detail; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        entity = (GankEntity.ResultsBean) getIntent()
                .getExtras()
                .getSerializable(EXTRA_DETAIL);
        mPresenter.getGirl();
        mPresenter.getQuery(entity._id);
        if (toolbar != null) {
            if (this instanceof AppCompatActivity) {
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    this.setActionBar((android.widget.Toolbar) this.findViewById(R.id.toolbar));
                    this.getActionBar().setDisplayShowTitleEnabled(false);
                }
            }
        }

        // TODO: 2017/7/13 添加到收藏夹
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFavorite) {
                    ArmsUtils.makeText(DetailActivity.this,"已移除收藏夹");
                    mPresenter.removeByid(entity);
                } else {
                    ArmsUtils.makeText(DetailActivity.this,"已添加到收藏夹");
                    mPresenter.addToFavorites(entity);
                }
            }
        });

        initWebView();

    }

    @Override
    public void onFavoriteChange(boolean isFavorite) {
        this.isFavorite = isFavorite;
        if (isFavorite){
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
        }else {
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.C4)));
        }

    }
    private void initWebView() {
        WebSettings settings = webview.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        webview.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }
        });

        webview.loadUrl(entity.url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setData(String url) {
        ArmsUtils.obtainAppComponentFromContext(this).imageLoader().loadImage(this,
                ImageConfigImpl
                        .builder()
                        .url(url)
                        .imageView(imageView)
                        .build());
    }


}
