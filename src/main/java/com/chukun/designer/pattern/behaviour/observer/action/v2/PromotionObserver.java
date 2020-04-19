package com.chukun.designer.pattern.behaviour.observer.action.v2;

import com.chukun.designer.pattern.behaviour.observer.action.v1.PromotionService;

/**
 * @author chukun
 * 发放体检金的观察者
 */
public class PromotionObserver implements RegisterObserver {

    private PromotionService promotionService;

    @Override
    public void handleRegisterSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
