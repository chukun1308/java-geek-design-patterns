package com.chukun.designer.principle.lod.simple;

import com.chukun.designer.principle.lod.Html;
import com.chukun.designer.principle.lod.HtmlRequest;

/**
 * @author chukun
 *
 */
public class HtmlDownloader {

    private NetworkTransporterV1 transporter;

    public Html downloadHtml(String url) {
        byte[] content = transporter.send(new HtmlRequest(url));
        return new Html(content);
    }

}
