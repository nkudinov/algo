import java.util.Arrays;
import java.util.Scanner;

public class Tetris6 {
    public static void main(String[] args) {
        int[][] board = new int[20][10]; // rows x cols
        int[][] figure = new int[][]{{1, 1}, {1, 1}};
        char op = '?';
        Scanner scanner = new Scanner(System.in);
        int col = 0;

        while (op != 'x') {
            display(col, board, figure);
            System.out.println("Please enter: x - exit, l - left, r - right, d - drop:");
            op = scanner.nextLine().charAt(0);
            switch (op) {
                case 'l' -> col = Math.max(col - 1, 0);
                case 'r' -> col = Math.min(col + 1, board[0].length - figure[0].length);
                case 'd' -> {
                    dropFigure(col, board, figure);
                    col = 0;
                }
            }
        }
        scanner.close();
    }

    private static void display(int col, int[][] board, int[][] figure) {
        char[][] display = new char[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            Arrays.fill(display[r], '.');
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 1) {
                    display[r][c] = 'X';
                }
            }
        }

        for (int r = 0; r < figure.length; r++) {
            for (int c = 0; c < figure[0].length; c++) {
                if (figure[r][c] == 1) {
                    int boardRow = r;
                    int boardCol = col + c;
                    if (boardRow < board.length && boardCol < board[0].length) {
                        display[boardRow][boardCol] = 'X';
                    }
                }
            }
        }

        for (char[] row : display) {
            for (char cell : row) {
                System.out.print(" " + cell);
            }
            System.out.println();
        }
    }

    private static void dropFigure(int col, int[][] board, int[][] figure) {
        int row = 0;
        while (canPlace(row, col, board, figure)) {
            row++;
        }
        row--;
        if (row >= 0) {
            placeFigure(row, col, board, figure);
        }
    }

    private static void placeFigure(int row, int col, int[][] board, int[][] figure) {
        for (int r = 0; r < figure.length; r++) {
            for (int c = 0; c < figure[0].length; c++) {
                if (figure[r][c] == 1) {
                    board[row + r][col + c] = 1;
                }
            }
        }
    }

    private static boolean canPlace(int row, int col, int[][] board, int[][] figure) {
        for (int r = 0; r < figure.length; r++) {
            for (int c = 0; c < figure[0].length; c++) {
                if (figure[r][c] == 1) {
                    int boardRow = row + r;
                    int boardCol = col + c;

                    if (boardRow >= board.length || boardCol < 0 || boardCol >= board[0].length) {
                        return false;
                    }

                    if (board[boardRow][boardCol] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
