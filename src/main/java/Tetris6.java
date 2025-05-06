import java.util.Arrays;
import java.util.Scanner;

public class Tetris6 {
    public static void main(String[] args) {
        int[][] board = new int[10][20];
        int[][] figure = new int[][]{{1, 1}, {1, 1}};
        char op = '?';
        Scanner scanner = new Scanner(System.in);
        int col = 0;
        while (op != 'x') {
            display(col, board, figure);
            System.out.println("Please enter: x- exit, l - left, r - right, d - drop:");
            op = scanner.nextLine().charAt(0);
            switch (op) {
                case 'l' -> col = Math.max(col - 1, 0);
                case 'r' -> col = Math.min(col + 1, board.length - figure.length);
                case 'd' -> dropFigure(board, figure);
            }
        }
    }

    private static void display(int col, int[][] board, int[][] figure) {
        char[][] display = new char[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            Arrays.fill(display[r],'.');
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0) {
                    continue;
                }
                display[r][c] = 'X';
            }
        }
        for (int r = 0; r < figure.length; r++) {
            for (int c = 0; c < figure[0].length; c++) {
                if (figure[r][c] == 0) {
                    continue;
                }
                 int boardRow = r;
                 int boardCol = col + c;
                display[boardRow][boardCol] = 'X';
            }
        }
        for(int r=  0; r < display.length; r++) {
            StringBuilder sb = new StringBuilder();
            for(int c = 0; c < display[0].length;c++) {
                sb.append(' ').append(display[r][c]);
            }
            System.out.println(sb.toString());
        }
    }

    private static void dropFigure(int col, int[][] board, int[][] figure) {
        int row = 0;
        while ( canPlace(row, col, board, figure)) {
            row++;
        }
        row--;
        placeFigure(row, col, board, figure);
    }

    private static void placeFigure(int row, int col, int[][] board, int[][] figure) {

    }

    private static boolean canPlace(int row, int col, int[][] board, int[][] figure) {
    }
}
