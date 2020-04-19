package com.chukun.designer.principle.ocp.expand;

import com.chukun.designer.principle.ocp.simple.AlertRule;
import com.chukun.designer.principle.ocp.simple.Notification;

import java.util.ArrayList;

/**
 * @author chukun
 */
public class ApplicationContext {

    private AlertRule alertRule;
    private Notification notification;
    private Alert02 alert02;

    public void initializeBeans() {
        alertRule = new AlertRule();
        notification = new Notification.NotificationBuilder()
                .setWechatIds(new ArrayList<>())
                .setTelephones(new ArrayList<>())
        .setEmailAddresses(new ArrayList<>())
        .builder();
        alert02 = new Alert02();
        alert02.addAlertHandler(new TpsAlertHandler(alertRule,notification));
        alert02.addAlertHandler(new TpsAlertHandler(alertRule,notification));
        // 添加timeout相关的处理器
        alert02.addAlertHandler(new TimeoutAlertHandler(alertRule,notification));
    }

    public Alert02 getAlert() {
        return alert02;
    }

    private ApplicationContext() {
        throw new RuntimeException("singleton is not allow initialized....");
    }

    public static ApplicationContext getInstance(){
        return ApplicationContext.getInstance();
    }

    /**
     * 单例对象holder类
     */
    private static class ApplicationContextHolder {
        private static  final ApplicationContext applicationContext = new ApplicationContext();

        public static ApplicationContext getInstance() {
            return applicationContext;
        }
    }
}
