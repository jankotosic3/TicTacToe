package org.jetbrains.kotlinx.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomComputerPlayerTest {

    private RandomComputerPlayer player;
    private Board board;

    @BeforeEach
    public void setUp() {
        player=new RandomComputerPlayer("Test",Mark.X);
        board=new Board();
    }

    @Test
    public void testChooseValidPosition() {

        Position choice=player.chooseMove(board);

        assertNotNull(choice);
        assertTrue(choice.getValue()>=0 && choice.getValue()<=9);
        assertEquals(Mark.EMPTY,board.getMark(choice));

    }

    @Test
    public void testChooseAvailablePosition() {
        for(int i=1;i<=9;i++) {
            if (i!=5)board.placeMark(new Position(i),Mark.X);
        }
        Position choice=player.chooseMove(board);
        assertNotNull(choice);
        assertEquals(Mark.EMPTY,board.getMark(choice));
    }

}
