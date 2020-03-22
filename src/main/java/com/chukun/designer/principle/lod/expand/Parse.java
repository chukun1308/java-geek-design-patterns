package com.chukun.designer.principle.lod.expand;

/**
 * 解析相关的内容
 */
public interface Parse<T> {

    /**
     * 解析方法定义
     * @param content
     * @return
     */
    String parse(T content);
}
