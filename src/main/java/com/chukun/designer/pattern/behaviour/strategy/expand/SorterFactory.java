package com.chukun.designer.pattern.behaviour.strategy.expand;

import java.util.HashMap;
import java.util.Map;

public class SorterFactory {

    private static final Map<String, ISorter> SORTER_MAP = new HashMap<>();

    static {
        SORTER_MAP.put("QuickSort", new QuickSort());
        SORTER_MAP.put("ExternalSort", new ExternalSort());
        SORTER_MAP.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        SORTER_MAP.put("MapReduceSort", new MapReduceSort());
    }

    public static ISorter getSort(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return SORTER_MAP.get(type);
    }
}
