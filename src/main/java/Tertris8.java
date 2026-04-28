import java.util.Arrays;
import java.util.Scanner;

public class Tertris8 {
    public static void main(String[] args) {
        int[][] mat = new int[10][10];
        int[][] fig = new int[][]{{1, 1}, {1, 1}};
        int col = 0;
        char op = '_';
        Scanner scanner = new Scanner(System.in);
        while (op != 'x') {
            print(mat, fig, col);
            op = scanner.next().charAt(0);

            switch (op) {
                case 'l' -> col = moveFigLeft(col, mat, fig);
                case 'r' -> col = moveFigRight(col, mat, fig);
                case 'd' -> {
                    dropFig(col, mat, fig);
                    col = 0;
                }
            }
        }
    }

    private static void dropFig(int col, int[][] mat, int[][] fig) {
        int row = 0;
        while (canPlace(row, col, mat, fig)) {
            row++;
        }
        row--;
        place(row, col, mat, fig);
    }

    private static void place(int row, int col, int[][] mat, int[][] fig) {
       for(int r = 0; r < fig.length;r++) {
           for(int c = 0; c< fig[0].length;c++) {
               mat[row+r][col+c] = 1;
           }
       }
    }

    private static int moveFigRight(int col, int[][] mat, int[][] fig) {
        if (canPlace(0,col + 1, mat, fig)) {
            return col + 1;
        }
        return col;
    }

    private static int moveFigLeft(int col, int[][] mat, int[][] fig) {
        if (canPlace(0,col - 1, mat, fig)) {
            return col - 1;
        }
        return col;
    }

    private static boolean canPlace(int row, int col, int[][] mat, int[][] fig) {
        if (col < 0 || col + fig[0].length > mat[0].length) {
            return false;
        }
        if (row < 0 || row + fig.length > mat.length ) {
            return false;
        }
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 0) {
                    continue;
                }
                if (mat[row+r][col+c]==1){
                    return false;
                }
            }
        }
        return true;
    }

    private static void print(int[][] mat, int[][] fig, int col) {
        char[][] display = new char[mat.length][mat[0].length];
        for (int r = 0; r < mat.length; r++) {
            Arrays.fill(display[r], '.');
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) {
                    continue;
                }
                display[r][c] = 'x';
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
            for (int c = 0; c < display[0].length; c++) {
                sb.append(' ').append(display[r][c]);
            }
            System.out.println(sb.toString());
        }
    }
}
