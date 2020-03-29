package com.chukun.designer.action.statistics.v2;

import com.chukun.designer.action.statistics.v1.RequestStat;

import java.util.Map;

/**
 * @author chukun
 *   将统计数据显示到终端。
 *   将这部分逻辑剥离出来，
 *   设计成两个类：ConsoleViewer 类和 EmailViewer 类，分别负责将统计结果显示到命令行和邮件中
 */
public interface StatViewer {

    void output(Map<String, RequestStat> requestStats, long startTimeInMillis,long endTimeInMillis);
}
