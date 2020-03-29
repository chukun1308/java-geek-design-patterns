package com.chukun.designer.action.statistics.v2;

import com.chukun.designer.action.statistics.v1.*;

import java.util.*;

/**
 * 邮件处理类
 *   emailReport 与 consoleReport 里面存在大量的重复代码
 *   这个可以用继承来解决。。。。
 */
public class EmailReporterV2 {

    private static final Long DAY_HOURS_IN_SECONDS = 86400L;
    private MetricsStorage metricsStorage;
    private StatViewer statViewer;
    private AggregatorV2 aggregator;


    public EmailReporterV2(MetricsStorage metricsStorage) {
        this(metricsStorage, new AggregatorV2(), new EmailViewer());
    }

    public EmailReporterV2(MetricsStorage metricsStorage, AggregatorV2 aggregator, StatViewer statViewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.statViewer = statViewer;
    }


    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String,List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
                // TODO 转换为HTML格式，发送邮件
                statViewer.output(stats,startTimeInMillis,endTimeInMillis);
            }
        },firstTime,DAY_HOURS_IN_SECONDS*1000);
    }
}
