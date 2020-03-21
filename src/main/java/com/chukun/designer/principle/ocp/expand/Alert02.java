package com.chukun.designer.principle.ocp.expand;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chukun
 * 升级版本版本的alert
 */
public class Alert02 {
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }

}
