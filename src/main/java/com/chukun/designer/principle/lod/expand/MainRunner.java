package com.chukun.designer.principle.lod.expand;

import com.chukun.designer.principle.lod.Html;

public class MainRunner {

    public static void main(String[] args) {
        // 获取html download接口
        Downloader<Html> htmlDownloader = DocumentFactory.getInstance().createDownloader("htmlDownloader");
        // 获取html parse 接口
        Parse<Html> htmlParse = DocumentFactory.getInstance().createParse("htmlParse");
        // 解析网页内容
        String content = htmlParse.parse(htmlDownloader.download("www.baidu.com"));
        // 封装document对象
        DocumentV2 document = new DocumentV2("www.baidu.com",content);

    }
}
