import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Tetris10 {
    public static void main(String[] args) {
        int[][] mat = new int[10][10];
        int[][] fig = new int[][]{{1, 1}, {1, 1}};
        int col = 0;
        Scanner scanner = new Scanner(System.in);
        char op = ',';
        while (op != 'x') {
            display(col, mat, fig);
            op = scanner.next().charAt(0);
            switch (op) {
                case 'l' -> col = moveLeft(col, mat, fig);
                case 'r' -> col = moveRight(col, mat, fig);
                case 'd' -> {
                    drop(col, mat, fig);
                    col = 0;
                }
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
                if (fig[r][c] == 0 ) {
                    continue;
                }
                 mat[row + r][col + c] = 1;

            }
        }
    }

    private static void display(int col, int[][] mat, int[][] fig) {
        char[][] display = new char[mat.length][mat[0].length];
        for (int r = 0; r < mat.length; r++) {
            Arrays.fill(display[r], '.');
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 1) {
                    display[r][c] = 'o';
                }
            }
        }
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 0) {
                    continue;
                }
                display[r][col + c] = 'f';
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

    private static int moveRight(int col, int[][] mat, int[][] fig) {
        if (col + 1 >= mat.length) {
            return col;
        }
        if (!canPlace(0, col + 1, mat, fig)) {
            return col;
        }
        return col + 1;
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

    private static boolean canPlace(int row, int col, int[][] mat, int[][] fig) {
        if (row + fig.length > mat.length) {
            return false;
        }
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 0) {
                    continue;
                }
                if (mat[row + r][col + c] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
