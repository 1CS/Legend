package com.game.legend.mvp.contract;

import com.avos.avoscloud.AVUser;

public class RegisterContract {
    public interface IView extends BaseContract.IView {
        void onRegisterSuccess(AVUser user);
    }

    public interface IPresenter extends BaseContract.IPresenter {
        void register(String email, String password);
    }
}
