package chatApp;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Player player1 = new Player('X');
        Player player2 = new Player('O');
        Player currentPlayer = player1;

        while (true) {
            board.printBoard();
            System.out.println("Player " + currentPlayer.getMark() + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.placeMark(row, col, currentPlayer.getMark())) {
                if (board.checkWin()) {
                    board.printBoard();
                    System.out.println("Player " + currentPlayer.getMark() + " wins!");
                    break;
                } else if (board.isFull()) {
                    board.printBoard();
                    System.out.println("The game is a draw!");
                    break;
                }
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }
        scanner.close();
    }
}
