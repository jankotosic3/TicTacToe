package org.jetbrains.kotlinx.tictactoe;

/**
 * Represents a computer player that uses the minimax algorithm to play optimally.
 * This player will never lose - it will either win or draw against any opponent.
 *
 * The minimax algorithm explores all possible future game states to determine
 * the best move by assuming both players play optimally.
 */
public class SmartComputerPlayer extends Player {

    public SmartComputerPlayer(String name, Mark mark) {
        super(name, mark);
    }

    /**
     * Chooses the optimal move using the minimax algorithm.
     * Evaluates all possible moves and selects the one that maximizes
     * this player's chances of winning while minimizing the opponent's chances.
     *
     * @param board the current board state
     * @return the optimal position to play
     */
    @Override
    public Position chooseMove(Board board) {

        int bestScore = Integer.MIN_VALUE;
        Position bestMove=null;

        for (Position position : board.getAvailablePositions()) {
            board.placeMark(position, getMark());
            int score=minimax(board,false);
            board.removeMark(position);

            if (score > bestScore) {
                bestScore = score;
                bestMove = position;
            }

        }

        System.out.println(getName()+"("+getMark()+") chooses position "+bestMove.getValue());
        return bestMove;

    }

    /**
     * Minimax algorithm implementation.
     * Recursively evaluates all possible future game states to determine
     * the value of the current board state.
     *
     * @param board the board state to evaluate
     * @param isMaximizing true if this is the AI's turn (maximizing),
     *                     false if it's the opponent's turn (minimizing)
     * @return the evaluation score: 1 for AI win, -1 for opponent win, 0 for draw
     */
    private int minimax(Board board, boolean isMaximizing) {

        WinChecker winChecker = new WinChecker();
        Mark winner =winChecker.checkWinner(board);

        //base cases
        if (winner == getMark()) return 1;
        if (winner == getOpponentMark()) return -1;
        if (board.getAvailablePositions().isEmpty()) return 0;

        int bestScore= isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (Position position : board.getAvailablePositions()) {
            board.placeMark(position, isMaximizing ? getMark() : getOpponentMark());
            int score=minimax(board,!isMaximizing);
            board.removeMark(position);

            if(isMaximizing)bestScore=Math.max(score,bestScore);
            else bestScore=Math.min(score,bestScore);

        }
        return bestScore;
    }

    /**
     * Gets the opponent's mark.
     *
     * @return O if this player is X, or X if this player is O
     */
    private Mark getOpponentMark() {
        return getMark()==Mark.X ? Mark.O : Mark.X;
    }



}
