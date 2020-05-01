package com.chukun.designer.pattern.behaviour.state.v1;

import com.chukun.designer.pattern.behaviour.state.State;

/**
 * @author chukun
 *  分支逻辑法，实现状态机
 *
 *  对于简单的状态机来说，分支逻辑这种实现方式是可以接受的。但是，对于复杂的状态机来说，这种实现方式极易漏写或者错写某个状态转移。
 *  除此之外，代码中充斥着大量的 if-else 或者 switch-case 分支判断逻辑，可读性和可维护性都很差。
 */
public class MarioStateMachineV1 {

    private int score;
    private State currentState;

    public MarioStateMachineV1() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    /**
     * 吃到蘑菇
     */
    public void obtainMushRoom() {
        //TODO
        if (currentState.equals(State.SMALL)) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }

    /**
     * 拿到斗篷
     */
    public void obtainCape() {
        //TODO
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }

    /**
     * 吃到火焰
     */
    public void obtainFireFlower() {
        //TODO
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }

    /**
     * 遇到怪物
     */
    public void meetMonster() {
        //TODO
        if (currentState.equals(State.SUPER)) {
            this.currentState = State.SMALL;
            this.score -= 100;
        }
        if (currentState.equals(State.CAPE)) {
            this.currentState = State.SMALL;
            this.score -= 200;
        }
        if (currentState.equals(State.FIRE)) {
            this.currentState = State.SMALL;
            this.score -= 300;
        } else {
            this.currentState = State.DEAD;
            this.score = 0;
        }
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }


    public static void main(String[] args) {

        MarioStateMachineV1 marioStateMachine = new MarioStateMachineV1();
        marioStateMachine.obtainMushRoom();

        System.out.println("marioStateMachine score : " + marioStateMachine.getScore() + ", current state : " + marioStateMachine.getCurrentState());
    }
}
