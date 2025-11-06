package org.jetbrains.kotlinx.tictactoe;

public class GameResult {

    private final ResultType resultType;
    private final Player winner;

    public GameResult(ResultType resultType, Player winner) {
        this.resultType = resultType;
        this.winner = winner;
    }

    public static GameResult win(Player winner) {
        return new GameResult(ResultType.WIN, winner);
    }

    public static GameResult draw() {
        return new GameResult(ResultType.DRAW, null);
    }

    public static GameResult inProgress() {
        return new GameResult(ResultType.IN_PROGRESS, null);
    }
    public boolean isGameOver() {
        return resultType != ResultType.IN_PROGRESS;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public Player getWinner() {
        return winner;
    }
}
