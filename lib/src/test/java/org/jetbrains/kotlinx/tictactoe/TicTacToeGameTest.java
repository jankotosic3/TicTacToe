package org.jetbrains.kotlinx.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeGameTest {

    private Player playerX;
    private Player playerO;

    @BeforeEach
    public void setUp() {
        playerX=new RandomComputerPlayer("testX",Mark.X);
        playerO=new RandomComputerPlayer("testO", Mark.O);
    }

    @Test
    public void testInitialization(){

        TicTacToeGame game=new TicTacToeGame(playerX,playerO);

        assertEquals(playerX,game.getCurrentPlayer());
        assertEquals(playerO,game.getPlayerO());
        assertEquals(playerX,game.getPlayerX());
        assertEquals(ResultType.IN_PROGRESS,game.getGameResult().getResultType());

    }

    @Test
    public void testEmptyBoardOnStart(){

        TicTacToeGame game=new TicTacToeGame(playerX,playerO);

        for (int i = 1; i <=9 ; i++) {
            assertEquals(Mark.EMPTY,game.getBoard().getMark(new Position(i)));
        }

    }

    @Test
    public void testGameShouldEnd(){

        TicTacToeGame game=new TicTacToeGame(playerX,playerO);
        Board board=game.getBoard();
        Player currentPlayer=game.getCurrentPlayer();
        WinChecker checker= game.getWinChecker();

        int moves=0;

        while(moves<9){
            Position move=currentPlayer.chooseMove(board);
            board.placeMark(move,currentPlayer.getMark());
            moves++;

            Mark winner=checker.checkWinner(board);
            if(winner!=Mark.EMPTY){
                break;
            }

            currentPlayer= currentPlayer==playerX?playerO:playerX;

        }
        assertTrue(moves<=9);

    }

}
