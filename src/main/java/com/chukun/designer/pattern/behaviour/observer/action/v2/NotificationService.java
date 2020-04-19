package com.chukun.designer.pattern.behaviour.observer.action.v2;

/**
 * @author chukun
 *  提醒服务接口
 */
public interface NotificationService {

    /**
     * 发送站内消息
     * @param userId
     * @param message
     */
    void sendInboxMessage(long userId,String message);
}
