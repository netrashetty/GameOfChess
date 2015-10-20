package com.opentable.gameofchess;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.ToString;
/**
 * Created by netra.shetty on 19/10/15.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Position {
    private final int row,column; //indicates position on file and rank
    private Piece curPieceOccupyingPosition;
    private Colour colourofSquare;
    private State state;
}
