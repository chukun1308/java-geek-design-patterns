package com.chukun.designer.pattern.structure.bridge.v2;

public class NormalNotification extends  NotificationV2 {

    public NormalNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notify(String message) {
        sender.send(message);
    }
}
