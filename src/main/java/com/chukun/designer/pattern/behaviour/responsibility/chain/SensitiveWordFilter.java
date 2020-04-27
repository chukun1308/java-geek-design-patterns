package com.chukun.designer.pattern.behaviour.responsibility.chain;

/**
 * @author chukun
 *  过滤器接口
 */
public interface SensitiveWordFilter {

    boolean doFilter(Content content);
}
