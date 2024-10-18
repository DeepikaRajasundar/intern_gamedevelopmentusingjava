package connectFour;

import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private char[][] board = new char[ROWS][COLUMNS];
    private char currentPlayer = 'R'; // Red player starts

    public ConnectFour() {
        // Initialize the board
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean dropPiece(int column) {
        if (column < 0 || column >= COLUMNS || board[0][column] != '.') {
            return false; // Invalid move
        }

        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == '.') {
                board[i][column] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin() {
        // Check horizontal, vertical, and diagonal lines
        return checkLines();
    }

    private boolean checkLines() {
        // Check horizontal, vertical, and diagonal lines
        return checkHorizontal() || checkVertical() || checkDiagonals();
    }

    private boolean checkHorizontal() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS - 3; c++) {
                if (board[r][c] == currentPlayer &&
                    board[r][c + 1] == currentPlayer &&
                    board[r][c + 2] == currentPlayer &&
                    board[r][c + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVertical() {
        for (int c = 0; c < COLUMNS; c++) {
            for (int r = 0; r < ROWS - 3; r++) {
                if (board[r][c] == currentPlayer &&
                    board[r + 1][c] == currentPlayer &&
                    board[r + 2][c] == currentPlayer &&
                    board[r + 3][c] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        // Check \ diagonal
        for (int r = 0; r < ROWS - 3; r++) {
            for (int c = 0; c < COLUMNS - 3; c++) {
                if (board[r][c] == currentPlayer &&
                    board[r + 1][c + 1] == currentPlayer &&
                    board[r + 2][c + 2] == currentPlayer &&
                    board[r + 3][c + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check / diagonal
        for (int r = 3; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS - 3; c++) {
                if (board[r][c] == currentPlayer &&
                    board[r - 1][c + 1] == currentPlayer &&
                    board[r - 2][c + 2] == currentPlayer &&
                    board[r - 3][c + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        return false;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R'; // Switch player
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        int column;

        while (!gameWon) {
            game.printBoard();
            System.out.println("Player " + game.getCurrentPlayer() + ", enter column (0-6): ");
            column = scanner.nextInt();

            if (game.dropPiece(column)) {
                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                    gameWon = true;
                } else {
                    game.changePlayer();
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }

        scanner.close();
    }
}
