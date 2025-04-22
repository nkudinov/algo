import java.util.Arrays;
import java.util.Scanner;


public class Tetris2 {

    public static final int ROWS = 10;
    public static final int COLS = 10;

    public static void main(String[] args) {
        char op = '?';
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[ROWS][COLS];
        int[][] fig = new int[][]{{1, 1}, {1, 1}};
        while (op != 'x') {
            displayBoardAndFigure(board, fig);
            System.out.println("Enter, x -exit, l - left, r - right, u - up, d - down:");
            op = scanner.nextLine().charAt(0);
            dropFigure(board, fig);
        }
    }

    private static void dropFigure(int[][] board, int[][] fig) {
        int h = 0;
        while ( h < ROWS) {
            h++;
        }
        h--;

    }

    private static void displayBoardAndFigure(int[][] board, int[][] fig) {
        char[][] disp = new char[ROWS][COLS];
        for (int r = 0; r < board.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 1) {
                    disp[r][c] = 'x';
                } else {
                    disp[r][c] = '.';
                }
            }
        }
        for (int r = 0; r < fig.length; r++) {
            for (int c = 0; c < fig[0].length; c++) {
                if (fig[r][c] == 1) {
                    disp[r][c] = 'Y';
                } else {
                    disp[r][c] = '.';
                }
            }
        }
        for (int r = 0; r < disp.length; r++) {
            System.out.println(Arrays.toString(disp[r]));
        }
    }
}
