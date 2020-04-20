package com.chukun.designer.pattern.behaviour.observer.action.v3;

import com.chukun.designer.pattern.behaviour.observer.action.v1.PromotionService;
import com.chukun.designer.pattern.behaviour.observer.action.v2.RegisterObserver;
import com.google.common.eventbus.Subscribe;

public class RegPromotionObserver implements RegisterObserver {

    private PromotionService promotionService;

    @Subscribe
    @Override
    public void handleRegisterSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
