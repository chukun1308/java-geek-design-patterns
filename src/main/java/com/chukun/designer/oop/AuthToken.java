package com.chukun.designer.oop;

import java.util.Map;

/**
 * token的相关操作
 * @author chukun
 */
public class AuthToken {

    /**
     * 默认的过期时间
     */
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;

    /**
     * token信息
     */
    private String token;

    private long createTime;

    /**
     * 过期时间的默认值
     */
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token,long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token,long createTime,long expiredTimeInterval) {
        this(token,createTime);
        this.expiredTimeInterval = expiredTimeInterval;
    }

    /**
     * 生成token信息
     * @param baseUrl
     * @param createTime
     * @param params
     * @return
     */
    public static AuthToken create(String baseUrl, long createTime, Map<String,Object> params) {

        // 应用加密算法，生成token
        String token = "";

        return new AuthToken(token,createTime);
    }

    public String getToken() {
        return token;
    }

    /**
     * 判断token是否过期
     * @return
     */
    public boolean isExpired() {
        return  Boolean.TRUE;
    }

    /**
     * 是否匹配token
     * @param token
     * @return
     */
    public boolean match(AuthToken token) {
        return Boolean.TRUE;
    }



}
