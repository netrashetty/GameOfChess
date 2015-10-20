package com.opentable.gameofchess;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Created by netra.shetty on 19/10/15.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Move {
    private final Piece piece;
    private final Position fromPosition;
    private final Position toPosition;
    //indicates the intent of the move, could be used for regular or special moves
    //check/enpassant/killPiece cases
    private final MoveIntent moveIntent;

    /**
     * Validates the move according to the given board snapshot
     * @param BoardSnapshot
     * @return boolean
     */
    public boolean isValidMove(BoardSnapshot boardSnapshot) {
        switch (piece.getPieceType()) {
            case ROOK: return isValidRookMove(boardSnapshot);
            case PAWN: return isValidPawnMove(boardSnapshot);
            case QUEEN: return isValidQueenMove(boardSnapshot);
            case KING: return isValidKingMove(boardSnapshot);
            case BISHOP: return isValidBishopMove(boardSnapshot);
            case KNIGHT: return isValidKnightMove(boardSnapshot);
            default: return false;
        }
    }

    public boolean isValidRookMove(BoardSnapshot boardSnapshot) {
        boolean isValidMove = false;
        return isValidMove;
    }

    public boolean isValidPawnMove(BoardSnapshot boardSnapshot) {
        boolean isValidMove = false;
        //a pawn move is valid in following cases
        //1. nextposrow, nextpostcol = curposrow +/- 1, curposcol AND State.FREE
        //2. nextposrow, nextposcol = curposrow +/- 1, curposcol +/- 1 AND State.OCCUPIED
        //3. enpassant ; skipping this check as discussed, boardSnapshot is useful for finding enpassant
        if (toPosition.getState() == State.FREE) {
            if (piece.getColour() == Colour.BLACK) {
                if (toPosition.getColumn() == fromPosition.getColumn() &&
                        toPosition.getRow() == (fromPosition.getRow() - 1)) {
                    isValidMove = true;
                }
            } else {
                if (toPosition.getColumn() == fromPosition.getColumn() &&
                        toPosition.getRow() == (fromPosition.getRow() + 1)) {
                    isValidMove = true;
                }
            }
        } else {
            if (piece.getColour() == Colour.BLACK) {
                if (fromPosition.getRow() != 0 && toPosition.getRow() == (fromPosition.getRow() - 1)) {
                    if (fromPosition.getColumn() !=0 && toPosition.getColumn() == (fromPosition.getColumn()-1)) {
                        isValidMove = true;
                    }
                    if (fromPosition.getColumn() !=7 && toPosition.getColumn() == (fromPosition.getColumn()+1)) {
                        isValidMove = true;
                    }
                }
            } else {
                if (fromPosition.getRow() != 7 && toPosition.getRow() == (fromPosition.getRow() + 1)) {
                    if (fromPosition.getColumn() !=0 && toPosition.getColumn() == (fromPosition.getColumn()-1)) {
                        isValidMove = true;
                    }
                    if (fromPosition.getColumn() !=7 && toPosition.getColumn() == (fromPosition.getColumn()+1)) {
                        isValidMove = true;
                    }
                }
            }
        }
        return isValidMove;
    }

    public boolean isValidKingMove(BoardSnapshot boardSnapshot) {
        boolean isValidMove = false;
        return isValidMove;
    }

    public boolean isValidQueenMove(BoardSnapshot boardSnapshot) {
        boolean isValidMove = false;
        return isValidMove;
    }

    public boolean isValidBishopMove(BoardSnapshot boardSnapshot) {
        boolean isValidMove = false;
        return isValidMove;
    }

    public boolean isValidKnightMove(BoardSnapshot boardSnapshot) {
        boolean isValidMove = false;
        return isValidMove;
    }
}
