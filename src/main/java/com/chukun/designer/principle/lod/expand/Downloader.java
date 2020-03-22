package com.chukun.designer.principle.lod.expand;

/**
 * 下载接口定义
 * @param <T>
 */
public interface Downloader<T> {
    /**
     * 下载方法定义
     * @param url
     * @return
     */
    T download(String url);

}
