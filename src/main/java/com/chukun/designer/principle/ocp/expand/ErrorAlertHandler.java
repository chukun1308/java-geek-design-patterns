package com.chukun.designer.principle.ocp.expand;

import com.chukun.designer.principle.ocp.simple.AlertRule;
import com.chukun.designer.principle.ocp.simple.Notification;

/**
 * @author chukun
 * error相关的check的处理逻辑
 */
public class ErrorAlertHandler extends AlertHandler {


    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
//        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
//            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
//        }
    }
}
