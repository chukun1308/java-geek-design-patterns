package com.chukun.designer.pattern.bridge.v2;

import java.util.List;

/**
 * @author
 *  Notification 类中的三个成员变量通过 set 方法来设置，但是这样的代码实现存在一个明显的问题，
 *  那就是 telephones中的数据有可能在 Notification 类外部被修改
 */
public class TelephoneMsgSender implements MessageSender {

    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
       // 省略打电话的逻辑
    }
}
