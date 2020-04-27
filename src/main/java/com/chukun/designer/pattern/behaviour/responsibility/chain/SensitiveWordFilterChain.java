package com.chukun.designer.pattern.behaviour.responsibility.chain;

import java.util.ArrayList;
import java.util.List;

public class SensitiveWordFilterChain {

    private List<SensitiveWordFilter> filters = new ArrayList<>();

    public void addFilter(SensitiveWordFilter filter) {
        filters.add(filter);
    }

    public boolean filter(Content content) {
        for (SensitiveWordFilter filter : filters) {
            if (!filter.doFilter(content)){
                return false;
            }
        }
        return true;
    }
}
