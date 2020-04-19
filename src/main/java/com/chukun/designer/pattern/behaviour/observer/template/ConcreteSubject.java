package com.chukun.designer.pattern.behaviour.observer.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chukun
 *  被观察者实现类
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
              observer.update(message);
        }
    }
}
