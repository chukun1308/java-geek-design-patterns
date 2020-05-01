package com.chukun.designer.pattern.behaviour.state.v2;

import com.chukun.designer.pattern.behaviour.state.Event;
import com.chukun.designer.pattern.behaviour.state.State;

/**
 * @author chukun
 * 查表法，实现状态机
 * <p>
 * 状态机的第二种实现方式查表法，就更加合适了
 * <p>
 * 相对于分支逻辑的实现方式，查表法的代码实现更加清晰，可读性和可维护性更好。当修改状态机时，
 * 只需要修改 transitionTable 和 actionTable 两个二维数组即可。
 * 实际上，如果把这两个二维数组存储在配置文件中，当需要修改状态机时，甚至可以不修改任何代码，只需要修改配置文件就可以了
 */
public class MarioStateMachineV2 {

    private int score;
    private State currentState;


    /**
     * 基于转化表的解释
     *
     *   SMALL --> State.SUPER  +100  SMALL --> State.CAPE  +200  SMALL --> State.FIRE  +300  SMALL --> State.SMALL  +0
     *   SUPER --> State.SUPER  +0    SUPER --> State.CAPE  +200  SUPER --> State.FIRE  +300  SUPER --> State.SMALL  -100
     *   CAPE -->  State.CAPE   +0    CAPE --> State.CAPE   +0    CAPE --> State.CAPE    +0   CAPE --> State.SMALL  -200
     *   FIRE --> State.FIRE    +0  FIRE --> State.FIRE   +0  FIRE --> State.FIRE    +0  FIRE --> State.SMALL -300
     *
     *   其他的状态，转换不了
     */


    /**
     * 状态转移表
     */
    private static final State[][] transitionTable = {
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.CAPE, State.CAPE, State.CAPE, State.SMALL},
            {State.FIRE, State.FIRE, State.FIRE, State.SMALL}
    };

    /**
     *得分表
     */
    private static final int[][] actionTable = {
            {+100, +200, +300, +0},
            {+0, +200, +300, -100},
            {+0, +0, +0, -200},
            {+0, +0, +0, -300}
    };

    public MarioStateMachineV2() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    /**
     * 吃到蘑菇
     */
    public void obtainMushRoom() {
       executeEvent(Event.GOT_MUSHROOM);
    }

    /**
     * 拿到斗篷
     */
    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    /**
     * 吃到火焰
     */
    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }

    /**
     * 遇到怪物
     */
    public void meetMonster() {
        executeEvent(Event.MET_MONSTER);
    }

    /**
     * 根据时间，与当前的状态，更新状态与得分
     * @param event
     */
    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = transitionTable[stateValue][eventValue];
        this.score += actionTable[stateValue][eventValue];
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }


    public static void main(String[] args) {

        MarioStateMachineV2 marioStateMachine = new MarioStateMachineV2();
        marioStateMachine.obtainMushRoom();

        System.out.println("marioStateMachine score : " + marioStateMachine.getScore() + ", current state : " + marioStateMachine.getCurrentState());
    }
}
