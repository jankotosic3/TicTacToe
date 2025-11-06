package org.jetbrains.kotlinx.tictactoe;

import java.util.Scanner;

/**
 * Represents a human player who makes moves via console input.
 * Prompts the user to enter a number between 1-9 and validates the input.
 */
public class HumanPlayer extends Player {

    private final Scanner scanner;

    /**
     * Creates a new human player.
     *
     * @param name the player's name
     * @param mark the player's mark (X or O)
     */
    public HumanPlayer(String name, Mark mark) {
        super(name, mark);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompts the human player to choose a move via console input.
     * Validates that the input is a number between 1-9 and that the
     * position is not already occupied. Continues prompting until
     * a valid move is entered.
     *
     * @param board the current board state
     * @return the position chosen by the player
     */
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
