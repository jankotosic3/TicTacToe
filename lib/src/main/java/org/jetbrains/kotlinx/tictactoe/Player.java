package org.jetbrains.kotlinx.tictactoe;

/**
 * Abstract base class for all player types in Tic-Tac-Toe.
 * A player has a name, a mark (X or O), and must implement
 * a strategy for choosing moves.
 *
 * Subclasses include HumanPlayer, RandomComputerPlayer, and SmartComputerPlayer.
 */
public abstract class Player {

    private final String name;
    private final Mark mark;

    /**
     * Creates a new player.
     *
     * @param name the player's name
     * @param mark the player's mark (X or O)
     * @throws IllegalArgumentException if mark is EMPTY
     */
    public Player(String name, Mark mark) {
        if (mark == Mark.EMPTY) {
            throw new IllegalArgumentException("Player mark cant empty");
        }
        this.name = name;
        this.mark = mark;
    }

    /**
     * Gets the player's name.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's mark.
     *
     * @return the player's mark (X or O)
     */
    public Mark getMark() {
        return mark;
    }

    /**
     * Chooses a move for this player given the current board state.
     * This method must be implemented by subclasses to define the
     * player's strategy (human input, random, AI, etc.).
     *
     * @param board the current board state
     * @return the position where the player wants to place their mark
     */
    public abstract Position chooseMove(Board board);

    /**
     * Returns a string representation of the player.
     *
     * @return player name and mark in format "Name (Mark)"
     */
    @Override
    public String toString() {
        return name + " (" + mark + ")";
    }
}
