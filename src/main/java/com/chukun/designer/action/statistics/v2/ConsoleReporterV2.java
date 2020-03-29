package com.chukun.designer.action.statistics.v2;

import com.chukun.designer.action.statistics.v1.Aggregator;
import com.chukun.designer.action.statistics.v1.MetricsStorage;
import com.chukun.designer.action.statistics.v1.RequestInfo;
import com.chukun.designer.action.statistics.v1.RequestStat;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 控制台处理类
 */
public class ConsoleReporterV2 {

    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executorService;
    private StatViewer statViewer;
    private AggregatorV2 aggregator;

    public ConsoleReporterV2(MetricsStorage metricsStorage,AggregatorV2 aggregator,StatViewer statViewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.statViewer = statViewer;
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executorService.scheduleAtFixedRate(() -> {
            long durationInMillis = durationInSeconds * 1000;
            long endTimeMillis = System.currentTimeMillis();
            long startTimeInMills = endTimeMillis - durationInMillis;
            Map<String, List<RequestInfo>> requestInfos =
                    metricsStorage.getRequestInfos(startTimeInMills, endTimeMillis);
            Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
            statViewer.output(stats,startTimeInMills,endTimeMillis);
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
