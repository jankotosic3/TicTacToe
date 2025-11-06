package org.jetbrains.kotlinx.tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private final Scanner scanner;

    public HumanPlayer(String name, Mark mark) {
        super(name, mark);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position chooseMove(Board board) {

        System.out.println(getName()+"("+getMark()+"), enter your move 1-9: ");
        while (true) {
            int move = Integer.parseInt(scanner.nextLine());
            if (move < 1 || move > 9) {
                System.out.println("Invalid move. Enter a number between 1 and 9.");
                continue;
            }
            Position position = new Position(move);
            if (board.getMark(position) != Mark.EMPTY) {
                System.out.println("Invalid move, that position is already taken.");
                continue;
            }
            return position;
        }

    }
}
