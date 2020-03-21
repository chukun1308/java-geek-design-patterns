package com.chukun.designer.oop;

import com.sun.prism.impl.QueuedPixelSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chukun
 * 鉴权接口的基本实现逻辑
 */
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator {


    private final CredentialStorage credentialStorage;

    public DefaultApiAuthenticatorImpl() {
        credentialStorage = new MysqlCredentialStorage();
    }

    public DefaultApiAuthenticatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {

        String token = apiRequest.getToken();
        String appId = apiRequest.getAppId();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getBaseUrl();
        AuthToken authToken = new AuthToken(token,timestamp);
        if (authToken.isExpired()) {
            throw  new RuntimeException("token is expired....");
        }

        String password = credentialStorage.getPasswordByAppId(appId);
        if (password == null || "".equals(password)) {
            throw  new RuntimeException("appId is not exist....");
        }
        Map<String,Object> params = new HashMap<String, Object>(){
            {
                put("password",password);
                put("appId",appId);
            }
        };
        AuthToken serverToken = AuthToken.create(originalUrl, timestamp, params);
        if (!serverToken.match(authToken)) {
            throw new RuntimeException("Token verfication failed...");
        }
    }

}
