package org.jetbrains.kotlinx.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Mark[][] grid;


    public Board() {

        grid=new Mark[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j]=Mark.EMPTY;
            }
        }


    }
    void placeMark(Position position, Mark mark){
        int row=position.toRow();
        int col=position.toColumn();

        if (grid[row][col]!=Mark.EMPTY) {
            throw new IllegalStateException("Position "+position+" is already placed on board");
        }
        grid[row][col]=mark;
    }

    public Mark getMark(Position position){
        int row=position.toRow();
        int col=position.toColumn();
        return grid[row][col];
    }

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

    public Mark[][] getGrid() {
        return grid;
    }


}
