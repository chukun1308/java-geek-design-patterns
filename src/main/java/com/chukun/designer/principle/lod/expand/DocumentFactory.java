package com.chukun.designer.principle.lod.expand;

/**
 * @author chukun
 *  工厂方法实现
 */
public class DocumentFactory {


    private DocumentFactory(){
    }

    private static class DocumentFactoryHolder {
        final  static DocumentFactory documentFactory = new DocumentFactory();
    }

    public static DocumentFactory getInstance() {
        return DocumentFactoryHolder.documentFactory;
    }

    /**
     * 创建文档
     * @param key
     * @param url
     * @return
     */
    public  DocumentV2 createDownloader (String key,String url) {
        Downloader downloader = DownloaderFactory.getInstance().createDownloader(key);
        Parse parse = ParseFactory.getInstance().createParse(key);
        String content = parse.parse(downloader.download(url));
        return new DocumentV2(url,content);
    }

}
