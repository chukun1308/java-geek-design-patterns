package com.chukun.designer.principle.lod.expand;


import com.chukun.designer.principle.lod.Html;
import com.chukun.designer.principle.lod.HtmlRequest;

/**
 * @author chukun
 *  html 下载实现
 */
public class HtmlDownLoader implements Downloader<Html>{

    private NetworkTransporterV2 transporter;

    @Override
    public Html download(String url) {
        HtmlRequest htmlRequest = new HtmlRequest(url);
        byte[] rawHtml = transporter.send(htmlRequest.getAddress(), htmlRequest.getContent().getBytes());
        return new Html(rawHtml);
    }
}
