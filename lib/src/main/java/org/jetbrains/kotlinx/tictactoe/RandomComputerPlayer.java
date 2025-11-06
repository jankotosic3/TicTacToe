package org.jetbrains.kotlinx.tictactoe;

import java.util.List;
import java.util.Random;

/**
 * Represents a computer player that chooses moves randomly.
 * Selects a random position from the available empty positions on the board.
 */
public class RandomComputerPlayer extends Player {

    private final Random random;

    /**
     * Creates a new random computer player.
     *
     * @param name the player's name
     * @param mark the player's mark (X or O)
     */
    public RandomComputerPlayer(String name, Mark mark) {
        super(name, mark);
        this.random = new Random();
    }

    /**
     * Chooses a random available position on the board.
     *
     * @param board the current board state
     * @return a randomly selected available position
     */
    @Override
    public Position chooseMove(Board board) {
        List<Position> avaliablePositions = board.getAvailablePositions();
        Position choice=avaliablePositions.get(random.nextInt(avaliablePositions.size()));

        System.out.println(getName()+"("+getMark()+") chooses position "+choice.getValue());
        return choice;
    }
}
