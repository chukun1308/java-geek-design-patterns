package com.chukun.designer.principle.lod.expand;


import java.util.HashMap;
import java.util.Map;

/**
 * @author chukun
 *  工厂方法实现
 */
public class DownloaderFactory {

    private static final Map<String,Downloader> downloaderFactoryMap = new HashMap<>();

    static {
        downloaderFactoryMap.put("htmlDownloader",new HtmlDownLoader());
    }

    private DownloaderFactory(){
        throw new RuntimeException("singleton is not initialized....");
    }

    private static class DocumentFactoryHolder {
        final  static DownloaderFactory documentFactory = new DownloaderFactory();
    }

    public static DownloaderFactory getInstance() {
        return DocumentFactoryHolder.documentFactory;
    }

    public  Downloader createDownloader (String key) {
        return downloaderFactoryMap.getOrDefault(key,new HtmlDownLoader());
    }

}
