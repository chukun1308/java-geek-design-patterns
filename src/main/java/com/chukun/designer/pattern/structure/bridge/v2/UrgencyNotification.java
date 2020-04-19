package com.chukun.designer.pattern.structure.bridge.v2;

/**
 * @author chukun
 *
 */
public class UrgencyNotification extends  NotificationV2 {

    public UrgencyNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notify(String message) {
        sender.send(message);
    }
}
