package com.game.legend.mvp.contract;

public class BaseContract {
    public interface IView {
        void showError(int resId);

        void showError(String message);

        void showLoading();

        void hideLoading();
    }

    public interface IPresenter{
        void onDestroy();
    }
}
