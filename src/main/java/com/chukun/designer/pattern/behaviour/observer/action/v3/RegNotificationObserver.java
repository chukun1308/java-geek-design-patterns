package com.chukun.designer.pattern.behaviour.observer.action.v3;

import com.chukun.designer.pattern.behaviour.observer.action.v2.NotificationService;
import com.chukun.designer.pattern.behaviour.observer.action.v2.RegisterObserver;
import com.google.common.eventbus.Subscribe;

public class RegNotificationObserver implements RegisterObserver {

    private NotificationService notificationService;

    /**
     * 基于 EventBus，不需要定义 Observer 接口，
     * 任意类型的对象都可以注册到 EventBus 中，
     * 通过 @Subscribe 注解来标明类中哪个函数可以接收被观察者发送的消息。
     * @param userId
     */
    @Subscribe
    @Override
    public void handleRegisterSuccess(long userId) {
        notificationService.sendInboxMessage(userId,"welcome...");
    }
}
