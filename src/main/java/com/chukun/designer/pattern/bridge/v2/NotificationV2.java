package com.chukun.designer.pattern.bridge.v2;

/**
 * @author chukun
 *  定义通知的抽象类
 */
public abstract class NotificationV2 {

    protected MessageSender sender;

    public NotificationV2(MessageSender sender) {
        this.sender = sender;
    }

    public abstract void  notify(String message);

}
