package com.game.legend.mvp.contract;

import com.avos.avoscloud.AVUser;

public class LoginContract {
    public interface IView extends BaseContract.IView {
        void onLoginSuccess(AVUser user);
    }

    public interface IPresenter extends BaseContract.IPresenter {
        void login(String username, String password);
    }
}
