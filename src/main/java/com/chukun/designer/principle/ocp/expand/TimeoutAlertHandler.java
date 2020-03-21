package com.chukun.designer.principle.ocp.expand;

import com.chukun.designer.principle.ocp.simple.AlertRule;
import com.chukun.designer.principle.ocp.simple.Notification;

/**
 * @author chukun
 * timeout相关的check的处理逻辑
 */
public class TimeoutAlertHandler extends AlertHandler {


    public TimeoutAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
//        if (apiStatInfo.getTimeoutCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeoutCount()) {
//            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
//        }
    }
}
