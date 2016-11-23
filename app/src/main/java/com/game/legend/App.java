package com.game.legend;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.im.v2.AVIMMessageManager;
import com.avos.avoscloud.im.v2.AVIMTypedMessage;
import com.game.legend.lean.MessageHandler;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AVOSCloud.initialize(this, "ieJiUQ6jQQj3y6Xos9Uyvt9E-gzGzoHsz", "rk9fThys8R40XOzxhoSJmoh4");

        // 必须在启动的时候注册 MessageHandler
        // 应用一启动就会重连，服务器会推送离线消息过来，需要 MessageHandler 来处理
        AVIMMessageManager.registerMessageHandler(AVIMTypedMessage.class, new MessageHandler(this));
    }
}
