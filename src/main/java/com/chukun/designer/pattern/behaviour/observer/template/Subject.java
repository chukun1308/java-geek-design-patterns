package com.chukun.designer.pattern.behaviour.observer.template;

/**
 * @author chukun
 *  被观察者接口
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Message message);
}
