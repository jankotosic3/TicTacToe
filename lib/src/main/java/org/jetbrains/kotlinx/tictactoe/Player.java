package org.jetbrains.kotlinx.tictactoe;

import com.sun.jdi.event.StepEvent;

public abstract class Player {

    private final String name;
    private final Mark mark;

    public Player(String name, Mark mark) {
        if (mark == Mark.EMPTY) {
            throw new IllegalArgumentException("Player mark cant empty");
        }
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public Mark getMark() {
        return mark;
    }

    public abstract Position chooseMove(Board board);

    @Override
    public String toString() {
        return name + " (" + mark + ")";
    }
}
