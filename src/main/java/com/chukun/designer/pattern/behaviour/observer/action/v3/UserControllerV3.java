package com.chukun.designer.pattern.behaviour.observer.action.v3;

import com.chukun.designer.pattern.behaviour.observer.action.v1.UserService;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author chukun
 * <p>
 * <p>
 * EventBus 翻译为“事件总线”，它提供了实现观察者模式的骨架代码。
 * 可以基于此框架，非常容易地在业务场景中实现观察者模式，不需要从零开始开发。
 * 其中，Google Guava EventBus 就是一个比较著名的 EventBus 框架，
 * 它不仅仅支持异步非阻塞模式，同时也支持同步阻塞模式
 */
public class UserControllerV3 {

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    private EventBus eventBus;
    private UserService userService;

    public UserControllerV3() {
        //eventBus = new EventBus(); // 同步阻塞模式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            // EventBus 类提供了 register() 函数用来注册观察者
            // unregister() 函数 unregister() 函数用来从 EventBus 中删除某个观察者
            eventBus.register(observer);
        }
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        long userId = userService.register(telephone, password);
        // EventBus 中的 post() 函数）来给 Observer 发送消息（在 EventBus 中消息被称作事件 event）
        //调用 post() 函数发送消息的时候，并非把消息发送给所有的观察者，而是发送给可匹配的观察者。
        // 所谓可匹配指的是，能接收的消息类型是发送消息（post 函数定义中的 event）类型的父类
        eventBus.post(userId);
        return userId;
    }
}
