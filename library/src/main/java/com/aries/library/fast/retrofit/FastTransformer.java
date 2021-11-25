package com.aries.library.fast.retrofit;


import androidx.annotation.NonNull;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.schedulers.Schedulers;

//import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

/**
 * @Author: AriesHoo on 2018/7/23 14:24
 * @E-Mail: AriesHoo@126.com
 * Function: 控制操作线程的辅助类
 * Description:
 */
public class FastTransformer {

    /**
     * 线程切换
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> switchSchedulers() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return switchSchedulers(upstream);
            }
        };
    }

    /**
     * 线程切换
     *
     * @param observable
     * @param <T>
     * @return
     */
    public static <T> Observable<T> switchSchedulers(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
