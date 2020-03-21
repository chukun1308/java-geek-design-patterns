package com.chukun.designer.principle.ocp.simple;

/**
 * @author chukun
 * 表示通知的紧急程度，
 * 包括 SEVERE（严重）、
 *     URGENCY（紧急）、
 *     NORMAL（普通）、
 *     TRIVIAL（无关紧要)
 */
public enum NotificationEmergencyLevel {

    SEVERE(1,"严重"),
    URGENCY(2,"紧急"),
    NORMAL(3,"普通"),
    TRIVIAL(4,"无关紧要 ");

    private byte code;
    private String desc;

    NotificationEmergencyLevel(Integer code,String desc) {
        this.code = code.byteValue();
        this.desc = desc;
    }
}
