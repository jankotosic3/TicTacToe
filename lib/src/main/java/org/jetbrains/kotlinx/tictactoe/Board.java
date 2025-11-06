package org.jetbrains.kotlinx.tictactoe;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a tic tac toe board.
 * Board is 3x3 grid of marks, where marks x and o can be placed.
 * This class manages the state of the board and provides methods for placing and removing marks
 * and querying board state.
 * */
public class Board {

    /** the grid storing the marks */
    private final Mark[][] grid;

    /**
     * Creates a new board with all positions initialised to Mark.EMPTY
     */
    public Board() {

        grid=new Mark[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j]=Mark.EMPTY;
            }
        }

    }

    /**
     * Places a mark on a specified position on the board
     * @param position the position where a mark should be placed
     * @param mark a mark that should be placed (x or o)
     * @throws IllegalStateException if the position is already occupied
     */
    void placeMark(Position position, Mark mark){
        int row=position.toRow();
        int col=position.toColumn();

        if (grid[row][col]!=Mark.EMPTY) {
            throw new IllegalStateException("Position "+position+" is already placed on board");
        }
        grid[row][col]=mark;
    }

    /**
     * Removes mark from a specified place on board and makes it EMPTY again
     * @param position position to clear
     */
    void removeMark(Position position){
        int row=position.toRow();
        int col=position.toColumn();

        grid[row][col]=Mark.EMPTY;
    }

    /**
     * Gets a mark from specified location on the board
     * @param position a position to query
     * @return the mark at specified position
     */
    public Mark getMark(Position position){
        int row=position.toRow();
        int col=position.toColumn();
        return grid[row][col];
    }

    /**
     * Prints current board state to the console
     */
    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String mark = grid[i][j] == Mark.EMPTY ? " " : grid[i][j].toString();
                System.out.print(" " + mark + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    /**
     * Returns a list of all positions on the board that are currently empty
     * @return list of all available positions
     */
    public List<Position> getAvailablePositions() {
        List<Position> positions = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            Position pos=new Position(i);
            if (getMark(pos)==Mark.EMPTY) {
                positions.add(pos);
            }
        }
        return positions;
    }

    /**
     * Gets direct access to interenal grid
     * @return the internal grid
     */
    public Mark[][] getGrid() {
        return grid;
    }


}
