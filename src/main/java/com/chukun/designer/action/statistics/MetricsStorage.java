package com.chukun.designer.action.statistics;

import java.util.List;
import java.util.Map;

/**
 * @author chukun
 * 统计存储接口
 */
public interface MetricsStorage {

    /**
     * 保存请求参数
     * @param requestInfo
     */
    void saveRequestInfo(RequestInfo requestInfo);

    /**
     * 获取相关的信息
     * @param apiName
     * @param startTimeInMillis
     * @param endTimeMillis
     * @return
     */
    List<RequestInfo> getRequestInfos(String apiName,long startTimeInMillis,long endTimeMillis);

    /**
     * 获取相关的信息
     * @param startTimeInMillis
     * @param endTimeInMillis
     * @return
     */
    Map<String,List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
