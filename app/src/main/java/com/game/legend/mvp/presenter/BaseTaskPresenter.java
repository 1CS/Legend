package com.game.legend.mvp.presenter;

import com.game.legend.mvp.contract.BaseContract;
import com.game.legend.net.NetTask;

import java.util.ArrayList;

import rx.Subscription;

public class BaseTaskPresenter implements BaseContract.IPresenter {
    private ArrayList<Subscription> tasks;

    protected void addTask(NetTask task) {
        addTask(task.subscription);
    }

    protected void addTask(Subscription subscription) {
        if (subscription != null) {
            if (tasks == null) {
                tasks = new ArrayList<>();
            }
            tasks.add(subscription);
        }
    }

    @Override
    public void onDestroy() {
        if (tasks == null) return;
        for (Subscription subscription : tasks) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }
}
