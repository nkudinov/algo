import java.util.Arrays;
import java.util.Scanner;

public class Tetris11 {
    public static void main(String[] args) {
        int[][] mat = new int[10][20];
        int[][] fig = new int[][]{{1, 1}};
        int col = 0;
        Scanner scanner = new Scanner(System.in);
        char op = '.';
        while (op != 'x') {
            display(col, mat, fig);
            op = scanner.next().charAt(0);
            switch (op) {
                case 'l' -> col = moveLeft(col, mat, fig);
                case 'r' -> col = moveRight(col, mat, fig);
                case 'd' -> {drop(col, mat, fig); col = 0;}
            }
        }
    }

    private static void drop(int col, int[][] mat, int[][] fig) {
       int row = 0; 
       while (canPlace(row, col, mat, fig)) {
           row++;
       }
       place(row - 1, col, mat, fig);
    }

    private static void place(int row, int col, int[][] mat, int[][] fig) {
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 1) {
                    mat[row + r][col + c] = 1;
                }
            }
        }
    }

    private static void display(int col, int[][] mat, int[][] fig) {
        char[][] display = new char[mat.length][mat[0].length];
        for (int r = 0; r < mat.length; r++) {
            Arrays.fill(display[r], '.');
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 1) {
                    display[r][c] = 'x';
                }
            }
        }
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 1) {
                    display[r][col + c] = 'f';
                }
            }
        }
        for (int r = 0; r < display.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < display[r].length; c++) {
                sb.append(display[r][c]).append(' ');
            }
            System.out.println(sb.toString());
        }
    }


    private static int moveRight(int col, int[][] mat, int[][] fig) {
        if (col + 1 + fig[0].length > mat[0].length) {
            return col;
        }
        if (!canPlace(0, col + 1, mat, fig)) {
            return col;
        }
        return col + 1;
    }

    private static boolean canPlace(int row, int col, int[][] mat, int[][] fig) {
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 0) continue;

                // ✅ boundary check FIRST
                if (row + r >= mat.length || col + c >= mat[0].length) {
                    return false;
                }

                if (mat[row + r][col + c] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int moveLeft(int col, int[][] mat, int[][] fig) {
        if (col - 1 < 0) {
            return col;
        }
        if (!canPlace(0, col - 1, mat, fig)) {
            return col;
        }
        return col - 1;
    }
}
