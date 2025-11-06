package org.jetbrains.kotlinx.tictactoe;

import java.util.Scanner;

public class PlayerFactory {

    private Scanner scanner;

    public PlayerFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    public Player createPlayer(String playerName, Mark mark) {

        System.out.println("Select player type for " + mark +":");
        System.out.println("1. Human player");
        System.out.println("2. Random computer");
        System.out.println("3. Smart computer");
        System.out.println("Enter your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                return new HumanPlayer(playerName, mark);
            case 2:
                return new RandomComputerPlayer(playerName, mark);
            case 3:
                return new SmartComputerPlayer(playerName, mark);
            default:
                 System.out.println("Invalid choice. Defaulting to Human player");
                 return new HumanPlayer(playerName, mark);
        }


    }

}
