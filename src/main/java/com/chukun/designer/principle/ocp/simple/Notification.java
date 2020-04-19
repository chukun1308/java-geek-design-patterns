package com.chukun.designer.principle.ocp.simple;

import java.util.List;
import java.util.Objects;

/**
 * @author chukun
 * 告警通知类，支持邮件、短信、微信、手机等多种通知渠道
 *
 *  Notification 类的代码实现有一个最明显的问题，那就是有很多 if-else 分支逻辑。
 *  实际上，如果每个分支中的代码都不复杂，后期也没有无限膨胀的可能（增加更多 if-else 分支判断），
 *  那这样的设计问题并不大，没必要非得一定要摒弃 if-else 分支逻辑
 *
 */
public class Notification {

    private List<String> emailAddresses;
    private List<String> telephones;
    private List<String> wechatIds;

    public Notification(NotificationBuilder builder) {
        this.emailAddresses = builder.emailAddresses;
        this.telephones = builder.telephones;
        this.wechatIds = builder.wechatIds;

    }

    /**
     * @param level
     * @param message
     */
    public void notify(NotificationEmergencyLevel level, String message) {
        if (level.equals(NotificationEmergencyLevel.SEVERE)) {
            //...自动语音电话
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //...发微信
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            //...发邮件
        } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            //...发邮件
        }
    }

    /**
     * 使用builder模式，解决 局部变量被篡改的情况
     */
    public static class NotificationBuilder {
        private List<String> emailAddresses;
        private List<String> telephones;
        private List<String> wechatIds;


        public Notification builder() {
            if (Objects.isNull(emailAddresses) || emailAddresses.size()==0) {
                throw new IllegalArgumentException("emailAddresses is not empty");
            }
            if (Objects.isNull(telephones) || telephones.size()==0) {
                throw new IllegalArgumentException("telephones is not empty");
            }
            if (Objects.isNull(wechatIds) || wechatIds.size()==0) {
                throw new IllegalArgumentException("wechatIds is not empty");
            }
            return new Notification(this);
        }

        public NotificationBuilder setEmailAddresses(List<String> emailAddresses) {
            this.emailAddresses = emailAddresses;
            return this;
        }

        public NotificationBuilder setTelephones(List<String> telephones) {
            this.telephones = telephones;
            return this;
        }

        public NotificationBuilder setWechatIds(List<String> wechatIds) {
            this.wechatIds = wechatIds;
            return this;
        }
    }
}
