package org.jetbrains.kotlinx.tictactoe;

public class Position {

    // positions can be a number from 1 to 9, 1 being the top left and 9 being the bottom right
    // 1 2 3
    // 4 5 6
    // 7 8 9

    private final int value;


    public Position(int value) {
        if (value < 0 || value>9) throw new IllegalArgumentException("value < 0 or value > 9");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int toRow() {
        return (value-1)/3;
    }
    public int toColumn() {
        return (value-1)%3;
    }

}
