package com.chukun.designer.principle.ocp.simple;

/**
 * @author chukun
 * 一般开发，扩展性差
 */
public class Alert01 {

    private final AlertRule alertRule;
    private final Notification notification;

    public Alert01(AlertRule alertRule, Notification notification) {
        this.alertRule = alertRule;
        this.notification = notification;
    }

    /**
     * 检查规则
     * 业务逻辑主要集中在 check() 函数中。
     * 当接口的 TPS 超过某个预先设置的最大值时，以及当接口请求出错数大于某个最大允许值时，
     * 就会触发告警，通知接口的相关负责人或者团队
     * <p>
     * 需要添加一个功能，当每秒钟接口超时请求个数，超过某个预先设置的最大阈值时，也要触发告警发送通知
     * <p>
     * 主要的改动有两处：
     * 1.修改 check() 函数的入参，添加一个新的统计数据 timeoutCount，表示超时接口请求数；
     * 2.在 check() 函数中添加新的告警逻辑
     *
     * @param api
     * @param requestCount
     * @param errorCount
     * @param durationOfSeconds
     */
    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
//        long tps = requestCount / durationOfSeconds;
//        if (tps > alertRule.getMatchedRule(api).getMaxTps()) {
//            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
//        }
//        if (errorCount > alertRule.getMatchedRule(api).getMaxErrorCount()) {
//            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
//        }
//        // TODO  改动二：添加接口超时处理逻辑
//        long timeoutTps = timeoutCount / durationOfSeconds;
//        if (timeoutTps > rule.getMatchedRule(api).getMaxTimeoutTps()) {
//            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
//        }
    }


}
