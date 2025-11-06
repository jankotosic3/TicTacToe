package org.jetbrains.kotlinx.tictactoe;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to TicTacToe!");
        System.out.println("Enter name for Player X");
        String nameX = input.nextLine();
        System.out.println("Enter name for Player O");
        String nameO = input.nextLine();

        System.out.println("Should player X be a computer? (y/n)");
        boolean isXComputer = input.nextLine().equalsIgnoreCase("y");
        System.out.println("Should player O be a computer? (y/n)");
        boolean isOComputer = input.nextLine().equalsIgnoreCase("y");

        Player playerX, playerO;
        if(isXComputer){
            playerX=new RandomComputerPlayer(nameX,Mark.X);
        }else playerX=new HumanPlayer(nameX,Mark.X);
        if(isOComputer){
            playerO=new RandomComputerPlayer(nameO,Mark.O);
        }else playerO=new HumanPlayer(nameO,Mark.O);

        TicTacToeGame game = new TicTacToeGame(playerX,playerO);
        game.play();

    }
}
