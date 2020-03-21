package com.chukun.designer.principle.ocp.expand;

import com.chukun.designer.principle.ocp.simple.AlertRule;
import com.chukun.designer.principle.ocp.simple.Notification;

public abstract  class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule,Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    /**
     * 留给子类实现，相关的check逻辑
     * @param apiStatInfo
     */
    public abstract void check(ApiStatInfo apiStatInfo);

}
