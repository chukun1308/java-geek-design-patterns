package com.chukun.designer.pattern.proxy.v3;

import com.chukun.designer.action.statistics.v1.MetricsCollector;
import com.chukun.designer.action.statistics.v1.RequestInfo;
import com.chukun.designer.pattern.proxy.UserController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chukun
 *   动态代理（Dynamic Proxy），就是不事先为每个原始类编写代理类，而是在运行的时候，
 *   动态地创建原始类对应的代理类，然后在系统中用代理类替换掉原始类
 */
public class MetricsCollectorProxy {

    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    /**
     * 动态代理类
     */
    private class DynamicProxyHandler implements InvocationHandler {

        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();
            Object invoke = method.invoke(proxiedObject, args);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);
            return invoke;
        }
    }

    public static void main(String[] args) {
        // 创建代理类
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        // 使用代理方法
        Object result = proxy.createProxy(new UserController());
    }
}


