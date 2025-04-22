import java.util.Arrays;
import java.util.Scanner;

public class Tetris3 {

    public static final int ROWS = 20;
    public static final int COLS = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[ROWS][COLS];
        int[][] figure = new int[][]{{1, 1}, {1, 1}};
        char op = '?';
        int figureCol = 3;
        while (op != 'x') {
            display(figureCol, board, figure);
            System.out.println("Enter, x- exit, l - left, r - right, d - drop:");
            op = scanner.nextLine().charAt(0);
            switch (op) {
              case  'l' ->figureCol = Math.max(0, figureCol- 1);
              case  'r' ->figureCol = Math.min(COLS-2, figureCol+1);
              case 'd' -> dropFigure(figureCol, board, figure);
            }
        }
    }

    private static void dropFigure(int figureCol, int[][] board, int[][] figure) {
        int row = 0;
        while ( canPlace(row, figureCol, board, figure)) {
            row++;
        }
        row--;
        placeFigure(row, figureCol, board, figure);
    }

    private static void placeFigure(int row, int figureCol, int[][] board, int[][] figure) {
        for(int r = 0; r < figure.length; r++) {
            for(int c = 0; c < figure[0].length;c++) {
                if (figure[r][c] == 0) {
                    continue;
                }
                int boardRow = row + r;
                int boardCol = figureCol + c;
                board[boardRow][boardCol] = 1;
            }
        }
    }

    private static boolean canPlace(int row, int figureCol, int[][] board, int[][] figure) {
         for(int r = 0; r < figure.length; r++) {
             for(int c = 0; c < figure[0].length;c++) {
                 int boardRow = row + r;
                 int boardCol = figureCol + c;
                 if (boardRow >= board.length || boardCol >= board[0].length) {
                     return false;
                 }
                 if (figure[r][c] == 0) {
                     continue;
                 }
                 if (board[boardRow][boardCol] == 1) {
                     return false;
                 }
             }
         }
         return true;
    }

    private static void display(int figureCol, int[][] board, int[][] figure) {
        char[][] display = new char[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            Arrays.fill(display[r], '.');
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 1) {
                    display[r][c] = 'x';
                }
            }
        }
        for (int r = 0; r < figure.length; r++) {
            for (int c = 0; c < figure[0].length; c++) {
                if (figure[r][c] == 1) {
                    int boardCol = c + figureCol;
                    display[r][boardCol] = 'x';
                }
            }
        }
        for (int r = 0; r < display.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < display.length; c++) {
                sb.append(' ').append(display[r][c]);
            }
            System.out.println(sb.toString());
        }
    }
}
