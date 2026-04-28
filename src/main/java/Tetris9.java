import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Tetris9 {
    public static void main(String[] args) {
        int[][] mat = new int[10][20];
        int[][] fig = new int[][]{{1, 1}, {0, 1}};
        char op = '.';
        Scanner scanner = new Scanner(System.in);
        int col = 0;
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
        row--;
        place(row, col, mat, fig);
    }

    private static int moveRight(int col, int[][] mat, int[][] fig) {
        if (col + 1 + fig.length > mat.length) {
            return col;
        }
        if (!canPlace(0, col + 1, mat, fig)) {
            return col;
        }
        col++;
        return col;
    }

    private static void display(int col, int[][] mat, int[][] fig) {
        char[][] display = new char[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(display[i], '.');
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[i][c] == 1) {
                    display[i][c] = 'x';
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
                for (char ch : display[r]) {
                    sb.append(ch).append(' ');
                }
                System.out.println(sb.toString());
            }
        }
    }

    private static int moveLeft(int col, int[][] mat, int[][] fig) {
        if (col - 1 > 0) {
            return col;
        }
        if (!canPlace(0, col - 1, mat, fig)) {
            return col;
        }
        col--;
        return col;
    }

    private static void place(int row, int col, int[][] mat, int[][] fig) {
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                mat[row + c][col + c] = fig[r][c];
            }
        }
    }

    private static boolean canPlace(int row, int col, int[][] mat, int[][] fig) {
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 0) {
                    continue;
                }
                if (mat[row + c][col + c] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
