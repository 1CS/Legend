package com.game.legend.mvp.presenter;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.game.legend.mvp.contract.LoginContract;
import com.game.legend.utils.DebugLog;

public class LoginPresenter extends BaseTaskPresenter implements LoginContract.IPresenter {
    private LoginContract.IView iView;

    public LoginPresenter(LoginContract.IView iView) {
        this.iView = iView;
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public void login(String username, String password) {
        AVUser.logInInBackground(username, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser user, AVException e) {
                if (e != null) {
                    e.printStackTrace();
                } else if (user != null) {
                    iView.onLoginSuccess(user);
                } else {
                    DebugLog.e("Exception user == null");
                }
            }
        });
    }
}
