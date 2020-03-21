package com.chukun.designer.oop;

/**
 * @author chukun
 * 获取密码的接口
 */
public interface CredentialStorage {

    String getPasswordByAppId(String appId);
}
