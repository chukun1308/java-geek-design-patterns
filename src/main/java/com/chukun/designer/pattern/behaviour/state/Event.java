package com.chukun.designer.pattern.behaviour.state;

/**
 * @author chukun
 *   时件
 */
public enum Event {

    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3);

    private int value;

    Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
