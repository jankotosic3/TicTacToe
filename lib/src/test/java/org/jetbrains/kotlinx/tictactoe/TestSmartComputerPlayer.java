package org.jetbrains.kotlinx.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSmartComputerPlayer {

    private SmartComputerPlayer player;
    private Board board;

    @BeforeEach
    public void setUp() {
        player=new SmartComputerPlayer("Test",Mark.X);
        board=new Board();
    }

    @Test
    public void testChooseWinningMove(){
        board.placeMark(new Position(1),Mark.X);
        board.placeMark(new Position(2),Mark.X);
        board.placeMark(new Position(4),Mark.O);
        board.placeMark(new Position(5),Mark.O);

        Position choice=player.chooseMove(board);
        assertEquals(3, choice.getValue());
    }
    @Test
    public void testBlockOpponentWinningMove(){
        board.placeMark(new Position(1),Mark.X);
        board.placeMark(new Position(4),Mark.O);
        board.placeMark(new Position(5),Mark.O);

        Position choice=player.chooseMove(board);
        assertEquals(6, choice.getValue());
    }



}
