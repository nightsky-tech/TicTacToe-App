package com.example;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        // UC1: Initialize and display board
        initializeBoard(board);
        printBoard(board);

        // UC2: Toss and assign symbols
        GameState game = tossAndAssign();
        System.out.println("Player Symbol: " + game.playerSymbol);
        System.out.println("Computer Symbol: " + game.computerSymbol);
        System.out.println("First Turn: " + game.currentPlayer);

        // UC3: Get user input
        int slot = getUserSlot();
        System.out.println("User selected slot: " + slot);
    }

    // UC1: Initialize board
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // UC1: Print board
    public static void printBoard(char[][] board) {
        System.out.println("Tic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC2: Toss and assign symbols
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

    // UC3: Get user slot input
    public static int getUserSlot() {
        Scanner sc = new Scanner(System.in);
        int slot;

        while (true) {
            System.out.print("Enter slot (1-9): ");

            if (sc.hasNextInt()) {
                slot = sc.nextInt();

                if (slot >= 1 && slot <= 9) {
                    return slot;
                } else {
                    System.out.println("Invalid slot! Choose between 1 and 9.");
                }
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); // clear invalid input
            }
        }
    }

    // Game state class
    static class GameState {
        char playerSymbol;
        char computerSymbol;
        String currentPlayer;
    }
}