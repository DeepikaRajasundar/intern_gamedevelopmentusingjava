package chatApp;

public class Board {
    private char[][] board;
    private static final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean placeMark(int row, int col, char mark) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
            board[row][col] = mark;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') ||
                (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-')) {
                return true;
            }
        }
        // Check diagonals
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') ||
               (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-');
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
