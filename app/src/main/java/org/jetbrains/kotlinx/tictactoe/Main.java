package org.jetbrains.kotlinx.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        PlayerFactory playerFactory=new PlayerFactory(input);

        System.out.println("Welcome to TicTacToe!");
        System.out.println("Enter name for Player X");
        String nameX = input.nextLine();
        System.out.println("Enter name for Player O");
        String nameO = input.nextLine();

        Player playerX= playerFactory.createPlayer(nameX, Mark.X);
        Player playerO=playerFactory.createPlayer(nameO, Mark.O);

        TicTacToeGame game = new TicTacToeGame(playerX,playerO);
        game.play();

    }


}
