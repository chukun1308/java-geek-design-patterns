package com.chukun.designer.pattern.behaviour.state;

/**
 * @author chukun
 * εη§ηΆζ
 */
public enum State {

    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3),
    DEAD(4);

    private int value;

    State(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
