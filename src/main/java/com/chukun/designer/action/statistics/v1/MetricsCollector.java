package com.chukun.designer.action.statistics.v1;


public class MetricsCollector {
    private MetricsStorage metricsStorage;//基于接口而非实现编程

    public MetricsCollector() {
        this.metricsStorage = new RedisMetricsStorage();
    }

    // 依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    //    用一个函数代替了最小原型中的两个函数
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || "".equals(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}