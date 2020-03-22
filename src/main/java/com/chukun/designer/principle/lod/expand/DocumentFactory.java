package com.chukun.designer.principle.lod.expand;


import java.util.HashMap;
import java.util.Map;

/**
 * @author chukun
 *  工厂方法实现
 */
public class DocumentFactory {

    private static final Map<String,Downloader> downloaderFactoryMap = new HashMap<>();
    private static final Map<String,Parse> parseFactoryMap = new HashMap<>();

    static {
        downloaderFactoryMap.put("htmlDownloader",new HtmlDownLoader());
        parseFactoryMap.put("htmlParse",new HtmlParse());
    }

    private DocumentFactory(){
        throw new RuntimeException("singleton is not initialized....");
    }

    private static class DocumentFactoryHolder {
        final  static DocumentFactory documentFactory = new DocumentFactory();
    }

    public static DocumentFactory getInstance() {
        return DocumentFactoryHolder.documentFactory;
    }

    public  Downloader createDownloader (String key) {
        return downloaderFactoryMap.getOrDefault(key,new HtmlDownLoader());
    }

    public  Parse createParse (String key) {
        return parseFactoryMap.getOrDefault(key,new HtmlParse());
    }

}
