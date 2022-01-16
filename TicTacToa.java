package TICTACTOA;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToa {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> computerPositions = new ArrayList<Integer>();

    public static boolean checkWin(char[][] board) {
        for (int i = 0; i <= 2; i++) {
            if (board[2 * i][0] == 'X' && board[2 * i][2] == 'X' && board[2 * i][4] == 'X')
                return true;
            else if (board[0][2 * i] == 'X' && board[2][2 * i] == 'X' && board[4][2 * i] == 'X')
                return true;

        }
        if (board[0][0] == 'X' && board[2][2] == 'X' && board[4][4] == 'X')
            return true;
        else if (board[0][4] == 'X' && board[2][2] == 'X' && board[4][0] == 'X')
            return true;
        return false;

    }

    public static void computerMove() {
        int bestScore = -111111;
        int bestMove;

    }

    public static boolean checkLose(char[][] board) {
        for (int i = 0; i <= 2; i++) {
            if (board[2 * i][0] == 'O' && board[2 * i][2] == 'O' && board[2 * i][4] == 'O')
                return true;
            else if (board[0][2 * i] == 'O' && board[2][2 * i] == 'O' && board[4][2 * i] == 'O')
                return true;

        }
        if (board[0][0] == 'O' && board[2][2] == 'O' && board[4][4] == 'O')
            return true;
        else if (board[0][4] == 'O' && board[2][2] == 'O' && board[4][0] == 'O')
            return true;
        return false;

    }

    private static void printB(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + "  ");
            }
            System.out.println();
        }
    }

    private static void palceInBoard(char[][] board, int pos, String player) {
        char symbol = ' ';
        if (player.equals("user")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (player.equals("computer")) {
            symbol = 'O';
            computerPositions.add(pos);
        }
        switch (pos) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
        }

    }

    public static void main(String[] ar) {
        char[][] board = { { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' } };
        Scanner input = new Scanner(System.in);
        int posplyer = 11;
        int i = 1;
        Random rand = new Random();

        while (true) {
            // int a = posplyer ;
            do {
                i++;
                System.out.println("Enter palcement 1 - 9");
                posplyer = input.nextInt();
            } while (playerPositions.contains(posplyer) || computerPositions.contains(posplyer));
            palceInBoard(board, posplyer, "user");

            // computer turn 7-----
            int poscomputer = 0;
            // int b= poscomputer ;
            do {
                poscomputer = rand.nextInt(9) + 1;
            } while (computerPositions.contains(poscomputer) || playerPositions.contains(poscomputer));

            palceInBoard(board, poscomputer, "computer");
            printB(board);
            if (checkWin(board)) {
                System.out.println("you won !!!!");
                break;
            }
            if (checkLose(board)) {
                System.out.println("you lose -SAD-");
                break;
            }
            if (playerPositions.size() == 5 || computerPositions.size() == 5) {
                System.out.println("RESTART THE GAME !!!");
                break;
            }

        }

    }
}
