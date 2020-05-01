package com.chukun.designer.pattern.behaviour.state.v3;

import com.chukun.designer.pattern.behaviour.state.State;

public class CapeMario implements IMario {

    private static final CapeMario instance = new CapeMario();

    private CapeMario() {
    }

    public static CapeMario getInstance() {
        return instance;
    }


    @Override
    public State getName() {
        return State.CAPE;
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
