package com.chukun.designer.pattern.behaviour.observer.action.v2;

import com.chukun.designer.pattern.behaviour.observer.action.v1.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chukun
 *   对于注册接口频繁改动，所以升级注册接口，使用观察者模式
 *
 *  说明:
 *      当需要添加新的观察者的时候，比如，用户注册成功之后，推送用户注册信息给大数据征信系统，
 *   基于观察者模式的代码实现，UserControllerV2 类的 register() 函数完全不需要修改，
 *   只需要再添加一个实现了 RegisterObserver 接口的类，并且通过 setRegObservers() 函数将它注册到 UserControllerV2 类中即可
 *
 *   缺点:
 *     它是一种同步阻塞的实现方式。观察者和被观察者代码在同一个线程内执行，
 *     被观察者一直阻塞，直到所有的观察者代码都执行完成之后，才执行后续的代码。
 *     对照上面讲到的用户注册的例子，register() 函数依次调用执行每个观察者的 handleRegisterSuccess() 函数，
 *     等到都执行完成之后，才会返回结果给客户端。如果注册接口是一个调用比较频繁的接口，对性能非常敏感，希望接口的响应时间尽可能短，
 *     那可以将同步阻塞的实现方式改为异步非阻塞的实现方式，以此来减少响应时间.
 *
 *     那如何实现一个异步非阻塞的观察者模式呢？
 *     简单一点的做法是，在每个 handleRegisterSuccess() 函数中，创建一个新的线程执行代码。
 *     不过，还有更加优雅的实现方式，那就是基于 EventBus 来实现.详见v3版本，使用EventBus实现异步调用。
 */
public class UserControllerV2 {

    private UserService userService;

    private List<RegisterObserver> registerObservers = new ArrayList<>();

    public void setObservers(List<RegisterObserver> observers) {
        registerObservers.addAll(observers);
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        long userId = userService.register(telephone, password);
        for (RegisterObserver observer : registerObservers) {
            observer.handleRegisterSuccess(userId);
        }
        return userId;
    }
}
