package com.chukun.designer.action.statistics.v2;

import com.chukun.designer.action.statistics.v1.*;

import java.util.concurrent.TimeUnit;

/**
 * @author chukun
 *   统计 v2版本的示例代码
 */
public class MainRunnerV2 {

    public static void main(String[] args) {

        // 创建数据收集器
        MetricsStorage metricsStorage = new RedisMetricsStorage();

        // 创建统计对象
        AggregatorV2 aggregator = new AggregatorV2();

        // 显示到终端
        ConsoleViewer consoleViewer = new ConsoleViewer();
        ConsoleReporterV2 consoleReporter = new ConsoleReporterV2(metricsStorage, aggregator, consoleViewer);
        consoleReporter.startRepeatedReport(60, 60);

        // 发送邮件
        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addAddress("chukun@qq.com");
        EmailReporterV2 emailReporter = new EmailReporterV2(metricsStorage, aggregator, emailViewer);
        emailReporter.startDailyReport();

        // 收集接口访问数据
        MetricsCollector collector = new MetricsCollector(metricsStorage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));
        collector.recordRequest(new RequestInfo("change", 100, 12434));
        collector.recordRequest(new RequestInfo("change", 123, 14233));
        collector.recordRequest(new RequestInfo("order", 12, 12456));
        collector.recordRequest(new RequestInfo("order", 13, 13357));

        try {
            TimeUnit.MILLISECONDS.sleep(100000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
