package com.chukun.designer.oop;

/**
 * @author chukun
 * 认证接口
 */
public interface ApiAuthenticator {

    void auth(String url);

    void auth(ApiRequest apiRequest);
}
