package com.chukun.designer.pattern.behaviour.state.v3;

import com.chukun.designer.pattern.behaviour.state.State;

public class FireMario implements IMario {

    private static final FireMario instance = new FireMario();

    private FireMario() {
    }

    public static FireMario getInstance() {
        return instance;
    }


    @Override
    public State getName() {
        return State.FIRE;
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
