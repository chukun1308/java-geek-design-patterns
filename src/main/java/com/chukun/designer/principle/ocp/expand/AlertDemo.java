package com.chukun.designer.principle.ocp.expand;

/**
 * @author chukun
 *
 */
public class AlertDemo {

    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo("api",10,20,10);
        // 中间处理逻辑省略......
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}
