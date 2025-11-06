package org.jetbrains.kotlinx.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {

    private Board board;

    @BeforeEach
    void setup(){
        board = new Board();
    }

    @Test
    public void testInitialisation(){
        for (int i = 1; i <=9; i++) {
            assertEquals(Mark.EMPTY, board.getMark(new Position(i)));
        }
    }

    @Test
    public void testPlaceMark(){
        Position position = new Position(5);
        board.placeMark(position,Mark.X);
        assertEquals(Mark.X, board.getMark(position));
    }

    @Test
    public void testPlaceMarkOnOccupiedPosition(){
        Position position = new Position(5);
        board.placeMark(position,Mark.X);
        assertThrows(IllegalStateException.class, () -> board.placeMark(position,Mark.X));
    }

    @Test
    public void testRemoveMark(){
        Position position = new Position(5);
        board.placeMark(position,Mark.X);
        assertEquals(Mark.X, board.getMark(position));
        board.removeMark(position);
        assertEquals(Mark.EMPTY, board.getMark(position));
    }

    @Test
    public void testGetAvaliblePositions(){
        assertEquals(9,board.getAvailablePositions().size());
    }

    @Test
    public void testGetAvaliblePositionsAfterMoves(){
        assertEquals(9,board.getAvailablePositions().size());

        board.placeMark(new Position(1),Mark.X);
        board.placeMark(new Position(2),Mark.X);
        board.placeMark(new Position(3),Mark.X);

        assertEquals(6,board.getAvailablePositions().size());
        assertFalse(board.getAvailablePositions().contains(new Position(1)));
        assertFalse(board.getAvailablePositions().contains(new Position(2)));
        assertFalse(board.getAvailablePositions().contains(new Position(3)));

    }

}
