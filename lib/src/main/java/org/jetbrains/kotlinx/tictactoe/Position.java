package org.jetbrains.kotlinx.tictactoe;


/**
 * represents a position in a tic tac toe board
 * positions are numbered from 1 to 9
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
public class Position {


    private final int value;

    // minimum valid position value
    private final int minPosition=1;
    // maximum valid position value
    private final int maxPosition=9;


    /**
    * Creates a new position with given value
    * @param value of the position, it must be between 1 and 9
    * @throws IllegalArgumentException if value is not between 1 and 9
    */
    public Position(int value) {
        if (value < minPosition || value>maxPosition) throw new IllegalArgumentException("value <1 or value > 9");
        this.value = value;
    }

    /**
     * gets the position value
     * @return the position value (1-9)
     * */
    public int getValue() {
        return value;
    }


    /**
     * converts position value to 0 based row index
     * @return the row index (0-2)
     * */
    public int toRow() {
        return (value-1)/3;
    }

    /**
     * converts position value to 0 based column index
     * @return the column index (0-2)
     * */
    public int toColumn() {
        return (value-1)%3;
    }

}
