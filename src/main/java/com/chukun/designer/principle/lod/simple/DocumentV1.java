package com.chukun.designer.principle.lod.simple;

import com.chukun.designer.principle.lod.Html;

/**
 * @author 文档的实体类
 * 代码缺陷：
 *   1. 代码里面依赖html具体的文档格式，导致  asp ，jsp无法实现解析
 *   2. 构造函数使用download的代码，影响效率
 */
public class DocumentV1 {

    private Html html;
    private String url;

    public DocumentV1(String url) {
        this.url = url;
        HtmlDownloader downloader = new HtmlDownloader();
        this.html = downloader.downloadHtml(url);
    }  //...
}
