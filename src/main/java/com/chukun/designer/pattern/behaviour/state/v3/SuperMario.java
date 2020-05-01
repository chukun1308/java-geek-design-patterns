package com.chukun.designer.pattern.behaviour.state.v3;

import com.chukun.designer.pattern.behaviour.state.State;

public class SuperMario implements IMario {

    private static final SuperMario instance = new SuperMario();

    private SuperMario() {
    }

    public static SuperMario getInstance() {
        return instance;
    }


    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtainMushRoom(MarioStateMachineV3 stateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachineV3 stateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachineV3 stateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachineV3 stateMachine) {

    }
}
