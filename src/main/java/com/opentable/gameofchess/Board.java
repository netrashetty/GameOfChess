package com.opentable.gameofchess;

import javafx.geometry.Pos;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by netra.shetty on 19/10/15.
 */
@Getter
@Setter
@ToString
public class Board {
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Colour turn; //whose turn is it to play next
    private List<Move> movesSoFar;
    private List<BoardSnapshot> boardSnapshotsSoFar;

    //api to execute a particular move in the game,
    public boolean move(Move m) {
        //if move made successfully return true, toggle turn
        return false;
    }

    public Board() {
        Position[][] initialState = initializeBoardPositions();
        BoardSnapshot boardSnapshot = new BoardSnapshot(initialState);

        List<BoardSnapshot> bs = new ArrayList<BoardSnapshot>();
        bs.add(boardSnapshot);

        this.boardSnapshotsSoFar = bs;
        this.movesSoFar = new ArrayList<Move>();
        this.blackPlayer = new Player(Colour.BLACK, 1.0);
        this.whitePlayer = new Player(Colour.WHITE, 1.0);
        this.turn = Colour.WHITE; //white plays first
    }

    public Position[][] initializeBoardPositions() {
        Position[][] positions = new Position[8][8];
        //1. Initialize All FREE squares
        //color of first block alternates every row
        Colour firstSquareColor;
        for (int row=2;row<6;row++) {
            if (row%2 == 0) {
                firstSquareColor = Colour.WHITE;
            } else {
                firstSquareColor = Colour.BLACK;
            }
            Colour squareColor = firstSquareColor;
            for (int col=0;col<8;col++) {
                Position emptyPosition = new Position(row,col,null,squareColor, State.FREE);
                positions[row][col] = emptyPosition;
                squareColor = Colour.findByValue((squareColor.getValue() + 1)%2);
            }
        }

        //2. Initialize All Pawns
        Colour squareColor = Colour.BLACK;
        for (int col=0; col<8;col++) {
             Piece blackPawn = new Piece(PieceType.PAWN, 6, col, Colour.BLACK);
             Position blackPawnPosition = new Position(6, col, blackPawn, squareColor, State.OCCUPIED);
             positions[6][col] = blackPawnPosition;
        }

        squareColor = Colour.WHITE;
        for (int col=0; col<8;col++) {
            Piece whitePawn = new Piece(PieceType.PAWN, 1, col, Colour.WHITE);
            Position whitePawnPosition = new Position(1, col, whitePawn, squareColor, State.OCCUPIED);
            positions[1][col] = whitePawnPosition;
        }

        //3. Initialize All Rooks
        Piece leftBlackRook = new Piece(PieceType.ROOK, 7, 0, Colour.BLACK);
        Position leftBlackRookPosition = new Position(7,0, leftBlackRook, Colour.WHITE, State.OCCUPIED);

        Piece rightBlackRook = new Piece(PieceType.ROOK, 7, 7, Colour.BLACK);
        Position rightBlackRookPosition = new Position(7,7, rightBlackRook, Colour.BLACK, State.OCCUPIED);

        Piece leftWhiteRook = new Piece(PieceType.ROOK, 0, 0, Colour.WHITE);
        Position leftWhiteRookPosition = new Position(0,0, leftWhiteRook, Colour.BLACK, State.OCCUPIED);


        Piece rightWhiteRook = new Piece(PieceType.ROOK, 0, 7, Colour.WHITE);
        Position rightWhiteRookPosition = new Position(0,7, rightWhiteRook, Colour.WHITE, State.OCCUPIED);

        positions[7][0] = leftBlackRookPosition;
        positions[7][7] = rightBlackRookPosition;
        positions[0][0] = leftWhiteRookPosition;
        positions[0][7] = rightWhiteRookPosition;

        //4. Initialize Both Queens
        Piece whiteQueen = new Piece(PieceType.QUEEN, 0, 3, Colour.WHITE);
        Position whiteQueenPositon = new Position(0,3, whiteQueen, Colour.WHITE, State.OCCUPIED);
        positions[0][3] = whiteQueenPositon;

        Piece blackQueen = new Piece(PieceType.QUEEN, 0, 3, Colour.BLACK);
        Position blackQueenPosition = new Position(7,3, blackQueen, Colour.BLACK, State.OCCUPIED);
        positions[7][3] = blackQueenPosition;

        //5. Initialize Both Kings
        Piece whiteKing = new Piece(PieceType.KING, 0,4, Colour.WHITE);
        Position whiteKingPosition = new Position(0,4, whiteKing, Colour.BLACK, State.OCCUPIED);
        positions[0][4] = whiteKingPosition;

        Piece blackKing = new Piece(PieceType.KING, 7,4, Colour.BLACK);
        Position blackKingPosition = new Position(7,4, blackKing, Colour.WHITE, State.OCCUPIED);
        positions[7][4] = blackKingPosition;


        //6. Initialize All Knights
        Piece leftWhiteKnight = new Piece(PieceType.KNIGHT, 0,2, Colour.WHITE);
        Position leftWhiteKnightPosition = new Position(0,2, leftWhiteKnight, Colour.WHITE, State.OCCUPIED);
        positions[0][2] = leftWhiteKnightPosition;

        Piece rightWhiteKnight = new Piece(PieceType.KNIGHT, 0,6, Colour.WHITE);
        Position rightWhiteKnightPosition = new Position(0,6, rightWhiteKnight, Colour.BLACK, State.OCCUPIED);
        positions[0][6] = rightWhiteKnightPosition;

        Piece leftBlackKnight = new Piece(PieceType.KNIGHT, 7,2, Colour.BLACK);
        Position leftBlackKnightPosition = new Position(7,2, leftBlackKnight, Colour.BLACK, State.OCCUPIED);
        positions[7][2] = leftBlackKnightPosition;

        Piece rightBlackKnight = new Piece(PieceType.KNIGHT, 7,6, Colour.BLACK);
        Position rightBlackKnightPosition = new Position(7,6, rightBlackKnight, Colour.WHITE, State.OCCUPIED);
        positions[7][6] = rightBlackKnightPosition;

        //7. Initialize All Bishops
        Piece leftBlackBishop = new Piece(PieceType.BISHOP, 7,3, Colour.BLACK);
        Position leftBlackBishopPosition = new Position(7,3, leftBlackBishop, Colour.WHITE, State.OCCUPIED);
        positions[7][3] = leftBlackBishopPosition;

        Piece rightBlackBishop = new Piece(PieceType.BISHOP, 7,5, Colour.BLACK);
        Position rightBlackBishopPosition = new Position(7,5, rightBlackBishop, Colour.BLACK, State.OCCUPIED);
        positions[7][5] = rightBlackBishopPosition;

        Piece leftWhiteBishop = new Piece(PieceType.BISHOP, 0,3, Colour.WHITE);
        Position leftWhiteBishopPosition = new Position(0,3, leftWhiteBishop, Colour.BLACK, State.OCCUPIED);
        positions[0][3] = leftWhiteBishopPosition;

        Piece rightWhiteBishop = new Piece(PieceType.BISHOP, 0,5, Colour.WHITE);
        Position rightWhiteBishopPosition = new Position(0,5, rightWhiteBishop, Colour.WHITE, State.OCCUPIED);
        positions[0][5] = rightBlackBishopPosition;

        //return positions
        return positions;
    }
}
