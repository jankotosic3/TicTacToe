package org.jetbrains.kotlinx.tictactoe;

/**
 * Represents the possible outcomes of tic tac toe game
 */
public enum ResultType {
    /**
     * One player has won the game
     */
    WIN,
    /**
     * The game ended in a draw (the board is full and there is no winner)
     */
    DRAW,
    /**
     * The game is still ongoing
     */
    IN_PROGRESS;
}
