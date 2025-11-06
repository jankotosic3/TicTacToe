package org.jetbrains.kotlinx.tictactoe;

/**
 * Represents the result of a Tic-Tac-Toe game.
 * Encapsulates both the type of result (win/draw/in-progress) and
 * the winner (if applicable).
 */
public class GameResult {

    private final ResultType resultType;
    private final Player winner;

    /**
     * Creates a new game result.
     *
     * @param resultType the type of result
     * @param winner the winning player (null if draw or in progress)
     */
    public GameResult(ResultType resultType, Player winner) {
        this.resultType = resultType;
        this.winner = winner;
    }

    /**
     * Factory method to create a win result.
     *
     * @param winner the player who won
     * @return a GameResult representing a win
     */
    public static GameResult win(Player winner) {
        return new GameResult(ResultType.WIN, winner);
    }

    /**
     * Factory method to create a draw result.
     *
     * @return a GameResult representing a draw
     */
    public static GameResult draw() {
        return new GameResult(ResultType.DRAW, null);
    }

    /**
     * Factory method to create an in-progress result.
     *
     * @return a GameResult representing a game still in progress
     */
    public static GameResult inProgress() {
        return new GameResult(ResultType.IN_PROGRESS, null);
    }

    /**
     * Checks if the game has ended (either win or draw).
     *
     * @return true if the game is over, false if still in progress
     */
    public boolean isGameOver() {
        return resultType != ResultType.IN_PROGRESS;
    }

    /**
     * Gets the type of result.
     *
     * @return the result type
     */
    public ResultType getResultType() {
        return resultType;
    }

    /**
     * Gets the winning player.
     *
     * @return the winner, or null if the game is a draw or still in progress
     */
    public Player getWinner() {
        return winner;
    }
}
