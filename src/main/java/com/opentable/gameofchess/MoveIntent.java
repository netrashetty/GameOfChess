package com.opentable.gameofchess;

/**
 * Created by netra.shetty on 19/10/15.
 */
public enum MoveIntent {

    REGULAR_MOVE(0), CHECK(1), ENPASSANT(2), KILLPIECE(3);

    private final int value;

    private MoveIntent(int value) { this.value = value; }

    public int getValue() {
        return this.value;
    }

    public static MoveIntent findByValue(int value) {
        switch (value) {
            case 0: return REGULAR_MOVE;
            case 1: return CHECK;
            case 2: return ENPASSANT;
            case 3: return KILLPIECE;
            default: return null;
        }
    }
}
