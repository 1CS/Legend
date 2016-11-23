package com.game.legend.net;

/**
 * Created by LiuCongshan on 2016/6/16.
 * NetCallback
 */
public abstract class NetCallback<T extends BaseResponse> {

    //请求成功回调
    public abstract void onSucceed(T response);

    //请求失败回调
    public abstract void onError(Throwable e);
}
