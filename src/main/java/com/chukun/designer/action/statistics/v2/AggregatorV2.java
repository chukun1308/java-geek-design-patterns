package com.chukun.designer.action.statistics.v2;

import com.chukun.designer.action.statistics.v1.RequestInfo;
import com.chukun.designer.action.statistics.v1.RequestStat;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chukun
 *   重构aggregator相关的代码，解决代码统计逻辑不清晰的问题,
 *    这里还有优化的空间，就是当时间间隔过大，就会出现数据量很大的问题，就是导致内存溢出。
 *    解决思路，分片统计相关的指标
 *    对于 percentile，需要先排序，然后在统计，这样分片就不行了，需要先进行外部排序，写到文件中，然后在读取响应的数据。。。
 */
public class AggregatorV2 {

    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {

        Map<String,RequestStat> requestStatMap = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfoList = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfoList,durationInMillis);
            requestStatMap.put(apiName,requestStat);
        }
        return  requestStatMap;
    }

    /**
     * 处理统计逻辑
     * @param requestInfos
     * @param durationInMills
     * @return
     */
    private RequestStat doAggregate(List<RequestInfo> requestInfos,long durationInMills) {
        List<Double> responseTimes  = requestInfos.stream().map(RequestInfo::getResponseTime).collect(Collectors.toList());

        RequestStat resultRequestStat = new RequestStat();

        resultRequestStat.setMaxResponseTime(max(responseTimes));
        resultRequestStat.setMinResponseTime(min(responseTimes));
        resultRequestStat.setAvgResponseTime(avg(responseTimes));
        resultRequestStat.setCount(responseTimes.size());
        resultRequestStat.setP99ResponseTime(percentile99(responseTimes));
        resultRequestStat.setP999ResponseTime(percentile999(responseTimes));
        resultRequestStat.setTps((long) tps(responseTimes.size(),Double.parseDouble(durationInMills +"")));
        return resultRequestStat;
    }

    private double max(List<Double> dataset) {
        Double max = Collections.max(dataset,Double::compareTo);
        return max;
    }

    private double min(List<Double> dataset) {
        Double min = Collections.min(dataset,Double::compareTo);
        return min;
    }

    private double avg(List<Double> dataset) {
        if (isEmpty(dataset)) {
            throw new IllegalArgumentException("dataset is empty, can not calculate avg...");
        }
        Double sum = dataset.stream().reduce(0d, Double::sum);
        return sum / dataset.size();
    }

    private double tps(int count,double duration) {
        double tps = (count / duration * 1000);
        return tps;
    }

    private double percentile999(List<Double> dataset) {
        return percentile(dataset,0.999);
    }

    private double percentile99(List<Double> dataset) {
        return percentile(dataset,0.99);
    }

    private double percentile(List<Double> dataset,double ratio) {
        if (isEmpty(dataset)) {
            throw new IllegalArgumentException("dataset is empty, can not calculate percentile99...");
        }
        compare(dataset);
        int idx = (int) (dataset.size() * ratio);
        return dataset.get(idx);
    }

    /**
     * 排序
     * @param dataset
     * @return
     */
    private List<Double> compare(List<Double> dataset) {
        dataset.sort((o1, o2) -> {
            double diff = o1 - o2;
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else {
                return 0;
            }
        });
        return dataset;
    }

    private boolean isEmpty(List<Double> dataset) {
        return dataset == null || dataset.size()==0;
    }
}
