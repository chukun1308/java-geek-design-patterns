package com.chukun.designer.action.statistics.v3;

import com.chukun.designer.action.statistics.v1.MetricsStorage;
import com.chukun.designer.action.statistics.v1.RedisMetricsStorage;
import com.chukun.designer.action.statistics.v2.AggregatorV2;
import com.chukun.designer.action.statistics.v2.ConsoleViewer;
import com.chukun.designer.action.statistics.v2.StatViewer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 控制台处理类
 */
public class ConsoleReporterV3  extends ScheduleReporter{

    private ScheduledExecutorService executorService;

    // 使用 cas操作，放在多次请求
    private  volatile AtomicBoolean runStatus = new AtomicBoolean(false);

    private Object lock = new Object();

    public ConsoleReporterV3() {
        this(new RedisMetricsStorage(),new AggregatorV2(),new ConsoleViewer());
    }

    public ConsoleReporterV3(MetricsStorage metricsStorage, AggregatorV2 aggregator, StatViewer statViewer) {
        super(metricsStorage,aggregator,statViewer);
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        try {
            synchronized (lock) {
                if (runStatus.get()) {
                    System.out.println("has executed....");
                    return;
                }
                runStatus.compareAndSet(false,true);
                executorService.scheduleAtFixedRate(() -> {
                    long durationInMillis = durationInSeconds * 1000;
                    long endTimeMillis = System.currentTimeMillis();
                    long startTimeInMills = endTimeMillis - durationInMillis;
                    doStatAndReport(startTimeInMills, endTimeMillis);
                }, 0, periodInSeconds, TimeUnit.SECONDS);
            }
        }catch (Exception e) {
            runStatus.set(false);
        }
    }

    public static void main(String[] args) {
        ConsoleReporterV3 consoleReporter = new ConsoleReporterV3();
        consoleReporter.startRepeatedReport(1,1);
        consoleReporter.startRepeatedReport(1,1);
        consoleReporter.startRepeatedReport(1,1);
    }
}
