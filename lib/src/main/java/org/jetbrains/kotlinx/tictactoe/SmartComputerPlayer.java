package org.jetbrains.kotlinx.tictactoe;

public class SmartComputerPlayer extends Player {

    public SmartComputerPlayer(String name, Mark mark) {
        super(name, mark);
    }

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

    private int minimax(Board board, boolean isMaximizing) {

        WinChecker winChecker = new WinChecker();
        Mark winner =winChecker.checkWinner(board);

        //base cases
        if (winner == getMark()) return 1;
        if (winner == getOppeonentMark()) return -1;
        if (board.getAvailablePositions().isEmpty()) return 0;

        int bestScore= isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (Position position : board.getAvailablePositions()) {
            board.placeMark(position, isMaximizing ? getMark() : getOppeonentMark());
            int score=minimax(board,!isMaximizing);
            board.removeMark(position);

            if(isMaximizing)bestScore=Math.max(score,bestScore);
            else bestScore=Math.min(score,bestScore);

        }
        return bestScore;
    }


    private Mark getOpponentMark() {
        return getMark() == Mark.X ? Mark.O : Mark.X;
    }


    private Mark getOppeonentMark() {
        return getMark()==Mark.X ? Mark.O : Mark.X;
    }

}
