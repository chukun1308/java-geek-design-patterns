package com.chukun.designer.pattern.bridge.v1;

import com.chukun.designer.principle.ocp.expand.AlertHandler;
import com.chukun.designer.principle.ocp.expand.ApiStatInfo;
import com.chukun.designer.principle.ocp.simple.AlertRule;
import com.chukun.designer.principle.ocp.simple.Notification;

/**
 * @author chukun
 *  在API监控告警的例子中，我们如下方式来使用Notification类：
 *
 *   详见
 *    {@link Notification }
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
