package com.chukun.designer.pattern.structure.bridge.v2;

import java.util.List;

public class WechatMsgSender implements MessageSender {

    private List<String> wechatIds;

    public WechatMsgSender(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }

    @Override
    public void send(String message) {
       // 省略发微信的逻辑
    }
}
