package com.chukun.designer.pattern.proxy.v2;

import com.chukun.designer.action.statistics.v1.MetricsCollector;
import com.chukun.designer.action.statistics.v1.RequestInfo;
import com.chukun.designer.mvcddd.mvc.UserVo;

/**
 * @author chukun
 *
 *  代理模式:
 *    代理类 UserControllerProxy 和原始类 UserController02 实现相同的接口 IUserController。UserController02 类只负责业务功能。
 *    代理类 UserControllerProxy 负责在业务代码执行前后附加其他逻辑代码，并通过委托的方式调用原始类来执行业务代码
 *
 *  缺点:
 *    代码
 */
public class UserControllerProxy implements IUserController {

    private MetricsCollector metricsCollector;
    private UserController02 userController02;

    public UserControllerProxy(UserController02 userController02) {
        this.userController02 = userController02;
        this.metricsCollector = new MetricsCollector();
    }


    @Override
    public UserVo login(String telephone, String password) {

        long startTimestamp = System.currentTimeMillis();
        // 委托
        UserVo userVo = userController02.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = userController02.register(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    public static void main(String[] args) {

        //UserControllerProxy使用举例
        // 因为原始类和代理类实现相同的接口，是基于接口而非实现编程
        UserControllerProxy userControllerProxy = new UserControllerProxy(new UserController02());
    }
}
