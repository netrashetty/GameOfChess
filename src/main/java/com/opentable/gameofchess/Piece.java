package com.opentable.gameofchess;

/**
 * Created by netra.shetty on 19/10/15.
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Piece {
    private final PieceType pieceType;
    //Required?
    private int currentPositionX;
    private int currentPostionY;
    private final Colour colour;

    //Given a position and piece at that position, this method returns a set of possible moves that the piece can make
    private List<Move> possibleMoves(Position position) {
        List<Move> moves = new ArrayList<Move>();
        //code to find possible moves for given pieceType, position
        return moves;
    }
}
