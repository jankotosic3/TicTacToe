package org.jetbrains.kotlinx.tictactoe;

import java.util.List;
import java.util.Random;

public class RandomComputerPlayer extends Player {

    private final Random random;

    public RandomComputerPlayer(String name, Mark mark) {
        super(name, mark);
        this.random = new Random();
    }

    @Override
    public Position chooseMove(Board board) {
        List<Position> avaliablePositions = board.getAvailablePositions();
        Position choice=avaliablePositions.get(random.nextInt(avaliablePositions.size()));

        System.out.println(getName()+"("+getMark()+") chooses position "+choice.getValue());
        return choice;
    }
}
