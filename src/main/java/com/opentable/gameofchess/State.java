package com.opentable.gameofchess;

/**
 * Created by netra.shetty on 19/10/15.
 */
public enum State {
    OCCUPIED(0), FREE(1);

    private final int value;

    private State(int value) { this.value = value; }

    public int getValue() {
        return this.value;
    }

    public static State findByValue(int value) {
        switch (value) {
            case 0: return OCCUPIED;
            case 1: return FREE;
            default: return null;
        }
    }
}
