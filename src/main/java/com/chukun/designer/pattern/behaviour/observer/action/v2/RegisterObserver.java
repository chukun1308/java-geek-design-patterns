package com.chukun.designer.pattern.behaviour.observer.action.v2;

/**
 * @author chukun
 *  观察者接口
 */
public interface RegisterObserver {

    /**
     * 定义注册成功的方法
     * @param userId
     */
    void handleRegisterSuccess(long userId);
}
