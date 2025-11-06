package org.jetbrains.kotlinx.tictactoe;

/**
 * Main game controller for Tic-Tac-Toe.
 * Manages the game loop, player turns, win checking, and game state.
 * Orchestrates the interaction between players, board, and win checker.
 */
public class TicTacToeGame {

    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;
    private final WinChecker winChecker;
    private GameResult gameResult;

    /**
     * Creates a new Tic-Tac-Toe game with two players.
     *
     * @param playerX the player using X marks (goes first)
     * @param playerO the player using O marks
     */
    public TicTacToeGame(Player playerX, Player playerO) {
        this.board = new Board();
        this.playerX = playerX;
        this.playerO = playerO;
        this.winChecker = new WinChecker();
        this.currentPlayer = playerX; // player x is always first
        this.gameResult=GameResult.inProgress();
    }

    /**
     * Starts and runs the game loop.
     * Continues until the game ends in either a win or draw.
     * Displays the board after each move and announces the result.
     */
    public void play(){
        board.printBoard();

        while(!gameResult.isGameOver()){
            Position move=currentPlayer.chooseMove(board);
            board.placeMark(move,currentPlayer.getMark());
            board.printBoard();

            updateGameResult();

            if (!gameResult.isGameOver()) {
                switchPlayer();
            }
        }
        if(gameResult.getResultType()==ResultType.WIN){
            System.out.println("Congratulations! "+ gameResult.getWinner().getName()+" You win!");
        }else System.out.println("Its a draw!");

    }

    /**
     * Switches the current player to the other player.
     */
    private void switchPlayer(){
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        }else  {
            currentPlayer = playerX;
        }
    }

    /**
     * Updates the game result based on the current board state.
     * Checks for a winner or a draw (board full with no winner).
     */
    private void updateGameResult(){
        Mark winnerMark=winChecker.checkWinner(board);
        if(winnerMark!=Mark.EMPTY){
            Player winner;
            if(winnerMark==Mark.X){
                winner=playerX;
            }else winner=playerO;
            gameResult= GameResult.win(winner);
            return;
        }

        boolean boardFull=true;
        for (int i = 1; i <= 9; i++) {
            if(board.getMark(new Position(i))==Mark.EMPTY){
                boardFull=false;
                break;
            }
        }
        if(boardFull){
            gameResult=GameResult.draw();
        }

    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public WinChecker getWinChecker() {
        return winChecker;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
