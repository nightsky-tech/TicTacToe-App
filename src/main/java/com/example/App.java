package com.example;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        // UC1
        initializeBoard(board);
        printBoard(board);

        // UC2
        GameState game = tossAndAssign();
        System.out.println("Player Symbol: " + game.playerSymbol);
        System.out.println("Computer Symbol: " + game.computerSymbol);
        System.out.println("First Turn: " + game.currentPlayer);

        // UC3
        int slot = getUserSlot();

        // UC4
        int[] position = convertSlotToIndex(slot);
        int row = position[0];
        int col = position[1];

        System.out.println("Converted Position → Row: " + row + ", Column: " + col);
    }

    // UC1
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

    // UC2
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

    // UC3
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
                sc.next();
            }
        }
    }

    // UC4
    public static int[] convertSlotToIndex(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        return new int[]{row, col};
    }

    // Game state
    static class GameState {
        char playerSymbol;
        char computerSymbol;
        String currentPlayer;
    }
}