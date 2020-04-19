package com.chukun.designer.pattern.behaviour.observer.action.v2;

/**
 * @author chukun
 *  注册发送站内消息的观察者
 */
public class RegisterNotificationObserver implements  RegisterObserver{

    private NotificationService notificationService;

    @Override
    public void handleRegisterSuccess(long userId) {
        notificationService.sendInboxMessage(userId,"welcome.....");
    }
}
