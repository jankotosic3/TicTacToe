package org.jetbrains.kotlinx.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class WinCheckerTest {

    private Board board;
    private WinChecker winChecker;

    @BeforeEach
    public void setUp() {
        board = new Board();
        winChecker = new WinChecker();
    }

    @Test
    public void testRow(){
        board.placeMark(new Position(1),Mark.X);
        board.placeMark(new Position(2),Mark.X);
        board.placeMark(new Position(3),Mark.X);

        assertEquals(Mark.X, winChecker.checkWinner(board));
    }

    @Test
    public void testColumn(){
        board.placeMark(new Position(1),Mark.X);
        board.placeMark(new Position(4),Mark.X);
        board.placeMark(new Position(7),Mark.X);
        assertEquals(Mark.X, winChecker.checkWinner(board));
    }

    @Test
    public void testDiagonal(){
        board.placeMark(new Position(1),Mark.X);
        board.placeMark(new Position(5),Mark.X);
        board.placeMark(new Position(9),Mark.X);
        assertEquals(Mark.X, winChecker.checkWinner(board));
    }

    @Test
    public void testDiagonal2(){
        board.placeMark(new Position(3),Mark.X);
        board.placeMark(new Position(5),Mark.X);
        board.placeMark(new Position(7),Mark.X);
        assertEquals(Mark.X, winChecker.checkWinner(board));
    }

    @Test
    public void testRowIncomplete(){
        board.placeMark(new Position(1),Mark.X);
        board.placeMark(new Position(2),Mark.X);

        assertEquals(Mark.EMPTY, winChecker.checkWinner(board));
    }

    @Test
    public void testColumnIncomplete(){
        board.placeMark(new Position(1),Mark.X);
        board.placeMark(new Position(4),Mark.X);

        assertEquals(Mark.EMPTY, winChecker.checkWinner(board));
    }

    @Test
    public void testDiagonalIncomplete(){
        board.placeMark(new Position(1),Mark.X);
        board.placeMark(new Position(5),Mark.X);
        assertEquals(Mark.EMPTY, winChecker.checkWinner(board));
    }

}
