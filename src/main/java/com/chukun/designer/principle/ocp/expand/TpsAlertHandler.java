package com.chukun.designer.principle.ocp.expand;

import com.chukun.designer.principle.ocp.simple.AlertRule;
import com.chukun.designer.principle.ocp.simple.Notification;
import com.chukun.designer.principle.ocp.simple.NotificationEmergencyLevel;

/**
 * @author chukun
 * tps相关的check的处理逻辑
 */
public class TpsAlertHandler extends AlertHandler {


    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
//        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
//        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
//            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
//        }
    }
}
