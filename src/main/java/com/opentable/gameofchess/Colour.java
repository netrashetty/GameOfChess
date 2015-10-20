package com.opentable.gameofchess;

/**
 * Created by netra.shetty on 19/10/15.
 */
public enum Colour {
    WHITE(0), BLACK(1);

    private final int value;

    private Colour(int value) { this.value = value; }

    public int getValue() {
        return this.value;
    }

    public static Colour findByValue(int value) {
        switch (value) {
            case 0: return WHITE;
            case 1: return BLACK;
            default: return null;
        }
    }
}
