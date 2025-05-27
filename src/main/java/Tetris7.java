import java.util.Arrays;
import java.util.Scanner;

public class Tetris7 {
    public static void main(String[] args) {
        int[][] board = new int[20][20];
        int[][] figure = new int[][]{{1, 0}, {1, 1}};
        int col = 0;
        char op = '?';
        Scanner scanner = new Scanner(System.in);
        while (op != 'x') {
            display(col, board, figure);
            System.out.println("please enter, x = exit, l = left, r = right, d - drop figure:");
            op = scanner.nextLine().charAt(0);
            switch (op) {
                case 'l' -> col = Math.max(0, col - 1);
                case 'r' -> col = Math.min(board[0].length - figure[0].length, col + 1);
                case 'd' -> {drop(col, board, figure); col = 0;}
            }
        }
    }

    private static void drop(int col, int[][] board, int[][] figure) {
        int row = 0;
        while ( canPlace(row, col, board, figure)) {
            row++;
        }
        row--;
        place(row, col, board, figure);
    }

    private static boolean canPlace(int row, int col,  int[][] board, int[][] figure) {
        for (int r = 0; r < figure.length; r++) {
            for (int c = 0; c < figure[0].length; c++) {
                if (figure[r][c] == 0) {
                    continue;
                }
                int boardRow = row + r;
                int boardCol =  col + c;
                if (boardRow >= board.length || boardCol >= board[0].length) {
                    return false;
                }
                if (board[boardRow][boardCol] !=0){
                    return false;
                }
            }
        }
        return true;
    }

    private static void place(int row, int col, int[][] board, int[][] figure) {
        for (int r = 0; r < figure.length; r++) {
            for (int c = 0; c < figure[0].length; c++) {
                if (figure[r][c] == 0) {
                    continue;
                }
                int boardRow = row + r;
                int boardCol =  col + c;
                board[boardRow][boardCol] = 1;
            }
        }
    }

    private static void display(int col, int[][] board, int[][] figure) {
        char[][] display = new char[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            Arrays.fill(display[r], '.');
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0) {
                    continue;
                }
                display[r][c] = 'x';
            }
        }
        for (int r = 0; r < figure.length; r++) {
            for (int c = 0; c < figure[0].length; c++) {
                int newCol = col + c;
                if (figure[r][c] == 1) {
                    display[r][newCol] = 'f';
                }
            }
        }
        for (int r = 0; r < display.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < display[0].length; c++) {
                sb.append(' ').append(display[r][c]);
            }
            System.out.println(sb.toString());
        }
    }
}
