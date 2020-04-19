package com.chukun.designer.pattern.behaviour.observer.action.v1;

/**
 * @author chukun
 * 投资接口
 */
public interface PromotionService {

    /**
     * 给用户发放投资体验金
     * @param userId
     */
    void issueNewUserExperienceCash(long userId);
}
