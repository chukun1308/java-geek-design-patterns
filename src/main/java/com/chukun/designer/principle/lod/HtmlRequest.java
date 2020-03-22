package com.chukun.designer.principle.lod;

/**
 * @author chukun
 *   html请求参数封装
 */
public class HtmlRequest {

    private String address;
    private String content;


    public HtmlRequest(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
