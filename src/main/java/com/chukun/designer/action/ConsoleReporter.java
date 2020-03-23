package com.chukun.designer.action;

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
public class ConsoleReporter {

    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executorService;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executorService.scheduleAtFixedRate(() -> {
            long durationInMillis = durationInSeconds * 1000;
            long endTimeMillis = System.currentTimeMillis();
            long startTimeInMills = endTimeMillis - durationInMillis;
            Map<String, List<RequestInfo>> requestInfos =
                    metricsStorage.getRequestInfos(startTimeInMills, endTimeMillis);
            Map<String, RequestStat> stats = new HashMap<>();
            for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                String appName = entry.getKey();
                List<RequestInfo> requestInfosPerApi = entry.getValue();
                RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                stats.put(appName, requestStat);
            }

            System.out.println("Time Span : [" + startTimeInMills + " , " + endTimeMillis + "]");
            Gson gson = new Gson();
            System.out.println(gson.toJson(stats));
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
