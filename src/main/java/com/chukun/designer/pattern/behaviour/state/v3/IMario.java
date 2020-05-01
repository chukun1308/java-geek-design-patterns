package com.chukun.designer.pattern.behaviour.state.v3;

import com.chukun.designer.pattern.behaviour.state.State;

public interface IMario {

    State getName();

    /**
     * 拿到蘑菇之后的操作
     * @param stateMachine
     */
    void obtainMushRoom(MarioStateMachineV3 stateMachine);

    /**
     * 拿到斗篷之后的操作
     * @param stateMachine
     */
    void obtainCape(MarioStateMachineV3 stateMachine);

    /**
     * 拿到火焰之后的操作
     * @param stateMachine
     */
    void obtainFireFlower(MarioStateMachineV3 stateMachine);

    /**
     * 遇到怪物之后的操作
     * @param stateMachine
     */
    void meetMonster(MarioStateMachineV3 stateMachine);
}
