package com.chukun.designer.pattern.structure.bridge.v2;

public class TrivialNotification extends  NotificationV2 {

    public TrivialNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notify(String message) {
        sender.send(message);
    }
}
