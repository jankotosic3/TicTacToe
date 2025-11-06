package org.jetbrains.kotlinx.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameResultTest {

    @Test
    public void testWinResult(){
        Player player=new HumanPlayer("Winner",Mark.X);
        GameResult result =GameResult.win(player);

        assertEquals(ResultType.WIN,result.getResultType());
        assertEquals(player,result.getWinner());
        assertTrue(result.isGameOver());

    }

    @Test
    public void testDrawResult(){

        GameResult result =GameResult.draw();

        assertEquals(ResultType.DRAW,result.getResultType());
        assertNull(result.getWinner());
        assertTrue(result.isGameOver());

    }

    @Test
    public void testInProgressResult(){

        GameResult result =GameResult.inProgress();

        assertEquals(ResultType.IN_PROGRESS,result.getResultType());
        assertNull(result.getWinner());
        assertFalse(result.isGameOver());

    }

}
