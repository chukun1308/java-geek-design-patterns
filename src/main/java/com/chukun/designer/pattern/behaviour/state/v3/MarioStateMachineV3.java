package com.chukun.designer.pattern.behaviour.state.v3;


/**
 * @author chukun
 *  状态模式，实现状态机
 *
 *      在查表法的代码实现中，事件触发的动作只是简单的积分加减，所以，我们用一个 int 类型的二维数组 actionTable 就能表示，
 *  二维数组中的值表示积分的加减值。但是，如果要执行的动作并非这么简单，
 *  而是一系列复杂的逻辑操作（比如加减积分、写数据库，还有可能发送消息通知等等），就没法用如此简单的二维数组来表示了
 */
public class MarioStateMachineV3 {

    private int score;
    private IMario currentState;

    public MarioStateMachineV3() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public IMario getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }

    public void meetMonster() {
        this.currentState.meetMonster(this);
    }
}
