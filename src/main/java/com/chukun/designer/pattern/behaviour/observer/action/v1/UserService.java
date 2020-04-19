package com.chukun.designer.pattern.behaviour.observer.action.v1;

/**
 * @author chukun
 *  用户注册接口
 */
public interface UserService {

    /**
     * 注册接口
     * @param telephone
     * @param password
     * @return
     */
    long register(String telephone, String password);
}
