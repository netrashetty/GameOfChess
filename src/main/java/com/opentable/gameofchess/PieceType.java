package com.opentable.gameofchess;

/**
 * Created by netra.shetty on 19/10/15.
 */
public enum PieceType {
    ROOK(0),
    PAWN(1),
    QUEEN(2),
    KING(3),
    BISHOP(4),
    KNIGHT(5);

    private final int value;

    private PieceType(int value) { this.value = value; }

    public int getValue() {
        return this.value;
    }

    public static PieceType findByValue(int value) {
        switch (value) {
            case 0: return ROOK;
            case 1: return PAWN;
            case 2: return QUEEN;
            case 3: return KING;
            case 4: return BISHOP;
            case 5: return KNIGHT;
            default: return null;
        }
    }
}
