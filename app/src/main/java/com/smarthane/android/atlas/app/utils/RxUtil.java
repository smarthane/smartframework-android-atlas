package com.smarthane.android.atlas.app.utils;

import com.jess.arms.mvp.IView;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.RxFragment;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by smarthane on 2017/12/6.
 */

public class RxUtil {



    public static <T>LifecycleTransformer<T> bindToLifecycle(IView view) {
        if (view instanceof RxAppCompatActivity) {
            return ((RxAppCompatActivity)view).bindToLifecycle();
        } else if (view instanceof RxFragment) {
            return ((RxFragment)view).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("view isn't acivity or fragment");
        }
    }


}
