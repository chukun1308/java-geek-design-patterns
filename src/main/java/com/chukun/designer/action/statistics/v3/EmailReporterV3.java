package com.chukun.designer.action.statistics.v3;

import com.chukun.designer.action.statistics.v1.MetricsStorage;
import com.chukun.designer.action.statistics.v1.RequestInfo;
import com.chukun.designer.action.statistics.v1.RequestStat;
import com.chukun.designer.action.statistics.v2.AggregatorV2;
import com.chukun.designer.action.statistics.v2.EmailViewer;
import com.chukun.designer.action.statistics.v2.StatViewer;

import java.util.*;

/**
 * 邮件处理类
 *   emailReport 与 consoleReport 里面存在大量的重复代码
 *   这个可以用继承来解决。。。。
 */
public class EmailReporterV3 extends ScheduleReporter{

    private static final Long DAY_HOURS_IN_SECONDS = 86400L;


    public EmailReporterV3(MetricsStorage metricsStorage) {
        this(metricsStorage, new AggregatorV2(), new EmailViewer());
    }

    public EmailReporterV3(MetricsStorage metricsStorage, AggregatorV2 aggregator, StatViewer statViewer) {
        super(metricsStorage,aggregator,statViewer);
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
                doStatAndReport(startTimeInMillis,endTimeInMillis);
            }
        },firstTime,DAY_HOURS_IN_SECONDS*1000);
    }
}
