package com.chukun.designer.action.statistics.v3;

import com.chukun.designer.action.statistics.v1.MetricsStorage;
import com.chukun.designer.action.statistics.v1.RequestInfo;
import com.chukun.designer.action.statistics.v1.RequestStat;
import com.chukun.designer.action.statistics.v2.AggregatorV2;
import com.chukun.designer.action.statistics.v2.StatViewer;

import java.util.List;
import java.util.Map;

/**
 * @author chukun
 *  consoleReporter 与 emailReporter 基类
 */
public abstract class ScheduleReporter {

    private MetricsStorage metricsStorage;
    private StatViewer statViewer;
    private AggregatorV2 aggregator;

    public ScheduleReporter(MetricsStorage metricsStorage, AggregatorV2 aggregator, StatViewer statViewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.statViewer = statViewer;
    }

    protected void doStatAndReport(long startTimeInMillis,long endTimeInMillis) {
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>>  requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat>  stats = aggregator.aggregate(requestInfos, durationInMillis);
        statViewer.output(stats,startTimeInMillis,endTimeInMillis);
    }
}
