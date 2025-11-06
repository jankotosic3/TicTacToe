package org.jetbrains.kotlinx.tictactoe;

public class WinChecker {

    public Mark checkWinner(Board board) {

        Mark[][] grid= board.getGrid();

        // check rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0]!=Mark.EMPTY && grid[i][0]==grid[i][1] && grid[i][0]==grid[i][2]) {
                return grid[i][0];
            }
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            if (grid[0][j]!=Mark.EMPTY && grid[0][j]==grid[1][j] && grid[0][j]==grid[2][j]) {
                return grid[0][j];
            }
        }

        // check main diagonal
        if (grid[0][0]!=Mark.EMPTY && grid[0][0]==grid[1][1] && grid[0][0]==grid[2][2]) {
            return grid[0][0];
        }

        //check side diagonal
        if (grid[0][2]!=Mark.EMPTY && grid[0][2]==grid[1][1] && grid[0][2]==grid[2][0]) {
            return grid[0][2];
        }

        return Mark.EMPTY;
    }

}
