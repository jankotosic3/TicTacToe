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

        Player playerX=createPlayer(nameX,Mark.X,input);
        Player playerO=createPlayer(nameO,Mark.O,input);




        TicTacToeGame game = new TicTacToeGame(playerX,playerO);
        game.play();

    }

    private static Player createPlayer(String name,Mark mark, Scanner input){

        System.out.println("Should player "+mark+" be a computer? (y/n)");
        boolean computer=input.nextLine().equalsIgnoreCase("y");
        if(computer){
            System.out.println("Should player "+mark+" be a smart computer?(y/n)");
            boolean smartcomputer=input.nextLine().equalsIgnoreCase("y");
            if(smartcomputer)return new SmartComputerPlayer(name,mark);
            else return new RandomComputerPlayer(name,mark);
        }else return new HumanPlayer(name,mark);


    }
}
