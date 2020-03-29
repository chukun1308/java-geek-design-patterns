package com.chukun.designer.action.statistics.v2;

import com.chukun.designer.action.statistics.v1.RequestStat;
import com.google.gson.Gson;

import java.util.Map;

/**
 * @author chukun
 *  ConsoleViewer 负责将结果打印到控制台
 */
public class ConsoleViewer implements StatViewer {
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {

        System.out.println("time span ["+startTimeInMillis+" , "+endTimeInMillis+"]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
