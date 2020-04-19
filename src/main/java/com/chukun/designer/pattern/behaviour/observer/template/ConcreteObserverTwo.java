package com.chukun.designer.pattern.behaviour.observer.template;

/**
 * @author chukun
 *  观察者实现类
 */
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverTwo reserved message : "+message);
        System.out.println("ConcreteObserverTwo is notified.");
    }
}
