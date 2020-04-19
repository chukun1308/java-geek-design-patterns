package com.chukun.designer.pattern.behaviour.observer.template;

/**
 * @author chukun
 *
 */
public class Message {

    private long messageId;
    private String content;

    public Message(long messageId,String content) {
        this.messageId = messageId;
        this.content = content;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", content='" + content + '\'' +
                '}';
    }
}
