package com.game.legend.net;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by LiuCongshan on 2016/8/8.
 * NetTask
 */
public class NetTask<T extends BaseResponse> {
    public Observable<T> observable;
    public Subscription subscription;

    public NetTask(Observable<T> observable) {
        this.observable = observable;
    }

    /**
     * 得到一个执行网络在io线程
     * 执行观察在UI线程的Observable
     *
     * @return
     */
    public Observable<T> getPreHandleObservable() {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 异步的调用方法
     *
     * @param callback
     */
    public void enqueue(final NetCallback<T> callback) {
        subscription = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<T>() {
                @Override
                public void call(T t) {
                    callback.onSucceed(t);
                }
            }, new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    throwable.printStackTrace();
                    callback.onError(throwable);
                }
            });
    }

    public void cancel() {
        if (subscription != null && !subscription.isUnsubscribed()) subscription.unsubscribe();
    }
}
