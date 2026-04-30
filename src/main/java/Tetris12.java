import java.util.Arrays;
import java.util.Scanner;

public class Tetris12 {
    public static void main(String[] args) {
        int[][] mat = new int[10][10];
        int[][] fig = new int[][]{{1, 1,1,1,1}};
        int col = 0;
        char op = '.';
        Scanner scanner = new Scanner(System.in);
        while (op != 'x') {
            process(col, mat, fig);
            display(col, mat, fig);
            op = scanner.next().charAt(0);
            switch (op) {
                case 'l' -> col = moveLeft(col, fig, mat);
                case 'r' -> col = moveRight(col, fig, mat);
                case 'd' -> {
                    dropFig(col, fig, mat);
                    col = 0;
                }
            }
        }
    }

    private static void process(int col, int[][] mat, int[][] fig) {
        for (int r = mat.length - 1; r >= 0; r--) {
            int cnt = 0;
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 1) {
                    cnt++;
                }
            }
            if (cnt == mat[0].length) {
                for (int rr = r; rr > 0; rr--) {
                    System.arraycopy(mat[rr - 1], 0, mat[rr], 0, mat[0].length);
                }
                Arrays.fill(mat[0], 0);
                r++;
            }

        }
    }

    private static void dropFig(int col, int[][] fig, int[][] mat) {
        int row = 0;
        while (canPlace(row, col, fig, mat)) {
            row++;
        }
        place(row - 1, col, fig, mat);
    }

    private static void place(int row, int col, int[][] fig, int[][] mat) {
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 0) {
                    continue;
                }
                mat[row + r][col + c] = 1;
            }
        }
    }

    private static int moveRight(int col, int[][] fig, int[][] mat) {
        if (col + fig[0].length > mat[0].length || !canPlace(0, col + 1, fig, mat)) {
            return col;
        }
        return col + 1;
    }

    private static int moveLeft(int col, int[][] fig, int[][] mat) {
        if (col - 1 < 0 || !canPlace(0, col - 1, fig, mat)) {
            return col;
        }
        return col - 1;
    }

    private static boolean canPlace(int row, int col, int[][] fig, int[][] mat) {
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 0) {
                    continue;
                }
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

    private static void display(int col, int[][] mat, int[][] fig) {
        char[][] disp = new char[mat.length][mat[0].length];
        for (int r = 0; r < mat.length; r++) {
            Arrays.fill(disp[r], '.');
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) {
                    continue;
                }
                disp[r][c] = 'x';
            }
        }
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 0) {
                    continue;
                }
                disp[r][col + c] = '0';
            }
        }
        for (int r = 0; r < disp.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < disp[0].length; c++) {
                sb.append(disp[r][c]).append(' ');
            }
            System.out.println(sb.toString());
        }
    }
}
