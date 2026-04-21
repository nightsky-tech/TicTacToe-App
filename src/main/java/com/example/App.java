package com.example;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        initializeBoard(board);
        printBoard(board);

        GameState game = tossAndAssign();

        System.out.println("Player Symbol: " + game.playerSymbol);
        System.out.println("Computer Symbol: " + game.computerSymbol);
        System.out.println("First Turn: " + game.currentPlayer);
    }

    // UC1 methods
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("Tic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC2 logic
    public static GameState tossAndAssign() {
        Random rand = new Random();
        GameState game = new GameState();

        int toss = rand.nextInt(2);

        if (toss == 0) {
            game.currentPlayer = "Player";
            game.playerSymbol = 'X';
            game.computerSymbol = 'O';
        } else {
            game.currentPlayer = "Computer";
            game.playerSymbol = 'O';
            game.computerSymbol = 'X';
        }

        return game;
    }

    // Game state class
    static class GameState {
        char playerSymbol;
        char computerSymbol;
        String currentPlayer;
    }
}