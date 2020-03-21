package com.chukun.designer.oop;

/**
 * api request封装
 * @author chukun
 */
public class ApiRequest {

    private final String baseUrl;
    private final String token;
    private final String appId;
    private final long   timestamp;

    public ApiRequest(String baseUrl,String token,String appId,long timestamp){
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url) {
        return new ApiRequest(null,null,null,0);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
