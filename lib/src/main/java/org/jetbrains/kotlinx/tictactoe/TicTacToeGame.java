package org.jetbrains.kotlinx.tictactoe;

public class TicTacToeGame {

    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;
    private final WinChecker winChecker;
    private GameResult gameResult;

    public TicTacToeGame(Player playerX, Player playerO) {
        this.board = new Board();
        this.playerX = playerX;
        this.playerO = playerO;
        this.winChecker = new WinChecker();
        this.currentPlayer = playerX; // player x is always first
        this.gameResult=GameResult.inProgress();
    }

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
            System.out.println("Congratulations!"+ gameResult.getWinner().getName()+"You win!");
        }else System.out.println("Its a draw!");

    }

    private void switchPlayer(){
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        }else  {
            currentPlayer = playerX;
        }
    }

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
        for (int i = 0; i < 3; i++) {
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
