package com.game.legend.mvp.presenter;

import android.text.TextUtils;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;
import com.game.legend.R;
import com.game.legend.mvp.contract.RegisterContract;

public class RegisterPresenter extends BaseTaskPresenter implements RegisterContract.IPresenter {
    private RegisterContract.IView iView;

    public RegisterPresenter(RegisterContract.IView iView) {
        this.iView = iView;
    }

    private boolean checkEmail(String email) {
        return TextUtils.isEmpty(email);
    }

    private boolean checkPassword(String password) {
        return TextUtils.isEmpty(password);
    }

    @Override
    public void register(String email, String password) {
        if (checkEmail(email) || checkPassword(password)) {
            iView.showError(R.string.tip_error_username_password);
            return;
        }

        final AVUser user = new AVUser();
        user.setUsername(email);
        user.setPassword(password);
        user.setEmail(email);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e != null) {
                    e.printStackTrace();
                } else {
                    iView.onRegisterSuccess(user);
                }
            }
        });
    }
}
