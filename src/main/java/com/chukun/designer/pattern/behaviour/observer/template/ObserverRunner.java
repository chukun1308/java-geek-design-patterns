package com.chukun.designer.pattern.behaviour.observer.template;

/**
 * @author chukun
 *  示例启动类
 */
public class ObserverRunner {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message(1,"hello observer"));
    }
}
